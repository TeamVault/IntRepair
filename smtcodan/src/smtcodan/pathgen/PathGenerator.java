///**
//   [Class description.  This class is used for path generation]
//   
//   [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
//   about desired improvements, etc.]
//   
//   @author Andreas Ibing
//   @version $Revision: x  Date: x hour: 
//**/
//package smtcodan.pathgen;
//
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
//import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
//import org.eclipse.cdt.codan.core.model.cfg.IBranchNode;
//import org.eclipse.cdt.codan.core.model.cfg.ICfgData;
//import org.eclipse.cdt.codan.core.model.cfg.IConnectorNode;
//import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;
//import org.eclipse.cdt.codan.core.model.cfg.IExitNode;
//import org.eclipse.cdt.codan.core.model.cfg.IJumpNode;
//import org.eclipse.cdt.codan.core.model.cfg.IPlainNode;
//import org.eclipse.cdt.codan.core.model.cfg.ISingleOutgoing;
//import org.eclipse.cdt.codan.core.model.cfg.IStartNode;
//import org.eclipse.cdt.codan.internal.core.cfg.AbstractBasicBlock;
//import org.eclipse.cdt.core.dom.ast.ASTVisitor;
//import org.eclipse.cdt.core.dom.ast.IASTCompoundStatement;
//import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
//import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
//import org.eclipse.cdt.core.dom.ast.IASTEqualsInitializer;
//import org.eclipse.cdt.core.dom.ast.IASTExpression;
//import org.eclipse.cdt.core.dom.ast.IASTFunctionDeclarator;
//import org.eclipse.cdt.core.dom.ast.IASTIdExpression;
//import org.eclipse.cdt.core.dom.ast.IASTInitializer;
//import org.eclipse.cdt.core.dom.ast.IASTName;
//import org.eclipse.cdt.core.dom.ast.IASTNode;
//import org.eclipse.cdt.core.dom.ast.IASTStandardFunctionDeclarator;
//import org.eclipse.cdt.core.dom.ast.IASTStatement;
//import org.eclipse.cdt.core.dom.ast.IASTWhileStatement;
//import org.eclipse.cdt.core.dom.ast.IBinding;
//import org.eclipse.cdt.core.dom.ast.IVariable;
//import org.eclipse.cdt.core.index.IIndexBinding;
//import org.eclipse.cdt.core.index.IIndexName;
//import org.eclipse.cdt.internal.core.model.ext.ICElementHandle;
//import org.eclipse.cdt.internal.ui.viewsupport.IndexUI;
//import org.eclipse.core.runtime.CoreException;
//
//import smtcodan.FunctionCallCollector;
//import smtcodan.ProgramPath;
//import smtcodan.ProgramStructureFacade;
//
//// TODO: Auto-generated Javadoc
///**
// * The Class PathGenerator.
// */
//public class PathGenerator {
//	
//// TODO: maybe joint data structure for backTrackPath and pathDecs -> joint remove()...	
//// TODO bound maxCallDepth for recursion... , e.g. HashMap<IStartNode, Integer> fctCallDepths;	
//	
//	/** The program structure facade object psf. */
//public ProgramStructureFacade psf;			
//	
//	/** The entry paths array. */
//	public ArrayDeque<ProgramPath> entryPaths; 	// for pseudo-inlined nodes
//	
//	/** The path decs object. */
//	public IPathDecMap pathDecs;  // for backtracking	
//	
//	/** The back track path obeject. */
//	ProgramPathIBB backTrackPath;
//	
//	/** The next path ibb object. */
//	ProgramPathIBB nextPathIBB;
//	
//	/** The paths exhausted boolean variable. */
//	boolean pathsExhausted;
//	
//	/** The next path number. */
//	int nextPathNumber;
//	
//	/** The stack. */
//	ArrayDeque<PathGenFctSpace> stack;  // for multiple calls in one statement
//	
//	/**
//	 * Instantiates a new path generator.
//	 *
//	 * @param apsf the apsf
//	 */
//	public PathGenerator(ProgramStructureFacade apsf) {
//		pathsExhausted = false;		
//		psf = apsf;
//		pathDecs = new PathDecMap();	
//		nextPathNumber = 1;
//		stack = new ArrayDeque<PathGenFctSpace>();	
//		entryPaths = new ArrayDeque<ProgramPath>();
//		ProgramPathIBB.resetPathCounter();
//	}	
//	
//	/**
//	 * Checks for next path.
//	 *
//	 * @return true, if successful
//	 */
//	public boolean hasNextPath() {
//		if (pathsExhausted) {
//			return false;
//		}
//		if (nextPathIBB != null) {
//			return true;
//		}
//		nextPathIBB = findNextPath();					
//		if (nextPathIBB!=null) {
//			return true;
//		} else {
//			return false;
//		}
//	}	
//
//	/**
//	 * Gets the next path.
//	 *
//	 * @return the next path
//	 */
//	public ProgramPath getNextPath() {
//		ProgramPath actPath = nextPathIBB.toProgramPath();
//		nextPathIBB = null;
//		return actPath;		
//	}
//	
//	/**
//	 * Gets the next start path.
//	 *
//	 * @return the next start path
//	 */
//	ProgramPathIBB getNextStartPath() {
//		ProgramPathIBB startPath = new ProgramPathIBB();
//		if (backTrackPath == null) {			
//			// path 1
//			IStartNode mainStart = psf.getRootCFGStartNode();
//			ProgramPath mainEntryPath = new ProgramPath(); // for hash for IndBasicBlock...
//			mainEntryPath.add(mainStart);
//			entryPaths.addLast(mainEntryPath);
//			IndBasicBlock mainStartIBB = new IndBasicBlock(mainStart, mainEntryPath);								
//			startPath.add(mainStartIBB);							
//			return startPath;
//		} else {
//			// backtracking
//			Iterator<IndBasicBlock> decIter = backTrackPath.descendingIterator();				
//			IBasicBlock lastRemoved = null; // for restoring open-fcall-stack
//			IBasicBlock secondLastRemoved = null;			
//			while (decIter.hasNext()) {
//				IndBasicBlock ibb = decIter.next();									
//				if (ibb.getLocal() instanceof IDecisionNode) {
//					if (pathDecs.hasBwNext(ibb)) {
//						IBasicBlock nextChild = pathDecs.getBwNext(ibb);
//						startPath.addAll(backTrackPath);					
//						startPath.add(new IndBasicBlock(nextChild, entryPaths.peekLast()));
//						return startPath;						
//					} else {
//						pathDecs.remove(ibb);
//						// continue backtracking...												
//					}
//				}		
//				// backtrack node									
//				// update entryPaths				
//				if (ibb.getLocal() instanceof IExitNode) {					
//					ProgramPath newEntryPath = ibb.getEntryPath();
//					entryPaths.addLast(newEntryPath);
//				} else if (ibb.getLocal() instanceof IStartNode) {
//					entryPaths.removeLast();
//				} 									
//				// update callnode-fcall-stack
//				if (ibb.getLocal() instanceof IStartNode) {
//					IndBasicBlock ibbsl = backTrackPath.peekThirdLast();
//					if (ibbsl == null) {
//						pathsExhausted = true;
//						System.out.println("Paths exhausted");
//						return null;
//					}										
//					IBasicBlock ibsl = ibbsl.getLocal(); 
//					if (ibsl instanceof IExitNode) {
//						// backtrack return with open fcall on stack; push fcall stack
//						stack.peekLast().pushOpenStartNode(ibb.getLocal());		
//						// 	remove three (2+1)
//						decIter.remove();
//						decIter.next();
//						decIter.remove();
//						decIter.next();						
//					} else {
//						// backtrack normal fcall enter; pop stack
//						stack.removeLast();
//					}					
//				} else if (ibb.getLocal() instanceof IExitNode) {
//					// push (empty) stack
//					IBasicBlock returnNode = secondLastRemoved;
//					IBasicBlock callNode = lastRemoved;							
//					IBasicBlock ibsl = backTrackPath.peekThirdLast().getLocal(); 
//					if (ibsl instanceof IExitNode && (ibb.getEntryPath().size() == 1)) {						
//						// special case return before exit main:
//						lastRemoved = ibb.getLocal(); // will become returnNode in next iteration						
//					} else {
//						PathGenFctSpace pgfs = new PathGenFctSpace(returnNode);
//						pgfs.setCallNode(callNode);
//						stack.addLast(pgfs);						
//						secondLastRemoved = lastRemoved;
//						lastRemoved = ibb.getLocal();
//					}										
//					
//				} else {
//					secondLastRemoved = lastRemoved;
//					lastRemoved = ibb.getLocal();	
//				}
//				// remove					
//				decIter.remove();
//			}			
//		}
//		pathsExhausted = true;
//		System.out.println("PathGen: Paths exhausted");
//		return null;			
//	}	
//		
//	/**
//	 * Find next path and return an ProgrampathIBB object.
//	 *
//	 * @return the program path ibb
//	 */
//	private ProgramPathIBB findNextPath() {		
//		try {
//			// search forward for new path
//			System.out.println("");
//			System.out.println("PathGen: generate Path: " + nextPathNumber);
//			nextPathNumber++;				
//			nextPathIBB = getNextStartPath();		
//			if (nextPathIBB == null) {
//				return null;
//			}									
//			IBasicBlock startChilds[] = nextPathIBB.peekLast().getLocal().getOutgoingNodes();			
//			IndBasicBlock nextnode = new IndBasicBlock(startChilds[0], entryPaths.peekLast());
//			while (nextnode.getLocal() != null) {		
//				IndBasicBlock actnode = nextnode;																						
//				nextPathIBB.addLast(actnode);								
//				if (actnode.getLocal() instanceof IExitNode) {													
//					entryPaths.pollLast();										
//					if (stack.peekLast() != null) {
//						IBasicBlock callNode = stack.peekLast().getCallNode();											
//						if (callNode instanceof IDecisionNode) {
//							// probably nothing to do !?
//						}						
//						// for return value to call node:
//						nextPathIBB.addLast(new IndBasicBlock(callNode, entryPaths.peekLast()));						
//						IBasicBlock nextStartNode = stack.peekLast().popOpenStartNode();																					
//						if (nextStartNode != null) {
//							// open function call														
//							nextnode = new IndBasicBlock(nextStartNode, entryPaths.peekLast());														
//							continue;
//						} else {
//							nextnode = new IndBasicBlock(stack.peekLast().getReturnNode(), entryPaths.peekLast());
//							stack.removeLast();																							
//							continue;								
//						}														
//					} else { // exiting main										
//						backTrackPath = nextPathIBB;
//						return nextPathIBB;							
//					}										
//				} else if (actnode.getLocal() instanceof IStartNode) {
//					IStartNode locStart = (IStartNode) actnode.getLocal();
//					entryPaths.addLast(nextPathIBB.toProgramPath());				
//					nextnode = new IndBasicBlock( locStart.getOutgoing(), entryPaths.peekLast());
//				} else if (actnode.getLocal() instanceof IBranchNode) {
//					IBranchNode locBranch = (IBranchNode) actnode.getLocal();			
//					nextnode = new IndBasicBlock(locBranch.getOutgoing(), entryPaths.peekLast());							
//				} else if (actnode.getLocal() instanceof IJumpNode) {
//					IJumpNode locJump = (IJumpNode) actnode.getLocal();
//					nextnode = new IndBasicBlock(locJump.getJumpNode(), entryPaths.peekLast());		
//				} else if (actnode.getLocal() instanceof IDecisionNode) {
//					// TODO: move redundant function call code with IPlainNode below into new method
//					IDecisionNode locDec = (IDecisionNode) actnode.getLocal();					
//					CxxDecisionNode cdn = (CxxDecisionNode) locDec;
//					IASTExpression branchexpr = (IASTExpression) cdn.getNode();										
//					// check function call node; consider nested calls in one statement					
//					FunctionCallCollector fccollector = new FunctionCallCollector();
//					branchexpr.accept(fccollector);
//					ArrayList<IASTName> fcnames = fccollector.getFunctionNames();
//					if (!fcnames.isEmpty()) {						
//						// calling node												
//						if (containsLocalCall(fcnames)) {
//							// pick return node
//							IndBasicBlock returnNode = null;																																		
//							IBasicBlock nextLocal = pathDecs.getFwNext(actnode);
//							returnNode = new IndBasicBlock(nextLocal, entryPaths.peekLast());																					
//							stack.addLast(new PathGenFctSpace(returnNode.getLocal()));
//							stack.peekLast().setCallNode(locDec);																													
//							for (IASTName fcallName : fcnames) {
//								IBinding fbinding = fcallName.resolveBinding();								
//								IStartNode cfgStartNode = psf.getCFGStartNodeByFBinding(fbinding);
//								if (cfgStartNode != null) {
//									// project-local function
//									stack.peekLast().pushOpenStartNode(cfgStartNode);								
//								}												
//							}							
//							if (stack.peekLast().hasOpenCall()) {
//								// enter project-local function call
//								IStartNode newStartNode = (IStartNode) stack.peekLast().popOpenStartNode();		
//								
//								// new entry path for nextnode!
//								ProgramPath nextentrypath = nextPathIBB.toProgramPath();
//								nextentrypath.add((IBasicBlock) newStartNode);
//																							
//								//nextnode = new IndBasicBlock(newStartNode, entryPaths.peekLast());
//								nextnode = new IndBasicBlock(newStartNode, nextentrypath);								
//								continue;
//							} 
//						} else {
//							// only library call(s)							
//							IBasicBlock nextLocal = pathDecs.getFwNext(actnode);
//							nextnode = new IndBasicBlock(nextLocal, entryPaths.peekLast());												
//						}						
//					} else {
//						// no function call
//						IBasicBlock nextLocal = null;
//						if (pathDecs.hasFwNext(actnode)) {
//							nextLocal = pathDecs.getFwNext(actnode);
//						} else {
//							IBasicBlock children[] = actnode.getOutgoingNodes();
//							// skip, jump out (get jump node)
//							nextLocal = ((ISingleOutgoing) children[1]).getOutgoing();
//						}						
//						nextnode = new IndBasicBlock(nextLocal, entryPaths.peekLast());																	
//					}							
//				} else if (actnode.getLocal() instanceof IConnectorNode) {
//					IConnectorNode locCon = (IConnectorNode) actnode.getLocal();
//					nextnode = new IndBasicBlock(((ISingleOutgoing) locCon).getOutgoing(), entryPaths.peekLast());
//				} else { 
//					// plain node, check for function call, consider nested calls
//					IPlainNode locpnode = (IPlainNode) actnode.getLocal();		
//					IASTNode anode = (IASTNode) ((ICfgData) locpnode).getData();						
//					FunctionCallCollector fccollector = new FunctionCallCollector();
//					anode.accept(fccollector);
//					ArrayList<IASTName> fcnames = fccollector.getFunctionNames();
//					if (!fcnames.isEmpty()) {
//						// calling node												
//						if (containsLocalCall(fcnames)) {
//							IBasicBlock returnNode = locpnode.getOutgoing();
//							stack.addLast(new PathGenFctSpace(returnNode));
//							stack.peekLast().setCallNode(locpnode);																													
//							for (IASTName fcallName : fcnames) {
//								IBinding fbinding = fcallName.resolveBinding();
//								// function call by function pointer, TODO: find cleaner solution, pointers destroy separation between path generation and interpretation
//								if (fbinding instanceof IVariable) {
//									FctPtrResolver resolver = new FctPtrResolver((IVariable) fbinding, nextPathIBB);
//									fbinding = resolver.resolve();
//								}								
//								IStartNode cfgStartNode = psf.getCFGStartNodeByFBinding(fbinding);
//								if (cfgStartNode != null) {
//									// project-local function
//									stack.peekLast().pushOpenStartNode(cfgStartNode);								
//								}												
//							}							
//							if (stack.peekLast().hasOpenCall()) {
//								// enter project-local function call
//								IStartNode newStartNode = (IStartNode) stack.peekLast().popOpenStartNode();										
//								// new entry path for nextnode
//								ProgramPath nextentrypath = nextPathIBB.toProgramPath();
//								nextentrypath.add((IBasicBlock) newStartNode);																							
//								nextnode = new IndBasicBlock(newStartNode, nextentrypath);								
//								continue;
//							} else {									
//								IBasicBlock child[] = actnode.getLocal().getOutgoingNodes();
//								nextnode = new IndBasicBlock(child[0], entryPaths.peekLast());
//								continue;
//							}
//						} else {
//							// only library call(s)
//							IBasicBlock child[] = actnode.getLocal().getOutgoingNodes();
//							nextnode = new IndBasicBlock(child[0], entryPaths.peekLast());
//							continue;
//						}
//					}
//					// no function call node
//					IBasicBlock child[] = actnode.getLocal().getOutgoingNodes();
//					nextnode = new IndBasicBlock(child[0], entryPaths.peekLast());												
//				}
//			}					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}			
//		backTrackPath = nextPathIBB;
//		return nextPathIBB;
//	}
//					
//	/**
//	 * Contains local call.
//	 *
//	 * @param fcnames the fcnames
//	 * @return true, if successful
//	 */
//	boolean containsLocalCall(ArrayList<IASTName> fcnames) {
//		for (IASTName fcallName : fcnames) {
//			IBinding fbinding = fcallName.resolveBinding();
//			if (fbinding instanceof IVariable) {
//				// function pointer called
//				FctPtrResolver resolver = new FctPtrResolver((IVariable) fbinding, nextPathIBB);
//				fbinding = resolver.resolve();
//			}
//			IStartNode cfgStartNode = psf.getCFGStartNodeByFBinding(fbinding);
//			if (cfgStartNode != null) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//	
//	/**
//	 * The Class FctPtrResolver extends the class ASTVisitor in order to get the method public int visit(IASTDeclarator decl)
//	 * The method public int visit(IASTDeclarator decl) checks for IASTDeclator nodes in order to see what type of expression it is.
//	 */
//	class FctPtrResolver extends ASTVisitor {
//		
//		/** The function pointer object fptr. */
//		IVariable fptr;
//		
//		/** The program path IBB object path. */
//		ProgramPathIBB path;
//		
//		/** The function binding fct. */
//		IBinding fct;
//		
//		/** The resolved. */
//		boolean resolved;
//		
//		/**
//		 * Instantiates a new function pointer resolver.
//		 *
//		 * @param fptr the fptr
//		 * @param path the path
//		 */
//		FctPtrResolver(IVariable fptr, ProgramPathIBB path) {
//			shouldVisitDeclarators = true;
//			this.fptr = fptr;
//			this.path = path;
//			this.resolved = false;
//		}
//		
//		/**
//		 * Resolve the bindings.
//		 *
//		 * @return the i binding
//		 */
//		IBinding resolve() {
//			Iterator<IndBasicBlock> deciter = nextPathIBB.descendingIterator();
//			while (deciter.hasNext() && !resolved) {
//				AbstractBasicBlock bb = (AbstractBasicBlock) deciter.next().getLocal();
//				IASTNode in = (IASTNode) bb.getData();
//				if (in == null) {
//					continue;
//				}
//				in.accept(this);
//			}			
//			return fct;
//		}
//		
//		/* (non-Javadoc)
//		 * @see org.eclipse.cdt.core.dom.ast.ASTVisitor#visit(org.eclipse.cdt.core.dom.ast.IASTDeclarator)
//		 */
//		public int visit(IASTDeclarator decl) {
//			if (!(decl instanceof IASTStandardFunctionDeclarator)) {
//				return PROCESS_ABORT;
//			}
//			IASTDeclarator ndecl = decl.getNestedDeclarator();
//			IASTName fptrname = ndecl.getName();
//			if (!fptrname.resolveBinding().equals(fptr)) {
//				return PROCESS_ABORT;
//			}
//			IASTInitializer ini = decl.getInitializer();
//			IASTIdExpression fctid = (IASTIdExpression) ((IASTEqualsInitializer) ini).getInitializerClause();
//			IASTName fname = fctid.getName();
//			fct = fname.resolveBinding();
//			resolved = true;
//			return PROCESS_ABORT;
//		}		
//	}			
//	
//	/**
//	 * Report unsat.
//	 *
//	 * @param unsatPath the unsat path object
//	 */
//	public void reportUnsat(ProgramPath unsatPath) {
//		// backroll until unsat, keeping pathDecs, entryPaths and stack consistent
//		// TODO: remove code duplicate with findNextStartPath
//		IndBasicBlock unsatIBB = getUnsatIBB(unsatPath);				
//		Iterator<IndBasicBlock> decIter = backTrackPath.descendingIterator();	
//		IBasicBlock lastRemoved = null; // for restoring open-fcall-stack
//		IBasicBlock secondLastRemoved = null;		
//		while (decIter.hasNext()) {						
//			IndBasicBlock ibb = decIter.next();				
//			if (ibb.equals(unsatIBB)) {
//				IBasicBlock[] incoming = ibb.getLocal().getIncomingNodes();
//				IndBasicBlock decibb = new IndBasicBlock(incoming[0], ibb.getEntryPath());
//				pathDecs.setUnsatLastDec(decibb);
//				return;
//			}						
//			if (ibb.getLocal() instanceof IDecisionNode) {
//					pathDecs.backRollLast(ibb);
//					decIter.remove();
//					continue;
//			}		
//			// backtrack node							
//			// update entryPaths				
//			if (ibb.getLocal() instanceof IExitNode) {					
//				ProgramPath newEntryPath = ibb.getEntryPath();
//				entryPaths.addLast(newEntryPath);
//			} else if (ibb.getLocal() instanceof IStartNode) {
//				entryPaths.removeLast();
//			} 									
//			// update callnode-fcall-stack
//			if (ibb.getLocal() instanceof IStartNode) {
//				IndBasicBlock ibbsl = backTrackPath.peekThirdLast();								
//				IBasicBlock ibsl = ibbsl.getLocal(); 
//				if (ibsl instanceof IExitNode) {
//					// backtrack return with open fcall on stack; push fcall stack
//					stack.peekLast().pushOpenStartNode(ibb.getLocal());		
//					// 	remove three (2+1)
//					decIter.remove();
//					decIter.next();
//					decIter.remove();
//					decIter.next();						
//				} else {
//					// backtrack normal fcall enter; pop stack
//					stack.removeLast();
//				}					
//			} else if (ibb.getLocal() instanceof IExitNode) {
//				// push (empty) stack
//				IBasicBlock returnNode = secondLastRemoved;
//				IBasicBlock callNode = lastRemoved;																								
//				IBasicBlock ibsl = backTrackPath.peekThirdLast().getLocal(); 
//				if (ibsl instanceof IExitNode && (ibb.getEntryPath().size() == 1)) {						
//					// special case return before exit main:
//					lastRemoved = ibb.getLocal(); // will become returnNode in next iteration						
//				} else {
//					PathGenFctSpace pgfs = new PathGenFctSpace(returnNode);
//					pgfs.setCallNode(callNode);
//					stack.addLast(pgfs);
//					//
//					secondLastRemoved = lastRemoved;
//					lastRemoved = ibb.getLocal();
//				}										
//				
//			} else {
//				secondLastRemoved = lastRemoved;
//				lastRemoved = ibb.getLocal();	
//			}			
//			decIter.remove();
//		}			
//	}				
//	
//	/**
//	 * Gets the unsat ibb object.
//	 *
//	 * @param unsatPath the unsat path
//	 * @return the unsat ibb
//	 */
//	private IndBasicBlock getUnsatIBB(ProgramPath unsatPath) {
//		Iterator<IndBasicBlock> btIter = backTrackPath.iterator();
//		Iterator<IBasicBlock> unsatIter = unsatPath.iterator();
//		IndBasicBlock ibb = null;
//		while (unsatIter.hasNext()) {
//			IBasicBlock unsatbb = unsatIter.next();
//			ibb = btIter.next();			
//		}
//		return ibb; // assert ibb is BranchNode
//	}
//					 		
//}
//
