package smtcodan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.IBranchNode;
import org.eclipse.cdt.codan.core.model.cfg.ICfgData;
import org.eclipse.cdt.codan.core.model.cfg.IConnectorNode;
import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;
import org.eclipse.cdt.codan.core.model.cfg.IExitNode;
import org.eclipse.cdt.codan.core.model.cfg.IJumpNode;
import org.eclipse.cdt.codan.core.model.cfg.IPlainNode;
import org.eclipse.cdt.codan.core.model.cfg.ISingleOutgoing;
import org.eclipse.cdt.codan.core.model.cfg.IStartNode;
import org.eclipse.cdt.codan.internal.core.cfg.AbstractBasicBlock;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTDoStatement;
import org.eclipse.cdt.core.dom.ast.IASTEqualsInitializer;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTForStatement;
import org.eclipse.cdt.core.dom.ast.IASTIdExpression;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTStandardFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTWhileStatement;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.cdt.core.dom.ast.IVariable;
import org.eclipse.core.resources.IFile;

import smtcodan.checkers.BoundsChecker;
import smtcodan.checkers.HardCodedPasswordChecker;
import smtcodan.checkers.InformationExposureChecker;
import smtcodan.checkers.IntegerOverFlowChecker;
import smtcodan.checkers.LoopNonTermChecker;
import smtcodan.checkers.MissingRequiredCryptoStepChecker;
import smtcodan.checkers.OperationOnResourceInWrongPhaseOfLifetimeChecker;
import smtcodan.checkers.UnboundedOverflowChecker;
import smtcodan.interpreter.ActionLog;
import smtcodan.interpreter.Interpreter;
import smtcodan.interpreter.PThread;
import smtcodan.pathgen.IBBComparator;
import smtcodan.pathgen.IPathDecMap;
import smtcodan.pathgen.IndBasicBlock;
import smtcodan.pathgen.PathDecMap;
import smtcodan.pathgen.PathGenFctSpace;
import smtcodan.pathgen.ProgramPathIBB;
import smtcodan.quickfixes.SMTConstraintObject;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymPointerOrig;

public class PathExplorer extends Thread implements IPThreadObserver {

	WorkPoolManager see;
	ProgramStructureFacade psf;
	ArrayList<IPathObserver> pathobserverlist;
	ProgramPath partitionStartPath;
	ProgramPathIBB path;
	int decDepthInc; // number of branchNodes in path which are not contained in
						// partitionStartPath
	ArrayDeque<ProgramPath> entryPaths; // for pseudo-inlined nodes
	IPathDecMap pathDecs;
	WorkPool workPool;
	// TODO: move to scheduler class
	ArrayList<PThread> pthreadList;
	PThread activePThread;
	boolean schedulePoint;
	boolean replayOtherThreadMode;
	int otherPThreadnr;
	public Interpreter ps;
	ArrayDeque<IndBasicBlock> btOtherThreadBuffer;

	public static float countBranchNodes = 0;

	// FIXME: proper data structure
	TreeMap<IndBasicBlock, HashSet<String>> contextCache;

	public Interpreter getInterpreter() {
		return ps;
	}

	public PathExplorer(WorkPoolManager see, ProgramStructureFacade psf,
			WorkPool workPool) {
		contextCache = new TreeMap<IndBasicBlock, HashSet<String>>(
				new IBBComparator());
		this.see = see;
		this.psf = psf;
		partitionStartPath = new ProgramPath();
		this.workPool = workPool;
		entryPaths = new ArrayDeque<ProgramPath>();
		schedulePoint = false;
		btOtherThreadBuffer = new ArrayDeque<IndBasicBlock>();
		replayOtherThreadMode = false;
	}

	public PathExplorer(WorkPoolManager see, ProgramStructureFacade psf,
			WorkPool workPool, ProgramPath partitionStartPath) {
		this.see = see;
		this.psf = psf;
		this.partitionStartPath = partitionStartPath;
		this.workPool = workPool;
		entryPaths = new ArrayDeque<ProgramPath>();
		schedulePoint = false;
		btOtherThreadBuffer = new ArrayDeque<IndBasicBlock>();
		replayOtherThreadMode = false;
	}

	enum eDirection {
		FORWARD, // plus switch replayOtherThreadMode; TODO: simplify/unify
		BACKWARD, EXHAUSTED
	}

	IndBasicBlock execStartPath() throws PathUnsatException {
		// FIXME: simplify pathDecs
		for (IBasicBlock ibb : partitionStartPath) {
			if (ibb instanceof IStartNode) {
				entryPaths.add(path.toProgramPath());
				entryPaths.peekLast().add(ibb);
			}
			if (ibb instanceof IExitNode) {
				entryPaths.pollLast();
			}
			if (ibb instanceof IBranchNode) {
				pathDecs.dictateFwNext(new IndBasicBlock(activePThread
						.getPThreadNr(), ibb, entryPaths.peekLast()));
			}
			path.addLast(new IndBasicBlock(activePThread.getPThreadNr(), ibb,
					entryPaths.peekLast()));
			notifyPathObserversEnter(activePThread, ibb);
		}
		IBasicBlock children[] = path.peekLast().getOutgoingNodes();
		IndBasicBlock nextnode = new IndBasicBlock(
				activePThread.getPThreadNr(), children[0],
				entryPaths.peekLast());
		return nextnode;
	}

