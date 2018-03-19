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

import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.core.resources.IFile;

import smtcodan.Config;
import smtcodan.IMissingCryptoStepObserver;
import smtcodan.PathExplorer;
import smtcodan.Solver;
import smtcodan.interpreter.Interpreter;
import smtcodan.parser.AnnotationExecution;
import smtcodan.parser.Comment;
import smtcodan.parser.FunctionComment;
import smtcodan.quickfixes.SMTConstraintObject;

// TODO: Auto-generated Javadoc
/**
 * The Class InformationExposureChecker.
 */
public class MissingRequiredCryptoStepChecker implements
		IMissingCryptoStepObserver {

	/** The ps. */
	Interpreter ps;

	/** The sv. */
	Solver sv;

	/** The see. */
	PathExplorer pe;

	/** The found error. */
	boolean foundError = false;

	final static String f_call_attribute = "sink";
	static String problemMessage = "Mising Crypto Step Bug Detected";
	static String problemDescription = "See CWE-325 for Description";

	/** The problemid. */
	public static String problemid = "smtcodan.checkers.mypsproblem";

	private static HashMap<String, Comment> commentsMap;
	// only this function calls need to be taken into acount
	// due to annotations we can not distinguish between other
	// annotated function calls
	final ArrayList<String> callsToTakeIntoAccount = new ArrayList<String>() {
		{
			add("void _CryptAcquireContext();");
			add("void _CryptCreateHash();");
			add("void _CryptHashData();");
			add("void _CryptDeriveKey();");
			add("void _CryptEncrypt();");
		}
	};

	String postCall;
	boolean condition = true;
	String lastCall = null;

	/**
	 * Instantiates a new cW e526 checker b.
	 * 
	 * @param ps
	 *            the ps
	 * @param sv
	 *            the sv
	 * @param see
	 *            the see
	 */
	public MissingRequiredCryptoStepChecker(Interpreter ps, Solver sv,
			PathExplorer pe) {
		this.ps = ps;
		this.sv = sv;
		this.pe = pe;
	}

	@Override
	public void updateChecker(String call, IFile file, IASTFileLocation loc) {
		// the checker requires the parser to be on
		commentsMap = AnnotationExecution.getCommentsMap();
		if (commentsMap != null && Config.shouldRunParser()) {
			Comment comment = commentsMap.get("void " + call);
			boolean isSink = false;
			if (comment != null) {
				ArrayList<FunctionComment> sink = comment.getFunctionComments();
				// check that the call is a sink
				for (int i = 0; i < sink.size(); i++) {
					FunctionComment fc = sink.get(i);
					if (fc.getAtribute() != null)
						if (fc.getAtribute().equals(f_call_attribute)) {
							isSink = true;
						}
				}
			}
			// check the condition the triggering condition
			if (postCall != null && lastCall != null && comment != null
					&& isSink
					&& (callsToTakeIntoAccount.contains("void " + call))) {
				postCall = postCall + "();";
				if (commentsMap.get("void " + postCall) != null) {
					if (!postCall.equals(call) && !lastCall.equals(call)) {
						condition = false;
					} else {
						condition = true;
					}
				}

			}
			// trigger the bug
			if (!condition) {
				condition = true;
				problemMessage = new String(problemMessage);
				problemDescription = new String(problemDescription);

				int startline = loc.getStartingLineNumber();
				pe.reportProblem(problemid, file, startline - 1,
						problemMessage, problemDescription,
						new SMTConstraintObject(null, null, null),
						ps.getNvlist());
				pe.bugDetected(problemid, file, loc, problemMessage,
						problemDescription, ps.getNvlist());
			}
			// save the call for next run
			if (comment != null) {
				ArrayList<FunctionComment> function_comments = comment
						.getFunctionComments();

				for (int i = 0; i < function_comments.size(); i++) {
					FunctionComment fc = function_comments.get(i);
					if (fc.getPostStep() != null) {
						postCall = fc.getPostStep();
					}
				}
				lastCall = call;
			} else {

			}
		}
	}
}
