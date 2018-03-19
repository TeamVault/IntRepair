package smtcodan.quickfixes.integer.overflow;

import java.math.BigInteger;
import java.util.StringTokenizer;

import org.eclipse.cdt.core.dom.ast.IASTNode;

import smtcodan.Solver;
import smtcodan.WorkPool;
import smtcodan.interpreter.Interpreter;
import smtcodan.logger.StatementLogger;
import smtcodan.quickfixes.IAssertLogicOperation;
import smtcodan.quickfixes.SMTConstraintObject;

// TODO: Auto-generated Javadoc
/**
 * The Class AssertBufferOverflow.
 */
public class AssertIntegerOverflow implements IAssertLogicOperation {

	/** The sv. */
	private static Solver sv;

	private static Interpreter ps;

	/** The buggy variable. */
	public static String buggyVariable;

	/** The buffer overflow quick fix message. */
	public static String INTEGER_OVERFLOW_QUICK_FIX_MESSAGE = "Quick-Fix Location";

	/** The buffer overflow bug location message. */
	public static String INTEGER_OVERFLOW_BUG_LOCATION_MESSAGE = "Integer Overflow Error Detected";

	/** The constraint value. */
	public static String constraintValue;

	public static boolean notFound = false;

	/**
	 * Gets the buggy variable.
	 * 
	 * @return the buggy variable
	 */

	public static String getBuggyVariable() {
		return buggyVariable;
	}

	/**
	 * Sets the buggy variable.
	 * 
	 * @param buggyVariable
	 *            the new buggy variable
	 */
	public void setBuggyVariable(String buggyVariable) {
		AssertIntegerOverflow.buggyVariable = buggyVariable;
	}

	/**
	 * Gets the constraint value.
	 * 
	 * @return
	 * 
	 * @return the constraint value
	 */

	public static String getConstraintValue(WorkPool workPool, boolean nf,
			IASTNode node) {
		return "blaq";
	}

	/**
	 * Sets the constraint value.
	 * 
	 * @param constraintValue
	 *            the new constraint value
	 */
	public void setConstraintValue(String constraintValue) {
		AssertIntegerOverflow.constraintValue = constraintValue;
	}

	public static String getIntegerOverflowQuickFixString(String x, String y) {
		return "if ( " + x + " = " + y + ")";
	}

	public static String getIntegerOverflowQuickFixString(WorkPool workPool,
			IASTNode node) {

		String[] fileNameSplits = node.getContainingFilename().split("/");
		String fileName = fileNameSplits[fileNameSplits.length - 1];

		// Unique ID Stub
		int startID = 73455;

		String template = "if ("
				+ QuickFixIntegerOverflow.ob.getBufferSize().toString()
						.replace("= ", "")
				+ " > "
				+ QuickFixIntegerOverflow.ob.getOffset().toString()
				+ " || "
				+ QuickFixIntegerOverflow.ob.getBufferSize().toString()
						.replace("=", "") + " < " + "-"
				+ QuickFixIntegerOverflow.ob.getOffset().toString() + ") "
				+ "\n" + "\t" + "\t" + "\t" + "exit(EXIT_FAILURE);"
				+ "//terminate program execution \n" + "\n";

		// select the suited repair pattern
		String statement = QuickFixIntegerOverflow.ob.getBufferSize()
				.toString().replace("= ", "");

		String[] result = statement.split("\\s");

		// assume there are exactly three tokens inside this string after we
		// removed the equals sign
		String leftHandSide = null;
		String operator = null;
		String rightHandSide = null;

		if (result.length == 3) {
			leftHandSide = result[0];
			operator = result[1];
			rightHandSide = result[2];
			System.out.println(":" + leftHandSide + ":" + operator + ":"
					+ rightHandSide);
		}

		// start to destinguish between the three cases
		// case1 1: e.g., data + 1;
		if (leftHandSide != null && rightHandSide != null
				&& !leftHandSide.equals(rightHandSide) && operator.equals("+")) {
			// first computation
			BigInteger val1 = new BigInteger(QuickFixIntegerOverflow.ob
					.getOffset().toString());
			BigInteger val2 = new BigInteger("-" + rightHandSide);
			BigInteger val3 = val1.add(val2);

			// second computation
			BigInteger val4 = new BigInteger("-"
					+ QuickFixIntegerOverflow.ob.getOffset().toString());

			BigInteger val5 = new BigInteger("-" + rightHandSide);
			BigInteger val6 = val4.add(val5);
			startID++;
			return "if ("
					+ leftHandSide
					+ " <= "
					+ val3.toString()
					+ " && "
					+ leftHandSide
					+ " >= "
					+ val6.toString()
					+ "){ "
					+ "\n"
					+ "\t"
					+ "\t"
					+ "\t"
					+ "placeHolder"
					+ "\n }else{ \n"

					// Version 1
					// + "return;" + " }\n";

					// Version 2
					// + "logg_IO_error(ID);" + " }\n";

					// Version 3
					+ "FILE * fp = fopen (\"IO_error_log.txt\", \"w+\");\n"
					+ "fprintf(fp, \"IO ID: %d FileName: %s LineNumber: %d\","
					+ startID + ",\"" + fileName + "\","
					+ node.getFileLocation().getStartingLineNumber() + ")\n;"
					+ "fclose(fp);" + " }\n";

			// case 2: e.g., data * data;
		} else if (leftHandSide != null && rightHandSide != null
				&& leftHandSide.equals(rightHandSide) && operator.equals("*")) {

			startID++;
			return "if (sqrt("
					+ leftHandSide
					+ ") <= sqrt("
					+ QuickFixIntegerOverflow.ob.getOffset().toString()
					+ ") && -sqrt("
					+ leftHandSide
					+ ") >= -sqrt("
					+ QuickFixIntegerOverflow.ob.getOffset().toString()
					+ "))"
					+ "{ "
					+ "\n"
					+ "\t"
					+ "\t"
					+ "\t"
					+ "placeHolder"
					+ "\n }else{ \n"

					// Version 1
					// + "\n }else{ \n" + "return;" + " }\n";

					// Version 2
					// + "\n }else{ \n" + "logg_IO_error(ID);" + " }\n";

					// Version 3
					+ "FILE * fp = fopen (\"IO_error_log.txt\", \"w+\");\n"
					+ "fprintf(fp, \"IO ID: %d FileName: %s LineNumber: %d\","
					+ startID + ",\"" + fileName + "\","
					+ node.getFileLocation().getStartingLineNumber() + ")\n;"
					+ "fclose(fp);" + " }\n";

			// case 3: e.g., data * 2;
		} else if (leftHandSide != null && rightHandSide != null
				&& !leftHandSide.equals(rightHandSide)
				&& operator.trim().equals("*")) {
			System.out.println("here2");
			// first computation
			BigInteger val1 = new BigInteger(QuickFixIntegerOverflow.ob
					.getOffset().toString());
			BigInteger val2 = new BigInteger(rightHandSide);
			BigInteger val3 = val1.divide(val2);

			// second computation
			BigInteger val4 = new BigInteger("-"
					+ QuickFixIntegerOverflow.ob.getOffset().toString());

			BigInteger val5 = new BigInteger(rightHandSide);
			BigInteger val6 = val4.divide(val5);

			startID++;
			return "if ("
					+ leftHandSide
					+ " <= "
					+ val3.toString()
					+ " && "
					+ leftHandSide
					+ " >= "
					+ val6.toString()
					+ "){ "
					+ "\n"
					+ "\t"
					+ "\t"
					+ "\t"
					+ "placeHolder"
					+ "\n }else{ \n"
					// Version 1
					// + "return;" + " }\n";

					// Version 2
					// + "log_IO_error(ID);" + " }\n";

					// Version 3
					+ "FILE * fp = fopen (\"IO_error_log.txt\", \"w+\");\n"
					+ "fprintf(fp, \"IO ID: %d FileName: %s LineNumber: %d\","
					+ startID + ",\"" + fileName + "\","
					+ node.getFileLocation().getStartingLineNumber() + ")\n;"
					+ "fclose(fp);" + " }\n";

		} else {
			return "no template selected";
		}

	}