	ArrayList<ProgramPath> getSplitPaths() {
		ProgramPath splitPath = new ProgramPath();
		Iterator<IBasicBlock> startPathIter = partitionStartPath.iterator();
		Iterator<IBasicBlock> pathIter = path.toProgramPath().iterator();
		ProgramPath tempEntryPath = new ProgramPath();
		while (startPathIter.hasNext()) {
			IBasicBlock nextBb = startPathIter.next();
			splitPath.add(nextBb);
			pathIter.next();

		} // splitPath equals startPath
			// add next decision, differing from path
		boolean finished = false;
		ArrayList<ProgramPath> res = new ArrayList<ProgramPath>();
		ProgramPath newPartitionStartPath = new ProgramPath(); // temp copy for
																// modification
																// try
		newPartitionStartPath.addAll(partitionStartPath);
		int newDecDepthInc = decDepthInc;
		while (!finished && pathIter.hasNext()) {
			IBasicBlock ibb = pathIter.next();
			// actualize partitionStartPath only if split found
			newPartitionStartPath.add(ibb);
			if (ibb instanceof IStartNode) {
				tempEntryPath.clear();
				tempEntryPath.addAll(splitPath);
				if (tempEntryPath.size() > 1) {
					// add startNode
					tempEntryPath.addLast(ibb);
				}
			}
			if (ibb instanceof IBranchNode) {
				newDecDepthInc -= 1;
				IndBasicBlock decibb = new IndBasicBlock(
						activePThread.getPThreadNr(),
						((IBranchNode) ibb).getIncoming(), tempEntryPath);
				if (pathDecs.hasBwNext(decibb)) {
					finished = true;
					// FIXME only unchecked siblings (not unsat ones)
					ArrayList<IBasicBlock> openBranches = pathDecs
							.peekOpenChildren(decibb);
					for (IBasicBlock branch : openBranches) {
						ProgramPath oneres = new ProgramPath();
						oneres.addAll(splitPath);
						oneres.add(branch);
						res.add(oneres);
					}
					partitionStartPath = newPartitionStartPath;
					decDepthInc = newDecDepthInc;
					return res;
				} else {
					splitPath.addLast(ibb);
				}
			} else {
				splitPath.addLast(ibb);
			}
		}
		return null;
	}

	boolean checkLoopClosed() throws InfiniteLoopException {
		// only check first (longest) closed loop
		Iterator<IndBasicBlock> iter = path.iterator();
		IndBasicBlock decibb = path.getLast();
		IBasicBlock decNode = decibb.getLocal();
		IBasicBlock loopNode = null;
		int loopLength = -1;
		int i = 0;
		while (iter.hasNext()) {
			IndBasicBlock candibb = iter.next();
			IBasicBlock cand = candibb.getLocal();
			i++;
			if (cand.equals(decNode)
					&& (decibb.getPThreadNr() == candibb.getPThreadNr())) {
				if (i < path.size()) {
					loopNode = cand;
					loopLength = i;
					break;
				}
			}
		}
		boolean firstClosed = true;
		while (iter.hasNext()) {
			IndBasicBlock candibb = iter.next();
			IBasicBlock cand = candibb.getLocal();
			i++;
			if (cand.equals(decNode)
					&& (decibb.getPThreadNr() == candibb.getPThreadNr())
					&& (i < path.size() - 1)) {
				firstClosed = false;
			}
		}
		if ((loopNode != null) && (loopLength > 0)) {
			notifyPathObserversLoopClosed(loopNode, loopLength, firstClosed);
		}
		return false;
	}

