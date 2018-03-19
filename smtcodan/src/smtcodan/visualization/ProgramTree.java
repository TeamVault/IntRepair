package smtcodan.visualization;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.RepaintManager;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.apache.commons.collections15.functors.ConstantTransformer;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxPlainNode;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.IBranchNode;
import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;
import org.eclipse.cdt.codan.core.model.cfg.IExitNode;
import org.eclipse.cdt.codan.core.model.cfg.IStartNode;
import org.w3c.dom.Document;

import smtcodan.Config;
import smtcodan.pathgen.IndBasicBlock;
import smtcodan.pathgen.ProgramPathIBB;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class ProgramTree {

	// // TODO Uncomment to use: needs JUNG graph library and Apache batik libs
	// // loaded as plug-ins
	// //
	DelegateTree<IProgramTreeEntry, TreeEdge> tree;

	VisualizationViewer<IProgramTreeEntry, TreeEdge> vv;

	TreeLayout<IProgramTreeEntry, TreeEdge> treeLayout;

	public ProgramTree() {
		tree = new DelegateTree<IProgramTreeEntry, TreeEdge>();
	}

	public DelegateTree<IProgramTreeEntry, TreeEdge> getTree() {
		return tree;
	}

	public synchronized void reportUnsat(ProgramPathIBB pathIBB) {
		Iterator<IndBasicBlock> iter = pathIBB.iterator();
		boolean firstLevel = true;
		IProgramTreeEntry lastEntry = null;
		IProgramTreeEntry root = tree.getRoot();
		Collection<IProgramTreeEntry> children = new ArrayList<IProgramTreeEntry>();
		while (iter.hasNext()) {
			IndBasicBlock ibb = iter.next();
			IBasicBlock bb = ibb.getLocal();
			// add or remove node types
			if ((bb instanceof IDecisionNode) || (bb instanceof IBranchNode)
					|| (bb instanceof CxxPlainNode)) {
				if (firstLevel) {
					if (root != null) {
						// assert root.equals(ibb);
						lastEntry = root;
						children = tree.getChildren(root);
					} else {
						tree.addVertex(ibb);
						root = ibb;
						lastEntry = root;
					}
				} else {
					if (children.isEmpty()) {
						tree.addEdge(new TreeEdge(), lastEntry, ibb);
						lastEntry = ibb;
					} else {
						if (children.contains(ibb)) {
							lastEntry = ibb;
							children = tree.getChildren(ibb);
						} else {
							children = new ArrayList<IProgramTreeEntry>(); // 'clear'
							// unmodifiable
							// collection
							tree.addEdge(new TreeEdge(), lastEntry, ibb);
							lastEntry = ibb;
						}
					}
				}
				firstLevel = false;

			}
		}
		tree.addEdge(new TreeEdge(), lastEntry, new UnsatTreeLeaf());
//		 dump();
//		 show();
	}

	public synchronized void reportSat(ProgramPathIBB pathIBB) {
		// TODO: remove duplicate code with reportUnsat()
		Iterator<IndBasicBlock> iter = pathIBB.iterator();
		boolean firstLevel = true;
		IProgramTreeEntry lastEntry = null;
		IProgramTreeEntry root = tree.getRoot();
		Collection<IProgramTreeEntry> children = new ArrayList<IProgramTreeEntry>();

		while (iter.hasNext()) {
			IndBasicBlock ibb = iter.next();
			IBasicBlock bb = ibb.getLocal();
			// add or remove node types

			if ((bb instanceof IDecisionNode) || (bb instanceof IBranchNode)
					|| (bb instanceof CxxPlainNode)) {

				if (firstLevel) {
					if (root != null) {
						// assert root.equals(ibb);
						lastEntry = root;
						children = tree.getChildren(root);
					} else {
						tree.addVertex(ibb);
						root = ibb;
						lastEntry = root;
					}
				} else {
					if (children.isEmpty()) {
						tree.addEdge(new TreeEdge(), lastEntry, ibb);
						lastEntry = ibb;
					} else {
						if (children.contains(ibb)) {
							lastEntry = ibb;
							children = tree.getChildren(ibb);
						} else {
							children = new ArrayList<IProgramTreeEntry>(); // 'clear'
							// unmodifiable
							// collection
							tree.addEdge(new TreeEdge(), lastEntry, ibb);
							lastEntry = ibb;
						}
					}
				}
				firstLevel = false;
			}
		}
		if (tree.getRoot() != null) {
			tree.addEdge(new TreeEdge(), lastEntry, new SatTreeLeaf());
		}
//		 dump();
//		 show();
	}

	public synchronized void show() {
		treeLayout = new TreeLayout<IProgramTreeEntry, TreeEdge>(tree, 120, 50);
		vv = new VisualizationViewer<IProgramTreeEntry, TreeEdge>(treeLayout,
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

	public synchronized void dump() {
		treeLayout = new TreeLayout<IProgramTreeEntry, TreeEdge>(tree, 120, 50);
		vv = new VisualizationViewer<IProgramTreeEntry, TreeEdge>(treeLayout,
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
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Rectangle2D bounds = vv.getBounds();
			if (bounds != null) {
				// Constructs the svg generator used for painting the graph to
				GenericDOMImplementation domImpl = (GenericDOMImplementation) GenericDOMImplementation
						.getDOMImplementation();
				Document document = domImpl.createDocument(null, "svg", null);
				SVGGraphics2D svgGenerator = new SVGGraphics2D(
						(org.w3c.dom.Document) document);
				svgGenerator.translate(-bounds.getX(), -bounds.getY());
				// Paints the graph to the svg generator with no double
				// buffering enabled to make sure we get a vector image.
				RepaintManager currentManager = RepaintManager
						.currentManager(vv);
				currentManager.setDoubleBufferingEnabled(false);
				vv.paint(svgGenerator);
				// Writes the graph to the specified file as an SVG stream
				Writer writer = new OutputStreamWriter(out, "UTF-8");
				svgGenerator.stream(writer, false);
				currentManager.setDoubleBufferingEnabled(true);
			}
		} catch (UnsupportedEncodingException | SVGGraphics2DIOException e) {
			e.printStackTrace();
		}
		frame.dispose();

	}

}
