package smtcodan.multithreadanalysis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.ICfgData;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.core.resources.IFile;

import smtcodan.Config;
import smtcodan.IPThreadObserver;
import smtcodan.ProgramStructureFacade;
import smtcodan.Solver;
import smtcodan.WorkPool;
import smtcodan.WorkPoolManager;
import smtcodan.interpreter.Interpreter;
import smtcodan.interpreter.PThread;
import smtcodan.multithreadanalysis.checkers.RaceChecker;
import smtcodan.pathgen.IndBasicBlock;
import smtcodan.pathgen.ProgramPathIBB;

public class MTAnalyzer {

	// TODO: different classes for different interleaving criteria; Coverage parent class
	
	WorkPool wp; // to report errors
	Interpreter ps;
	MTAPath mtapath;
	RaceChecker rc;
	
	LRDefCoverage allCov; // aggregated
	
	public MTAnalyzer(ProgramPathIBB ltnpath, ProgramStructureFacade psf) {				
		mtapath = annotate(ltnpath, psf);
		allCov = new LRDefCoverage(mtapath);
	};	
				
	MTAPath annotate(ProgramPathIBB ltnpath, ProgramStructureFacade psf) {
		// find definenodes, usenodes, joinnodes, locknodes, unlocknodes, exitnodes
		ps = new Interpreter(psf, new Solver(), true);
		MTAbstractor anno = new MTAbstractor(ps);				
		ps.attach((IPThreadObserver) anno);
		ps.attach((ISharedMemObserver) anno);
		ps.initEnv();
		anno.createMain();
		for (IndBasicBlock ibb : ltnpath) {	
			anno.enterNode(ibb.getPThreadNr(), ibb.getLocal());						
			anno.leaveNode(ibb.getPThreadNr(), ibb.getLocal());
		}				
		anno.exitMain();
		MTAPath path = anno.getMTAPath();
		int i=0;
		for (IMTANode node : path) {
			((MTANode) node).setRefNr(i);
			i++;
		}		
		return path; 
	}			
	