	public void run() {
		System.out.println("worker started (id " + this.getId() + ")");
		Solver sv = new Solver();
		pthreadList = new ArrayList<PThread>();
		ps = new Interpreter(psf, sv, false);
		BoundsChecker ac = new BoundsChecker(ps, sv, this);
		PathValidator pv = new PathValidator(ps, sv);
		LoopNonTermChecker ntc = new LoopNonTermChecker(ps, sv);
		UnboundedOverflowChecker uofc = new UnboundedOverflowChecker(ps, sv);
		IntegerOverFlowChecker iofc = new IntegerOverFlowChecker(ps, sv, this);
		InformationExposureChecker iec = new InformationExposureChecker(ps, sv,
				this);
		MissingRequiredCryptoStepChecker mrcsc = new MissingRequiredCryptoStepChecker(
				ps, sv, this);

		OperationOnResourceInWrongPhaseOfLifetimeChecker miwpol = new OperationOnResourceInWrongPhaseOfLifetimeChecker(
				ps, sv, this);

		HardCodedPasswordChecker hcpc = new HardCodedPasswordChecker(ps, sv,
				this);

		pathobserverlist = new ArrayList<IPathObserver>();
		pathobserverlist.add(ps);
		pathobserverlist.add(pv);

		pathobserverlist.add(ntc);
		pathobserverlist.add(uofc);

		ps.attach(this);
		ps.attach(ac);
		ps.attach(iofc);
		ps.attach(iec);
		ps.attach(mrcsc);
		ps.attach(miwpol);
		ps.attach(hcpc);

		pathDecs = new PathDecMap(Config.getLoopDepthBound()); // for
																// backtracking
		ArrayDeque<PathGenFctSpace> stack = new ArrayDeque<PathGenFctSpace>(); // for
																				// multiple
																				// calls
																				// in
																				// one
																				// statement
		ps.initEnv();

		// start pthread and put in list
		SymFctSignature fsign = psf.getSymFctSignByCfgNode(psf
				.getRootCFGStartNode());
		activePThread = new PThread(ps, fsign);
		pthreadList.add(activePThread);
		activePThread.setInitialized();

		// start path
		path = new ProgramPathIBB();
		IndBasicBlock actnode = null;
		// countBranchNodes = 0;
		decDepthInc = 0; // number of branchNodes in current Path minus those in
							// partitionStartPath
		boolean splitBlocked = false; // if split try doesn't work, try again
										// after next DecNode
		eDirection state = eDirection.FORWARD;
		try {
			if (partitionStartPath.size() == 0) {
				IStartNode mainStart = psf.getRootCFGStartNode();
				ProgramPath mainEntryPath = new ProgramPath(); // for hash for
																// IndBasicBlock...
				mainEntryPath.add(mainStart);
				entryPaths.addLast(mainEntryPath);
				IndBasicBlock mainStartIBB = new IndBasicBlock(
						activePThread.getPThreadNr(), mainStart, mainEntryPath);
				actnode = mainStartIBB;
			} else {
				actnode = execStartPath();
				// decDepthInc still 0;
			}
		} catch (PathUnsatException e) {
			workPool.reportTreeUnsatPath(path);
			state = eDirection.EXHAUSTED;

		}
		while (state != eDirection.EXHAUSTED) {
			if (state == eDirection.FORWARD) {
				if (workPool.splitNeeded()) {
					// if enough decision depth return split path
					if ((decDepthInc >= 1) && (!splitBlocked)) {
						System.out.println("try partition split (worker id "
								+ this.getId() + ")");
						ArrayList<ProgramPath> splitPaths = this
								.getSplitPaths();
						if (splitPaths == null) {
							splitBlocked = true; // FIXME: check consistency
													// with decDepthInc
						}
						workPool.addSplitPaths(splitPaths); // also for
															// splitPaths==null,
															// to notify others
					}
				}
				if (!btOtherThreadBuffer.isEmpty()) {
					// replay other threads' nodes
					replayOtherThreadMode = true;
					IndBasicBlock ot = btOtherThreadBuffer.pollFirst();
					otherPThreadnr = ot.getPThreadNr();
					path.add(ot);
					try {
						notifyPathObserversEnter(
								pthreadList.get(ot.getPThreadNr()),
								ot.getLocal());
					} catch (PathUnsatException e) {
						// e.printStackTrace();
					}
					replayOtherThreadMode = false;
					continue;
				}
				// forward path extension
				if (schedulePoint) {
					// last node was unlocknode?
					activePThread.setNextNode(actnode);
					int scheduled = LTNSchedule();
					activePThread = pthreadList.get(scheduled);
					actnode = activePThread.getNextNode();
					schedulePoint = false;
					System.out.println("switch to thread " + scheduled);
				}
				try {

					path.addLast(actnode);
					if (actnode.getLocal() instanceof IBranchNode) {
						// count branch nodes for statistics
						countBranchNodes++;
						// adjust decDepth before PathValidator is called
						// vasantha ask what do they mean by splitblocked and
						// from here only the path unsat is called
						decDepthInc += 1;
						splitBlocked = false;
					}
					// vasantha for the else branch here an exception is thrown
					notifyPathObserversEnter(activePThread, actnode.getLocal());
					if (actnode.getLocal() instanceof IExitNode) {
						IExitNode exitNode = (IExitNode) actnode.getLocal();
						if (!exitNode.getStartNode().equals(
								psf.getRootCFGStartNode())) {
							// not for main exit...
							String endLiveContext = ps.getEndLiveContext();
							// check already exists
							if (contextCache.containsKey(path.getLast())) {
								HashSet<String> hset = contextCache.get(path
										.getLast());
								if (hset.contains(endLiveContext)) {
									if (Config.shouldMergePaths()) {
										throw new PathMergedException();
									}
								} else {
									hset.add(endLiveContext);
								}
							} else {
								HashSet<String> hset = new HashSet<String>();
								hset.add(endLiveContext);
								contextCache.put(path.getLast(), hset);
							}
						}
						entryPaths.pollLast();
						if (stack.peekLast() != null) {
							IBasicBlock callNode = stack.peekLast()
									.getCallNode();
							if (callNode == null) {
								// exiting main, fake return
								state = eDirection.BACKWARD;
								continue;
							} else if (callNode instanceof IDecisionNode) {
								// probably nothing to do !?
							}
							// for return value to call node:
							actnode = new IndBasicBlock(
									activePThread.getPThreadNr(), callNode,
									entryPaths.peekLast());
							path.addLast(actnode);
							notifyPathObserversEnter(activePThread,
									actnode.getLocal());
							IBasicBlock nextStartNode = stack.peekLast()
									.popOpenStartNode();
							if (nextStartNode != null) {
								// open function call
								actnode = new IndBasicBlock(
										activePThread.getPThreadNr(),
										nextStartNode, entryPaths.peekLast());
								continue;
							} else {
								actnode = new IndBasicBlock(
										activePThread.getPThreadNr(), stack
												.peekLast().getReturnNode(),
										entryPaths.peekLast());
								stack.removeLast();
								continue;
							}
						} else { // exiting main
							workPool.reportTreeSatPath(path);
							System.out
									.println(" +++ Satpath reported +++ (now backtracking)started");
							state = eDirection.BACKWARD;
							continue;
						}
					} else if (actnode.getLocal() instanceof IStartNode) {
						IStartNode locStart = (IStartNode) actnode.getLocal();
						entryPaths.addLast(path.toProgramPath());
						// here we get the outgoing nodes from the previous node
						// in the path
						actnode = new IndBasicBlock(
								activePThread.getPThreadNr(),
								locStart.getOutgoing(), entryPaths.peekLast());
						continue;
					} else if (actnode.getLocal() instanceof IBranchNode) {
						// count branch nodes for statistics
						countBranchNodes++;
						IBranchNode locBranch = (IBranchNode) actnode
								.getLocal();
						actnode = new IndBasicBlock(
								activePThread.getPThreadNr(),
								locBranch.getOutgoing(), entryPaths.peekLast());
						continue;
					} else if (actnode.getLocal() instanceof IJumpNode) {
						IJumpNode locJump = (IJumpNode) actnode.getLocal();
						actnode = new IndBasicBlock(
								activePThread.getPThreadNr(),
								locJump.getJumpNode(), entryPaths.peekLast());
						continue;
					} else if (actnode.getLocal() instanceof IDecisionNode) {
						// been here before?
						IASTNode data = (IASTNode) ((ICfgData) actnode
								.getLocal()).getData();
						IASTNode parent = null;
						if (data != null) {
							parent = data.getParent();
						}
						// vasantha ask paul what to do here
						if (Config.shouldCheckNonTerm()
								|| Config.shouldCheckTerm()
								|| Config.shouldCheckUnboundedOverflow()) {
							if ((data == null) && (parent == null)) { // empty
																		// for-loop
								checkLoopClosed();
							} else if (parent instanceof IASTWhileStatement
									|| parent instanceof IASTDoStatement
									|| parent instanceof IASTForStatement) {
								// only loops
								checkLoopClosed();
							}
						}
						// TODO: move redundant function call code with
						// IPlainNode below into new method
						IDecisionNode locDec = (IDecisionNode) actnode
								.getLocal();
						CxxDecisionNode cdn = (CxxDecisionNode) locDec;
						IASTExpression branchexpr = (IASTExpression) cdn
								.getNode();

						// check function call node; consider nested calls in
						// one statement
						ArrayList<IASTName> fcnames = ps.getFunctionNames();

						if (!fcnames.isEmpty()) {
							// calling node
							if (containsLocalCall(fcnames, path.toProgramPath())) {
								// pick return node
								IndBasicBlock returnNode = null;
								IBasicBlock nextLocal = pathDecs
										.getFwNext(actnode);
								returnNode = new IndBasicBlock(
										activePThread.getPThreadNr(),
										nextLocal, entryPaths.peekLast());
								stack.addLast(new PathGenFctSpace(returnNode
										.getLocal()));
								stack.peekLast().setCallNode(locDec);
								for (IASTName fcallName : fcnames) {
									synchronized (fcallName) {
										IBinding fbinding = null;
										fbinding = fcallName.resolveBinding();
										IStartNode cfgStartNode = psf
												.getCFGStartNodeByFBinding(fbinding);
										if (cfgStartNode != null) {
											// project-local function
											stack.peekLast().pushOpenStartNode(
													cfgStartNode);
										}
									}
								}
								if (stack.peekLast().hasOpenCall()) {
									// enter project-local function call
									IStartNode newStartNode = (IStartNode) stack
											.peekLast().popOpenStartNode();

									// new entry path for nextnode!
									ProgramPath nextentrypath = path
											.toProgramPath();
									nextentrypath
											.add((IBasicBlock) newStartNode);

									actnode = new IndBasicBlock(
											activePThread.getPThreadNr(),
											newStartNode, nextentrypath);
									continue;
								}
							} else {
								// only library call(s)
								IBasicBlock nextLocal = pathDecs
										.getFwNext(actnode);
								actnode = new IndBasicBlock(
										activePThread.getPThreadNr(),
										nextLocal, entryPaths.peekLast());
								continue;
							}
						} else {
							// no function call
							IBasicBlock nextLocal = null;
							if (pathDecs.hasFwNext(actnode)) {
								nextLocal = pathDecs.getFwNext(actnode);
							} else {
								IBasicBlock children[] = actnode
										.getOutgoingNodes();
								if (Config.shouldSkipOutBoundedLoops()) {
									// 1. check termination (linear unnested
									// single-path loop, requires fixpoint
									// absence)
									// vasantha ask paul about the exception
									boolean term = ps
											.getTerminatesContextFree(locDec);
									if (!term) {
										// do not skip
										System.out
												.println("  path unsat: loop bounded");
										throw new PathUnsatException();
									} else {
										// check not read later
										// 2. read set (breadth-first, cfg-node
										// coverage); requires no read of
										// loopvars
										if (ps.isDeadLoop(locDec)) {
											// invalidate loop vars
											ps.invalidateLoopVarContext();
											// skip, jump out (get jump node)
											nextLocal = ((ISingleOutgoing) children[1])
													.getOutgoing();
											System.out
													.println("   loop bounded, sound skip-out: loopvars all dead \n");
										} else {
											// don't skip
											System.out
													.println("  path unsat: loop bounded");
											throw new PathUnsatException();
										}
									}
								} else {
									System.out
											.println("  path unsat: loop bounded");
									throw new PathUnsatException();
								}
							}
							actnode = new IndBasicBlock(
									activePThread.getPThreadNr(), nextLocal,
									entryPaths.peekLast());
							continue;
						}
					} else if (actnode.getLocal() instanceof IConnectorNode) {
						IConnectorNode locCon = (IConnectorNode) actnode
								.getLocal();
						actnode = new IndBasicBlock(
								activePThread.getPThreadNr(),
								((ISingleOutgoing) locCon).getOutgoing(),
								entryPaths.peekLast());
						continue;
					} else {
						// plain node, check for function call, consider nested
						// calls
						IPlainNode locpnode = (IPlainNode) actnode.getLocal();

						// ArrayList<IASTName> fcnames =
						// fccollector.getFunctionNames();
						ArrayList<IASTName> fcnames = new ArrayList<IASTName>();
						fcnames.addAll(ps.getFunctionNames());
						if (!fcnames.isEmpty()) {
							// calling node
							if (containsLocalCall(fcnames, path.toProgramPath())) {
								IBasicBlock returnNode = locpnode.getOutgoing();
								stack.addLast(new PathGenFctSpace(returnNode));
								stack.peekLast().setCallNode(locpnode);
								for (IASTName fcallName : fcnames) {
									synchronized (fcallName) {
										IBinding fbinding = fcallName
												.resolveBinding();
										// function call by function pointer,
										// TODO: find cleaner solution
										if (fbinding instanceof IVariable) {
											FctPtrResolver resolver = new FctPtrResolver(
													(IVariable) fbinding,
													path.toProgramPath());
											fbinding = resolver.resolve();
										}
										IStartNode cfgStartNode = psf
												.getCFGStartNodeByFBinding(fbinding);
										if (cfgStartNode != null) {
											// project-local function
											stack.peekLast().pushOpenStartNode(
													cfgStartNode);
										}
									}
								}
								if (stack.peekLast().hasOpenCall()) {
									// enter project-local function call
									// vasantha here we go to the other file
									// which has the local function calls like
									// here it is for printf
									IStartNode newStartNode = (IStartNode) stack
											.peekLast().popOpenStartNode();
									// new entry path for nextnode
									ProgramPath nextentrypath = path
											.toProgramPath();
									nextentrypath
											.add((IBasicBlock) newStartNode);
									actnode = new IndBasicBlock(
											activePThread.getPThreadNr(),
											newStartNode, nextentrypath);
									continue;
								} else {
									IBasicBlock child[] = actnode.getLocal()
											.getOutgoingNodes();
									actnode = new IndBasicBlock(
											activePThread.getPThreadNr(),
											child[0], entryPaths.peekLast());
									continue;
								}
							} else {
								// only library call(s)
								// here you get the outgoing nodes
								IBasicBlock child[] = actnode.getLocal()
										.getOutgoingNodes();
								actnode = new IndBasicBlock(
										activePThread.getPThreadNr(), child[0],
										entryPaths.peekLast());
								continue;
							}
						}
						// no function call node
						IBasicBlock child[] = actnode.getLocal()
								.getOutgoingNodes();
						actnode = new IndBasicBlock(
								activePThread.getPThreadNr(), child[0],
								entryPaths.peekLast());
						continue;
					}
				} catch (PathUnsatException e) {
					// e.printStackTrace();
					if (Config.shouldStoreUnsatPaths()) {
						workPool.reportTreeUnsatPath(path);
					}
					// TODO cleanup
					// last decnode on path:
					// vasantha path unsat is also handled here
					Iterator<IndBasicBlock> deciter = path.descendingIterator();
					boolean found = false;
					IndBasicBlock decibb = null;
					while (deciter.hasNext() && !found) {
						IndBasicBlock ibb = deciter.next();
						IBasicBlock bb = ibb.getLocal();
						if (bb instanceof IDecisionNode) {
							found = true;
							decibb = ibb;
						}
					}
					pathDecs.setUnsatLastDec(decibb);
					state = eDirection.BACKWARD;
					continue;
				} catch (InfiniteLoopException e) {
					state = eDirection.EXHAUSTED;
					continue;
				} catch (PathMergedException e) {
					System.out
							.println("    *** path pruned (merged) (now backtracking)");
					state = eDirection.BACKWARD;
					continue;
				}
			} else { // state == BACKWARD
				// backtracking

				Iterator<IndBasicBlock> decIter = path.descendingIterator();
				IBasicBlock lastRemoved = null; // for restoring
												// open-fcall-stack
				IBasicBlock secondLastRemoved = null;

				while (decIter.hasNext() && (state == eDirection.BACKWARD)) {
					IndBasicBlock ibb = decIter.next();
					if (ibb.getPThreadNr() != activePThread.getPThreadNr()) {
						// save for redo in case of backtrack between branchnode
						// and decisionnode
						btOtherThreadBuffer.addFirst(ibb);
						// remove
						notifyPathObserversBackTrack(
								pthreadList.get(ibb.getPThreadNr()),
								ibb.getLocal());
						decIter.remove();
						continue;
					}
					// backtracking in same thread:
					if (ibb.getLocal() instanceof IBranchNode) {
						btOtherThreadBuffer = new ArrayDeque<IndBasicBlock>();
						if (decDepthInc == 0) {
							state = eDirection.EXHAUSTED;
							break;
						}
						decDepthInc -= 1;
					}
					// vasantha else branch is handled here so ask paul
					if (ibb.getLocal() instanceof IDecisionNode) {
						if (pathDecs.hasBwNext(ibb)) {
							IBasicBlock nextChild = pathDecs.getBwNext(ibb);
							actnode = new IndBasicBlock(
									activePThread.getPThreadNr(), nextChild,
									entryPaths.peekLast());
							state = eDirection.FORWARD;
							continue;
						} else {
							pathDecs.remove(ibb);
							// continue backtracking...
						}
					}
					// backtrack node
					// update entryPaths
					if (ibb.getLocal() instanceof IExitNode) {
						ProgramPath newEntryPath = ibb.getEntryPath();
						entryPaths.addLast(newEntryPath);

					} else if (ibb.getLocal() instanceof IStartNode) {
						entryPaths.removeLast();
					}
					// update callnode-fcall-stack
					if (ibb.getLocal() instanceof IStartNode) {
						IndBasicBlock ibbsl = path.peekThirdLast();
						if (ibbsl == null) {
							state = eDirection.EXHAUSTED;
							break;
						}
						IBasicBlock ibsl = ibbsl.getLocal();
						if (ibsl instanceof IExitNode) {
							// backtrack return with open fcall on stack; push
							// fcall stack
							stack.peekLast().pushOpenStartNode(ibb.getLocal());
							// remove three (2+1)
							decIter.remove();
							IndBasicBlock tempIbb = decIter.next();
							if (tempIbb.getLocal() instanceof IBranchNode) {
								decDepthInc -= 1;
							}
							decIter.remove();
							tempIbb = decIter.next();
							if (tempIbb.getLocal() instanceof IBranchNode) {
								decDepthInc -= 1;
							}
						} else {
							// backtrack normal fcall enter; pop stack
							stack.removeLast();
						}
					} else if (ibb.getLocal() instanceof IExitNode) {
						// push (empty) stack
						IBasicBlock returnNode = secondLastRemoved;
						IBasicBlock callNode = lastRemoved;
						IBasicBlock ibsl = path.peekThirdLast().getLocal();
						if (ibsl instanceof IExitNode
								&& (ibb.getEntryPath().size() == 1)) {
							// special case return before exit main:
							lastRemoved = ibb.getLocal(); // will become
															// returnNode in
															// next iteration
						} else {
							PathGenFctSpace pgfs = new PathGenFctSpace(
									returnNode);
							pgfs.setCallNode(callNode);
							stack.addLast(pgfs);
							secondLastRemoved = lastRemoved;
							lastRemoved = ibb.getLocal();
						}
					} else {
						secondLastRemoved = lastRemoved;
						lastRemoved = ibb.getLocal();
					}
					// remove
					notifyPathObserversBackTrack(activePThread, ibb.getLocal());
					decIter.remove();
				}
				if (state == eDirection.BACKWARD) {
					// backtracked to main entry
					state = eDirection.EXHAUSTED;
				}
			}
		} // end while // (state == EXHAUSTED)
		System.out.println("partition exhausted, thread reporting death (id "
				+ this.getId() + ").");
		workPool.reportDead(this);
	}

