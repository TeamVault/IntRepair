package smtcodan.quickfixes.information.exposure;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.cdt.codan.core.model.AbstractChecker;
import org.eclipse.cdt.codan.core.model.IProblemLocation;
import org.eclipse.cdt.codan.internal.core.model.CodanMarkerProblemReporter;
import org.eclipse.cdt.codan.internal.ui.CodanProblemMarkerResolutionGenerator;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.OperationCanceledException;

import smtcodan.Config;
import smtcodan.WorkPool;
import smtcodan.logger.StatementLogger;
import smtcodan.pathgen.ProgramPathIBB;
import smtcodan.quickfixes.CGNodeVisitor;
import smtcodan.quickfixes.InfluenciableNodeVisitor;
import smtcodan.quickfixes.PathObject;
import smtcodan.quickfixes.Refactoring;
import smtcodan.quickfixes.SMTConstraintObject;

// TODO: Auto-generated Javadoc
/* FrameDemo.java requires no other files. */
/**
 * The Class Propagation.
 */
public class RefactoringFinderInformationExposure extends AbstractChecker
		implements ActionListener {

	/** The text. */
	private String text = "Path";

	/** The list box entrys. */
	private String listBoxEntrys[] = null;

	/** The selected path. */
	private String selectedPath = null;

	/** The walkthrough list. */
	public ArrayList<PathObject> walkthroughList = null;

	/** The walkthrough list size. */
	private int walkthroughListSize;

	/** The starting index. */
	int startingIndex = 0; // used only for initialisation

	/** The see. */
	// public SymbolicExecutionEngine see;

	/** The problem id. */
	public String problemId;

	/** The counter for the number of fixes. */

	public int start_line1;

	/** The marker. */
	public CodanMarkerProblemReporter marker = null;

	/** The erase previous nodes. */
	private boolean erasePreviousNodes = false;

	/** The erase previous nodes. */
	public static boolean eraseQuickFixMarker;

	/** The quick fix bounds. */
	public QuickFixInformationExposure quickFixBounds;

	/** resolution. */
	public CodanProblemMarkerResolutionGenerator resolution = null;

	/** The refactoring. */
	public Refactoring bugRefactoring;

	/** The quick fix refactoring. */
	public Refactoring quickFixRefactoring;

	/** The refactorings. */
	public static ArrayList<Refactoring> refactoringsList = null;

	/** The initial bug file. */
	public static IASTFileLocation initialBugFile;

	public static int countInfluenciablePaths;

	public HashMap<String, ProgramPathIBB> programPathsmap;

	public WorkPool workPool;

	public static int counterBuggyPaths = 0;
	public static int counterNotInPlaceQuickFixes = 0;

	/**
	 * Instantiates a new propagation.
	 * 
	 * @param propagationMap
	 *            the propagation map
	 * @param problemId
	 *            the problem id
	 * @param refactorings
	 *            the refactorings
	 */
	public RefactoringFinderInformationExposure(final Map propagationMap,
			String problemId, ArrayList<Refactoring> refactorings, WorkPool wp) {
		// TODO Auto-generated constructor stub
		// the refactoring list
		this.refactoringsList = refactorings;
		// problem id
		this.problemId = problemId;

		this.workPool = wp;

		// this.programPathsmap = pm;

		// this.start_line1 =start_line;
		this.quickFixBounds = new QuickFixInformationExposure();
		// report the bug label
		// set the replaceable label
		quickFixBounds
				.setReplaceStringOld(getTheLabelWhereTheBugWasFound(propagationMap));
		// set the constaint object
		quickFixBounds.setOb(getConstraintObject(propagationMap));
		// walkthroughList
		walkthroughList = new ArrayList<PathObject>();
		// set the erase quick fix markers to false, originally the check box is
		// not checked
		eraseQuickFixMarker = false;
		// erase previous nodes set to false, originally the check box is not
		// checked
		erasePreviousNodes = false;

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// create the gui, window presentation can be switched on or off
				if (Config.showRunQuickFixWindow)
					createAndShowGUI(propagationMap);
			}
		});
	}

	/**
	 * Gets the initial bug file.
	 * 
	 * @return the initial bug file
	 */
	public static IASTFileLocation getInitialBugFile() {
		return initialBugFile;
	}

	/**
	 * Sets the initial bug file.
	 * 
	 * @param initialBugFile
	 *            the new initial bug file
	 */
	public static void setInitialBugFile(IASTFileLocation initialBugFile) {
		RefactoringFinderInformationExposure.initialBugFile = initialBugFile;
	}

	/**
	 * Gets the the label where the bug was found.
	 * 
	 * @param propagationMap
	 *            the propagation map
	 * @return the the label where the bug was found
	 */
	public String getTheLabelWhereTheBugWasFound(Map propagationMap) {
		Iterator it5 = propagationMap.entrySet().iterator();
		while (it5.hasNext()) {
			Map.Entry pairs = (Map.Entry) it5.next();
			for (int i = 0; i < ((ArrayList<PathObject>) pairs.getValue())
					.size(); i++) {
				if (((ArrayList<PathObject>) pairs.getValue()).get(i)
						.isStartupNode()) {
					return ((ArrayList<PathObject>) pairs.getValue()).get(i)
							.getNode().getRawSignature().toString();
				}
			}
		}
		return "null";

	}

	/**
	 * setTheConstraintVarAndValue Gets the constraint object.
	 * 
	 * @param propagationMap
	 *            the propagation map
	 * @return the constraint object
	 */
	public SMTConstraintObject getConstraintObject(Map propagationMap) {
		Iterator it6 = propagationMap.entrySet().iterator();
		while (it6.hasNext()) {
			Map.Entry pairs = (Map.Entry) it6.next();
			for (int i = 0; i < ((ArrayList<PathObject>) pairs.getValue())
					.size(); i++) {
				if (((ArrayList<PathObject>) pairs.getValue()).get(i)
						.isStartupNode()) {
					return ((ArrayList<PathObject>) pairs.getValue()).get(i)
							.getConstraintOb();
				}
			}
		}
		return null;

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 * 
	 * @param propagationMap
	 *            the propagation map
	 */
	@SuppressWarnings("unchecked")
	public void createAndShowGUI(final Map propagationMap) {
		// Create and set up the window.

		JFrame frame = new JFrame("Propagation Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JPanel labelspanel = new JPanel();
		labelspanel.setLayout(new GridLayout(0, 1));
		JPanel inputpanel = new JPanel();
		inputpanel.setLayout(new GridLayout(0, 1));

		// inputpanel.setLayout(new GridLayout(0,2,5,5));

		inputpanel.setSize(200, 200);
		// inputpanel.setBorder(BorderFactory.createDashedBorder(Color.BLUE));
		final JTextField nodeTextField = new JTextField(30);
		nodeTextField.setEditable(false);
		final JTextField fileTextField = new JTextField(50);
		fileTextField.setEditable(false);
		final JTextField lineNumberTextField = new JTextField(3);
		lineNumberTextField.setEditable(false);
		final JTextField pathSizeTextBox = new JTextField(3);
		pathSizeTextBox.setEditable(false);
		final JTextField nodeIndexTextBox = new JTextField(3);
		nodeIndexTextBox.setEditable(false);
		final JTextField quickFixTextBox = new JTextField(3);
		quickFixTextBox.setEditable(false);
		final JTextField numberOfquickFixesBox = new JTextField(3);
		numberOfquickFixesBox.setEditable(false);

		final JLabel nodeTextFieldLabel = new JLabel("Node Statement:");
		final JLabel fileTextFieldLabel = new JLabel("Current File:");
		final JLabel nodeIndexLabel = new JLabel("Current Node:");
		final JLabel lineNumberTextFieldLabel = new JLabel("Current Line:");

		final JLabel eraseNodesLabel = new JLabel("Erase node markers:");
		final JCheckBox shouldEraseAllNodesCheckBox = new JCheckBox();

		final JLabel eraseQuickFixLabel = new JLabel("Erase quick-fix marker:");
		final JCheckBox eraseQuickFixMarkersAfterQuickFixWasInserted = new JCheckBox();

		final JLabel pathSizeLabel = new JLabel("Total Number of Nodes:");
		final JLabel quickFixAvailable = new JLabel("Quick-fix available:");
		final JLabel numberOfquickFixesAvailable = new JLabel(
				"Number of Quick-fix locations:");

		JButton forwardNavigationButton = new JButton("Forward");
		forwardNavigationButton.setPreferredSize(new Dimension(110, 20));
		JButton backwardNavigationButton = new JButton("Backward");
		backwardNavigationButton.setPreferredSize(new Dimension(110, 20));
		JButton autoFindButton = new JButton("Find Pre Quick-fix Locations");
		autoFindButton.setPreferredSize(new Dimension(250, 20));

		forwardNavigationButton.addActionListener(this);
		backwardNavigationButton.addActionListener(this);
		autoFindButton.addActionListener(this);

		// Create a panel to hold all other components
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		frame.getContentPane().add(topPanel);

		JPanel buttonPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		frame.getContentPane().add(buttonPanel);

		// Create the data model for this example
		final Map<String, ArrayList<PathObject>> path_map = new HashMap<String, ArrayList<PathObject>>();

		Iterator it2 = propagationMap.entrySet().iterator();
		ArrayList<String> pathList = new ArrayList<String>();

		// create listbox id's
		while (it2.hasNext()) {
			Map.Entry pairs = (Map.Entry) it2.next();
			pathList.add(pairs.getKey().toString());
		}

		listBoxEntrys = new String[pathList.size()];
		listBoxEntrys = pathList.toArray(listBoxEntrys);

		// Create a new listbox control
		final JList listbox = new JList(listBoxEntrys);
		// add listener to the listbox
		listbox.addListSelectionListener(new ListSelectionListener() {
			ArrayList<String> text_nodes = new ArrayList<String>();

			public void valueChanged(ListSelectionEvent e) {
				if (propagationMap.containsKey(listbox.getSelectedValue())) {
					selectedPath = listbox.getSelectedValue().toString();
					Iterator it3 = propagationMap.entrySet().iterator();
					while (it3.hasNext()) {
						Map.Entry pairs = (Map.Entry) it3.next();
						for (int i = 0; i < ((ArrayList<PathObject>) pairs
								.getValue()).size(); i++) {
							if (((ArrayList<PathObject>) pairs.getValue()).get(
									i).isStartupNode()) {
								// fill the text fields after path was selected
								nodeTextField
										.setText(((ArrayList<PathObject>) pairs
												.getValue()).get(i).getNode()
												.getRawSignature().toString());
								fileTextField
										.setText(getStringNameFromURI(((ArrayList<PathObject>) pairs
												.getValue()).get(i).getFile()
												.toString()));
								lineNumberTextField.setText(String
										.valueOf(((ArrayList<PathObject>) pairs
												.getValue()).get(i)
												.getStartlifileLocation()));
								pathSizeTextBox.setText(String
										.valueOf(((ArrayList<PathObject>) pairs
												.getValue()).size()));
								nodeIndexTextBox.setText(String.valueOf(i));

								// set the replaceable label
								quickFixBounds
										.setReplaceStringNew(((ArrayList<PathObject>) pairs
												.getValue()).get(i).getNode()
												.getRawSignature().toString());
								// set the cons obj
								quickFixBounds
										.setOb(((ArrayList<PathObject>) pairs
												.getValue()).get(i)
												.getConstraintOb());

								// set the constrain var and value
								quickFixBounds
										.setTheConstraintVarAndValueFromMarker(AssertInformationExposure.INFORMATION_EXPOSURE_QUICK_FIX_MESSAGE);

								// indicate that quick fix is available
								if (!((ArrayList<PathObject>) pairs.getValue())
										.get(i).getConstraintOb()
										.getBufferSize().equals("null")
										&& !((ArrayList<PathObject>) pairs
												.getValue()).get(i)
												.getConstraintOb()
												.getLinearSystem()
												.equals("null")) {
									quickFixTextBox.setText("yes");
								} else {
									quickFixTextBox.setText("no");
								}

								walkthroughList = (ArrayList<PathObject>) pairs
										.getValue();
								startingIndex = i;
								walkthroughListSize = ((ArrayList<PathObject>) pairs
										.getValue()).size();
							} else {
								// not a buggy path
							}
						}
					}
				}
			}
		});

		// add check box listener
		eraseQuickFixMarkersAfterQuickFixWasInserted
				.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent event) {
						if (event.getItemSelectable() == eraseQuickFixMarkersAfterQuickFixWasInserted) {
							if (eraseQuickFixMarkersAfterQuickFixWasInserted
									.isSelected()) {
								eraseQuickFixMarker = true;
							} else {
								eraseQuickFixMarker = false;
							}
						}
					}
				});

		// add check box listener
		shouldEraseAllNodesCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				if (event.getItemSelectable() == shouldEraseAllNodesCheckBox) {
					if (shouldEraseAllNodesCheckBox.isSelected()) {
						erasePreviousNodes = true;
					} else {
						erasePreviousNodes = false;
					}
				}
			}
		});

		// add listener to the backward navigation button
		backwardNavigationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// avoid a index out of bounds
				if (startingIndex > 0) {
					int index = startingIndex - 1;
					// check if path was selected
					if (walkthroughList == null) {
						StatementLogger
								.log_navigation("Select a path to navigate...");
						nodeTextField.setText("Select a path to navigate...");
						fileTextField.setText("Select a path to navigate...");
					} else {
						if (walkthroughList.get(index) != null) {
							StatementLogger
									.log_navigation("backward navigation...");

							// set the marker
							marker = new CodanMarkerProblemReporter();

							// set the replaceable label
							quickFixBounds.setReplaceStringNew(walkthroughList
									.get(index).getNode().getRawSignature()
									.toString());
							// set the cons obj
							quickFixBounds.setOb(walkthroughList.get(index)
									.getConstraintOb());

							// send the node to the StatementVisitor
							IASTNode in;
							in = walkthroughList.get(index).getNode();

							StatementLogger.log_navigation(String
									.valueOf(walkthroughList.get(index)
											.getStartlifileLocation()));

							CGNodeVisitor statvisitor = new CGNodeVisitor();
							in.accept(statvisitor);

							// indicate that quick fix is available
							if (!walkthroughList.get(index).getConstraintOb()
									.getBufferSize().equals("null")
									&& !walkthroughList.get(index)
											.getConstraintOb()
											.getLinearSystem().equals("null")) {
								quickFixTextBox.setText("yes");
							} else {
								quickFixTextBox.setText("no");
							}

							// remove previous markers
							if (erasePreviousNodes) {
								marker.deleteAllProblems();
							}

							// send node to StatementVisitor
							IASTNode node = walkthroughList.get(index)
									.getNode();

							CGNodeVisitor visitor = new CGNodeVisitor();
							node.accept(visitor);

							// put a marker
							IProblemLocation ploc = createProblemLocation(
									walkthroughList.get(index).getFile(),
									walkthroughList.get(index)
											.getStartlifileLocation());
							marker.reportProblem(problemId, ploc,
									"backward navigation...");

							// back propagation list
							quickFixBounds.backward_list(walkthroughList
									.get(index).getNode().getRawSignature()
									.toString());

							// update display boxes
							nodeTextField.setText(walkthroughList.get(index)
									.getNode().getRawSignature().toString());
							fileTextField
									.setText(getStringNameFromURI(walkthroughList
											.get(index).getFile().toString()));
							lineNumberTextField.setText(String
									.valueOf(walkthroughList.get(index)
											.getStartlifileLocation()));
							pathSizeTextBox.setText(String
									.valueOf(walkthroughList.size()));
							nodeIndexTextBox.setText(String.valueOf(index));

							// decrease the index
							startingIndex--;
						}
					}
				}
				// check if index reached starting node
				if (startingIndex == 0) {
					// notify the user too
					StatementLogger
							.log_navigation("End of navigation path reached...");
					nodeTextField.setText("End of navigation path reached...");
					fileTextField.setText("End of navigation path reached...");
				}
				// check if index reached starting node
				if (startingIndex == -10) {
					nodeTextField.setText("Select a path to navigate...");
					fileTextField.setText("Select a path to navigate...");
					StatementLogger
							.log_navigation("Select a path to navigate...");
				}
			}
		});

		// add forward button navigation
		forwardNavigationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// avoid a index out of bounds
				if (startingIndex < walkthroughListSize - 1) {
					int index = startingIndex + 1;
					// check if path was selected
					if (walkthroughList == null) {
						StatementLogger
								.log_navigation("Select a path to navigate...");
						nodeTextField.setText("Select a path to navigate...");
						fileTextField.setText("Select a path to navigate...");
					} else {
						if (walkthroughList.get(index) != null) {
							StatementLogger
									.log_navigation("forward navigation...");

							// set the marker
							marker = new CodanMarkerProblemReporter();

							// set the replaceable label
							quickFixBounds.setReplaceStringNew(walkthroughList
									.get(index).getNode().getRawSignature()
									.toString());

							// set the cons obj
							quickFixBounds.setOb(walkthroughList.get(index)
									.getConstraintOb());

							// indicate that quick fix is available
							if (!walkthroughList.get(index).getConstraintOb()
									.getBufferSize().equals("null")
									&& !walkthroughList.get(index)
											.getConstraintOb()
											.getLinearSystem().equals("null")) {
								quickFixTextBox.setText("yes");
							} else {
								quickFixTextBox.setText("no");
							}

							// remove previous markers
							if (erasePreviousNodes) {
								marker.deleteAllProblems();
							}

							// send node to StatementVisitor
							IASTNode node = walkthroughList.get(index)
									.getNode();
							CGNodeVisitor visitor = new CGNodeVisitor();
							node.accept(visitor);

							// put a marker
							IProblemLocation ploc = createProblemLocation(
									walkthroughList.get(index).getFile(),
									walkthroughList.get(index)
											.getStartlifileLocation());
							marker.reportProblem(problemId, ploc,
									"forward navigation...");

							// set the text in the boxes
							nodeTextField.setText(walkthroughList.get(index)
									.getNode().getRawSignature().toString());
							fileTextField
									.setText(getStringNameFromURI(walkthroughList
											.get(index).getFile().toString()));
							lineNumberTextField.setText(String
									.valueOf(walkthroughList.get(index)
											.getStartlifileLocation()));
							pathSizeTextBox.setText(String
									.valueOf(walkthroughList.size()));
							nodeIndexTextBox.setText(String.valueOf(index));

							// decrease the index
							startingIndex++;
						}
					}
				}
				// check if index reached starting node
				if (startingIndex == walkthroughListSize - 1) {
					StatementLogger
							.log_navigation("End of navigation path reached...");
					nodeTextField.setText("End of navigation path reached...");
					fileTextField.setText("End of navigation path reached...");
				}
			}
		});

		// add listener to the AutoFind button
		autoFindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// starting index
				int index = startingIndex;
				StatementLogger.log_quickFixes("start index: " + startingIndex);
				// how many previous quick fix locations should it find
				int NumberOfPreQuick_FixLocations = 1;
				// number of detected prefix locations
				int counter = 0;
				// this is for the string where the bug was originally found
				quickFixBounds.setReplaceStringOld(walkthroughList.get(index)
						.getNode().getRawSignature().toString());
				while (index > 0 && counter < NumberOfPreQuick_FixLocations) {
					// send the node to the StatementVisitor
					IASTNode in;
					in = walkthroughList.get(index).getNode();

					CGNodeVisitor statvisitor = new CGNodeVisitor();
					in.accept(statvisitor);

					// put a marker
					if (CGNodeVisitor.isFound() == true) {
						// set the marker
						marker = new CodanMarkerProblemReporter();

						// set the replaceable label
						quickFixBounds.setReplaceStringNew(walkthroughList
								.get(index).getNode().getRawSignature()
								.toString());
						// set the cons obj
						quickFixBounds.setOb(walkthroughList.get(index)
								.getConstraintOb());

						IProblemLocation ploc = createProblemLocation(
								walkthroughList.get(index).getFile(),
								walkthroughList.get(index)
										.getStartlifileLocation());

						marker.reportProblem(problemId, ploc,
								"Quick-fix location");
						counter++;
						StatementLogger
								.log_quickFixes("the quick-fix is at line: "
										+ walkthroughList.get(index)
												.getStartlifileLocation());

						// set the text in the boxes
						nodeTextField.setText(walkthroughList.get(index)
								.getNode().getRawSignature().toString());
						nodeTextField.setForeground(Color.BLUE);

						fileTextField
								.setText(getStringNameFromURI(walkthroughList
										.get(index).getFile().toString()));
						fileTextField.setForeground(Color.BLUE);
						lineNumberTextField.setText(String
								.valueOf(walkthroughList.get(index)
										.getStartlifileLocation()));
						lineNumberTextField.setForeground(Color.BLUE);

						pathSizeTextBox.setText(String.valueOf(walkthroughList
								.size()));
						pathSizeTextBox.setForeground(Color.BLUE);

						nodeIndexTextBox.setText(String.valueOf(index));
						nodeIndexTextBox.setForeground(Color.BLUE);

						quickFixTextBox.setText("yes");
						quickFixTextBox.setForeground(Color.BLUE);

					} else {
						// quickFixTextBox.setText("no");
					}
					index--;
				}
				numberOfquickFixesBox.setText(String.valueOf(counter));
				numberOfquickFixesBox.setForeground(Color.BLUE);
			}
		});

		// Add the list box to a scrolling pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(40, 50));
		scrollPane.getViewport().add(listbox);

		topPanel.add(scrollPane, BorderLayout.CENTER);
		// path size label
		labelspanel.add(pathSizeLabel, BorderLayout.EAST);
		inputpanel.add(pathSizeTextBox, BorderLayout.CENTER);
		// Node label
		labelspanel.add(nodeTextFieldLabel, BorderLayout.EAST);
		inputpanel.add(nodeTextField, BorderLayout.CENTER);
		// Node index
		labelspanel.add(nodeIndexLabel, BorderLayout.EAST);
		inputpanel.add(nodeIndexTextBox, BorderLayout.CENTER);
		// Line number label
		labelspanel.add(lineNumberTextFieldLabel, BorderLayout.EAST);
		inputpanel.add(lineNumberTextField, BorderLayout.CENTER);
		// File label
		labelspanel.add(fileTextFieldLabel, BorderLayout.EAST);
		inputpanel.add(fileTextField, BorderLayout.CENTER);
		// add quick fix available
		labelspanel.add(quickFixAvailable, BorderLayout.EAST);
		inputpanel.add(quickFixTextBox, BorderLayout.CENTER);
		// dfg
		labelspanel.add(numberOfquickFixesAvailable, BorderLayout.EAST);
		inputpanel.add(numberOfquickFixesBox, BorderLayout.CENTER);
		// Add checkbox
		labelspanel.add(eraseNodesLabel, BorderLayout.EAST);
		inputpanel.add(shouldEraseAllNodesCheckBox, BorderLayout.CENTER);

		// Add checkbox
		labelspanel.add(eraseQuickFixLabel, BorderLayout.EAST);
		inputpanel.add(eraseQuickFixMarkersAfterQuickFixWasInserted,
				BorderLayout.CENTER);

		labelspanel.setToolTipText("Current node:");
		buttonPanel.add(backwardNavigationButton, BorderLayout.CENTER);
		buttonPanel.add(forwardNavigationButton, BorderLayout.CENTER);
		buttonPanel.add(autoFindButton, BorderLayout.CENTER);

		frame.getContentPane().add(BorderLayout.WEST, labelspanel);
		frame.getContentPane().add(BorderLayout.EAST, inputpanel);
		frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
		frame.getContentPane().add(BorderLayout.NORTH, topPanel);

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		frame.setResizable(false);
		nodeTextField.requestFocus();

		// Display the window.
		frame.pack();
		frame.setVisible(true);
		// frame.setSize(925, 320);
	}

	/**
	 * Gets the string name from uri.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the string name from uri
	 */
	public String getStringNameFromURI(String filePath) {
		String delims = "[/]";
		String[] tokens = filePath.split(delims);
		return tokens[tokens.length - 1];
	}

	/**
	 * Action performed.
	 * 
	 * @param e
	 *            the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.codan.core.model.AbstractChecker#processResource(org.
	 * eclipse.core.resources.IResource)
	 */
	@Override
	public boolean processResource(IResource resource)
			throws OperationCanceledException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Search for influenciable paths by the quick fix node.
	 * 
	 * @param nodesmap
	 *            the nodesmap
	 * @param quickFixNode
	 *            the quick fix node
	 * @return true, if successful
	 */
	public boolean searchForInfluenciablePathsByTheQuickFixNode(Map nodesmap,
			IASTNode quickFixNode) {
		int quickFixNodeIndex = 0;
		boolean noBuggyNode = false;
		boolean influencingNode2 = false;
		countInfluenciablePaths = 0;
		// check if there is still a path remaining
		if (nodesmap.size() > 0) {
			Iterator<?> itx = nodesmap.entrySet().iterator();
			while (itx.hasNext() && !influencingNode2) {
				Map.Entry pairs = (Map.Entry) itx.next();
				ArrayList<PathObject> nodesList2 = ((ArrayList<PathObject>) pairs
						.getValue());
				noBuggyNode = false;
				for (int i = 0; i < nodesList2.size(); i++) {
					// check if the path contains the quick fix node at which we
					// want
					// to fix
					if (nodesList2.get(i).getNode().equals(quickFixNode)
							&& nodesList2
									.get(i)
									.getNode()
									.getFileLocation()
									.getFileName()
									.equals(quickFixNode.getFileLocation()
											.getFileName())
							&& nodesList2.get(i).getNode().getFileLocation()
									.getStartingLineNumber() == quickFixNode
									.getFileLocation().getStartingLineNumber()) {
						quickFixNodeIndex = i;
						noBuggyNode = true;
					}
				}
				if (!noBuggyNode) {
					// does not contain the buggy node then skip the path and
					// take the next path
					break;
				}

				// check if the nodes on the path could be influenced by our
				// buggy variable

				for (int i2 = quickFixNodeIndex; i2 < nodesList2.size(); i2++) {
					// start search from the influencing node down the path
					if (noBuggyNode) {
						InfluenciableNodeVisitor inv = new InfluenciableNodeVisitor();
						nodesList2.get(i2).getNode().accept(inv);
						if (InfluenciableNodeVisitor.isFound() == true) {
							influencingNode2 = true;
							countInfluenciablePaths++;
							InfluenciableNodeVisitor.setFound(false);
						}
					}
				}
			}
		}
		return influencingNode2;
	}

	/**
	 * Run quick fix searching algorithm.
	 * 
	 * @param propagationMap
	 *            the propagation map
	 * @param quickFixInformationExposure
	 *            the quick fix bounds
	 */
	public void runQuickFixSearchingAlgorithm(Map propagationMap,
			QuickFixInformationExposure quickFixInformationExposure) {
		// clean the list, this makes the list holding any time
		// only two
		// elements
		// refactoringsList.clear();
		// get the start index (this is the index in the walk through list where
		// the bug was detected)
		// and the first buggy path in the walkthroughList

		// a necessary condition for the not in-place quick fix.
		// for each buggy path a quick fix should be generated if
		// not than the not in-place quick fixes should not be
		// offered in the GUI, this cab be done with 2 counters
		// one counts the number a buggy path is encountered the
		// other counter counter each time a not in-place quick fix is
		// generated. These two values should be at the end of the algorithm
		// equal. If not equal than these should not be suggested in the GUI.
		counterBuggyPaths = 0;
		counterNotInPlaceQuickFixes = 0;
		Iterator it3 = propagationMap.entrySet().iterator();
		while (it3.hasNext()) {
			Map.Entry pairs = (Map.Entry) it3.next();
			for (int i = 0; i < ((ArrayList<PathObject>) pairs.getValue())
					.size(); i++) {
				// set the walkthroughList to be the first buggy path
				// a start up node is a on the path were the bug was located
				if (((ArrayList<PathObject>) pairs.getValue()).get(i)
						.isStartupNode()) {
					// one buggy path found
					counterBuggyPaths++;

					// set the replaceable label
					quickFixInformationExposure
							.setReplaceStringNew(((ArrayList<PathObject>) pairs
									.getValue()).get(i).getNode()
									.getRawSignature().toString());
					// set the cons obj
					quickFixInformationExposure
							.setOb(((ArrayList<PathObject>) pairs.getValue())
									.get(i).getConstraintOb());
					// set the constrain var and value
					quickFixInformationExposure
							.setTheConstraintVarAndValueFromMarker(AssertInformationExposure.INFORMATION_EXPOSURE_QUICK_FIX_MESSAGE);
					walkthroughList = (ArrayList<PathObject>) pairs.getValue();
					startingIndex = i;
					walkthroughListSize = ((ArrayList<PathObject>) pairs
							.getValue()).size();

					// the node were the bug was found index
					int index = startingIndex;
					boolean foundInfluenciablePath = false;

					StatementLogger.log_quickFixes("start index: "
							+ startingIndex);
					// how many previous quick fix locations should it find
					int NumberOfPreQuick_FixLocations = 1;

					// number of detected prefix locations
					int counter1 = 0;

					// check if walkthroughlist size is > 1
					if (walkthroughList.size() >= 1) {
						// set the string where the bug will be detected
						quickFixInformationExposure
								.setReplaceStringOld(walkthroughList.get(index)
										.getNode().getRawSignature().toString());
						quickFixInformationExposure
								.setTheConstraintVarAndValueFromMarker("Quick-Fix Location");

						IASTNode initNode;
						initNode = this.walkthroughList.get(index).getNode();
						// set the Initial bug location file
						setInitialBugFile(initNode.getFileLocation());

						// add bug location refactoring
						bugRefactoring = new Refactoring();
						refactoringsList.add(quickFixInformationExposure
								.createLocalRefactoringObject(bugRefactoring,
										initNode, this.workPool));

						// searching the pre quick fix location node
						// searching backwards on the path
						// while (index > 0
						// && counter1 < NumberOfPreQuick_FixLocations) {
						//
						// // send the node to the StatementVisitor
						// IASTNode foundNode;
						// foundNode = this.walkthroughList.get(index)
						// .getNode();
						// String node=foundNode.getRawSignature();
						// System.out.println(node);
						//
						// if(node.equals("printLine(getenv("+"\"PATH\""+"));")){
						// System.out.print("found");
						// }
						//
						// // check if the current selected path contains the
						// // a pre node were a value flows into our buggy
						// // variable
						// CGNodeVisitorInformationExposure startvisitor = new
						// CGNodeVisitorInformationExposure();
						// foundNode.accept(startvisitor);
						//
						// // set initial file location
						// CGNodeVisitorInformationExposure.setSourceFileLocation(foundNode
						// .getFileLocation());
						//
						// // put a marker, found will be called only for the
						// // binary
						// // statements, for the memcpy we don't search
						// // backwards, because
						// // there
						// // is no quick fix location on the path.
						// // in future for all types of pre quick fix
						// // locations we need a
						// // different visitor class. We need to differentiate
						// // based on
						// // the starting string
						// boolean
						// test=CGNodeVisitorInformationExposure.isFound();
						// if (CGNodeVisitorInformationExposure.isFound() ==
						// true&&
						// node.equals("printLine(getenv("+"\"PATH\""+"));")) {
						//
						// // check on all paths in the program in
						// // execution order if the quick
						// // fix changes the bahavior of the program
						//
						// // foundInfluenciablePath =
						// searchForInfluenciablePathsByTheQuickFixNode(
						// // propagationMap, foundNode);
						//
						// // set up a marker without reporting a problem
						// marker = new CodanMarkerProblemReporter();
						//
						// // set the replaceable label
						// quickFixInformationExposure
						// .setReplaceStringNew(this.walkthroughList
						// .get(index).getNode()
						// .getRawSignature().toString());
						// // set the constraint object
						// quickFixInformationExposure
						// .setOb(this.walkthroughList.get(index)
						// .getConstraintOb());
						//
						// // determine the variable to look for
						// IFile file = this.walkthroughList.get(index)
						// .getFile();
						// int line = this.walkthroughList.get(index)
						// .getStartlifileLocation();
						// IProblemLocation ploc = createProblemLocation(
						// file, line);
						//
						// // report a problem which has the quick fix
						// // attach to it
						//
						// // marker.reportProblem(problemId, ploc,
						// // "Quick-Fix Location",
						// // IMarker.TASK);
						//
						// // create the quick fix refactoring if no (even
						// // one)
						// // influencing path
						// // was found
						// //if (!foundInfluenciablePath) {
						// try {
						// // put the marker in the problems view
						// // IMarker marker2 = file
						// //
						// .createMarker(CodanMarkerProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE);
						// IMarker marker2 = file
						// .createMarker(ICModelMarker.TASK_MARKER);
						// marker2.setAttribute(IMarker.LOCATION,
						// line);
						// marker2.setAttribute(
						// IMarker.LINE_NUMBER, line);
						//
						// marker2.setAttribute(IMarker.MESSAGE,
						// "Quick fix available");
						// marker2.setAttribute(IMarker.PROBLEM,
						// "smtcodan.checkers.mypsproblem3");
						// marker2.setAttribute(
						// IMarker.USER_EDITABLE, true);
						// marker2.setAttribute("d",
						// IMarker.SEVERITY_INFO);
						// ICodanProblemMarker tt = CodanProblemMarker
						// .createCodanProblemMarkerFromResourceMarker(marker2);
						// } catch (CoreException e) {
						// // TODO Auto-generated catch block
						// e.printStackTrace();
						// }
						//
						// StatementLogger
						// .log_quickFixes("The quick-fix is at line: "
						// + this.walkthroughList
						// .get(index)
						// .getStartlifileLocation());
						//
						// // add quick-fix refactoring in the
						// // refactorings list
						// quickFixRefactoring = new Refactoring();
						// refactoringsList.add(quickFixInformationExposure
						// .createPreRefactoringObject(
						// quickFixRefactoring,
						// foundNode, programPathsmap,
						// workPool));
						// // one not in-place quick fix was generated
						// counterNotInPlaceQuickFixes++;
						// //}
						//
						// counter1++;
						// } else {
						//
						// }
						// // going back on the path
						// index--;
						// }
					}
				} else if (((ArrayList<PathObject>) pairs.getValue()).get(i)
						.isStartupNode() == false) {
					// skip the path
				}
			}
		}
		System.out.println(counterNotInPlaceQuickFixes + " "
				+ counterBuggyPaths);
		// remove re-factorings duplicates and concatenate
		removeDuplicatesAndConcatenate();
	}

	public void removeDuplicatesAndConcatenate() {
		System.out
				.println("\n R1: Refactorings list before duplicates removal size: "
						+ RefactoringFinderInformationExposure.refactoringsList
								.size());
		int counter = 0;
		while (counter < RefactoringFinderInformationExposure.refactoringsList
				.size()) {
			counter++;
			// remove duplicates, same replacement string, same line, same
			// file
			// and the same quick fix string
			for (int i = 0; i < RefactoringFinderInformationExposure.refactoringsList
					.size(); i++) {
				for (int j = i + 1; j < RefactoringFinderInformationExposure.refactoringsList
						.size(); j++) {

					// replacement string is the same, the string where the
					// bug
					// was found
					if (RefactoringFinderInformationExposure.refactoringsList
							.get(i)
							.getReplaceStatementNode()
							.getRawSignature()
							.toString()
							.equals(RefactoringFinderInformationExposure.refactoringsList
									.get(j).getReplaceStatementNode()
									.getRawSignature().toString())
							// line number is the same
							&& RefactoringFinderInformationExposure.refactoringsList
									.get(i).getLineNumber() == RefactoringFinderInformationExposure.refactoringsList
									.get(j).getLineNumber()
							// file name is the same
							&& RefactoringFinderInformationExposure.refactoringsList
									.get(i)
									.getSourceFileName()
									.toString()
									.equals(RefactoringFinderInformationExposure.refactoringsList
											.get(j).getSourceFileName()
											.toString())
							// the quick-fix string is the same
							&& RefactoringFinderInformationExposure.refactoringsList
									.get(i)
									.getQuickFixString()
									.toString()
									.equals(RefactoringFinderInformationExposure.refactoringsList
											.get(j).getQuickFixString()
											.toString())) {

						// remove the duplicate
						RefactoringFinderInformationExposure.refactoringsList
								.remove(i);
					}
				}
			}
			System.out
					.println("\n R2: Refactorings list after duplicates removal size: "
							+ RefactoringFinderInformationExposure.refactoringsList
									.size());
		}

		// concatenate quick-fixes that affect the same line in the same file
		for (int i = 0; i < RefactoringFinderInformationExposure.refactoringsList
				.size(); i++) {
			for (int j = i + 1; j < RefactoringFinderInformationExposure.refactoringsList
					.size(); j++) {

				// replacement string is not the same
				if (RefactoringFinderInformationExposure.refactoringsList
						.get(i)
						.getReplaceStatementNode()
						.getRawSignature()
						.toString()
						.equals(RefactoringFinderInformationExposure.refactoringsList
								.get(j).getReplaceStatementNode()
								.getRawSignature().toString())
						// line number is the same
						&& RefactoringFinderInformationExposure.refactoringsList
								.get(i).getLineNumber() == RefactoringFinderInformationExposure.refactoringsList
								.get(j).getLineNumber()
						// file name is the same
						&& RefactoringFinderInformationExposure.refactoringsList
								.get(i)
								.getSourceFileName()
								.toString()
								.equals(RefactoringFinderInformationExposure.refactoringsList
										.get(j).getSourceFileName().toString())

						// quick string is different
						&& (!RefactoringFinderInformationExposure.refactoringsList
								.get(i)
								.getQuickFixString()
								.equals(RefactoringFinderInformationExposure.refactoringsList
										.get(j).getQuickFixString().toString()))) {

					// put the re-factoring string into one object
					RefactoringFinderInformationExposure.refactoringsList
							.get(i)
							.setQuickFixString(
									RefactoringFinderInformationExposure.refactoringsList
											.get(i).getQuickFixString()
											+ "\n"
											+ RefactoringFinderInformationExposure.refactoringsList
													.get(j).getQuickFixString());

					// remove the duplicate
					RefactoringFinderInformationExposure.refactoringsList
							.remove(j);
				}
				// replacement string if it is the same
				if (RefactoringFinderInformationExposure.refactoringsList
						.get(i)
						.getReplaceStatementNode()
						.getRawSignature()
						.toString()
						.equals(RefactoringFinderInformationExposure.refactoringsList
								.get(j).getReplaceStatementNode()
								.getRawSignature().toString())
						// line number is the same
						&& RefactoringFinderInformationExposure.refactoringsList
								.get(i).getLineNumber() == RefactoringFinderInformationExposure.refactoringsList
								.get(j).getLineNumber()
						// file name is the same
						&& RefactoringFinderInformationExposure.refactoringsList
								.get(i)
								.getSourceFileName()
								.toString()
								.equals(RefactoringFinderInformationExposure.refactoringsList
										.get(j).getSourceFileName().toString())

						// quick string is different
						&& (RefactoringFinderInformationExposure.refactoringsList
								.get(i).getQuickFixString()
								.equals(RefactoringFinderInformationExposure.refactoringsList
										.get(j).getQuickFixString().toString()))) {

					// do not concatenate strings, just remove the duplicate
					// object
					// remove the duplicate
					RefactoringFinderInformationExposure.refactoringsList
							.remove(j);
				}
			}
		}
		System.out.println("\n Refactorings list size after merging: "
				+ RefactoringFinderInformationExposure.refactoringsList.size());
	}

	public void runQuickFixSearchingAlgorithm(IASTNode in,
			QuickFixInformationExposure quickFixInformationExposure) {

		// TODO Auto-generated method stub

		// set the replaceable label
		quickFixInformationExposure.setReplaceStringNew(in.getRawSignature()
				.toString());
		// set the cons obj
		// quickFixInformationExposure.setOb(in.getConstraintOb());
		// set the constrain var and value
		quickFixInformationExposure
				.setTheConstraintVarAndValueFromMarker(AssertInformationExposure.INFORMATION_EXPOSURE_QUICK_FIX_MESSAGE);
		// set the string where the bug will be detected
		quickFixInformationExposure.setReplaceStringOld(in.getRawSignature()
				.toString());
		quickFixInformationExposure
				.setTheConstraintVarAndValueFromMarker("Quick-Fix Location");
		// set the Initial bug location file
		setInitialBugFile(in.getFileLocation());

		// add bug location refactoring
		bugRefactoring = new Refactoring();
		refactoringsList.add(quickFixInformationExposure
				.createLocalRefactoringObject1(bugRefactoring, in,
						this.workPool));

	}
}
