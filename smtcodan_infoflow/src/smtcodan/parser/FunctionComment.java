package smtcodan.parser;

// TODO: Auto-generated Javadoc
/**
 * The Class FunctionComment.
 */
public class FunctionComment {

	/** The type. */
	private String type = null;

	/** The atribute. */
	private String atribute = null;
	private String preStep = null;
	private String postStep = null;
	private String level = null;

	/**
	 * Instantiates a new function comment.
	 */
	public FunctionComment() {
		this.type = "functionComment";
	}

	/**
	 * Instantiates a new function comment.
	 * 
	 * @param type
	 *            the type
	 * @param atribute
	 *            the atribute
	 */
	public FunctionComment(String type, String atribute) {
		super();
		this.type = "functionComment";
		this.atribute = atribute;
		this.postStep = null;
		this.preStep = null;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPostStep() {
		return postStep;
	}

	public void setPostStep(String postStep) {
		this.postStep = postStep;
	}

	public String getPreStep() {
		return preStep;
	}

	public void setPreStep(String preStep) {
		this.preStep = preStep;
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
	 * Gets the atribute.
	 * 
	 * @return the atribute
	 */
	public String getAtribute() {
		return atribute;
	}

	/**
	 * Sets the atribute.
	 * 
	 * @param atribute
	 *            the new atribute
	 */
	public void setAtribute(String atribute) {
		this.atribute = atribute;
	}
}