	void notifyPathObserversEnter(PThread pthread, IBasicBlock cfgnode)
			throws PathUnsatException {
		for (IPathObserver po : pathobserverlist) {
			po.enter(pthread, cfgnode);
		}
	}

	void notifyPathObserversBackTrack(PThread pthread, IBasicBlock cfgnode) {
		for (IPathObserver po : pathobserverlist) {
			po.goBackward(pthread, cfgnode); // not activePThread, backtracking
												// per pthread!
		}
	}

	void notifyPathObserversLoopClosed(IBasicBlock cand, int stemLength,
			boolean firstClosed) throws InfiniteLoopException {
		for (IPathObserver po : pathobserverlist) {
			po.loopClosed(this, cand, stemLength, firstClosed);
		}
	}

	// TODO: remove, and use interpreter method!
	class FctPtrResolver extends ASTVisitor {

		IVariable fptr;
		ProgramPath path;
		IBinding fct;
		boolean resolved;

		FctPtrResolver(IVariable fptr, ProgramPath path) {
			shouldVisitDeclarators = true;
			this.fptr = fptr;
			this.path = path;
			this.resolved = false;
		}

		IBinding resolve() {
			Iterator<IBasicBlock> deciter = path.descendingIterator();
			while (deciter.hasNext() && !resolved) {
				AbstractBasicBlock bb = (AbstractBasicBlock) deciter.next();
				IASTNode in = (IASTNode) bb.getData();
				if (in == null) {
					continue;
				}
				synchronized (in) {
					in.accept(this);
				}
			}
			return fct;
		}

