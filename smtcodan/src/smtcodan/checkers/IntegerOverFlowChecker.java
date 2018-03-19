package smtcodan.checkers;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;
import org.eclipse.core.resources.IFile;

import smtcodan.Config;
import smtcodan.IIntegerOverflowObserver;
import smtcodan.ImpVarName;
import smtcodan.PathExplorer;
import smtcodan.Solver;
import smtcodan.interpreter.Interpreter;
import smtcodan.quickfixes.SMTConstraintObject;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class IntegerOverFlowChecker.
 */
public class IntegerOverFlowChecker implements IIntegerOverflowObserver {

	/** The ps. */
	Interpreter ps;
	Solver sv;

	/** The pe. */
	PathExplorer pe;

	/** The char max. */
	private String CHAR_MAX = "CHAR_MAX";

	/** The char max. */
	private String INT_MAX = "INT_MAX";

	/** The char max. */
	private String LLONG_MAX = "LLONG_MAX";

	/** The char max. */
	private String SHRT_MAX = "SHRT_MAX";

	/** The uint max. */
	private String UINT_MAX = "UINT_MAX";

	/** The problemid. */
	public static String problemid = "smtcodan.checkers.mypsproblem";

	/** The problem message lower. */
	public static String integerOverflowCheckerMessage = "Integer Overflow Error Detected";

	/**
	 * Instantiates a new integer over flow checker.
	 * 
	 * @param ps
	 *            the ps
	 * @param sv
	 *            the sv
	 * @param pe
	 *            the symbolic execution engine
	 */