	public void doAnalyze(WorkPool wp) {
		this.wp = wp;
		rc = new RaceChecker(wp);
		IMTANode startnode = buildTree();
		ThreadState.resetThreadCounter();
		ThreadStates tstates = new ThreadStates();
		tstates.add(new ThreadState());		
		// different interleaving coverage
		if (Config.getInterleavingCoverage() == eInterleavingCoverage.PORed) {
			ActionSet ample = new ActionSet();
			ActionSet others = new ActionSet();
			ActionSet blocked = new ActionSet();
			ample.add(startnode);
			podfs(tstates, ample, others, blocked);			
		} else if (Config.getInterleavingCoverage() == eInterleavingCoverage.LRDef) {
			LRDefCoverage cov = new LRDefCoverage();		
			ActionSet ample = new ActionSet();
			ActionSet others = new ActionSet();
			ActionSet blocked = new ActionSet();
			ample.add(startnode);
			int visitedStates = podfs_lrdef(tstates, ample, others, blocked, cov);				
		} else {
			(new Exception("TODO")).printStackTrace();
		}										
	}
	
	
	IMTANode buildTree() {
		Object[] arr = mtapath.toArray();				
		for (int i=0; i<arr.length; i++) {
			IMTANode node = (IMTANode) arr[i];
			// find children, i.e. enabled nodes
			if (node instanceof MTCreateNode) {
				// find first node of created thread
				MTCreateNode cn = (MTCreateNode) node;
				int newtnr = cn.getCreateNr();
				boolean foundOwnThreadChild = (newtnr == 0); // not for dummy create 0
				boolean foundNewThreadChild = false;												
				for (int j=i+1; j<arr.length; j++) {
					IMTANode cand = (IMTANode) arr[j];
					if (!foundNewThreadChild && (cand.getPThreadNr() == newtnr)) {
						cn.addChild(cand);
						foundNewThreadChild = true;
					} else if (!foundOwnThreadChild && (cand.getPThreadNr() == cn.getPThreadNr())) {
						cn.addChild(cand);
						foundOwnThreadChild = true;
					}
					if (foundOwnThreadChild && foundNewThreadChild) {
						break;
					}
				}												
			} else if (node instanceof MTExitNode) {
				// might wake up joiners, not modelled here			
			} else if ((node instanceof MTDefSharedNode) || (node instanceof MTUseSharedNode)) {
				for (int j=i+1; j<arr.length; j++) {
					IMTANode cand = (IMTANode) arr[j];
					if (cand.getPThreadNr() == node.getPThreadNr()) {
						node.addChild(cand);
						break;
					}
				}
			} else if (node instanceof MTJoinNode) {
				for (int j=i+1; j<arr.length; j++) {
					IMTANode cand = (IMTANode) arr[j];
					if (cand.getPThreadNr() == node.getPThreadNr()) {
						node.addChild(cand);
						break;
					}
				}	
			} else if (node instanceof MTLockNode) {
				// may disable child, not modelled here
				for (int j=i+1; j<arr.length; j++) {
					IMTANode cand = (IMTANode) arr[j];
					if (cand.getPThreadNr() == node.getPThreadNr()) {
						node.addChild(cand);
						break;
					}
				}
			} else if (node instanceof MTUnlockNode) {
				// may enable others, not modelled here
				for (int j=i+1; j<arr.length; j++) {
					IMTANode cand = (IMTANode) arr[j];
					if (cand.getPThreadNr() == node.getPThreadNr()) {
						node.addChild(cand);
						break;
					}
				}				
			}						
		}		
		return (IMTANode) arr[0];
	}				
	
	
	public void podfs(ThreadStates threadStates, ActionSet ample, ActionSet others, ActionSet inblocked) {
		ThreadStates tstates = threadStates.cloneElements();
		ActionSet opens = others.cloneElements();
		ActionSet blocked = inblocked.cloneElements();
		// execute ampleSet
		ActionSet enabled = execute(tstates, ample, blocked);
		// remove all newly blocked from ample for path backtracking
		ample.removeAll(blocked);
		// add children to open states
		opens.addAll(enabled);
		if (opens.isEmpty()) {
			// backtrack ample sets:
			ArrayDeque<IMTANode> interleaving = new ArrayDeque<IMTANode>();
			ActionSet btample = ample;
			while(btample != null) {
				Iterator<IMTANode> deciter = btample.descendingIterator();
				while (deciter.hasNext()) {
					IMTANode n = deciter.next();
					interleaving.addFirst(n);
				}
				btample = btample.getParent();
			}
			dumpInterleaving(interleaving);			
			rc.findRace(interleaving);
		} else {
			// find ampleSets
			ArrayList<ActionSet> ampleSets = new ArrayList<ActionSet>();		
			ActionSet ampleSet = new ActionSet();
			ampleSets.add(ampleSet);
			ampleSet.add(opens.peekFirst());		
			opens.removeFirst();
			for (IMTANode cand: opens) {
				Iterator<ActionSet> it = ampleSets.iterator(); 
				while (it.hasNext()) {
					ActionSet as = it.next();
					if (fitsAmple(as, cand)) {					
						as.add(cand);
					} else {					
						ActionSet newSet = new ActionSet();
						newSet.add(cand);
						ampleSets.add(newSet);
					}
					break;
				}									
			} // all openNodes partitioned into ampleSets		
			// recursively enter one ampleSet
			for (int i=0; i<ampleSets.size(); i++) {
				ActionSet newAmple = ampleSets.get(i);
				newAmple.setParent(ample);
				ActionSet newOthers = new ActionSet();
				for (int j=0; j<ampleSets.size(); j++) {
					if (j==i) {
						continue;
					} else {
						newOthers.addAll(ampleSets.get(j));
					}
				}
				podfs(tstates, newAmple, newOthers, blocked);
			}
		}
				
	}
	
	
	public ActionSet execute(ThreadStates tstates, ActionSet ample, ActionSet blocked) {
		ActionSet children = new ActionSet();
		for (IMTANode node : ample) {
				int pthreadnr = node.getPThreadNr();
				if (node instanceof MTCreateNode) {
					tstates.add(new ThreadState());
					children.addAll((Collection<? extends IMTANode>) node.getChildren());
				} 	
				if (node instanceof MTExitNode) {				
					tstates.get(pthreadnr).setFinished();
					// wake up waiting threads
					ActionSet unblock = new ActionSet();
					for (ThreadState tstate : tstates) {
						if (tstate.getWantsToJoin()) {
							if (tstate.getJoinTarget() == pthreadnr) {
								tstate.unsetWantsToJoin();
								// unblock joiner:
								for (IMTANode jcand: blocked) {
									if (jcand.getPThreadNr() == tstate.getThreadNr()) {
										unblock.add(jcand);
										children.add(jcand);
									}
								}
							}
						}
					}				
					blocked.removeAll(unblock);
					// has no children										
				} else if (node instanceof MTLockNode) {				
					String lockname = ((MTLockNode) node).getLockName();				
					boolean mustblock = false;				
					// assume no double locking in replay				
					for (ThreadState ts : tstates) {
						if (ts.holdsLock(lockname)) {
							mustblock = true;
						}
					}
					if (mustblock) {
						tstates.get(node.getPThreadNr()).setWaitsForLock(lockname);
						blocked.add(node);
					} else {
						tstates.get(node.getPThreadNr()).lock(lockname);	
						children.addAll((Collection<? extends IMTANode>) node.getChildren());
					}																					
				} else if (node instanceof MTUnlockNode) {
					String lockname = ((MTUnlockNode) node).getLockName();
					tstates.get(node.getPThreadNr()).unlock(lockname);							
					children.addAll((Collection<? extends IMTANode>) node.getChildren());
					// enable blocked lockers
					ActionSet unblock = new ActionSet();
					for (ThreadState ts : tstates) {
						if (ts.getWaitsForLock(lockname)) {
							// move locknode from blocked to children
							for (IMTANode lcand : blocked) {
								if (lcand.getPThreadNr() == ts.getThreadNr()) {
									unblock.add(lcand);									
									children.add(lcand);
									break;
								}								
							}
						}
					}
					blocked.removeAll(unblock);
				} else if (node instanceof MTJoinNode) {
					int active = ((MTJoinNode) node).getPThreadNr();
					int joinTarget = ((MTJoinNode) node).getJoinTarget();				
					tstates.get(active).setWantsToJoin(joinTarget);				
					if (tstates.get(joinTarget).isAlive()) {
						blocked.add(node);
					} else {
						children.addAll((Collection<? extends IMTANode>) node.getChildren());
					}										
				} else if (node instanceof MTDefSharedNode) {
					children.addAll((Collection<? extends IMTANode>) node.getChildren());
					
				} else if (node instanceof MTUseSharedNode) {
					children.addAll((Collection<? extends IMTANode>) node.getChildren());
				} 				
		}		
		return children;
	}
	