		public int visit(IASTDeclarator decl) {
			if (!(decl instanceof IASTStandardFunctionDeclarator)) {
				return PROCESS_ABORT;
			}
			IASTDeclarator ndecl = decl.getNestedDeclarator();
			IASTName fptrname = ndecl.getName();
			if (!fptrname.resolveBinding().equals(fptr)) {
				return PROCESS_ABORT;
			}
			IASTInitializer ini = decl.getInitializer();
			IASTIdExpression fctid = (IASTIdExpression) ((IASTEqualsInitializer) ini)
					.getInitializerClause();
			IASTName fname = fctid.getName();
			fct = fname.resolveBinding();
			resolved = true;
			return PROCESS_ABORT;
		}
	}

	boolean containsLocalCall(ArrayList<IASTName> fcnames, ProgramPath path) {
		for (IASTName fcallName : fcnames) {
			synchronized (fcallName) {
				IBinding fbinding = fcallName.resolveBinding();
				if (fbinding instanceof IVariable) {
					// function pointer called
					FctPtrResolver resolver = new FctPtrResolver(
							(IVariable) fbinding, path);
					fbinding = resolver.resolve();
				}
				IStartNode cfgStartNode = psf
						.getCFGStartNodeByFBinding(fbinding);
				if (cfgStartNode != null) {
					return true;
				}
			}
		}
		return false;
	}