	/**
	 * Instantiates a new assert buffer overflow.
	 */
	public AssertIntegerOverflow() {
		super();
		this.sv = new Solver();
	}

	/**
	 * Creates the linear system.
	 * 
	 * @param ob
	 *            the ob
	 * @return the string
	 */
	@Override
	public String createLinearSystem(SMTConstraintObject ob) {
		String newline = System.getProperty("line.separator");
		String symbolicValue = "imp_quick_0";
		String produceModels = new String("(set-option :produce-models true)"
				+ newline);
		StringBuffer quickFixSymbolicValue = new StringBuffer("(declare-fun "
				+ symbolicValue + " () Int)" + newline);
		String assertLessThen = "(assert (< " + symbolicValue + " "
				+ ob.getBufferSize() + "))" + newline;
		String assertGreatherThenEqual = "(assert (>= (+ " + symbolicValue
				+ ") " + ob.getBufferSize() + "-1" + "))" + newline;

		String newConstraintsSystem = quickFixSymbolicValue + assertLessThen
				+ assertGreatherThenEqual;

		String checkSatExit = "(check-sat)" + newline + "(get-value ("
				+ symbolicValue + "))" + newline + "(exit)" + newline;

		String finalLinearSystem = produceModels + ob.getLinearSystem()
				+ newConstraintsSystem + checkSatExit;
		// the z3 solver complains about the null string
		if (finalLinearSystem.contains("null")) {
			finalLinearSystem = finalLinearSystem.replaceAll("null", "");
		}
		StatementLogger.log_quickFixes("Linear system \n" + finalLinearSystem);
		String reply = sv.queryReply(new String(finalLinearSystem));

		if (reply.contains("unsat")) {
			StatementLogger.log_quickFixes("unsat");
		} else {
			StatementLogger.log_quickFixes("sat");
		}
		StatementLogger.log_quickFixes("reply: \n" + reply);

		boolean found2 = false;
		StringTokenizer st2 = new StringTokenizer(reply.toString(), " ()");
		String value = null;
		StatementLogger.log_quickFixes("st: " + st2.toString());
		while (!found2 && st2.hasMoreTokens()) {
			String nexttoken = st2.nextToken();
			StatementLogger.log_quickFixes("nexttoken: " + nexttoken);
			if (nexttoken.contains(symbolicValue)) {
				value = st2.nextToken();
				found2 = true;
			}
		}
		StatementLogger.log_quickFixes("val: \n" + value);
		return value;
	}

}