	public int podfs_lrdef(ThreadStates threadStates, ActionSet ample, ActionSet others, ActionSet inblocked, LRDefCoverage cov) {
		int visitedStates = 1;
		// branch & bound with coverage
		ThreadStates tstates = threadStates.cloneElements();
		ActionSet opens = others.cloneElements();
		ActionSet blocked = inblocked.cloneElements();
		// execute ampleSet
		ActionSet enabled = execute_lrdef(tstates, ample, blocked, cov);
		// remove all newly blocked from ample for path backtracking
		ample.removeAll(blocked);
		// add children to open states
		opens.addAll(enabled);
		// already covered? // TODO: check only when ample contained a Use-node
		if (!allCov.possiblyNew(cov)) {
			// prune path...
			System.out.print("pruned " + cov.toString());
			return visitedStates;
		}		
		if (opens.isEmpty()) {
			// add coverage:			
			// TODO: should never happen ?
			if (cov.size() != allCov.size()) {
				// (new Exception()).printStackTrace();
				return visitedStates;
			}			
			allCov.addCoverage(cov);
			// backtrack ample sets:
			ArrayDeque<IMTANode> interleaving = new ArrayDeque<IMTANode>();
			ActionSet btample = ample;
			while(btample != null) {
				Iterator<IMTANode> deciter = btample.descendingIterator();
				while (deciter.hasNext()) {
					IMTANode n = deciter.next();
					interleaving.addFirst(n);
				}
				btample = btample.getParent();
			}
			dumpInterleaving(interleaving);			
			rc.findRace(interleaving);
		} else {
			// find ampleSets
			ArrayList<ActionSet> ampleSets = new ArrayList<ActionSet>();		
			ActionSet ampleSet = new ActionSet();
			ampleSets.add(ampleSet);
			ampleSet.add(opens.peekFirst());		
			opens.removeFirst();
			for (IMTANode cand: opens) {
				Iterator<ActionSet> it = ampleSets.iterator(); 
				while (it.hasNext()) {
					ActionSet as = it.next();
					if (fitsAmple(as, cand)) {					
						as.add(cand);
					} else {					
						ActionSet newSet = new ActionSet();
						newSet.add(cand);
						ampleSets.add(newSet);
					}
					break;
				}									
			} // all openNodes partitioned into ampleSets		
			// recursively enter one ampleSet
			for (int i=0; i<ampleSets.size(); i++) {
				ActionSet newAmple = ampleSets.get(i);
				newAmple.setParent(ample);
				ActionSet newOthers = new ActionSet();
				for (int j=0; j<ampleSets.size(); j++) {
					if (j==i) {
						continue;
					} else {
						newOthers.addAll(ampleSets.get(j));
					}
				}
				visitedStates += podfs_lrdef(tstates, newAmple, newOthers, blocked, cov.cloneElements());
			}
		}
		return visitedStates;	
	}
	
