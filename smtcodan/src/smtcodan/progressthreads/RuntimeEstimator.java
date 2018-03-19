package smtcodan.progressthreads;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxControlFlowGraph;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxPlainNode;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.internal.core.cfg.ControlFlowGraph;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTNode;

import smtcodan.ProgramStructureFacade;
import smtcodan.ProgramStructureFacade.CallGraphNode;
import smtcodan.visualization.TreeEdge;
import edu.uci.ics.jung.graph.DelegateTree;

// TODO: Auto-generated Javadoc
/**
 * The Class RuntimeEstimator.
 */
public class RuntimeEstimator extends ASTVisitor {
	// per function execution tree (kein in-lining), unroll branches up to a
	// upper bound, worst case
	/** The per function execution tree loops not skipped. */
	public HashMap<IASTFunctionDefinition, CxxControlFlowGraph> perFunctionExecutionTreeLoopsNotSkipped;

	// per function execution tree (kein in-lining), do not unroll branches,
	// best case
	/** The per function execution tree loops skiped. */
	public HashMap<IASTFunctionDefinition, CxxControlFlowGraph> perFunctionExecutionTreeLoopsSkiped;

	// per function call sequences, Only function calls
	/** The per function call sequences. */
	public HashMap<IASTFunctionDefinition, CxxControlFlowGraph> perFunctionCallSequences;

	/** The per function longest path. */
	public HashMap<IASTFunctionDefinition, CxxControlFlowGraph> perFunctionLongestPath;

	/** The per function shortest path. */
	public HashMap<IASTFunctionDefinition, CxxControlFlowGraph> perFunctionShortestPath;

	/** The total calltree. */
	Tree totalCalltree;

	/** The cgnlist. */
	Vector<CallGraphNode> cgnlist = null;

	/** The functioncfgmap. */
	HashMap<IASTFunctionDefinition, CxxControlFlowGraph> functioncfgmap = null;

	/** The psf. */
	ProgramStructureFacade psf;

	/** The tree. */
	Tree tree;

	/** The main. */
	CxxControlFlowGraph main;

	/** The startnode. */
	Node startnode;

	/** The level. */
	int level = 0;

	/** The number nodes total execution tree worse case. */
	int numberNodesTotalExecutionTreeWorseCase = 0;

	/** The number nodes total execution tree best case. */
	int numberNodesTotalExecutionTreeBestCase = 0;

	/**
	 * Instantiates a new runtime estimator.
	 * 
	 * @param psf
	 *            the psf
	 */
	public RuntimeEstimator(ProgramStructureFacade psf) {
		this.psf = psf;
		this.tree = new Tree();
		// this.printFdefMap();
		// this.setTreeRootNode();
		// this.fillTree(main, startnode);
		// this.printTree();

		this.getExecutionTreeFromFdef();

		// fill up the maps
		functioncfgmap = ProgramStructureFacade.functioncfgmapCopy;
		// 1 per Function Execution Tree Loops Skiped
		this.perFunctionExecutionTreeLoopsSkiped = new HashMap<IASTFunctionDefinition, CxxControlFlowGraph>();
		// 2 per Function Execution Tree Loops Not Skipped
		this.perFunctionExecutionTreeLoopsNotSkipped = new HashMap<IASTFunctionDefinition, CxxControlFlowGraph>();
		// 3 per function longest path
		this.perFunctionLongestPath = new HashMap<IASTFunctionDefinition, CxxControlFlowGraph>();
		// 4 per function shortest path
		this.perFunctionShortestPath = new HashMap<IASTFunctionDefinition, CxxControlFlowGraph>();
		// 5 per function call sequences, obtain best and worse case afterwards
		this.perFunctionCallSequences = new HashMap<IASTFunctionDefinition, CxxControlFlowGraph>();
		// 6 total call tree (function calls only), best and worse case
		this.totalCalltree = new Tree();
		// number of nodes in total execution tree, best and worse case
		this.numberNodesTotalExecutionTreeWorseCase = 0;
		this.numberNodesTotalExecutionTreeBestCase = 0;
	}

