package smtcodan.quickfixes.race.condition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.cdt.codan.core.model.AbstractChecker;
import org.eclipse.cdt.codan.internal.core.model.CodanMarkerProblemReporter;
import org.eclipse.cdt.codan.internal.ui.CodanProblemMarkerResolutionGenerator;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.OperationCanceledException;

import smtcodan.logger.StatementLogger;
import smtcodan.quickfixes.InfluenciableNodeVisitor;
import smtcodan.quickfixes.PathObject;
import smtcodan.quickfixes.Refactoring;
import smtcodan.quickfixes.SMTConstraintObject;

// TODO: Auto-generated Javadoc
/* FrameDemo.java requires no other files. */
/**
 * The Class Propagation.
 */
public class RefactoringFinderRaceCondition extends AbstractChecker implements
		ActionListener {

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

	/** The quick fix race condition */
	public QuickFixRaceCondition quickFixRaceCondition;

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

	public static PathObject thread_declaration_node;

	// a thread declaration contains this components
	// e.g. std_thread thread_a = NULL;
	String threadDeclarationContains1 = "std_thread";
	String threadDeclarationContains2 = "NULL;";

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
	public RefactoringFinderRaceCondition(final Map propagationMap,
			String problemId, ArrayList<Refactoring> refactorings) {
		// TODO Auto-generated constructor stub
		// the refactoring list
		this.refactoringsList = refactorings;
		// problem id
		this.problemId = problemId;

		// this.start_line1 =start_line;
		this.quickFixRaceCondition = new QuickFixRaceCondition();
		// report the bug label
		// set the replaceable label
		quickFixRaceCondition
				.setReplaceStringOld(getTheLabelWhereTheBugWasFound(propagationMap));
		// set the constaint object
		quickFixRaceCondition.setOb(getConstraintObject(propagationMap));
		// walkthroughList
		walkthroughList = new ArrayList<PathObject>();
		// set the erase quick fix markers to false, originally the check box is
		// not checked
		eraseQuickFixMarker = false;
		// erase previous nodes set to false, originally the check box is not
		// checked
		erasePreviousNodes = false;

		// javax.swing.SwingUtilities.invokeLater(new Runnable() {
		// public void run() {
		// // create the gui, window presentation can be switched on or off
		// if (Config.showQuickFixWindow)
		// createAndShowGUI(propagationMap);
		// }
		// });
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
		RefactoringFinderRaceCondition.initialBugFile = initialBugFile;
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
		Iterator it = nodesmap.entrySet().iterator();
		boolean hasQuickFixNode = false;
		boolean hasStartUpNode = false;
		boolean influencedNode = false;
		ArrayList<PathObject> nodesList = null;
		int quickFixNodeIndex = 0;
		int startUpNodeNodeIndex = 0;
		while (it.hasNext()) {
			hasQuickFixNode = false;
			hasStartUpNode = false;
			influencedNode = false;
			quickFixNodeIndex = 0;
			startUpNodeNodeIndex = 0;

			Map.Entry pairs = (Map.Entry) it.next();
			nodesList = ((ArrayList<PathObject>) pairs.getValue());
			// here we flag the possible starting nodes
			for (int i = 0; i < nodesList.size(); i++) {
				// check if the path contains the quick fix node which we want
				// to fix
				if (nodesList.get(i).getNode().equals(quickFixNode)) {
					quickFixNodeIndex = i;
					hasQuickFixNode = true;

				}

				// check if the path contains the start up node where we found
				// the bug
				if (nodesList.get(i).isStartupNode()) {
					startUpNodeNodeIndex = i;
					hasStartUpNode = true;
				}
			}

			// remove the not influenciable paths (do not contain the quick fix
			// node)
			if ((!hasQuickFixNode)) {
				// it.remove();
			}

		}

		boolean influencingNode2 = false;
		countInfluenciablePaths = 0;
		// check if there is still a path remaining
		if (nodesmap.size() > 0) {
			Iterator itx = nodesmap.entrySet().iterator();

			while (itx.hasNext() && !influencingNode2) {
				Map.Entry pairs = (Map.Entry) itx.next();
				ArrayList<PathObject> nodesList2 = ((ArrayList<PathObject>) pairs
						.getValue());

				// check if the nodes on the path could be influenced by our by
				// the
				// buggy variable

				boolean influencingNode = false;
				for (int i2 = quickFixNodeIndex; i2 < nodesList2.size(); i2++) {
					if (nodesList2.get(i2).getNode().equals(quickFixNode)) {

						influencingNode = true;
					}

					// start search from the influencing node down the path
					if (influencingNode) {

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
	 * @param quickFixRaceCondition
	 *            the quick fix bounds
	 */
	public void runQuickFixSearchingAlgorithm(Map propagationMap,
			QuickFixRaceCondition quickFixRaceCondition) {
		// clean the list, this makes the list holding any time
		// only two
		// elements
		// refactoringsList.clear();
		// get the start index (this is the index in the walk through list where
		// the bug was detected)
		// and the first buggy path in the walkthroughList
		Boolean found = false;
		System.out.println("paths size: " + propagationMap.size());
		Iterator it3 = propagationMap.entrySet().iterator();
		while (it3.hasNext() && found == false) {
			Map.Entry pairs = (Map.Entry) it3.next();
			System.out.print(pairs.getValue());
			for (int i = 0; i < ((ArrayList<PathObject>) pairs.getValue())
					.size(); i++) {
				// set the walkthroughList to be the first buggy path
				if (((ArrayList<PathObject>) pairs.getValue()).get(i)
						.isStartupNode()) {
					System.out.println("\n start up node "
							+ ((ArrayList<PathObject>) pairs.getValue()).get(i)
									.getNode().getRawSignature().toString());
					System.out.println("start up node line number "
							+ ((ArrayList<PathObject>) pairs.getValue()).get(i)
									.getStartlifileLocation());
					// set the replaceable label
					found = true;
					quickFixRaceCondition
							.setReplaceStringNew(((ArrayList<PathObject>) pairs
									.getValue()).get(i).getNode()
									.getRawSignature().toString());
					// set the cons obj
					quickFixRaceCondition.setOb(((ArrayList<PathObject>) pairs
							.getValue()).get(i).getConstraintOb());
					// set the constrain var and value
					quickFixRaceCondition
							.setTheConstraintVarAndValueFromMarker(AssertRaceCondition.RACE_CONDITION_QUICK_FIX_MESSAGE);
					walkthroughList = (ArrayList<PathObject>) pairs.getValue();
					startingIndex = i;
					walkthroughListSize = ((ArrayList<PathObject>) pairs
							.getValue()).size();

					int index = startingIndex;
					boolean foundInfluenciablePath = false;

					StatementLogger.log_quickFixes("start index: "
							+ startingIndex);
					// how many previous quick fix locations should it find

					// check if walkthroughlist size ==1
					if (walkthroughList.size() >= 1) {
						// set the string where the bug will be detected
						quickFixRaceCondition
								.setReplaceStringOld(walkthroughList.get(index)
										.getNode().getRawSignature().toString());
						quickFixRaceCondition
								.setTheConstraintVarAndValueFromMarker("Quick-Fix Location");

						IASTNode initNode;
						initNode = this.walkthroughList.get(index).getNode();
						// set the Initial bug location file
						setInitialBugFile(initNode.getFileLocation());

						// find the thread declaration node
						// after this node the thread lock will be created
						boolean found2 = false;
						for (int j = i; j >= 0; j--) {
							System.out
									.println("\n node index "
											+ j
											+ " "
											+ ((ArrayList<PathObject>) pairs
													.getValue()).get(j)
													.getNode()
													.getRawSignature()
													.toString());
							if (((ArrayList<PathObject>) pairs.getValue())
									.get(j).getNode().getRawSignature()
									.toString()
									.contains(threadDeclarationContains1)
									&& ((ArrayList<PathObject>) pairs
											.getValue())
											.get(j)
											.getNode()
											.getRawSignature()
											.toString()
											.contains(
													threadDeclarationContains2)
									&& !found2) {

								thread_declaration_node = walkthroughList
										.get(j);
								found2 = true;

							}

						}
						// add bug location refactoring
						bugRefactoring = new Refactoring();
						refactoringsList.add(quickFixRaceCondition
								.createLocalRefactoringObject(bugRefactoring,
										initNode));
						System.out.println(refactoringsList);
						return;
					}
				}

			}
		}
	}
}
