package smtcodan.quickfixes.race.condition;

import smtcodan.Solver;
import smtcodan.quickfixes.IAssertLogicOperation;
import smtcodan.quickfixes.SMTConstraintObject;
import smtcodan.quickfixes.introduceimpl.IntroduceRaceConditionRefactoring;

public class AssertRaceCondition implements IAssertLogicOperation {

	/** The sv. */
	private Solver sv;

	/** The buggy variable. */
	private static String buggyVariable;

	/** The race condition quick fix message. */
	public static String RACE_CONDITION_QUICK_FIX_MESSAGE = "Quick-Fix Location";

	/** The race condition bug location message. */
	public static String RACE_CONDITION_BUG_LOCATION_MESSAGE = "Race Condition Bug Location";

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
		AssertRaceCondition.buggyVariable = buggyVariable;
	}

	/**
	 * Gets the race condiiton quick fix string.
	 * 
	 * @return the race condition quick fix string
	 */

	public static String getRaceConditionQuickFixString() {
		return "std_thread_lock_acquire("
				+ IntroduceRaceConditionRefactoring.lockName + ");" + "\n"
				+ QuickFixRaceCondition.getReplaceStringOld() + "\n"
				+ "std_thread_lock_release("
				+ IntroduceRaceConditionRefactoring.lockName + ")";
	}

	public static String getRaceConditionLockDeclaration() {
		return "static std_thread_lock "
				+ IntroduceRaceConditionRefactoring.lockName + " = NULL;";

	}

	/**
	 * Instantiates a new assert buffer overflow.
	 */
	public AssertRaceCondition() {
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

}