	/**
	 * Sets the tree root node.
	 */
	public void setTreeRootNode() {
		main = psf.getRootCFunctionCFG();
		System.out.println(" \n nodes: " + main.getNodes());
		System.out.println(" \n nodes: " + main.getStartNode());
		startnode = new Node((IBasicBlock) main.getStartNode());
		tree.setRootElement(startnode);
	}

	/**
	 * Gets the execution tree from fdef.
	 * 
	 * @return the execution tree from fdef
	 */
	public void getExecutionTreeFromFdef() {
		CxxControlFlowGraph map = null;
		functioncfgmap = ProgramStructureFacade.functioncfgmapCopy;
		System.out.println("printFdefMap: ");

		int counter = 0;
		Iterator it = functioncfgmap.entrySet().iterator();
		while (it.hasNext()) {
			FunctionDefinitionTree ftree = new FunctionDefinitionTree();
			Map.Entry pairs = (Map.Entry) it.next();
			IASTFunctionDefinition fdef1 = (IASTFunctionDefinition) pairs
					.getKey();

			System.out.println("function definition: \n"
					+ ((IASTFunctionDefinition) pairs.getKey())
							.getRawSignature().toString() + "nodes: \n"
					+ ((CxxControlFlowGraph) pairs.getValue()).getNodes());
			int size = (int) ((ControlFlowGraph) pairs.getValue()).getNodes()
					.size();

			if (size > 15 && counter == 0) {
				counter++;
				// ftree.buildTree((CxxControlFlowGraph) pairs.getValue());
				JUNGTree.drawTree(((CxxControlFlowGraph) pairs.getValue())
						.getNodes());
				// ftree.dump(ftree.tree);

			}

			// ftree.show();
			System.out.println();

			// it removes the entrys from the map
			// it.remove(); // avoids a ConcurrentModificationException
		}

	}

	public int getNumberOfNodesFromTree(DelegateTree<IBasicBlock, TreeEdge> tree) {
		return tree.getChildCount(tree.getRoot());
	}

	public int getNumberOfWholeTree(
			HashMap<IASTFunctionDefinition, CxxControlFlowGraph> functioncfgmap) {
		int numberOfNodesPerFunction;
		int count = 0;

		Iterator it = functioncfgmap.entrySet().iterator();
		while (it.hasNext()) {
			FunctionDefinitionTree ftree = new FunctionDefinitionTree();
			Map.Entry pairs = (Map.Entry) it.next();
			IASTFunctionDefinition fdef1 = (IASTFunctionDefinition) pairs
					.getKey();
			numberOfNodesPerFunction = ((ControlFlowGraph) pairs.getValue())
					.getNodes().size();
			count = count + numberOfNodesPerFunction;
		}
		return count;

	}

	/**
	 * Prints the fdef map.
	 */
	public void printFdefMap() {
		CxxControlFlowGraph map = null;
		functioncfgmap = ProgramStructureFacade.functioncfgmapCopy;
		System.out.println("printFdefMap: ");
		Iterator it = functioncfgmap.entrySet().iterator();
		while (it.hasNext()) {
			Tree tree = new Tree();
			Map.Entry pairs = (Map.Entry) it.next();
			IASTFunctionDefinition fdef1 = (IASTFunctionDefinition) pairs
					.getKey();

			System.out.println("function definition: \n"
					+ ((IASTFunctionDefinition) pairs.getKey())
							.getRawSignature().toString() + "nodes: \n"
					+ ((CxxControlFlowGraph) pairs.getValue()));
			Collection<IBasicBlock> nodes = ((CxxControlFlowGraph) pairs
					.getValue()).getNodes();

			// it removes the entrys from the map
			// it.remove(); // avoids a ConcurrentModificationException
		}
	}

