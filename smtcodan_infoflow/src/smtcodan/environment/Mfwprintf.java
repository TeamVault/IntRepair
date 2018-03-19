/*
 * 
 */
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
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class Mprintf. The printf() represents a system boundary.
 */
public class Mfwprintf implements IFctModel {

	// fprintf(pFile, "User attempted access with password: %s\n", password);
	// and fprintf(password, "User attempted access\n");

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

	/** The annotation type. */
	private String annotationType;

	/** The comment map. */
	private HashMap<String, Comment> commentMap;

	/** The comment. */
	private Comment comment;

	/**
	 * Instantiates a new mprintf.
	 * 
	 * @param ps
	 *            the interpreter variable
	 */
	public Mfwprintf(Interpreter ps) {
		this.ps = ps;

		commentMap = AnnotationExecution.getCommentsMap();
		if (commentMap == null) {
			MyLogger.log_parser("Comment Map is Empty");
		} else {
			comment = commentMap.get(getLibrarySignature());
			if (comment == null) {
				MyLogger.log_parser("Mfprintf comment is null");
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
		return "fwprintf";
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
	public static String getLibrarySignature() {
		// contained in stdio.h
		return "extern int fwprintf (__FILE *__restrict __stream, __const wchar_t *__restrict __format, ...) /* __attribute__ ((__format__ (__wprintf__, 2, 3))) */;";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	public SymFunctionReturn exec(SymFunctionCall call) {
		ArrayList<IName> plist = call.getParams();
		int t = 0;
		t = plist.size() - 1;
		SymVarSSA sourceSSA1 = null;
		try {

			if (ps.resolveOrigSymVar(plist.get(t)).getCurrentSSACopy() instanceof SymIntSSA) {
				sourceSSA1 = (SymIntSSA) ps.resolveOrigSymVar(plist.get(t))
						.getCurrentSSACopy();
			} else if (ps.resolveOrigSymVar(plist.get(t)).getCurrentSSACopy() instanceof SymPointerSSA) {
				sourceSSA1 = (SymPointerSSA) ps.resolveOrigSymVar(plist.get(t))
						.getCurrentSSACopy();
			}

			// ISymObject t2 = sourceSSA1.getTarget();

			// SymArrayOrig sourceSSA2 = (SymArrayOrig) t2;

			// sourcearr = ((SymPointerSSA) sourceSSA).getTargetSSA();

			// this is for multi line comments
			if (sourceSSA1 != null && comment != null && annotationType != null) {
				// check that it is a multi line comment and that both multi
				// line lists are not empty
				if (annotationType.equals(Comment.mutilineLineComment)
						&& listMultiFunctionAnnotation != null
						&& listMultiParamterAnnotation != null) {
					// not used
				}

				// this is for single line comments
				else if (annotationType.equals(Comment.singleLineComment)
						&& listSingleFunctionAnnotation != null) {
					// check that the comment says that the function is a source
					String function_property = AnnotationUtil.FUNCTION_PROPERTY_SINK;
					// a multi line comment can contain more then one @function
					// annotation
					for (FunctionComment element : listSingleFunctionAnnotation)
						if (element.getAtribute().equals(
								function_property.toString())) {
							MyLogger.log_a("bbbbn");
							// notify the interpreter
							ps.notifyTrustBoundary(sourceSSA1);
						} else {
							// do nothing
						}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return sympointer
		IName retname = new ImpVarName();
		SymPointerOrig retvalorig = new SymPointerOrig(retname);
		retvalorig.setTargetType(eSymType.SymPointer);
		SymVarSSA ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);

		return new SymFunctionReturn(ssa);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getSignature()
	 */
	@Override
	public SymFctSignature getSignature() {

		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymIntOrig());
		fsign.addParam(new SymIntOrig());
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));

		fsign.setRType(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));
		return fsign;
	}

}
