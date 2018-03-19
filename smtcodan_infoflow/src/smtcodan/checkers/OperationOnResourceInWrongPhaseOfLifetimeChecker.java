/**
   [Class description.  The class represents a checker that looks for information exposure through environmental variables bugs.
   It extends the IInfoFlowObserver class ]
   
   [Other notes,  CWE-526: Information Exposure Through Environmental Variables,
    Environmental variables may contain sensitive information about a remote server]
   
   @author Paul Muntean
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.checkers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.core.resources.IFile;

import smtcodan.IMissingCryptoStepObserver;
import smtcodan.PathExplorer;
import smtcodan.Solver;
import smtcodan.interpreter.Interpreter;

// TODO: Auto-generated Javadoc
/**
 * The Class InformationExposureChecker.
 */
public class OperationOnResourceInWrongPhaseOfLifetimeChecker implements
		IMissingCryptoStepObserver {

	/** The ps. */
	Interpreter ps;

	/** The sv. */
	Solver sv;

	/** The see. */
	PathExplorer pe;

	/** The found error. */
	boolean foundError = false;

	/** The Constant f_call_attribute. */
	final static String f_call_attribute = "sink";

	/** The problem message. */
	static String problemMessage = "Operation On Resource In Wrong Phase Of Lifetime";

	/** The problem description. */
	static String problemDescription = "See CWE-666 for Description";

	/** The problemid. */
	public static String problemid = "smtcodan.checkers.mypsproblem";

	/** The condition. */
	boolean condition = true;

	/** The function_calls_list. */
	static ArrayList<String> function_calls_list;

	/** The files_list. */
	static ArrayList<IFile> files_list;

	/** The locations_list. */
	static ArrayList<IASTFileLocation> locations_list;

	/** The buggy index. */
	int buggyIndex;

	// the tracked function calls are added twice since they appear always twice
	// on a path due to how the CFG path was constructed
	// the list of interest function calls has to be given since based only on
	// the annotation it is not possible to differentiate between other function
	// calls that may be annotated but are not of interest for this checker
	/** The Constant myMap. */
	private static final Map<Integer, String> myMap = new HashMap<Integer, String>();
	static {
		myMap.put(0, "void _bind();");
		myMap.put(1, "void _bind();");
		myMap.put(2, "void _listen();");
		myMap.put(3, "void _listen();");
		myMap.put(4, "void _accept();");
		myMap.put(5, "void _accept();");
	}

	/**
	 * Instantiates a new cW e526 checker b.
	 * 
	 * @param ps
	 *            the ps
	 * @param sv
	 *            the sv
	 * @param pe
	 *            the pe
	 */
	public OperationOnResourceInWrongPhaseOfLifetimeChecker(Interpreter ps,
			Solver sv, PathExplorer pe) {
		this.ps = ps;
		this.sv = sv;
		this.pe = pe;
		this.function_calls_list = new ArrayList<String>();
		this.files_list = new ArrayList<IFile>();
		this.locations_list = new ArrayList<IASTFileLocation>();
	}

	/**
	 * Check list.
	 * 
	 * @param list
	 *            the list
	 * @return true, if successful
	 */
	private boolean checkList(ArrayList<String> list) {
		// check the first 6 list elements
		// these represent the last 6 function calls
		for (int i = 0; i < myMap.size(); i++) {
			if (!((String) myMap.get(i)).equals(list.get(i))) {
				buggyIndex = i;
				return false;
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.IMissingCryptoStepObserver#updateChecker(java.lang.String,
	 * org.eclipse.core.resources.IFile,
	 * org.eclipse.cdt.core.dom.ast.IASTFileLocation)
	 */
	@Override
	public void updateChecker(String call, IFile file, IASTFileLocation loc) {

		String internalCall = "void " + call + "";
		boolean found = false;
		for (int j = 0; j < myMap.size(); j++) {
			if (myMap.containsKey(j) && !found) {
				String f_call = (String) myMap.get(j);
				if (f_call.equals(internalCall)) {
					function_calls_list.add(f_call);
					files_list.add(file);
					locations_list.add(loc);
					found = true;
				}
			}
		}

		// check if f call was found
		if (function_calls_list.size() % myMap.size() == 0 && found) {
			condition = checkList(function_calls_list);
			function_calls_list.clear();
			if (condition) {
				files_list.clear();
				locations_list.clear();
			}
		}

		// trigger the bug
		if (!condition) {
			condition = true;
			problemMessage = new String(problemMessage);
			problemDescription = new String(problemDescription);

			int startline = locations_list.get(buggyIndex)
					.getStartingLineNumber();
			pe.reportProblem(problemid, files_list.get(buggyIndex), startline,
					problemMessage, problemDescription);
			pe.bugDetected(problemid, files_list.get(buggyIndex),
					locations_list.get(buggyIndex), problemMessage,
					problemDescription);

			// clear the lists
			files_list.clear();
			locations_list.clear();
		}
	}

}
