package smtcodan.progressthreads;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;

import org.apache.commons.collections15.functors.ConstantTransformer;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxControlFlowGraph;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxPlainNode;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.IBranchNode;
import org.eclipse.cdt.codan.core.model.cfg.IConnectorNode;
import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;
import org.eclipse.cdt.codan.core.model.cfg.IStartNode;
import org.eclipse.cdt.codan.internal.core.cfg.ConnectorNode;
import org.eclipse.cdt.codan.internal.core.cfg.JumpNode;

import smtcodan.Config;
import smtcodan.visualization.TreeEdge;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class FunctionDefinitionTree {

	// // TODO Uncomment to use: needs JUNG graph library and Apache batik libs
	// // loaded as plug-ins
	// //
	DelegateTree<IBasicBlock, TreeEdge> tree;

	VisualizationViewer<IBasicBlock, TreeEdge> vv;

	TreeLayout<IBasicBlock, TreeEdge> treeLayout;

	public FunctionDefinitionTree() {
		this.tree = new DelegateTree<IBasicBlock, TreeEdge>();
	}

	public DelegateTree<IBasicBlock, TreeEdge> getTree() {
		return tree;
	}

	public NumberedBasicBlock[] getPathnum(CxxControlFlowGraph pathIBB, int h) {

		NumberedBasicBlock[] pathnum = new NumberedBasicBlock[pathIBB
				.getNodes().size()];
		ArrayList<IBasicBlock> arrli = new ArrayList(pathIBB.getNodes());
		Object[] path = arrli.toArray();

		for (int k = 0; k < path.length; k++) {
			pathnum[k] = new NumberedBasicBlock((IBasicBlock) path[k], h);
		}
		return pathnum;

	}

	// gibt zu einem thenNode den zugehörigen elseNode aus
	public IBasicBlock gotoElse(CxxControlFlowGraph pathIBB,
			NumberedBasicBlock[] pathnum, NumberedBasicBlock thenNode) {
		Object[] path = pathIBB.getNodes().toArray();

		int count_then = 1;
		int count_else = 0;
		int i = 0;
		int j = 0;
		int k = 0;

		// ArrayList<IBasicBlock> arrli=new ArrayList(pathIBB.getNodes());
		// Object[] path= arrli.toArray();

		while (!((pathnum[j].toString()).equals(thenNode.toString()))
				&& ((pathnum[j].getNumber()) == (thenNode.getNumber()))
				&& j < pathnum.length) {
			j++;
		}
		i = j + 1;
		System.out.println("gotoElse then " + pathnum[i].toString());

		while (count_then != count_else) {

			if (path[i] instanceof IBranchNode) {

				if (((IBranchNode) path[i]).getLabel() == "then") {
					count_then++;

				} else if (((IBranchNode) path[i]).getLabel() == "else") {
					count_else++;

				}
			}
			i++;
			if (i == path.length - 1) {
				return (IBasicBlock) path[i];
			}
		}
		if (i == pathnum.length - 1) {
			return (IBasicBlock) pathnum[i];
		} else {
			return (IBasicBlock) pathnum[i - 1];
		}

	}

	// thenPath enthält den teil von pathIBB der bei then beginnt, die knoten
	// bis else enthält und dann noch die knoten hinter dem mergenode
	public ArrayList<IBasicBlock> splitArray_thenBranch(
			CxxControlFlowGraph pathIBB, CxxDecisionNode decNode, int h) {
		ArrayList<IBasicBlock> thenPath = new ArrayList<IBasicBlock>();
		IConnectorNode mergeNode = null;
		NumberedBasicBlock elseNode = null;
		NumberedBasicBlock thenNode = null;
		// IDecisionNode decNode = null;
		int i = 0;
		int j = 0;

		NumberedBasicBlock[] pathnum = getPathnum(pathIBB, h);

		ArrayList<IBasicBlock> arrli = new ArrayList(pathIBB.getNodes());
		Object[] path = arrli.toArray();
		// decNode = numDecNode.getD();
		System.out.println("decNode" + decNode.toString());
		thenNode = new NumberedBasicBlock(decNode.getOutgoingNodes()[0], h);
		elseNode = new NumberedBasicBlock(gotoElse(pathIBB, pathnum, thenNode),
				h);
		mergeNode = decNode.getMergeNode();

		System.out.println(elseNode.toString());

		while (!((pathnum[i].toString()).equals(thenNode.toString()))
				&& ((pathnum[i].getNumber()) == (thenNode.getNumber()))
				&& i < pathnum.length) { // gehe bis zum thenNode
			i++;
		}
		while (!((pathnum[i].toString()).equals(elseNode.toString())) // prüfe
																		// ob
																		// knoten
																		// der
																		// else
																		// node
																		// ist
																		// und
																		// ob
																		// die
																		// nummer
																		// gleich
																		// ist
				&& ((pathnum[i].getNumber()) == (elseNode.getNumber()))
				&& i < pathnum.length) {
			// füge alles ein von then bis else
			thenPath.add((IBasicBlock) path[i]);
			i++;
		}

		while (!(pathnum[i].toString().contains("Connector"))
				&& i < path.length - 1) {
			// lasse else branch aus
			i++;

		}
		j = i; // füge alles bis zum ende ein

		while (j < path.length) {
			thenPath.add((IBasicBlock) path[j]);
			j++;
		}

		System.out.println("thenPath: " + thenPath.toString());
		return thenPath;
	}

	// elsePath enthält die knoten von else bis zum ende von pathIBB
	public ArrayList<IBasicBlock> splitArray_elseBranch(
			CxxControlFlowGraph pathIBB, CxxDecisionNode decNode, int h) {
		ArrayList<IBasicBlock> elsePath = new ArrayList<IBasicBlock>();
		NumberedDecisionNode numDecNod = null;
		NumberedBasicBlock elseNode = null;
		NumberedBasicBlock thenNode = null;
		// CxxDecisionNode decNode = null;
		int i = 0;
		int j = 0;

		NumberedBasicBlock[] pathnum = getPathnum(pathIBB, h);
		ArrayList<IBasicBlock> arrli = new ArrayList(pathIBB.getNodes());
		Object[] path = arrli.toArray();
		// decNode = numDecNode.getD();
		thenNode = new NumberedBasicBlock(decNode.getOutgoingNodes()[0], h);
		elseNode = new NumberedBasicBlock(gotoElse(pathIBB, pathnum, thenNode),
				h);
		System.out.println(elseNode.toString());

		while (!((pathnum[i].toString()).equals(elseNode.toString()))
				&& ((pathnum[i].getNumber()) == (elseNode.getNumber()))
				&& i < pathnum.length) { // von anfang bis else

			i++;

		}
		j = i;
		while (j < path.length) { // von else bis ende hinzufügen
			elsePath.add((IBasicBlock) path[j]);

			j++;
		}
		System.out.println("elsePath: " + elsePath.toString());
		return elsePath;
	}

	// hängt die knoten aus dem array thenPath an den baum tree, beginn: hänge
	// an decnode den thenNode
	public synchronized DelegateTree<IBasicBlock, TreeEdge> createThenPath(
			CxxControlFlowGraph pathIBB, ArrayList<IBasicBlock> thenList,
			NumberedBasicBlock numDecNode, int h) {

		int i = 0;
		int j = 0;
		Iterator<IBasicBlock> iter = pathIBB.getNodes().iterator();
		Iterator<IBasicBlock> theniter = thenList.iterator();
		IBasicBlock ibb = null;
		IBasicBlock ibb_next = null;
		NumberedBasicBlock bb = null;
		NumberedBasicBlock bb_next = null;
		NumberedBasicBlock thenNode_num = null;
		NumberedBasicBlock elseNode = null;
		CxxDecisionNode decNode = null;
		NumberedBasicBlock bb_node = null;
		NumberedBasicBlock[] pathnum = getPathnum(pathIBB, h);
		ArrayList<IBasicBlock> arrli = new ArrayList(pathIBB.getNodes());
		Object[] path = arrli.toArray();
		decNode = numDecNode.getD();
		thenNode_num = new NumberedBasicBlock(decNode.getOutgoingNodes()[0], h);
		elseNode = new NumberedBasicBlock(gotoElse(pathIBB, pathnum,
				thenNode_num), h);

		tree.addEdge(new TreeEdge(), decNode, thenNode_num);
		// hängt
		// thenNode
		// an
		// DecNode
		theniter.next();
		ibb = theniter.next();

		// bb = new NumberedBasicBlock(ibb, h);
		tree.addEdge(new TreeEdge(), thenNode_num, ibb);

		// hängt
		// bb
		// an
		// thenNode
		ibb_next = theniter.next();

		// bb_next = new NumberedBasicBlock(ibb_next, h);
		while (theniter.hasNext()) {

			// System.out.println("bb probe 3 " + bb.toString());
			System.out.println("ibb probe 3 " + ibb.toString());
			// System.out.println("bb.getB() " + bb.getB().toString());
			if (ibb instanceof IDecisionNode) {
				System.out.println("ist bb decisionNode " + ibb.toString());

				tree.addEdge(new TreeEdge(), ibb, ibb_next);
				// bb_node = new NumberedBasicBlock((CxxDecisionNode) ibb, 0);
				extendTree(pathIBB, (CxxDecisionNode) ibb, h++);
				// hier
				// rekursiver
				// aufruf für
				// inlining

			} else {
				tree.addEdge(new TreeEdge(), ibb, ibb_next);
				ibb = ibb_next;

				ibb_next = theniter.next();

				bb = new NumberedBasicBlock(ibb, h);
				bb = bb_next;
				bb_next = new NumberedBasicBlock(ibb_next, h);
			}
		}

		return tree;

		// dump();
		// show();
	}

	// hängt die knoten aus dem array elsePath an den baum tree, beginn: hänge
	// an decNode den elseNode
	public synchronized DelegateTree<IBasicBlock, TreeEdge> createElsePath(
			CxxControlFlowGraph pathIBB, ArrayList<IBasicBlock> elseList,
			NumberedBasicBlock numDecNode, int h) {
		// TODO: remove duplicate code with reportUnsat()
		Iterator<IBasicBlock> iter = pathIBB.getNodes().iterator();

		IBasicBlock bb = null;
		IBasicBlock bb_child = null;
		IBasicBlock bb_next = null;
		IBasicBlock node = null;
		IBranchNode thenNode = null;
		NumberedBasicBlock thenNode_num = null;
		IBasicBlock elseNode = null;
		CxxDecisionNode decNode = null;
		IBasicBlock mergeNode = null;
		// System.out.println(elseNode.toString() + "  " +
		// mergeNode.toString());
		int i = 0;
		int j = 0;

		ArrayList<IBasicBlock> arrli = new ArrayList(pathIBB.getNodes());
		Object[] path = arrli.toArray();
		NumberedBasicBlock[] pathnum = getPathnum(pathIBB, h);
		Iterator<IBasicBlock> elseiter = elseList.iterator();
		decNode = numDecNode.getD();
		thenNode = (IBranchNode) decNode.getOutgoingNodes()[0];
		thenNode_num = new NumberedBasicBlock(decNode.getOutgoingNodes()[0], h);
		elseNode = gotoElse(pathIBB, pathnum, thenNode_num);
		mergeNode = decNode.getMergeNode();
		while (!(iter.next().equals(elseNode))) {

		}

		tree.addEdge(new TreeEdge(), decNode, elseNode);
		bb = elseNode;
		bb_next = elseiter.next();
		if (elseiter.hasNext()) {
			bb_next = elseiter.next();
		}
		System.out.println("bb probe 2 " + bb.toString());
		System.out.println("bb next probe " + bb_next.toString());

		while (elseiter.hasNext()) {

			System.out.println(bb.toString());

			if (bb instanceof IDecisionNode) {
				bb_child = bb_next;

				tree.addEdge(new TreeEdge(), bb, bb_next);
				extendTree(pathIBB, (CxxDecisionNode) bb, h++); // hier
																// rekursiver
				// aufruf

			}
			bb_child = bb_next;
			if (bb.toString().contains("ExitNode")
					&& !(elseNode.toString().equals("BranchNode: else"))) {
				break;
			} else {
				tree.addEdge(new TreeEdge(), bb, bb_child);
				bb = bb_child;
				bb_next = elseiter.next();
			}
		}

		return tree;

		// dump();
		// show();
	}

	public synchronized DelegateTree<IBasicBlock, TreeEdge> extendTree(
			CxxControlFlowGraph pathIBB, CxxDecisionNode numDecNode, int h) {

		// NumberedBasicBlock[] pathnum = getPathnum(pathIBB, h);

		ArrayList<IBasicBlock> thenPath = splitArray_thenBranch(pathIBB,
				numDecNode, h);
		ArrayList<IBasicBlock> elsePath = splitArray_elseBranch(pathIBB,
				numDecNode, h + 1);
		// DelegateTree<IBasicBlock, TreeEdge> Then = createThenPath(pathIBB,
		// thenPath, numDecNode, h); // Then und else Pfade werden an
		// // DecNode
		// // gehangen
		// DelegateTree<IBasicBlock, TreeEdge> Else = createElsePath(pathIBB,
		// elsePath, numDecNode, h + 1);

		return tree;

	}

	public synchronized DelegateTree<IBasicBlock, TreeEdge> buildTree(
			CxxControlFlowGraph pathIBB) {
		// TODO: remove duplicate code with reportUnsat()
		Iterator<IBasicBlock> iter = pathIBB.getNodes().iterator();

		boolean firstLevel = true;
		IBasicBlock lastEntry = null;
		IBasicBlock decnode = null;
		IBasicBlock thenNode = null;
		IBasicBlock elseNode = null;
		IBasicBlock root = this.tree.getRoot();
		NumberedBasicBlock bb_node = null;
		Collection<IBasicBlock> children = new ArrayList<IBasicBlock>();

		for (IBasicBlock bb : pathIBB.getNodes()) {

			System.out.println(bb.toString());

			// add or remove node types
			if ((bb instanceof IDecisionNode) || (bb instanceof CxxPlainNode)
					|| (bb instanceof JumpNode)
					|| (bb instanceof ConnectorNode)
					|| (bb instanceof IStartNode)) {
				if (firstLevel) {
					if (root != null) {
						// assert root.equals(ibb);
						lastEntry = root;
						children = tree.getChildren(root);
						firstLevel = false;

					} else {
						tree.addVertex(bb);
						root = bb;
						lastEntry = root;
						firstLevel = false;

					}
				} else if (!(bb instanceof IStartNode)) {
					if (!(bb instanceof IDecisionNode)) {
						tree.addEdge(new TreeEdge(), lastEntry,
								(IBasicBlock) bb);
						lastEntry = bb;
					} else {

						tree.addEdge(new TreeEdge(), lastEntry, bb);
						// bb_node = new NumberedBasicBlock((CxxDecisionNode)
						// bb,
						// 0);
						tree = extendTree(pathIBB, (CxxDecisionNode) bb, 0); // Rekursion
						break;
					}
				}

			}

		}
		return tree;

		// dump();
		// show();
	}

	public synchronized void show() {
		treeLayout = new TreeLayout<IBasicBlock, TreeEdge>(tree, 120, 50);
		vv = new VisualizationViewer<IBasicBlock, TreeEdge>(treeLayout,
				new Dimension(600, 600));
		vv.setBackground(Color.white);
		vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setArrowFillPaintTransformer(
				new ConstantTransformer(Color.lightGray));

		DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
		gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
		vv.setGraphMouse(gm);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);

		// FIXME centering and zooming currently needs breakpoint here
		int dummyBreak = 0;

		frame.dispose();
	}

	public synchronized void dump(DelegateTree<IBasicBlock, TreeEdge> tree) {
		treeLayout = new TreeLayout<IBasicBlock, TreeEdge>(tree, 120, 50);
		vv = new VisualizationViewer<IBasicBlock, TreeEdge>(treeLayout,
				new Dimension(600, 600));
		vv.setBackground(Color.white);
		vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		// vv.getRenderContext().setEdgeLabelTransformer(new
		// ToStringLabeller());
		// vv.getRenderContext().setArrowFillPaintTransformer(new
		// ConstantTransformer(Color.lightGray));

		DefaultModalGraphMouse gm = new DefaultModalGraphMouse();
		gm.setMode(ModalGraphMouse.Mode.TRANSFORMING);
		vv.setGraphMouse(gm);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true);

		String filepath = Config.getDumpTreePath();
		File file = new File(filepath);
		OutputStream out = null;
		// try {
		// out = new FileOutputStream(file);
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		// try {
		// Rectangle2D bounds = vv.getBounds();
		// if (bounds != null) {
		// // // Constructs the svg generator used for painting the graph to
		// // GenericDOMImplementation domImpl = (GenericDOMImplementation)
		// GenericDOMImplementation
		// // .getDOMImplementation();
		// // Document document = domImpl.createDocument(null, "svg", null);
		// // SVGGraphics2D svgGenerator = new SVGGraphics2D(
		// // (org.w3c.dom.Document) document);
		// // svgGenerator.translate(-bounds.getX(), -bounds.getY());
		// // // Paints the graph to the svg generator with no double
		// // // buffering enabled to make sure we get a vector image.
		// // RepaintManager currentManager = RepaintManager
		// // .currentManager(vv);
		// // currentManager.setDoubleBufferingEnabled(false);
		// // vv.paint(svgGenerator);
		// // // Writes the graph to the specified file as an SVG stream
		// // Writer writer = new OutputStreamWriter(out, "UTF-8");
		// // svgGenerator.stream(writer, false);
		// // currentManager.setDoubleBufferingEnabled(true);
		// }
		// } catch (UnsupportedEncodingException | SVGGraphics2DIOException e) {
		// e.printStackTrace();
		// }
		frame.dispose();

	}
}