package smtcodan.parser;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Comment.
 */
public class Comment {
	
	/** The Constant singleLineComment. */
	public static final String singleLineComment   = "singlelineComment";
    
    /** The Constant mutilineLineComment. */
    public static final String mutilineLineComment = "mutilineComment";
		
	/** The type. */
	String type = null;
	
	/** The function comments. */
	ArrayList<FunctionComment> functionComments = null;
	
	/** The parameter comments. */
	ArrayList<ParameterComment> parameterComments = null;
	
	/**
	 * Instantiates a new comment.
	 *
	 * @param functionComments the function comments
	 * @param parameterComments the parameter comments
	 */
	public Comment(ArrayList<FunctionComment> functionComments, ArrayList<ParameterComment> parameterComments ){
		this.functionComments = functionComments;
		this.parameterComments = parameterComments;
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
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the function comments.
	 *
	 * @return the function comments
	 */
	public ArrayList<FunctionComment> getFunctionComments() {
		return functionComments;
	}

	/**
	 * Sets the function comments.
	 *
	 * @param functionComments the new function comments
	 */
	public void setFunctionComments(ArrayList<FunctionComment> functionComments) {
		this.functionComments = functionComments;
	}

	/**
	 * Gets the parameter comments.
	 *
	 * @return the parameter comments
	 */
	public ArrayList<ParameterComment> getParameterComments() {
		return parameterComments;
	}

	/**
	 * Sets the parameter comments.
	 *
	 * @param parameterComments the new parameter comments
	 */
	public void setParameterComments(ArrayList<ParameterComment> parameterComments) {
		this.parameterComments = parameterComments;
	}

}
