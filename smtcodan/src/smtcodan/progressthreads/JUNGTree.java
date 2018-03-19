package smtcodan.progressthreads;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.RadialTreeLayout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.Tree;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.EllipseVertexShapeTransformer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.subLayout.TreeCollapser;

class Vertex {
	private static int IDCOUNTER = 0;
	private final String name;
	private final int id;

	Vertex(String name) {
		this.name = name;
		this.id = IDCOUNTER++;
	}

	String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

@SuppressWarnings("serial")
public class JUNGTree extends JApplet {

	/**
	 * the graph
	 */
	Forest<Vertex, Integer> graph;

	Factory<DirectedGraph<Vertex, Integer>> graphFactory = new Factory<DirectedGraph<Vertex, Integer>>() {

		public DirectedGraph<Vertex, Integer> create() {
			return new DirectedSparseMultigraph<Vertex, Integer>();
		}
	};

	Factory<Tree<Vertex, Integer>> treeFactory = new Factory<Tree<Vertex, Integer>>() {

		public Tree<Vertex, Integer> create() {
			return new DelegateTree<Vertex, Integer>(graphFactory);
		}
	};

	Factory<Integer> edgeFactory = new Factory<Integer>() {
		int i = 0;

		public Integer create() {
			return i++;
		}
	};

	Factory<Vertex> vertexFactory = new Factory<Vertex>() {
		int i = 0;

		public Vertex create() {
			return new Vertex("V" + i++);
		}
	};

	/**
	 * the visual component and renderer for the graph
	 */
	VisualizationViewer<Vertex, Integer> vv;

	VisualizationServer.Paintable rings;

	String root;

	TreeLayout<Vertex, Integer> layout;
	@SuppressWarnings("unchecked")
	FRLayout layout1;

	TreeCollapser collapser;

	RadialTreeLayout<Vertex, Integer> radialLayout;