	public void reportProblem(String problemid, IFile file, int startline,
			String problemMessage, String problemDescription,
			SMTConstraintObject co, ActionLog nvlist) {

		workPool.queueProblem(problemid, file, startline, problemMessage,
				problemDescription, co, nvlist);
		System.out.println(workPool.problemmap.size());

	}

	@Override
	public void updateStartPThread(int tnr, IStartNode startnode,
			SymPointerOrig args) {
		PThread newthread = new PThread(ps);
		// correct entry path?
		// startblock with new threadnr
		newthread.setNextNode(new IndBasicBlock(tnr, startnode,
				new ProgramPath()));
		newthread.setArgs(args);
		// TODO init with args
		pthreadList.add(newthread);
		path.setUsesMultiThreading(); // may enable race checker
		System.out.println("new thread nr " + tnr + " created");
	}

	public void backtrackStartPThread(int tnr) {
		pthreadList.remove(tnr);
	}

	int LTNSchedule() {
		// returns lowest possible pthread number (id)
		// find locked locks
		ArrayDeque<String> lockedLocks = new ArrayDeque<String>();
		for (PThread pthread : pthreadList) {
			lockedLocks.addAll(pthread.getOwnedLocks());
		}
		// find woken up waiter list
		ArrayList<Integer> wokenUps = new ArrayList<Integer>();
		for (PThread pthread : pthreadList) {
			if (pthread.getWaitsForLock()) {
				String wanted = pthread.getWantedLockName();
				if (!lockedLocks.contains(wanted)) {
					wokenUps.add(pthread.getPThreadNr());
				}
			}
		}
		for (PThread pthread : pthreadList) {
			boolean maySchedule = pthread.isAlive()
					&& !pthread.getWantsToJoin()
					&& (!pthread.getWaitsForLock() || wokenUps.contains(pthread
							.getPThreadNr()));
			if (maySchedule) {
				// put not scheduled wokenUps to sleep again
				int wokenScheduled = -1;
				if (wokenUps.contains(pthread.getPThreadNr())) {
					wokenScheduled = pthread.getPThreadNr();
					PThread ws = pthreadList.get(wokenScheduled);
					ws.lock(ws.getWantedLockName());
					ws.unsetWaitsForLock();
				}
				return pthread.getPThreadNr();
			}
		}
		(new Exception("thread schedule problem")).printStackTrace();
		return 0;
	}

