package smtcodan.quickfixes.introduceimpl.node;

import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTPointerOperator;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclSpecifier;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamedTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTQualifiedName;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTReferenceOperator;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTSimpleDeclSpecifier;

// TODO: Auto-generated Javadoc
/**
 * The Class NodeHelper.
 */
public class NodeHelper {

	/**
	 * Checks if is constructor.
	 * 
	 * @param function
	 *            the function
	 * @return true, if is constructor
	 */
	public static boolean isConstructor(ICPPASTFunctionDefinition function) {
		boolean isConstructor = isStructor(function, false);
		if (isConstructor) {
			return !isCopyConstructor(function);
		} else {
			return false;
		}
	}

	/**
	 * Checks if is destructor.
	 * 
	 * @param function
	 *            the function
	 * @return true, if is destructor
	 */
	public static boolean isDestructor(ICPPASTFunctionDefinition function) {
		return isStructor(function, true);
	}

	/**
	 * Checks if is structor.
	 * 
	 * @param function
	 *            the function
	 * @param isDestructor
	 *            the is destructor
	 * @return true, if is structor
	 */
	private static boolean isStructor(ICPPASTFunctionDefinition function,
			boolean isDestructor) {
		if (function.getDeclSpecifier() instanceof ICPPASTSimpleDeclSpecifier) {
			IASTName name = function.getDeclarator().getName();
			if (name instanceof ICPPASTQualifiedName) {
				name = ((ICPPASTQualifiedName) name).getLastName();
			}
			return ((ICPPASTSimpleDeclSpecifier) function.getDeclSpecifier())
					.getType() == ICPPASTSimpleDeclSpecifier.sc_unspecified
					&& name.toString().startsWith("~") == isDestructor
					&& ((ICPPASTSimpleDeclSpecifier) function
							.getDeclSpecifier()).getStorageClass() == IASTDeclSpecifier.sc_unspecified;
		}
		return false;
	}

	/**
	 * Checks if is emtyp declarator.
	 * 
	 * @param node
	 *            the node
	 * @return true, if is emtyp declarator
	 */
	public static boolean isEmtypDeclarator(IASTDeclaration node) {
		if (node instanceof IASTSimpleDeclaration) {
			return ((IASTSimpleDeclaration) node).getDeclarators().length == 0;
		}
		return false;
	}

	/**
	 * Checks if is function declarator.
	 * 
	 * @param node
	 *            the node
	 * @return true, if is function declarator
	 */
	public static boolean isFunctionDeclarator(IASTDeclaration node) {
		if (node instanceof IASTSimpleDeclaration) {
			IASTSimpleDeclaration simpleDecl = (IASTSimpleDeclaration) node;
			return (simpleDecl.getDeclarators() != null
					&& simpleDecl.getDeclarators().length > 0 && simpleDecl
						.getDeclarators()[0] instanceof ICPPASTFunctionDeclarator);
		}
		return false;
	}

	/**
	 * Checks if is static.
	 * 
	 * @param node
	 *            the node
	 * @return true, if is static
	 */
	public static boolean isStatic(IASTNode node) {
		if (node instanceof IASTSimpleDeclaration) {
			return ((IASTSimpleDeclaration) node).getDeclSpecifier()
					.getStorageClass() == IASTSimpleDeclSpecifier.sc_static;
		} else if (node instanceof ICPPASTFunctionDefinition) {
			return ((ICPPASTFunctionDefinition) node).getDeclSpecifier()
					.getStorageClass() == IASTSimpleDeclSpecifier.sc_static;
		}
		return false;
	}

	/**
	 * Checks if is copy constructor.
	 * 
	 * @param memberDefinition
	 *            the member definition
	 * @return true, if is copy constructor
	 */
	public static boolean isCopyConstructor(
			ICPPASTFunctionDefinition memberDefinition) {
		if (isStructor(memberDefinition, false)) {
			ICPPASTFunctionDeclarator functionDeclarator = (ICPPASTFunctionDeclarator) memberDefinition
					.getDeclarator();
			String className;
			if (functionDeclarator.getName() instanceof ICPPASTQualifiedName) {
				className = functionDeclarator.getName().getLastName()
						.toString();
			} else {
				className = functionDeclarator.getName().toString();
			}
			IASTParameterDeclaration[] parameters = functionDeclarator
					.getParameters();
			if (parameters.length == 1) {
				IASTParameterDeclaration parameter = parameters[0];
				if (parameter.getDeclSpecifier() instanceof ICPPASTNamedTypeSpecifier) {
					ICPPASTNamedTypeSpecifier parameterSpecifier = (ICPPASTNamedTypeSpecifier) parameter
							.getDeclSpecifier();
					if (parameterSpecifier.isConst()
							&& hasPointerOperator(parameter)
							&& isPointerOperatorReference(parameter
									.getDeclarator().getPointerOperators()[0])) {
						if (parameterSpecifier.getName().toString()
								.equals(className)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Checks if it is binary.
	 * 
	 * @param node
	 *            the node
	 * @return true, if it is binary
	 */
	public static boolean isBinary(IASTNode node) {
		if (node instanceof IASTBinaryExpression) {
			return ((IASTBinaryExpression) node).getOperator() == IASTBinaryExpression.op_assign;
		}
		return false;
	}

	// to check if the node has bugs

	/**
	 * Checks if is buggy node.
	 * 
	 * @param node
	 *            the node
	 * @return true, if is buggy node
	 */
	public static boolean isBuggyNode(IASTNode node) {
		if (node instanceof IASTBinaryExpression) {
			return ((IASTBinaryExpression) node).getOperator() == IASTBinaryExpression.op_assign;
		}
		return false;
	}

	/**
	 * Checks for pointer operator.
	 * 
	 * @param parameter
	 *            the parameter
	 * @return true, if successful
	 */
	private static boolean hasPointerOperator(IASTParameterDeclaration parameter) {
		return parameter.getDeclarator().getPointerOperators().length == 1;
	}

	/**
	 * Checks if is pointer operator reference.
	 * 
	 * @param pointer
	 *            the pointer
	 * @return true, if is pointer operator reference
	 */
	private static boolean isPointerOperatorReference(
			IASTPointerOperator pointer) {
		return pointer instanceof ICPPASTReferenceOperator;
	}
}