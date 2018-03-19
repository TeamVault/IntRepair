package smtcodan.quickfixes.information.exposure;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import smtcodan.Solver;
import smtcodan.quickfixes.IAssertLogicOperation;
import smtcodan.quickfixes.SMTConstraintObject;

public class AssertInformationExposure implements IAssertLogicOperation {

	/** The sv. */
	private Solver sv;

	/** The buggy variable. */
	public static String buggyVariable;

	/** The race condition quick fix message. */
	public static String INFORMATION_EXPOSURE_QUICK_FIX_MESSAGE = "Quick-Fix Location";

	/** The race condition bug location message. */
	public static String INFORMATION_EXPOSURE_BUG_LOCATION_MESSAGE = "Information Exposure Bug Location";

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
		AssertInformationExposure.buggyVariable = buggyVariable;
	}

	/**
	 * Gets the information overflow quick fix string.
	 * 
	 * @return the information overflow quick fix string
	 */

	public static String getInformationExposureQuickFixString1() {
		StringTokenizer str = null;
		ArrayList<String> arguments_fix = new ArrayList<String>();

		String old = QuickFixInformationExposure.getReplaceStringOld();
		String var = AssertInformationExposure.getBuggyVariable();

		str = new StringTokenizer(old, ",\";;\\( )", true);

		if (str != null)
			while (str.hasMoreTokens()) {
				arguments_fix.add(str.nextToken());
			}
		int length1 = arguments_fix.size();
		int i = 0;
		int j = 0;
		int wordcount = 0;
		int formatcount = 0;
		for (i = length1 - 1; i > 0; i--) {
			if ((arguments_fix.get(i).toString()).equals(")")) {
				for (j = i; j > 0; j--) {
					if (!arguments_fix.get(j).equals("\"")
							&& arguments_fix.get(j).equals(var)) {
						wordcount++;
						arguments_fix.remove(j);
						arguments_fix.remove(j - 2);

						System.out.println(arguments_fix.get(j - 2));

						break;
					}
				}

				break;
			}
		}
		int length2 = arguments_fix.size();
		for (i = length2 - 1; i > 0; i--) {
			if ((arguments_fix.get(i).toString()).equals("\"")) {
				for (j = i - 1; j > 0; j--) {
					Pattern pattern = Pattern.compile("%.?");
					Matcher matcher = pattern.matcher(arguments_fix.get(j));
					if (!arguments_fix.get(j).equals("\"") && matcher.find()) {
						formatcount++;
						if (wordcount == formatcount) {
							arguments_fix.remove(j);
							System.out.println(arguments_fix);

							break;
						}
					}
				}

				break;
			}
		}

		String fix = "";
		System.out.println(arguments_fix);
		for (String s : arguments_fix) {
			fix += s;
		}
		System.out.println(fix);
		String fix_final = removeLastChar(fix);

		return fix_final;
	}

	public static String getInformationExposureQuickFixString2() {
		StringTokenizer str = null;
		ArrayList<String> arguments_fix = new ArrayList<String>();

		String old = QuickFixInformationExposure.getReplaceStringOld();
		// String var=AssertInformationExposure.getBuggyVariable();

		String fix = old.replaceAll("\\(.*\\;", "(" + "\""
				+ "Confidential data has been restricted" + "\"" + ")");
		return fix;
	}

	/**
	 * Instantiates a new assert buffer overflow.
	 */
	public AssertInformationExposure() {
		super();
		this.sv = new Solver();
	}

	@Override
	public String createLinearSystem(SMTConstraintObject ob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConstraintValue(String quickFix) {
		// TODO Auto-generated method stub

	}

	private static String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}

}