	/**
	 * Gets the the nodes from map.
	 * 
	 * @param fdef
	 *            the fdef
	 * @return the the nodes from map
	 */
	public CxxControlFlowGraph getTheNodesFromMap(IASTFunctionDefinition fdef) {
		CxxControlFlowGraph map = null;
		functioncfgmap = ProgramStructureFacade.functioncfgmapCopy;

		Iterator it = functioncfgmap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			IASTFunctionDefinition fdef1 = (IASTFunctionDefinition) pairs
					.getKey();
			if (fdef1.equals(fdef)) {
				System.out.println("function definition: \n"
						+ ((IASTFunctionDefinition) pairs.getKey())
								.getRawSignature().toString() + " \nnodes: "
						+ ((CxxControlFlowGraph) pairs.getValue()).getNodes());
				System.out.println();
				return map = ((CxxControlFlowGraph) pairs.getValue());
			}
			// it removes the entrys from the map
			// it.remove(); // avoids a ConcurrentModificationException
		}
		return map;

	}

	/**
	 * Fill tree.
	 * 
	 * @param mainX
	 *            the main x
	 * @param startnodeX
	 *            the startnode x
	 */
	public void fillTree(CxxControlFlowGraph mainX, Node startnodeX) {
		CxxControlFlowGraph main = mainX;
		Node startnode = startnodeX;
		FunctionCallNodeVisitor visit1 = null;
		FunctionCallNodeVisitor visit2 = null;
		FunctionCallNodeVisitor visit3 = null;
		FunctionCallNodeVisitor visit4 = null;

		if (main != null) {
			for (IBasicBlock cgn : main.getNodes()) {
				Node node = new Node(cgn);
				startnode.addChild(node);

				// from CxxPlainNode to callGraphNode
				IASTNode node2 = null;

				if (cgn instanceof CxxPlainNode) {
					node2 = ((CxxPlainNode) cgn).getNode();
				} else if (cgn instanceof CxxDecisionNode) {
					node2 = ((CxxDecisionNode) cgn).getNode();
				}

				visit1 = new FunctionCallNodeVisitor(psf);
				if (node2 != null)
					node2.accept(visit1);
				if (visit1.isFound()) {
					visit1.setFound(false);
					// get nodes
					CxxControlFlowGraph map = getTheNodesFromMap(visit1
							.getFdef());

					if (map != null) {
						for (IBasicBlock j : map.getNodes()) {
							IASTNode node3 = null;

							if (j instanceof CxxPlainNode) {
								node3 = ((CxxPlainNode) j).getNode();

								// check its children
								if (node3.getChildren().length > 0) {
									IASTNode[] children = node3.getChildren();
									for (IASTNode child : children) {
										visit2 = new FunctionCallNodeVisitor(
												psf);
										child.accept(visit2);
										Node fnode = null;
										if (visit2.isFound()) {
											fnode = new Node(j);
											node.addChild(fnode);
											visit2.setFound(false);

										}
										// recursive call, send new root
										// node and nodes to be added
										CxxControlFlowGraph cfg = functioncfgmap
												.get(visit2.getFdef());
										fillTree(cfg, fnode);
										visit2.setFound(false);
									}
								}
							} else if (j instanceof CxxDecisionNode) {
								node3 = ((CxxDecisionNode) j).getNode();
								// check if the children are
								// function calls
								Node fnode = new Node(j);
								IASTNode[] children = node3.getChildren();
								System.out
										.println("my children: "
												+ node3.getRawSignature()
														.toString() + " size "
												+ node3.getChildren().length);
								for (IASTNode child : children) {
									visit1 = new FunctionCallNodeVisitor(psf);

									// child.accept(visit1);

									// if (visit1.isFound()) {
									fnode.addChild(new Node(child
											.getRawSignature().toString()));
									visit1.setFound(false);

									// }
									// recursive call, send new root
									// node and nodes to be added
									CxxControlFlowGraph cfg = functioncfgmap
											.get(visit1.getFdef());

									fillTree(cfg, fnode);
									visit1.setFound(false);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Prints the tree.
	 */
	public void printTree() {
		System.out.println(" \n Number of nodes in the tree: "
				+ tree.toList().size());
		System.out.println(" \n Final Tree: " + tree.toString());

	}

	// ProgramPathIBB newpath = new ProgramPathIBB();
	// for (IndBasicBlock ibb : this) {
	// newpath.add(ibb);
	// }
	// IndBasicBlock candibb = iter.next();
	// IBasicBlock cand = candibb.getLocal();

}
