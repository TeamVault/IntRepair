/**
   [Class description. This class extends the ASTVisitor. It will be instantiated for each basic block available in the Interpreter.
   For each basic block a new statement processor object will be instantiated and assigned to the IASTNode which we get by casting each basic block 
   which we get in the enter method in the interpreter class]
   
   [Other notes. Each statement is checked in this class regarding his type and a new symbolic variable is added to the attribute list]
   
   @author Andreas Ibing
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.quickfixes;

import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTArrayModifier;
import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTFieldReference;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTFunctionCallExpression;
import org.eclipse.cdt.core.dom.ast.IASTIdExpression;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;
import org.eclipse.cdt.core.dom.ast.IASTInitializerClause;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTPointerOperator;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTypeId;
import org.eclipse.cdt.core.dom.ast.IASTUnaryExpression;

import smtcodan.quickfixes.integer.overflow.AssertIntegerOverflow;

// TODO: Auto-generated Javadoc
/**
 * The Class SmProcessor.
 */
public class InfluenciableNodeVisitor extends ASTVisitor {

	/** The found. */
	public static boolean found = false;

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
		InfluenciableNodeVisitor.sourceFileLocation = sourceFileLocation;
	}

	/**
	 * Instantiates a new CG node visitor.
	 */
	public InfluenciableNodeVisitor() {

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

	// only IASTEspression binary expression operation equals is used
	// we could implement also a branch to handle also "int data = e;" this is
	// not handled currently

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
		// check if the buggy variable can influence a declaration
		IASTSimpleDeclaration sdecl = (IASTSimpleDeclaration) decl;
		IASTDeclSpecifier dspec = sdecl.getDeclSpecifier();
		IASTDeclarator[] decls = sdecl.getDeclarators();
		for (IASTDeclarator declarator : decls) {
			IASTInitializer ini = declarator.getInitializer();

			if (ini != null) {
				// check if the operand is equal to the buggy variable
				// e.g. ini can be "= { 0 }"
				if (ini.getRawSignature().toString()
						.contains(AssertIntegerOverflow.getBuggyVariable())) {
					InfluenciableNodeVisitor.setFound(true);
				} else {
					InfluenciableNodeVisitor.setFound(false);
				}
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
	 * (non-Javadoc)
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
	 * (non-Javadoc)
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.core.dom.ast.ASTVisitor#leave(org.eclipse.cdt.core.dom
	 * .ast.IASTExpression)
	 */
	public int leave(IASTExpression expr) {
		// check for unary expressions
		if (expr instanceof IASTUnaryExpression) {
			IASTUnaryExpression unexp = (IASTUnaryExpression) expr;
			int unop = unexp.getOperator();
			IASTExpression operand = unexp.getOperand();
			// check if the operand is equal to the buggy variable
			if (AssertIntegerOverflow.getBuggyVariable().equals(
					operand.getRawSignature().toString())) {
				InfluenciableNodeVisitor.setFound(true);
			} else {
				InfluenciableNodeVisitor.setFound(false);
			}
		}
		// for buffer[data] = 1;
		if (expr instanceof IASTBinaryExpression) {
			IASTBinaryExpression binexp = (IASTBinaryExpression) expr;
			IASTExpression op1 = binexp.getOperand1();
			IASTExpression op2 = binexp.getOperand2();
			int binop = binexp.getOperator();
			// if our expression is a assignment
			if (binop == IASTBinaryExpression.op_assign) {
				// if there is the buggy var in the right hand side term, op2
				// one of the parameters of the function call contains our buggy
				// var

				if (AssertIntegerOverflow.getBuggyVariable().equals(
						op2.getRawSignature().toString())) {
					InfluenciableNodeVisitor.setFound(true);
				} else if (op2 instanceof IASTFunctionCallExpression) {
					IASTFunctionCallExpression op2FunctionCall = (IASTFunctionCallExpression) op2;
					IASTInitializerClause[] list = op2FunctionCall
							.getArguments();
					for (int i = 0; i < list.length; i++) {
						if (AssertIntegerOverflow.getBuggyVariable().equals(
								list[i].getRawSignature().toString())) {
							InfluenciableNodeVisitor.setFound(true);
						}
					}
				} else if (op2 instanceof IASTIdExpression) {
					IASTIdExpression op2Id = (IASTIdExpression) op2;
					if (AssertIntegerOverflow.getBuggyVariable().equals(
							op2Id.getRawSignature().toString())) {
						InfluenciableNodeVisitor.setFound(true);
					}
				} else if (op2 instanceof IASTFieldReference) {
					IASTFieldReference op2Field = (IASTFieldReference) op2;
					if (AssertIntegerOverflow.getBuggyVariable().equals(
							op2Field.getRawSignature().toString())) {
						InfluenciableNodeVisitor.setFound(true);
					}
				} else {
					InfluenciableNodeVisitor.setFound(false);
				}

				return PROCESS_CONTINUE;
			} else if (binop == IASTBinaryExpression.op_notequals) {
				// TO DO
				return PROCESS_CONTINUE;
			} else if (binop == IASTBinaryExpression.op_divide) {
				// TO DO
				return PROCESS_CONTINUE;
			}
		}
		return PROCESS_CONTINUE;
	}

	/**
	 * Checks if is found.
	 * 
	 * @return true, if is found
	 */
	public static boolean isFound() {
		return InfluenciableNodeVisitor.found;
	}

	/**
	 * Sets the found.
	 * 
	 * @param found
	 *            the new found
	 */
	public static void setFound(boolean found) {
		InfluenciableNodeVisitor.found = found;
	}

}