	@Override
	public void updateJoinPThread(Integer tnr) {
		int ptnr = -1;
		PThread pt = null;
		if (replayOtherThreadMode) {
			ptnr = otherPThreadnr;
		} else {
			ptnr = activePThread.getPThreadNr();
		}
		pt = pthreadList.get(ptnr);
		// schedule decision
		pt.setWantsToJoin(tnr);
		schedulePoint = true;
		System.out.println("wants to join thread " + tnr);
	}

	public void backtrackJoinPThread(int waitingThread) {
		pthreadList.get(waitingThread).unsetWantsToJoin();
	}

	@Override
	public void updateLock(String lockname) {
		// held by anybody?
		int ptnr = -1;
		if (replayOtherThreadMode) {
			ptnr = otherPThreadnr;
		} else {
			ptnr = activePThread.getPThreadNr();
		}
		boolean mustBlock = false;
		boolean doubleLock = false;
		for (PThread thread : pthreadList) {
			if (thread.holdsLock(lockname)) {
				if (thread.getPThreadNr() == ptnr) {
					doubleLock = true;
				} else {
					mustBlock = true;
					break;
				}
			}
		}
		if (mustBlock) {
			pthreadList.get(ptnr).setWaitsForLock(lockname);
			schedulePoint = true;
		} else if (doubleLock) {
			// don't lock
			// TODO necessary at all??
		} else {
			pthreadList.get(ptnr).lock(lockname);
		}

	}