	@SuppressWarnings("unchecked")
	public JUNGTree(Collection<IBasicBlock> graph2) {

		// create a simple graph for the demo
		graph = new DelegateForest<Vertex, Integer>();

		createTree(graph2, null);

		layout = new TreeLayout<Vertex, Integer>(graph);
		// collapser = new TreeCollapser();

		// radialLayout = new RadialTreeLayout<Vertex, Integer>(graph);
		// radialLayout.setSize(new Dimension(600, 600));
		vv = new VisualizationViewer<Vertex, Integer>(layout, new Dimension(
				600, 600));

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

		Container content = getContentPane();
		final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
		content.add(panel);

		final DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();

		vv.setGraphMouse(graphMouse);

		JComboBox modeBox = graphMouse.getModeComboBox();
		modeBox.addItemListener(graphMouse.getModeListener());
		graphMouse.setMode(ModalGraphMouse.Mode.TRANSFORMING);

		final ScalingControl scaler = new CrossoverScalingControl();

		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scaler.scale(vv, 1.1f, vv.getCenter());
			}
		});
		JButton minus = new JButton("-");
		minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scaler.scale(vv, 1 / 1.1f, vv.getCenter());
			}
		});

		JToggleButton radial = new JToggleButton("Radial");
		radial.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					// layout.setRadial(true);
					vv.setGraphLayout(radialLayout);
					vv.getRenderContext().getMultiLayerTransformer()
							.setToIdentity();
					vv.addPreRenderPaintable(rings);
				} else {
					// layout.setRadial(false);
					vv.setGraphLayout(layout);
					vv.getRenderContext().getMultiLayerTransformer()
							.setToIdentity();
					vv.removePreRenderPaintable(rings);
				}
				vv.repaint();
			}
		});

		JButton collapse = new JButton("Collapse");
		collapse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Collection picked = new HashSet(vv.getPickedVertexState()
						.getPicked());
				if (picked.size() == 1) {
					Object root = picked.iterator().next();
					Forest inGraph = (Forest) layout.getGraph();

					try {
						collapser.collapse(vv.getGraphLayout(), inGraph, root);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					vv.getPickedVertexState().clear();
					vv.repaint();
				}
			}
		});

		JButton expand = new JButton("Expand");
		expand.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Collection picked = vv.getPickedVertexState().getPicked();
				for (Object v : picked) {
					if (v instanceof Forest) {
						Forest inGraph = (Forest) layout.getGraph();
						collapser.expand(inGraph, (Forest) v);
					}
					vv.getPickedVertexState().clear();
					vv.repaint();
				}
			}
		});

		JPanel scaleGrid = new JPanel(new GridLayout(1, 0));
		scaleGrid.setBorder(BorderFactory.createTitledBorder("Zoom"));

		JPanel controls = new JPanel();
		scaleGrid.add(plus);
		scaleGrid.add(minus);
		controls.add(radial);
		controls.add(scaleGrid);
		controls.add(modeBox);
		controls.add(collapse);
		controls.add(expand);
		content.add(controls, BorderLayout.SOUTH);
	}

	// class Rings implements VisualizationServer.Paintable {
	//
	// Collection<Double> depths;
	//
	// public Rings() {
	// depths = getDepths();
	// }
	//
	// private Collection<Double> getDepths() {
	// Set<Double> depths = new HashSet<Double>();
	// Map<Vertex, PolarPoint> polarLocations = radialLayout
	// .getPolarLocations();
	// for (Vertex v : graph.getVertices()) {
	// PolarPoint pp = polarLocations.get(v);
	// depths.add(pp.getRadius());
	// }
	// return depths;
	// }
	//
	// public void paint(Graphics g) {
	// g.setColor(Color.lightGray);
	//
	// Graphics2D g2d = (Graphics2D) g;
	// Point2D center = radialLayout.getCenter();
	//
	// Ellipse2D ellipse = new Ellipse2D.Double();
	// for (double d : depths) {
	// ellipse.setFrameFromDiagonal(center.getX() - d, center.getY()
	// - d, center.getX() + d, center.getY() + d);
	// Shape shape = vv.getRenderContext().getMultiLayerTransformer()
	// .getTransformer(Layer.LAYOUT).transform(ellipse);
	// g2d.draw(shape);
	// }
	// }
	//
	// public boolean useTransform() {
	// return true;
	// }
	// }

	// gibt zu einem thenNode den zugehörigen elseNode aus
	public int gotoElseIndex(Object[] graph2Array, IBasicBlock thenNode) {
		int count_then = 1;
		int count_else = 0;
		int i = 0;
		int j = 0;
		int k = 0;

		// ArrayList<IBasicBlock> arrli=new ArrayList(pathIBB.getNodes());
		// Object[] path= arrli.toArray();

		while (!((graph2Array[j].toString()).equals(thenNode.toString()))
				&& j < graph2Array.length) {
			j++;
		}
		i = j + 1;
		// System.out.println("gotoElse then " + path[i].toString());

		while (count_then != count_else) {

			if (graph2Array[i].toString().contains("Branch")) {

				if (graph2Array[i].toString().contains("then")) {
					count_then++;

				} else if (graph2Array[i].toString().contains("else")) {
					count_else++;

				}
			}
			i++;
			if (i == graph2Array.length - 1) {
				return i;
			}
		}
		if (i == graph2Array.length - 1) {
			return i;
		} else {
			return i - 1;
		}

	}

	/**
	 * create Tree
	 */
	public Collection<Vertex> createTree(Collection<IBasicBlock> graph2,
			Vertex lastEntry) {

		CxxDecisionNode decNode = null;
		CxxDecisionNode decNode2 = null;
		CxxDecisionNode decNode3 = null;
		IBasicBlock thenNode = null;
		IBasicBlock JumpFromThenNode = null;
		IBasicBlock JumpFromElseNode = null;
		IBasicBlock ibb = null;
		IBasicBlock firstNode = null;
		Vertex vFirstNode = null;
		Vertex vJumpFromThenNode1 = null;
		Vertex vJumpFromThenNode2 = null;
		Vertex vJumpFromElseNode1 = null;
		Vertex vJumpFromElseNode2 = null;
		Vertex v = null;
		Vertex w = null;
		Vertex vDecNode = null;
		Vertex lastEntry1 = null;
		Vertex lastEntry2 = null;
		Vertex lastEntry3 = null;
		Vertex lastEntry4 = null;
		Vertex lastEntryFromRecursionThenBranch1 = null;
		Vertex lastEntryFromRecursionThenBranch2 = null;
		Vertex lastEntryFromRecursionElseBranch1 = null;
		Vertex lastEntryFromRecursionElseBranch2 = null;
		int elseIndex = 0;// der Index des arrays graph2.toArray() an dem der
							// zum ThenNode gehörige ElseNode steht
		int countKnotenSpeicher = 0;
		int p = 0;
		int counter = 0;
		int counter2 = 0;
		Object[] graph2Array = graph2.toArray();
		ArrayList<IBasicBlock> KnotenSpeicher = new ArrayList<IBasicBlock>();
		Collection<IBasicBlock> graph3 = new ArrayList<IBasicBlock>();
		Collection<IBasicBlock> graph4 = new ArrayList<IBasicBlock>();
		Collection<Vertex> lastEntries = new ArrayList<Vertex>();
		Collection<Vertex> lastEntries1 = new ArrayList<Vertex>();
		Collection<Vertex> lastEntries2 = new ArrayList<Vertex>();
		Object[] KnotenSpeicherArray = KnotenSpeicher.toArray();

		/*
		 * INPUT 1
		 */
		// String text = "=IF(A2=1;0;IF(D2=D3;IF(C2=1;TRUE;FALSE);4))";

		/*
		 * INPUT 2
		 */

		String text = graph2.toString();

		text.toUpperCase();

		// START
		if (lastEntry != null) {
			firstNode = (IBasicBlock) graph2Array[0];
			vFirstNode = new Vertex(firstNode.toString());
			graph.addEdge(edgeFactory.create(), lastEntry, vFirstNode);
		}

		String[] operandStrings = text.substring(1, text.length()).split(",");

		Vertex[] operands = new Vertex[operandStrings.length];

		for (int i = 1; i < graph2Array.length; i++) {

			IBasicBlock s = (IBasicBlock) graph2Array[i];

			if (!(s.toString().contains("CxxDecisionNode"))) {
				if (graph.getVertices().size() == 0) {
					v = new Vertex(s.toString());
					graph.addVertex(v);
					lastEntry1 = v;
				} else if ((lastEntry != null) && (i == 1)) {
					v = new Vertex(s.toString());
					graph.addVertex(v);
					graph.addEdge(edgeFactory.create(), vFirstNode, v);
					lastEntry1 = v;
				} else {
					v = new Vertex(s.toString());
					graph.addVertex(v);
					graph.addEdge(edgeFactory.create(), lastEntry1, v);
					lastEntry1 = v;
				}

			} else {
				vDecNode = new Vertex(s.toString());
				graph.addVertex(v);
				graph.addEdge(edgeFactory.create(), lastEntry1, vDecNode);
				decNode = (CxxDecisionNode) s;
				thenNode = decNode.getOutgoingNodes()[0];
				elseIndex = gotoElseIndex(graph2Array, thenNode);
				i++;
				s = (IBasicBlock) graph2Array[i];
				while (!(s.toString().contains("Jump"))// wenn diese Bedingung
														// erfüllt ist, ist der
														// ThenBranch beendet.
														// Deswegen springen wir
														// raus
						&& i < graph2Array.length) {
					System.out.println(s.toString());

					if (s.toString().contains("CxxDecisionNode")) {// wenn
																	// decNode,
																	// dann
																	// rekursiver
																	// aufruf
						decNode2 = (CxxDecisionNode) s;
						graph3.clear();
						i++;
						s = (IBasicBlock) graph2Array[i];

						while (!(graph2Array[i] == decNode2.getMergeNode())
								&& i < graph2Array.length) {
							graph3.add((IBasicBlock) graph2Array[i]);
							i++;
						}
						System.out.println(graph3.toString());
						lastEntries1 = createTree(graph3, lastEntry);
						counter++;
						Iterator<Vertex> itThen = lastEntries1.iterator();
						lastEntryFromRecursionThenBranch1 = itThen.next();
						while (itThen.hasNext()) {
							lastEntryFromRecursionThenBranch2 = itThen.next();
						}
						i = i + graph3.size();
					} else {// wenn kein decNode, dann einfach einfügen

						v = new Vertex(s.toString());
						graph.addVertex(v);
						graph.addEdge(edgeFactory.create(), lastEntry1, v);
						lastEntry1 = v;
						i++;
						s = (IBasicBlock) graph2Array[i];
					}

				}

				s = (IBasicBlock) graph2Array[i];
				JumpFromThenNode = (IBasicBlock) graph2Array[i];
				if ((lastEntryFromRecursionThenBranch1 != null)// wenn create
																// rekursiv
																// aufgerufen
																// wurde, hängen
																// wir den
																// ThenJumpNode
																// an die
																// lastEntryFromRecursionThenBranch-Vertexes
						&& (lastEntryFromRecursionThenBranch2 != null)) {
					vJumpFromThenNode1 = new Vertex(JumpFromThenNode.toString());
					vJumpFromThenNode2 = new Vertex(JumpFromThenNode.toString());
					graph.addVertex(vJumpFromThenNode1);
					graph.addVertex(vJumpFromThenNode2);
					graph.addEdge(edgeFactory.create(),
							lastEntryFromRecursionThenBranch1,
							vJumpFromThenNode1);
					graph.addEdge(edgeFactory.create(),
							lastEntryFromRecursionThenBranch2,
							vJumpFromThenNode2);
				} else {
					v = new Vertex(s.toString());
					vJumpFromThenNode1 = new Vertex(JumpFromThenNode.toString());
					graph.addVertex(vJumpFromThenNode1);
					graph.addEdge(edgeFactory.create(), lastEntry1,
							vJumpFromThenNode1);
				}
				// Nun kommen die Knoten zwischen dem JumpNode von Then und dem
				// Begin des ElseBraches. Diese Knoten werden später an beide
				// Äste angehängt. Wir speichern sie in KnotenSpeicher.
				while (i != elseIndex && i < graph2Array.length) {
					KnotenSpeicher.add((IBasicBlock) graph2Array[i]);
					i++;
				}
				s = (IBasicBlock) graph2Array[i];// elseNode von dem ThenNode,
													// der zu dem DecNode gehört
													// von dem die Methode
													// aufgerufen wurde
				v = new Vertex(s.toString());
				graph.addVertex(v);
				graph.addEdge(edgeFactory.create(), vDecNode, v);// elseNode an
																	// den
																	// DecNode,
																	// von dem
																	// die
																	// Methode
																	// aufgerufen
																	// wird
																	// anhängen.
				lastEntry1 = v;

				if (i >= graph2Array.length - 1) {
					break;
				}
				i++;
				s = (IBasicBlock) graph2Array[i];// eins nach dem elseNode
				while (!(s.toString().contains("Jump"))
						&& i < graph2Array.length) {// solange
					// nicht
					// beim
					// JumpNode von Else,
					// füge
					// alles
					// unter
					// elseBranch
					// ein

					if (s.toString().contains("CxxDecisionNode")) {// wenn
																	// decNode,
																	// dann
																	// rekursiver
																	// aufruf
						decNode3 = (CxxDecisionNode) s;
						System.out.println(decNode3.toString() + " "
								+ decNode3.getMergeNode().toString());
						graph4.clear();
						i++;
						s = (IBasicBlock) graph2Array[i];
						while (!(graph2Array[i] == decNode3.getMergeNode())
								&& i < graph2Array.length) {
							graph4.add((IBasicBlock) graph2Array[i]);
							i++;
							s = (IBasicBlock) graph2Array[i];
						}

						System.out.println(graph4.toString());
						lastEntries2 = createTree(graph4, lastEntry);
						counter++;
						Iterator<Vertex> itElse = lastEntries2.iterator();
						lastEntryFromRecursionElseBranch1 = itElse.next();
						while (itElse.hasNext()) {
							lastEntryFromRecursionElseBranch2 = itElse.next();
						}

						i = i + graph4.size();
					} else {// sonst einfach normal unter else einfügen
						v = new Vertex(s.toString());
						graph.addVertex(v);
						graph.addEdge(edgeFactory.create(), lastEntry1, v);
						lastEntry1 = v;
						// if (i >= graph2Array.length - 1) {
						// break;
						// }
						i++;
						s = (IBasicBlock) graph2Array[i];
					}
				}

				s = (IBasicBlock) graph2Array[i];
				JumpFromElseNode = (IBasicBlock) graph2Array[i];
				if ((lastEntryFromRecursionElseBranch1 != null)// wenn create
																// rekursiv
																// aufgerufen
																// wurde, hängen
																// wir den
																// ElseJumpNode
																// an die
																// lastEntryFromRecursionElseBranch-Vertexes
						&& (lastEntryFromRecursionElseBranch2 != null)) {
					vJumpFromElseNode1 = new Vertex(JumpFromElseNode.toString());
					vJumpFromElseNode2 = new Vertex(JumpFromElseNode.toString());
					graph.addVertex(vJumpFromElseNode1);
					graph.addVertex(vJumpFromElseNode2);
					graph.addEdge(edgeFactory.create(),
							lastEntryFromRecursionElseBranch1,
							vJumpFromElseNode1);
					graph.addEdge(edgeFactory.create(),
							lastEntryFromRecursionElseBranch2,
							vJumpFromElseNode2);
				} else {
					v = new Vertex(s.toString());
					vJumpFromElseNode1 = new Vertex(JumpFromElseNode.toString());
					graph.addVertex(vJumpFromElseNode1);
					graph.addEdge(edgeFactory.create(), lastEntry1,
							vJumpFromElseNode1);
				}
				// hier bin ich hinter dem JumpNode, rufe für KnotenSpeicher
				// Array createTree rekursiv wieder auf
				// die Fallunterscheidungen prüfen an wieviele pfade diese
				// rekursion angehängt wird
				if ((lastEntryFromRecursionElseBranch1 != null)
						&& (lastEntryFromRecursionElseBranch2 != null)) {
					createTree(KnotenSpeicher, vJumpFromElseNode1);// hier wird
																	// die
																	// rekursion
																	// zb an
																	// vJmupFromElseNode1
																	// angehängt
					createTree(KnotenSpeicher, vJumpFromElseNode2);
					createTree(KnotenSpeicher, vJumpFromThenNode1);
					if (lastEntryFromRecursionThenBranch2 != null) {
						createTree(KnotenSpeicher, vJumpFromThenNode2);
					}
				} else if ((lastEntryFromRecursionThenBranch1 != null)
						&& (lastEntryFromRecursionThenBranch2 != null)) {
					createTree(KnotenSpeicher, vJumpFromThenNode1);
					createTree(KnotenSpeicher, vJumpFromThenNode2);
					createTree(KnotenSpeicher, vJumpFromElseNode1);
					if (lastEntryFromRecursionElseBranch2 != null) {
						createTree(KnotenSpeicher, vJumpFromElseNode2);
					}
				} else {
					createTree(KnotenSpeicher, vJumpFromElseNode1);
					createTree(KnotenSpeicher, vJumpFromThenNode1);
				}

			}

		}
		if ((lastEntryFromRecursionElseBranch1 == null)
				|| (lastEntryFromRecursionThenBranch1 == null)) {
			lastEntries.add(lastEntry1);
		} else {
			lastEntries.add(lastEntry1);
			lastEntries.add(lastEntry2);
		}
		return lastEntries;

		// System.out.println(Arrays.toString(operands));
		// int numNodes = operands.length / 3; // actually (operands.length - 1)
		// /
		// // 3
		// // but int division makes it the
		// // same
		// Vertex[] nodes = new Vertex[numNodes]; // stores the nodes (test
		// // strings)
		// int[] operandNos = new int[numNodes]; // stores the number of
		// operands
		// // the
		// // if currently has
		// int nodesIndex = -1; // the index of the if node currently parsed
		// for (Vertex s : operands) {
		// if (s.getName().contains("CxxDecisionNode")) {
		// // new if found -> increase position in the "stack" (nodes)
		// operandNos[++nodesIndex] = 0;
		// } else {
		// // addVertex(s);
		// graph.addVertex(s);
		// switch (operandNos[nodesIndex]++) {
		// case 0:
		// // first operand = node name
		// nodes[nodesIndex] = s;
		// break;
		// case 1:
		// // second operand found -> add edge
		// graph.addEdge(edgeFactory.create(), s, nodes[nodesIndex]);
		// break;
		// case 2:
		// // last operand found -> add edge and go back
		// do {
		// graph.addEdge(edgeFactory.create(), s,
		// nodes[nodesIndex]);
		// s = nodes[nodesIndex--];
		// } while (nodesIndex >= 0 && operandNos[nodesIndex]++ == 2);
		// if (nodesIndex >= 0) {
		// // was not the last operand of the IF
		// graph.addEdge(edgeFactory.create(), s,
		// nodes[nodesIndex]);
		// }
		// }
		// }
		// }
		// END

	}

	class ClusterVertexShapeFunction<V> extends
			EllipseVertexShapeTransformer<V> {

		ClusterVertexShapeFunction() {
			setSizeTransformer(new ClusterVertexSizeFunction<V>(20));
		}

		@SuppressWarnings("unchecked")
		@Override
		public Shape transform(V v) {
			if (v instanceof Graph) {
				int size = ((Graph) v).getVertexCount();
				if (size < 8) {
					int sides = Math.max(size, 3);
					return factory.getRegularPolygon(v, sides);
				} else {
					return factory.getRegularStar(v, size);
				}
			}
			return super.transform(v);
		}
	}

	/**
	 * A demo class that will make vertices larger if they represent a collapsed
	 * collection of original vertices
	 * 
	 * @author Tom Nelson
	 * 
	 * @param <V>
	 */
	class ClusterVertexSizeFunction<V> implements Transformer<V, Integer> {
		int size;

		public ClusterVertexSizeFunction(Integer size) {
			this.size = size;
		}

		public Integer transform(V v) {
			if (v instanceof Graph) {
				return 30;
			}
			return size;
		}
	}

	/**
	 * a driver for this demo
	 */
	public static void drawTree(Collection<IBasicBlock> graph) {
		JFrame frame = new JFrame();
		Container content = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		content.add(new JUNGTree(graph));
		frame.pack();
		frame.setVisible(true);
	}
}