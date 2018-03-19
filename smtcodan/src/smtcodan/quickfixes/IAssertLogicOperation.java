package smtcodan.quickfixes;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAssertLogicOperation.
 */
public interface IAssertLogicOperation {

	/**
	 * Creates the linear system.
	 * 
	 * @param ob
	 *            the ob
	 * @return the string
	 */
	public String createLinearSystem(SMTConstraintObject ob);

	/**
	 * Sets the buggy variable.
	 * 
	 * @param str
	 *            the new buggy variable
	 */
	public void setBuggyVariable(String str);

	/**
	 * Sets the constraint value.
	 * 
	 * @param quickFix
	 *            the new constraint value
	 */
	public void setConstraintValue(String quickFix);

}
