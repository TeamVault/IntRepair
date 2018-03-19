package smtcodan.parser;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class AnnotationParserUtil.
 */
public class AnnotationParserUtil {

	    //before these three methods can be called the type of the comment has 
		//to be found and the according methods should be called
		//for single line comment: only getSingleLineComment should be called
		//for multi line comment: both getMultilineFunctionComment and 
		//getMultilineParameterComment should be called
		/**
		 * Gets the single line comment.
		 *
		 * @param comment the comment
		 * @return the single line comment
		 */
		public static ArrayList<ParameterComment> getSingleLineParamterAnnotation(Comment comment) { 
			ArrayList<ParameterComment> objects = null;
		        		if(comment.getType().equals(Comment.singleLineComment)){
			        		objects = comment.getParameterComments();
		        		}
		        		//this should be a list with only one element
					    return objects;		
		}
		
		/**
		 * Gets the single line function annotation.
		 *
		 * @param comment the comment
		 * @return the single line function annotation
		 */
		public static ArrayList<FunctionComment> getSingleLineFunctionAnnotation(Comment comment) { 
			ArrayList<FunctionComment> objects = null;
		        		if(comment.getType().equals(Comment.singleLineComment)){
			        		objects = comment.getFunctionComments();
		        		}
		        		//this should be a list with only one element
					    return objects;		
		}
		
		/**
		 * Gets the multiline function comments.
		 *
		 * @param comment the comment
		 * @return the multiline function comment
		 */
		public static  ArrayList<FunctionComment> getMultilineFunctionComment(Comment comment){
			ArrayList<FunctionComment> objects =null;
			if(comment.getType().equals(Comment.mutilineLineComment)){
			         objects = comment.getFunctionComments();
			 }
			//this should be a list with 0 or n function comments
			return objects;	
		}
		
		/**
		 * Gets the multiline parameter comments.
		 *
		 * @param comment the comment
		 * @return the multiline parameter comment
		 */
		public static  ArrayList<ParameterComment> getMultilineParameterComment(Comment comment){
			ArrayList<ParameterComment> objects =null;
			if(comment.getType().equals(Comment.mutilineLineComment)){
			         objects = comment.getParameterComments();
			    	}
			//this should be a list with 0 or n parameter comments
			return objects;	
		}
}