	public IntegerOverFlowChecker(Interpreter ps, Solver sv, PathExplorer pe) {
		this.ps = ps;
		this.sv = sv;
		this.pe = pe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.IIntegerOverFlowObserver#updateLimitChecker(smtcodan.symvars
	 * .SymVarSSA, smtcodan.symvars.SymVarSSA, java.lang.String,
	 * org.eclipse.core.resources.IFile,
	 * org.eclipse.cdt.core.dom.ast.IASTFileLocation)
	 */
	@Override
	public void updateLimitChecker(SymVarSSA symVarSSA, IFile file,
			IASTFileLocation loc, IASTInitializer initializer) {

		System.out.println("updateLimitChecker symVarSSA.getSSAName(): "
				+ symVarSSA.getSSAName());

		System.out.println("updateLimitChecker symVarSSA.getOrigName(): "
				+ symVarSSA.getOrigName().toString());

		System.out.println("updateLimitChecker symVarSSA.getOrig(): "
				+ symVarSSA.getOrig().toString());

		ArrayList<IName> varSlice = new ArrayList<IName>();
		// create an SymArraySSA object from the SymPointerSSA access object
		// create an SymIntSSA object from the previously defined arrayTarget
		// object
		// add to the varSlice list the original name of the acces object
		varSlice.add(symVarSSA.getOrigName());
		// add to the varSlice list the original name of the acces object
		// get the offset as an string from the acces object
		// create an newline string object
		String newline = System.getProperty("line.separator");
		// get the Equation Slice Definitions from the ps for the
		// varSlice list
		String sliceDefs = "";
		String sliceEqs = "";
		if (varSlice != null) {
			sliceDefs = ps.getEQSDefs(varSlice);
			// get the Equation Slice from the ps for the varSlice list
			sliceEqs = ps.getEQS(varSlice);
		}

		// path deps: finer slicing possible...
		String pathDefs = ps.getPathDecDefs();
		String pathEqs = ps.getPathDecEQS();
		// (join defs:) TODO: avoid doubles directly
		// create a strings from the pathDefs and the sliceDefs
		StringBuffer jointDefs = new StringBuffer(pathDefs);

		StringTokenizer stokens = new StringTokenizer(sliceDefs, "\n");

		while (stokens.hasMoreTokens()) {
			String line = stokens.nextToken();
			if (!(jointDefs.toString().contains(line))) {
				jointDefs.append(line + "\n");
			}
		}

		// join slices:
		StringBuffer jointEqs = new StringBuffer(pathEqs);

		stokens = new StringTokenizer(sliceEqs, "\n");
		while (stokens.hasMoreTokens()) {
			String line = stokens.nextToken();
			if (!(jointEqs.toString().contains(line))) {
				jointEqs.append(line + "\n");
			}
		}

		// set the logic which should be used by the sv
		String logicDef = "(set-logic AUFNIRA)" + newline;
		// create the check-sat command as an string
		String checkSatExit = "(check-sat)" + newline + "(exit)" + newline;
		// merge the SMT-libs for the lower bound verification string

		String statementOriginal = null;

		String originalConstraint = null;
		String negatedConstraint = null;
		String statementNegated = null;

		// this is the left hand side of the assignment
		// usually this value will will produce the integer overflow
		String leftHandSide = symVarSSA.getSSAName();
		if (symVarSSA.getESymType() == eSymType.SymArray) {
			// get from the array at a certain index the variable
			// how do I know that the init value is at this index? To Do
			// the same arrayIndex used in the IASTInitializer leave method
			int arrayIndex = 0;
			IName spname = new ImpVarName();
			SymPointerOrig spo = new SymPointerOrig(spname);
			SymPointerSSA sps = (SymPointerSSA) ps.declareLocal(
					spo.getSymType(), null);
			// symVarSSA.addDependency(sps);
			String formula1 = new String(" \n(declare-fun " + sps.getSSAName()
					+ "() Int) \n");
			String formula2 = new String("(assert (= ( select "
					+ symVarSSA.getSSAName() + " " + arrayIndex + ") "
					+ sps.getSSAName() + ")) \n");
			statementOriginal = statementOriginal + formula1.toString()
					+ formula2.toString();

			// can the variable take values bigger than maximum allowed value?
			originalConstraint = "(assert (>  " + sps.getSSAName() + "  "
					+ ps.getCurrentLimit() + " ) ) " + newline;

			// here we assert that the value of the variable is less than the
			// maximum allowed value for this context. If now the solver replies
			// unsat that means that due to this constraint the variable can not
			// take values greater than the maximum allowed value,
			// ps.getCurrentLimit()
			negatedConstraint = "(assert (<  " + sps.getSSAName() + "  "
					+ ps.getCurrentLimit() + " ) ) " + newline;

			// the negated statement is initially equal to the actual
			// statementOriginal
			statementNegated = statementOriginal;

			// we add to the statementOriginal the originalConstraint
			statementOriginal = statementOriginal + originalConstraint;

			// we add to the statementNegated the nagatedConstraint and the
			// originalConstraint. We constrain the maximum allowed value and
			// afterwards
			// check in the whole statementNegated if the variable is allowed to
			// still take
			// greater value than the maximum allowed.
			statementNegated = statementNegated + negatedConstraint
					+ originalConstraint;

		} else {
			statementOriginal = "(assert (>  " + leftHandSide + "  "
					+ ps.getCurrentLimit() + " ) ) " + newline;
			// System.err.println("original system: " + statementOriginal);

			statementNegated = "(assert (<  " + leftHandSide + "  "
					+ ps.getCurrentLimit() + " ) ) " + newline;
			// System.err.println("negated system: " + statementNegated);
		}

		String smtLibStatementOriginal = logicDef + // definitions of the used
													// SMT logic
				jointDefs + // path constraint definitions
				jointEqs + // path constraint equations
				statementOriginal + // we add the original statement from above
				checkSatExit; // exit condition added to the SMT system

		String smtLibStatementNegated = logicDef + // definitions of the used
													// SMT logic
				jointDefs + // path constraint definitions
				jointEqs + // path constraint equations
				statementNegated + // we add the negated statement
				statementOriginal + // we add the original statement
				// notice that the tow constraints from above contradict each
				// other as result we should get an unsat reply from the solver
				// for the smtLibStatementNegated.
				checkSatExit; // exit condition added to the SMT system

		boolean foundError = false;
		String problemMessage = null;
		String problemDescription = null;

		String reply = sv.queryReply(smtLibStatementOriginal).toString();

		// this means the solver replied sat. This means there is a solution to
		// the linear system. This means there could be an integer overflow.
		if (!reply.contains("unsat")) {
			if (!Config.disableDebugMode) {
				System.out.println("sat at line: "
						+ loc.getStartingLineNumber() + "\n"
						+ smtLibStatementOriginal);
			}

			problemMessage = new String(integerOverflowCheckerMessage);

			problemDescription = new String(" trace: " + newline
					+ ps.getTrace() + newline + " verification condition: "
					+ newline + smtLibStatementOriginal + reply + newline);
			foundError = true;
		} else {
			if (!reply.contains("unsat")) {
				System.out.println("unsat at line: \n"
						+ loc.getStartingLineNumber() + "\n"
						+ smtLibStatementOriginal);
			}

			// everything is fine, there is no integer overflow
			System.out.println("no integer overflow bug found: ");
		}

		// there is an integer overflow bug.s
		if (foundError) {
			// the bug was found, now check if the negatedStatement replies
			// unsat. The negatedStatement should reply unsat.
			String replyNegated = sv.queryReply(smtLibStatementNegated)
					.toString();

			if (replyNegated.contains("unsat")) {
				// it should no longer be possible that the left hand side value
				// overflows. In this case we know how the quick fix should
				// look like. We basically have to constrain the left hand side
				// variable such that the value is less than the max allowed
				// value for this context
				System.out.println("test me: " + "\n limit: "
						+ ps.getCurrentLimit() + "\n value original name: "
						+ symVarSSA.getOrigName().toString()
						+ " \n declarator: " + initializer.getRawSignature());

				// report the integer overflow bug
				int startline = loc.getStartingLineNumber();
				pe.reportProblem(problemid, file, startline, problemMessage,
						problemDescription, new SMTConstraintObject(initializer
								.getRawSignature().toString(),
								"no smt system pased", ps.getCurrentLimit()),
						ps.getNvlist());
			} else {
				// report the integer overflow in this case too
				int startline = loc.getStartingLineNumber();
				pe.reportProblem(problemid, file, startline, problemMessage,
						problemDescription, new SMTConstraintObject(initializer
								.getRawSignature().toString(),
								"no smt system pased", ps.getCurrentLimit()),
						ps.getNvlist());
			}
		}
	}
}
