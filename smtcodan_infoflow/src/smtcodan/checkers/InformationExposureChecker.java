/**
   [Class description.  The class represents a checker that looks for information exposure through environmental variables bugs.
   It extends the IInfoFlowObserver class ]
   
   [Other notes,  CWE-526: Information Exposure Through Environmental Variables,
    Environmental variables may contain sensitive information about a remote server]
   
   @author Paul Muntean
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.checkers;

import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.core.resources.IFile;

import smtcodan.IInformationFlowObserver;
import smtcodan.PathExplorer;
import smtcodan.Solver;
import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymArrayOrig;
import smtcodan.symvars.SymVarSSA;

// TODO: Auto-generated Javadoc
/**
 * The Class InformationExposureChecker.
 */
public class InformationExposureChecker implements IInformationFlowObserver {

	/** The ps. */
	Interpreter ps;

	/** The sv. */
	Solver sv;

	/** The see. */
	PathExplorer pe;

	/** The found error. */
	boolean foundError = false;

	/** The problemid. */
	public static String problemid = "smtcodan.checkers.mypsproblem";

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
	public InformationExposureChecker(Interpreter ps, Solver sv, PathExplorer pe) {
		this.ps = ps;
		this.sv = sv;
		this.pe = pe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.IInfoFlowObserver#updateChecker(smtcodan.symvars.SymVarSSA,
	 * org.eclipse.core.resources.IFile,
	 * org.eclipse.cdt.core.dom.ast.IASTFileLocation)
	 */
	public void updateChecker(SymVarSSA access, IFile file, IASTFileLocation loc) {

		if (access.isConfidential()) {
			String problemMessage = null;
			String problemDescription = null;
			problemMessage = new String("Information Exposure Bug Detected");
			problemDescription = new String("See CWE-200 for Description");

			int startline = loc.getStartingLineNumber();
			pe.reportProblem(problemid, file, startline, problemMessage,
					problemDescription);
			pe.bugDetected(problemid, file, loc, problemMessage,
					problemDescription);
		}
	}

	@Override
	public void updateChecker(SymArrayOrig access, IFile file,
			IASTFileLocation loc) {
		if (access.isConfidential()) {
			String problemMessage = null;
			String problemDescription = null;
			problemMessage = new String("Information Exposure Bug Detected");
			problemDescription = new String("See CWE-200 for Description");

			int startline = loc.getStartingLineNumber();
			pe.reportProblem(problemid, file, startline, problemMessage,
					problemDescription);
			pe.bugDetected(problemid, file, loc, problemMessage,
					problemDescription);
		}
	}

}