	@Override
	public void updateUnlock(String lockname) {
		int ptnr = -1;
		PThread pt = null;
		if (replayOtherThreadMode) {
			ptnr = otherPThreadnr;
		} else {
			ptnr = activePThread.getPThreadNr();
		}
		pt = pthreadList.get(ptnr);
		if (!pt.holdsLock(lockname)) {
			// double unlock (consider backtracking)
			// TODO: necessary at all??
		} else {
			pt.releaseLock(lockname);
		}
		schedulePoint = true;
		// one waiting thread will acquire lock
	}

	@Override
	public void updateExitThread(int pThreadNr) {
		// add exitnode for backtracking
		IBasicBlock children[] = path.peekLast().getOutgoingNodes();
		IndBasicBlock exitnode = new IndBasicBlock(
				activePThread.getPThreadNr(), children[0],
				entryPaths.peekLast());
		// path.add(exitnode);
		// TODO: pthread exit value
		// FIXME: double insertion of pthread exit node in path?
		if (!replayOtherThreadMode) {
			try {
				path.add(exitnode);
				notifyPathObserversEnter(activePThread, exitnode.getLocal());
				entryPaths.pollLast();
			} catch (PathUnsatException e) {
				// e.printStackTrace();
			}
		}
		// set dead
		pthreadList.get(pThreadNr).setFinished();
		// activate waiting threads
		for (PThread pthread : pthreadList) {
			if (pthread.getWantsToJoin()) {
				int t = pthread.getJoinTarget();
				if (t == pThreadNr) {
					pthread.unsetWantsToJoin();
				}
			}
		}
		// schedule
		schedulePoint = true;
	}

	public void bugDetected(String id, IFile file, IASTFileLocation loc,
			String problemMessage, String problemDescription, ActionLog nvlist) {
		BugInfo info = BugInfo.get(id, file, loc, problemMessage,
				problemDescription, nvlist);
		System.out.println(path.size());
		// vasantha here we add the bug info and the depth of the path
		path.addBugInfo(path.size() - 1, info);

	}

	public void backtrackExitPThread(int tnr) {
		pthreadList.get(tnr).unsetFinished();
		System.out.println("backtrack exit " + tnr);
	}

}
