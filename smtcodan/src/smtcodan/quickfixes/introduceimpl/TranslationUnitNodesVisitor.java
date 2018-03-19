/**
   [Class description. This class extends the ASTVisitor. It will be instantiated for each basic block available in the Interpreter.
   For each basic block a new statement processor object will be instantiated and assigned to the IASTNode which we get by casting each basic block 
   which we get in the enter method in the interpreter class]
   
   [Other notes. Each statement is checked in this class regarding his type and a new symbolic variable is added to the attribute list]
   
   @author Andreas Ibing
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.quickfixes.introduceimpl;

import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTArrayModifier;
import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTFunctionCallExpression;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTPointerOperator;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorMacroDefinition;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTypeId;

import smtcodan.logger.StatementLogger;
import smtcodan.quickfixes.CGNodeVisitor;

// TODO: Auto-generated Javadoc
/**
 * The Class SmProcessor.
 */
public class TranslationUnitNodesVisitor extends ASTVisitor {

	/** The found. */
	public IASTNode myNode;

	/** The buggy statement. */
	private String buggyStatement;

	/** The buggy line. */
	private int buggyLine;

	/** The source file location. */
	public static IASTFileLocation sourceFileLocation;

	/**
	 * Gets the source file location.
	 * 
	 * @return the source file location
	 */
	public static IASTFileLocation getSourceFileLocation() {
		return sourceFileLocation;
	}

	/**
	 * Sets the source file location.
	 * 
	 * @param sourceFileLocation
	 *            the new source file location
	 */
	public static void setSourceFileLocation(IASTFileLocation sourceFileLocation) {
		CGNodeVisitor.sourceFileLocation = sourceFileLocation;
	}

	/**
	 * Instantiates a new CG node visitor.
	 * 
	 * @param buggyStatement
	 *            the buggy statement
	 * @param buggyLine
	 *            the buggy line
	 */
	public TranslationUnitNodesVisitor(String buggyStatement, int buggyLine) {

		this.buggyStatement = buggyStatement;
		this.buggyLine = buggyLine;
		this.myNode = null;

		shouldVisitExpressions = true;
		shouldVisitDeclarations = true;
		shouldVisitNames = true;
		shouldVisitDeclarators = true;
		shouldVisitInitializers = true;
		shouldVisitDeclSpecifiers = true;
		shouldVisitStatements = true;
		shouldVisitArrayModifiers = true;
		shouldVisitAttributes = true;
		shouldVisitBaseSpecifiers = true;
		shouldVisitCaptures = true;
		shouldVisitDesignators = true;
		shouldVisitEnumerators = true;
		shouldVisitImplicitNames = true;
		shouldVisitParameterDeclarations = true;
		shouldVisitPointerOperators = true;
		shouldVisitTypeIds = true;
	}

	/**
	 * Checks if is found.
	 * 
	 * @param sm
	 *            the sm
	 * @return true, if is found
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTStatement)
	 */
	public int leave(IASTStatement sm) {
		return PROCESS_CONTINUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTDeclaration)
	 */
	public int leave(IASTDeclaration decl) {
		if (decl instanceof IASTDeclaration) {
			String str = this.buggyStatement;
			if (decl.getRawSignature().toString().equals(str)
					&& this.buggyLine == decl.getFileLocation()
							.getStartingLineNumber()) {
				StatementLogger.log_quickFixes("my visitors function call "
						+ decl.getRawSignature().toString());
				this.myNode = decl.getOriginalNode();
				StatementLogger.log_quickFixes("IASTFunctionCallExpression "
						+ decl.getRawSignature().toString());
				return PROCESS_ABORT;
			}
		}
		return PROCESS_CONTINUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTTypeId)
	 */
	public int leave(IASTTypeId typeId) {
		return PROCESS_CONTINUE;
	}

	/*
	 * (non-Javadoc)TranslationUnitNodesVisitor
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTDeclSpecifier)
	 */
	public int leave(IASTDeclSpecifier dspec) {
		return PROCESS_CONTINUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTDeclarator)
	 */
	public int leave(IASTDeclarator decl) {
		return PROCESS_CONTINUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTArrayModifier)
	 */
	public int leave(IASTArrayModifier am) {
		return PROCESS_CONTINUE;

	}

	/*
	 * (non-Javadoc) TranslationUnitNodesVisitor
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTExpression)
	 */

	public int leave(IASTPointerOperator ptrop) {
		return PROCESS_CONTINUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTInitializer)
	 */
	public int leave(IASTInitializer ini) {

		return PROCESS_CONTINUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTParameterDeclaration)
	 */
	public int leave(IASTParameterDeclaration pdecl) {
		return PROCESS_CONTINUE;
	}

	/**
	 * Removes the last char.
	 * 
	 * @param str
	 *            the str
	 * @return the string
	 */
	private static String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTExpression)
	 */
	public int leave(IASTExpression expr) {
		// for buffer[data] = 1;
		if (expr instanceof IASTBinaryExpression) {
			IASTBinaryExpression binexp = (IASTBinaryExpression) expr;
			IASTExpression op1 = binexp.getOperand1();
			IASTExpression op2 = binexp.getOperand2();
			int binop = binexp.getOperator();
			if (binop == IASTBinaryExpression.op_assign) {
				String str = removeLastChar(this.buggyStatement);

				// get the node where the bug was located
				if (expr.getRawSignature().toString().equals(str)
						&& this.buggyLine == expr.getFileLocation()
								.getStartingLineNumber()) {

					StatementLogger.log_quickFixes("\n my visitors bynary "
							+ expr.getRawSignature().toString());
					StatementLogger.log_quickFixes("\n my visitors bynary "
							+ binexp.getOriginalNode().getRawSignature()
									.toString());

					this.myNode = binexp.getOriginalNode();
					return PROCESS_ABORT;
				}
			}
		} else if (expr instanceof IASTFunctionCallExpression) {
			String str = removeLastChar(this.buggyStatement);
			if (expr.getRawSignature().toString().equals(str)
					&& this.buggyLine == expr.getFileLocation()
							.getStartingLineNumber()) {
				StatementLogger.log_quickFixes("my visitors function call "
						+ expr.getRawSignature().toString());
				this.myNode = expr.getOriginalNode();
				StatementLogger.log_quickFixes("IASTFunctionCallExpression "
						+ expr.getRawSignature().toString());
				return PROCESS_ABORT;

				// get the second node in CWE-190 after the bug location
			} else if (!expr.getRawSignature().toString().equals(str)
					&& this.buggyLine == expr.getFileLocation()
							.getStartingLineNumber()) {

				StatementLogger.log_quickFixes("\n my visitors bynary "
						+ expr.getRawSignature().toString());
				StatementLogger.log_quickFixes("\n my visitors bynary "
						+ expr.getOriginalNode().getRawSignature().toString());

				this.myNode = expr.getParent();
				return PROCESS_ABORT;
			}
		}
		// vasantha
		else if (expr instanceof IASTPreprocessorMacroDefinition) {
			String str = removeLastChar(this.buggyStatement);
			if (expr.getRawSignature().toString().equals(str)
					&& this.buggyLine == expr.getFileLocation()
							.getStartingLineNumber()) {
				StatementLogger.log_quickFixes("my visitors function call "
						+ expr.getRawSignature().toString());
				this.myNode = expr.getOriginalNode();
				StatementLogger.log_quickFixes("IASTFunctionCallExpression "
						+ expr.getRawSignature().toString());
				return PROCESS_ABORT;
			}
		}

		return PROCESS_CONTINUE;
	}
}
