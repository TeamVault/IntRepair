package smtcodan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.PolarPoint;
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
import edu.uci.ics.jung.visualization.Layer;
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
	public JUNGTree() {

		// create a simple graph for the demo
		graph = new DelegateForest<Vertex, Integer>();

		createTree();

		layout = new TreeLayout<Vertex, Integer>(graph);
		collapser = new TreeCollapser();

		radialLayout = new RadialTreeLayout<Vertex, Integer>(graph);
		radialLayout.setSize(new Dimension(600, 600));
		vv = new VisualizationViewer<Vertex, Integer>(layout, new Dimension(
				600, 600));
		vv.setBackground(Color.white);
		vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setVertexShapeTransformer(
				new ClusterVertexShapeFunction());
		// add a listener for ToolTips
		vv.setVertexToolTipTransformer(new ToStringLabeller());
		vv.getRenderContext().setArrowFillPaintTransformer(
				new ConstantTransformer(Color.lightGray));
		rings = new Rings();

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

	class Rings implements VisualizationServer.Paintable {

		Collection<Double> depths;

		public Rings() {
			depths = getDepths();
		}

		private Collection<Double> getDepths() {
			Set<Double> depths = new HashSet<Double>();
			Map<Vertex, PolarPoint> polarLocations = radialLayout
					.getPolarLocations();
			for (Vertex v : graph.getVertices()) {
				PolarPoint pp = polarLocations.get(v);
				depths.add(pp.getRadius());
			}
			return depths;
		}

		public void paint(Graphics g) {
			g.setColor(Color.lightGray);

			Graphics2D g2d = (Graphics2D) g;
			Point2D center = radialLayout.getCenter();

			Ellipse2D ellipse = new Ellipse2D.Double();
			for (double d : depths) {
				ellipse.setFrameFromDiagonal(center.getX() - d, center.getY()
						- d, center.getX() + d, center.getY() + d);
				Shape shape = vv.getRenderContext().getMultiLayerTransformer()
						.getTransformer(Layer.LAYOUT).transform(ellipse);
				g2d.draw(shape);
			}
		}

		public boolean useTransform() {
			return true;
		}
	}

	/**
	 * create Tree
	 */
	private void createTree() {

		/*
		 * INPUT 1
		 */
		// String text = "=IF(A2=1;0;IF(D2=D3;IF(C2=1;TRUE;FALSE);4))";

		/*
		 * INPUT 2
		 */
		String text = "=IF(A2=1;0;IF(D2=D3;IF(C2=1;TRUE;FALSE);TRUE))";

		text.toUpperCase();

		// START
		String[] operandStrings = text.substring(1, text.length()).split(
				"[;()]+");

		Vertex[] operands = new Vertex[operandStrings.length];
		for (int i = 0; i < operandStrings.length; i++) {
			operands[i] = new Vertex(operandStrings[i]);
		}

		System.out.println(Arrays.toString(operands));
		int numIfs = operands.length / 3; // actually (operands.length - 1) / 3
											// but int division makes it the
											// same
		Vertex[] nodes = new Vertex[numIfs]; // stores the nodes (test strings)
		int[] operandNos = new int[numIfs]; // stores the number of operands the
											// if currently has
		int nodesIndex = -1; // the index of the if node currently parsed
		for (Vertex s : operands) {
			if (s.getName().equals("IF")) {
				// new if found -> increase position in the "stack" (nodes)
				operandNos[++nodesIndex] = 0;
			} else {
				// addVertex(s);
				graph.addVertex(s);
				switch (operandNos[nodesIndex]++) {
				case 0:
					// first operand = node name
					nodes[nodesIndex] = s;
					break;
				case 1:
					// second operand found -> add edge
					graph.addEdge(edgeFactory.create(), s, nodes[nodesIndex]);
					break;
				case 2:
					// last operand found -> add edge and go back
					do {
						graph.addEdge(edgeFactory.create(), s,
								nodes[nodesIndex]);
						s = nodes[nodesIndex--];
					} while (nodesIndex >= 0 && operandNos[nodesIndex]++ == 2);
					if (nodesIndex >= 0) {
						// was not the last operand of the IF
						graph.addEdge(edgeFactory.create(), s,
								nodes[nodesIndex]);
					}
				}
			}
		}
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
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Container content = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		content.add(new JUNGTree());
		frame.pack();
		frame.setVisible(true);
	}
}