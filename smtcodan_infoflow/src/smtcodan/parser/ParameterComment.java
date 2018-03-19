package smtcodan.parser;

// TODO: Auto-generated Javadoc
/**
 * The Class ParameterComment.
 */
public class ParameterComment {

	/** The type. */
	private String type = null;

	/** The parameter name. */
	private String parameterName = null;

	/** The security type. */
	private String securityType = null;

	private String level = null;

	/** The index. */
	private int index = 0;

	/**
	 * Instantiates a new parameter comment.
	 */
	public ParameterComment() {
		this.type = "parameterComment";
	}

	/**
	 * Instantiates a new parameter comment.
	 * 
	 * @param type
	 *            the type
	 * @param parameterName
	 *            the parameter name
	 * @param securityType
	 *            the security type
	 * @param index
	 *            the index
	 */
	public ParameterComment(String type, String parameterName,
			String securityType, int index) {
		super();
		this.type = "parameterComment";
		this.parameterName = parameterName;
		this.securityType = securityType;
		this.index = index;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * Gets the index.
	 * 
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index.
	 * 
	 * @param index
	 *            the new index
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the parameter name.
	 * 
	 * @return the parameter name
	 */
	public String getParameterName() {
		return parameterName;
	}

	/**
	 * Sets the parameter name.
	 * 
	 * @param parameterName
	 *            the new parameter name
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	/**
	 * Gets the security type.
	 * 
	 * @return the security type
	 */
	public String getSecurityType() {
		return securityType;
	}

	/**
	 * Sets the security type.
	 * 
	 * @param securityType
	 *            the new security type
	 */
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

}
