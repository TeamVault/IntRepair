package smtcodan.quickfixes.introduceimpl.node;

import org.eclipse.cdt.core.dom.ast.IASTDeclarator;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTFunctionDeclarator;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTNamedTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTQualifiedName;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTVisibilityLabel;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTDeclarator;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDeclarator;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTFunctionDefinition;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTName;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTNamedTypeSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTParameterDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTQualifiedName;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTReferenceOperator;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclSpecifier;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTSimpleDeclaration;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTVisibilityLabel;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Node objects.
 */
@SuppressWarnings("restriction")
public class NodeFactory {

	/**
	 * Creates a new Node object.
	 * 
	 * @param functionDefinition
	 *            the function definition
	 * @return the IAST simple declaration
	 */
	public static IASTSimpleDeclaration createDeclarationFromDefinition(
			ICPPASTFunctionDefinition functionDefinition) {
		IASTSimpleDeclaration declaration = new CPPASTSimpleDeclaration();
		declaration.setDeclSpecifier(functionDefinition.getDeclSpecifier()
				.copy());
		ICPPASTFunctionDeclarator declarator = (ICPPASTFunctionDeclarator) functionDefinition
				.getDeclarator().copy();
		IASTName memberName = declarator.getName();
		if (memberName instanceof ICPPASTQualifiedName) {
			memberName = memberName.getLastName();
		}
		declarator.setName(memberName);
		declaration.addDeclarator(declarator);
		return declaration;
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param classname
	 *            the classname
	 * @param hasQuallifiedName
	 *            the has quallified name
	 * @param parameters
	 *            the parameters
	 * @param isDestructor
	 *            the is destructor
	 * @return the ICPPAST function definition
	 */
	private static ICPPASTFunctionDefinition createStructorDefinition(
			String classname, boolean hasQuallifiedName,
			IASTParameterDeclaration[] parameters, boolean isDestructor) {
		ICPPASTFunctionDefinition constructorDefinition = new CPPASTFunctionDefinition();
		ICPPASTFunctionDeclarator constructorDeclarator = new CPPASTFunctionDeclarator();
		String name = classname;
		if (isDestructor) {
			name = "~" + classname;
		}
		IASTName astname = new CPPASTName(name.toCharArray());
		if (hasQuallifiedName) {
			CPPASTQualifiedName qname = new CPPASTQualifiedName();
			qname.addName(new CPPASTName(classname.toCharArray()));
			qname.addName(new CPPASTName(name.toCharArray()));
			astname = qname;
		}
		constructorDeclarator.setName(astname);
		if (parameters != null) {
			for (IASTParameterDeclaration parameter : parameters) {
				constructorDeclarator.addParameterDeclaration(parameter.copy());
			}
		}
		constructorDefinition.setDeclarator(constructorDeclarator);
		constructorDefinition.setDeclSpecifier(new CPPASTSimpleDeclSpecifier());

		return constructorDefinition;
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param classname
	 *            the classname
	 * @param hasQuallifiedName
	 *            the has quallified name
	 * @param parameters
	 *            the parameters
	 * @return the ICPPAST function definition
	 */
	public static ICPPASTFunctionDefinition createConstructorDefinition(
			String classname, boolean hasQuallifiedName,
			IASTParameterDeclaration[] parameters) {
		return createStructorDefinition(classname, hasQuallifiedName,
				parameters, false);
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param classname
	 *            the classname
	 * @param hasQuallifiedName
	 *            the has quallified name
	 * @return the ICPPAST function definition
	 */
	public static ICPPASTFunctionDefinition createDestructorDefinition(
			String classname, boolean hasQuallifiedName) {
		return createStructorDefinition(classname, hasQuallifiedName, null,
				true);
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param classname
	 *            the classname
	 * @param hasQuallifiedName
	 *            the has quallified name
	 * @return the ICPPAST function definition
	 */
	public static ICPPASTFunctionDefinition createBasicConstructorDefinition(
			String classname, boolean hasQuallifiedName) {
		return createConstructorDefinition(classname, hasQuallifiedName, null);
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param classname
	 *            the classname
	 * @param paramName
	 *            the param name
	 * @return the ICPPAST function definition
	 */
	public static ICPPASTFunctionDefinition createCopyConstructorDefinition(
			String classname, String paramName) {
		IASTParameterDeclaration[] paramList = new IASTParameterDeclaration[1];
		paramList[0] = createCopyParameter(classname, paramName);
		ICPPASTFunctionDefinition constructorDefinition = createConstructorDefinition(
				classname, true, paramList);
		return constructorDefinition;
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param classname
	 *            the classname
	 * @param paramName
	 *            the param name
	 * @return the ICPPAST parameter declaration
	 */
	private static ICPPASTParameterDeclaration createCopyParameter(
			String classname, String paramName) {
		ICPPASTParameterDeclaration paramDeclaration = new CPPASTParameterDeclaration();
		ICPPASTNamedTypeSpecifier paramTypeSpec = new CPPASTNamedTypeSpecifier();
		paramTypeSpec.setConst(true);
		paramTypeSpec.setName(new CPPASTName(classname.toCharArray()));
		paramDeclaration.setDeclSpecifier(paramTypeSpec);
		IASTDeclarator paramDeclarator = new CPPASTDeclarator();
		paramDeclarator.addPointerOperator(new CPPASTReferenceOperator(false));
		paramDeclarator.setName(new CPPASTName(paramName.toCharArray()));
		paramDeclaration.setDeclarator(paramDeclarator);
		return paramDeclaration;
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param className
	 *            the class name
	 * @param classType
	 *            the class type
	 * @return the IAST simple declaration
	 */
	public static IASTSimpleDeclaration createClassDeclaration(
			String className, int classType) {
		CPPASTCompositeTypeSpecifier classSpecifier = new CPPASTCompositeTypeSpecifier();
		classSpecifier.setName(new CPPASTName(className.toCharArray()));
		classSpecifier.setKey(classType);
		CPPASTSimpleDeclaration classDeclaration = new CPPASTSimpleDeclaration();
		classDeclaration.setDeclSpecifier(classSpecifier);
		return classDeclaration;
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param visibility
	 *            the visibility
	 * @return the ICPPAST visibility label
	 */
	public static ICPPASTVisibilityLabel createVisibilityLabel(int visibility) {
		ICPPASTVisibilityLabel visibilityLabel = new CPPASTVisibilityLabel(
				visibility);
		visibilityLabel.setVisibility(visibility);
		return visibilityLabel;
	}

	/**
	 * Creates a new Node object.
	 * 
	 * @param string
	 *            the string
	 * @param b
	 *            the b
	 * @param operandsList
	 *            the operands list
	 * @return the ICPPAST binary expression
	 */
	public static ICPPASTBinaryExpression createBinaryExpressionDefinition(
			String string, boolean b, IASTExpression operandsList) {
		// TODO Auto-generated method stub
		return null;
	}
}