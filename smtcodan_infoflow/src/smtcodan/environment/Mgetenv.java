/**
   [Class description. The getenv() function model]
   
   [Other notes,  -]
   
   @author Paul Muntean
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.environment;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.ImpVarName;
import smtcodan.interpreter.Interpreter;
import smtcodan.logger.MyLogger;
import smtcodan.parser.AnnotationExecution;
import smtcodan.parser.AnnotationParserUtil;
import smtcodan.parser.AnnotationUtil;
import smtcodan.parser.Comment;
import smtcodan.parser.FunctionComment;
import smtcodan.parser.ParameterComment;
import smtcodan.symvars.SymArrayOrig;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class Mgetenv.
 */
public class Mgetenv implements IFctModel {

	// int getenv("PATH");

	/** The ps. */
	private Interpreter ps;

	/** The list single paramter annotation. */
	private ArrayList<ParameterComment> listSingleParamterAnnotation;

	/** The list single function annotation. */
	private ArrayList<FunctionComment> listSingleFunctionAnnotation;

	/** The list multi paramter annotation. */
	private ArrayList<ParameterComment> listMultiParamterAnnotation;

	/** The list multi function annotation. */
	private ArrayList<FunctionComment> listMultiFunctionAnnotation;

	/** The comment. */
	private Comment comment;

	// it is required to define all the symbolic variables from the the execute
	// method in advance and also the return symbolic variables
	// it is required to define them in advance because we want to annotate them
	// in the constructor

	/** The exec() return value isp_ssa. */
	private SymPointerSSA isp_ssa = null;

	/** The annotation type. */
	private String annotationType;

	/**
	 * Instantiates a new mgetenv.
	 * 
	 * @param ps
	 *            the ps
	 */
	public Mgetenv(Interpreter ps) {
		this.ps = ps;
		HashMap<String, Comment> commentMap = AnnotationExecution
				.getCommentsMap();
		if (commentMap == null) {
			MyLogger.log_parser("Comment Map is Empty");
		} else {
			comment = commentMap.get(getLibrarySignature());
			if (comment == null) {
				MyLogger.log_parser("Mgetenv comment is null");
			} else {
				// a single line comment can be a @parameter or @function
				// annotation
				if (comment.getType().equals(Comment.singleLineComment)) {
					// this tells which annotation type we are dealing with
					annotationType = Comment.singleLineComment;
					listSingleParamterAnnotation = AnnotationParserUtil
							.getSingleLineParamterAnnotation(comment);
					listSingleFunctionAnnotation = AnnotationParserUtil
							.getSingleLineFunctionAnnotation(comment);
					if (listSingleParamterAnnotation == null) {
						// use the listSingleFunctionAnnotation
					} else {
						// use the listSingleParamterAnnotation
					}
				} else if (comment.getType()
						.equals(Comment.mutilineLineComment)) {
					annotationType = Comment.mutilineLineComment;
					listMultiParamterAnnotation = AnnotationParserUtil
							.getMultilineParameterComment(comment);
					listMultiFunctionAnnotation = AnnotationParserUtil
							.getMultilineFunctionComment(comment);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "getenv";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getLibrarySignature()
	 */
	/**
	 * Gets the library signature.
	 * 
	 * @return the library signature
	 */
	private static String getLibrarySignature() {
		// contained in stdlib.h
		return "extern char *getenv (__const char *__name) __THROW __nonnull ((1)) __wur;";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		ArrayList<IName> plist = call.getParams();
		SymPointerOrig isp = ps.getLocalOrigSymPointer(plist.get(0));
		IName nebn = new EnvVarName();
		SymIntOrig sb_size = new SymIntOrig(new ImpVarName());
		SymArrayOrig sb = new SymArrayOrig(nebn, sb_size);
		try {
			sb.setElemType(eSymType.SymPointer);
			SymVarSSA ssa = (SymVarSSA) ps.declareLocal(eSymType.SymPointer,
					null);
			// return pointer
			isp_ssa = (SymPointerSSA) ps.ssaCopy(isp);
			isp_ssa.setTargetType(eSymType.SymPointer);

			// for the CWE-526 scenario we are interested only in the first
			// parameter of the first object in the list
			// we set the return value to confidential if the first parameter is
			// confidential and if it has index 0
			// index 0 means it is the first parameter of the function. The
			// function must be also a source.

			// check if the annotation is a multi line comment and that both
			// multi line lists are not empty
			if (comment != null && annotationType != null
					&& annotationType.equals(Comment.mutilineLineComment)
					&& listMultiFunctionAnnotation != null
					&& listMultiParamterAnnotation != null) {
				// check that the comment says that the function is a source
				String function_property = AnnotationUtil.FUNCTION_PROPERTY_SOURCE;
				if (listMultiFunctionAnnotation.get(0).getAtribute()
						.equals(function_property.toString())) {
					// make shore that we use the first parameter from the
					// parameter list
					if (listMultiParamterAnnotation.get(0).getIndex() == 0) {
						String security_level = AnnotationUtil.PARAMTER_SECURITY_LEVEL_CONFIDENTIAL;
						// get the security level and compara it to confidential
						if (listMultiParamterAnnotation.get(0)
								.getSecurityType()
								.equals(security_level.toString())) {
							// set the sink as confidential
							isp_ssa.setConfidential(true);
						} else {
							isp_ssa.setConfidential(false);
						}
					}
				} else {
					// use the single line comment lists
				}
			}
			isp_ssa.setTarget(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SymFunctionReturn(isp_ssa);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getSignature()
	 */
	@Override
	public SymFctSignature getSignature() {
		// SymFctSignature fsign = new SymFctSignature();
		// fsign.addParam(new SymIntOrig());
		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymPointerOrig(eSymType.SymArray, new Integer(1)));

		fsign.setRType(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));
		return fsign;
	}

}