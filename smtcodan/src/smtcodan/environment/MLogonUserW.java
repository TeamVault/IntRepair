/**
   [Class description.  LogonUserA java model]
   
   [Other notes: -]
   
   @author Paul Muntean
   @version $Revision: A  Date: 20.02.2014 hour: 16:17:24
 **/
package smtcodan.environment;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.cdt.core.dom.IName;

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
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class MLogonUserA.
 */
public class MLogonUserW implements IFctModel {

	/**
	 * (LogonUserA( username, domain, password, LOGON32_LOGON_NETWORK,
	 * LOGON32_PROVIDER_DEFAULT, &pHandle) != 0).
	 */
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

	/** The annotation type. */
	private String annotationType;

	/**
	 * Instantiates a new mprintf.
	 * 
	 * @param ps
	 *            the interpreter variable
	 */
	public MLogonUserW(Interpreter ps) {
		this.ps = ps;

		HashMap<String, Comment> commentMap = AnnotationExecution
				.getCommentsMap();
		if (commentMap == null) {
			MyLogger.log_parser("Comment Map is Empty");
		} else {
			comment = commentMap.get(getLibrarySignature());
			if (comment == null) {
				MyLogger.log_parser("LogonUserW comment is null");
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
		return "LogonUserW";
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
		// contained in windows.h
		return "int LogonUserW(char *username, char *domain, char password, int LOGON32_LOGON_NETWORK, int LOGON32_PROVIDER_DEFAULT, HANDLE pHandle);";
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
		// get the third parameter
		SymVarSSA isp = null;
		if (ps.resolveOrigSymVar(plist.get(2)).getCurrentSSACopy() instanceof SymIntSSA) {
			isp = (SymIntSSA) ps.resolveOrigSymVar(plist.get(2))
					.getCurrentSSACopy();
		} else if (ps.resolveOrigSymVar(plist.get(2)).getCurrentSSACopy() instanceof SymPointerSSA) {
			isp = (SymPointerSSA) ps.resolveOrigSymVar(plist.get(2))
					.getCurrentSSACopy();
			SymArrayOrig isp2 = (SymArrayOrig) ((SymPointerSSA) isp)
					.getTarget();
		}

		// SymIntSSA isp = (SymIntSSA) ps.getLocalOrigSymVar(plist.get(2))
		// .getCurrentSSACopy();

		// CWE-259 and CWE-534 use all this model
		if (isp.isConfidential()) {
			// CWE-259
			// ps.notifyTrustBoundary(isp);
		} else {
			try {// CWE-534
				if (comment != null && annotationType != null
						&& annotationType.equals(Comment.mutilineLineComment)
						&& listMultiFunctionAnnotation != null
						&& listMultiParamterAnnotation != null) {
					// check that the comment says that the function is a source
					String function_property = AnnotationUtil.FUNCTION_PROPERTY_SOURCE;
					if (listMultiFunctionAnnotation.get(0).getAtribute()
							.equals(function_property.toString())) {
						// make shore that we use the third parameter from the
						// parameter list, this is the password
						if (listMultiParamterAnnotation.get(0).getIndex() == 2) {
							String security_level = AnnotationUtil.PARAMTER_SECURITY_LEVEL_CONFIDENTIAL;
							// get the security level and compara it to
							// confidential
							if (listMultiParamterAnnotation.get(0)
									.getSecurityType()
									.equals(security_level.toString())) {
								// set the sink as confidential
								isp.setConfidential(true);
							} else {
								isp.setConfidential(false);
							}
						}
					} else {
						// use the single line comment lists
					}
				}

				// works also without this
				// ps.declareLocal(eSymType.SymPointer, isp.getOrigName());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return new SymFunctionReturn(isp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getSignature()
	 */
	@Override
	public SymFctSignature getSignature() {
		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, new Integer(1)));
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, new Integer(1)));
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, new Integer(1)));
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));

		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));
		return fsign;
	}
}