	public ActionSet execute_lrdef(ThreadStates tstates, ActionSet ample, ActionSet blocked, LRDefCoverage cov) {
		ActionSet children = new ActionSet();
		for (IMTANode node : ample) {
				int pthreadnr = node.getPThreadNr();
				if (node instanceof MTCreateNode) {
					tstates.add(new ThreadState());
					children.addAll((Collection<? extends IMTANode>) node.getChildren());
				} 	
				if (node instanceof MTExitNode) {				
					tstates.get(pthreadnr).setFinished();
					// wake up waiting threads
					ActionSet unblock = new ActionSet();
					for (ThreadState tstate : tstates) {
						if (tstate.getWantsToJoin()) {
							if (tstate.getJoinTarget() == pthreadnr) {
								tstate.unsetWantsToJoin();
								// unblock joiner:
								for (IMTANode jcand: blocked) {
									if (jcand.getPThreadNr() == tstate.getThreadNr()) {
										unblock.add(jcand);
										children.add(jcand);
									}
								}
							}
						}
					}				
					blocked.removeAll(unblock);
					// has no children										
				} else if (node instanceof MTLockNode) {				
					String lockname = ((MTLockNode) node).getLockName();				
					boolean mustblock = false;				
					// assume no double locking in replay				
					for (ThreadState ts : tstates) {
						if (ts.holdsLock(lockname)) {
							mustblock = true;
						}
					}
					if (mustblock) {
						tstates.get(node.getPThreadNr()).setWaitsForLock(lockname);
						blocked.add(node);
					} else {
						tstates.get(node.getPThreadNr()).lock(lockname);	
						children.addAll((Collection<? extends IMTANode>) node.getChildren());
					}																					
				} else if (node instanceof MTUnlockNode) {
					String lockname = ((MTUnlockNode) node).getLockName();
					tstates.get(node.getPThreadNr()).unlock(lockname);							
					children.addAll((Collection<? extends IMTANode>) node.getChildren());
					// enable blocked lockers
					ActionSet unblock = new ActionSet();
					for (ThreadState ts : tstates) {
						if (ts.getWaitsForLock(lockname)) {
							// move locknode from blocked to children
							for (IMTANode lcand : blocked) {
								if (lcand.getPThreadNr() == ts.getThreadNr()) {
									unblock.add(lcand);									
									children.add(lcand);
									break;
								}								
							}
						}
					}
					blocked.removeAll(unblock);
				} else if (node instanceof MTJoinNode) {
					int active = ((MTJoinNode) node).getPThreadNr();
					int joinTarget = ((MTJoinNode) node).getJoinTarget();				
					tstates.get(active).setWantsToJoin(joinTarget);				
					if (tstates.get(joinTarget).isAlive()) {
						blocked.add(node);
					} else {
						children.addAll((Collection<? extends IMTANode>) node.getChildren());
					}									
				} else if (node instanceof MTDefSharedNode) {
					children.addAll((Collection<? extends IMTANode>) node.getChildren());					
				} else if (node instanceof MTUseSharedNode) {
					// find last def, from ampleset recursively
					MTDefSharedNode lastDef = findLastDef((MTUseSharedNode) node, ample);					
					if (lastDef == null) {
						// defined locally
						cov.addLocalDef((MTUseSharedNode) node);
					} else {
						int defnr = lastDef.getPThreadNr();
						int usenr = node.getPThreadNr();
						if (defnr == usenr) {
							// defined locally
							cov.addLocalDef((MTUseSharedNode) node);
						} else {
							// defined remotely
							cov.addRemoteDef((MTUseSharedNode) node);
						}
					}										
					children.addAll((Collection<? extends IMTANode>) node.getChildren());
				} 				
		}		
		return children;
	}
	
	MTDefSharedNode findLastDef(MTUseSharedNode useNode, ActionSet ample) {
		IBinding bd = useNode.getBinding();
		// in this set?
		for (IMTANode cand : ample) {
			if (cand instanceof MTDefSharedNode) {
				if (((MTDefSharedNode) cand).getBinding().equals(bd)) {
					return (MTDefSharedNode) cand;
				}
			}
		}
		// exists other set?
		if (ample.getParent() == null) {
			return null;
		}
		// other set
		return findLastDef(useNode, ample.getParent());
	}
	
	public boolean fitsAmple(ActionSet s, IMTANode cand) {
		for (IMTANode node : s) {
			if (isConflict(node, cand)) {
				return false;
			}
		}				
		return true;
	}
	
	public boolean isConflict(IMTANode node, IMTANode cand) {
		if (node instanceof MTCreateNode || cand instanceof MTCreateNode) {
			return true;
		}
		if (node instanceof MTLockNode && cand instanceof MTLockNode) {
			String l1 = ((MTLockNode) node).getLockName();
			String l2 = ((MTLockNode) cand).getLockName();
			if (l1.compareTo(l2)==0) {
				return true;
			}
		} else if ((node instanceof IMTDUNode) && (cand instanceof IMTDUNode)) {
			// both reads dont matter:
			if ((node instanceof MTUseSharedNode) && (cand instanceof MTUseSharedNode)) {
				return false;
			}
			IBinding b1 = ((IMTDUNode) node).getBinding();
			IBinding b2 = ((IMTDUNode) cand).getBinding();
			if (b1.equals(b2)) {
				return true;
			}
		}
		return false;
	}
	
	private void dumpInterleaving(ArrayDeque<IMTANode> interleaving) {
		Iterator<IMTANode> it = interleaving.iterator();
		IMTANode p = it.next();
		System.out.print(p.getPThreadNr() + " ");
		while (it.hasNext()) {
			IMTANode n = it.next();
			if (n.getPThreadNr() != p.getPThreadNr()) {
				System.out.print(n.getPThreadNr() + " ");
			}
			if (n instanceof MTLockNode) {
				System.out.print("L ");
			} else if (n instanceof MTUnlockNode) {
				System.out.print("U ");
			}
			p = n;
		}			
		System.out.println();
	}	
	
}
