/**
   [Class description. This class extends the ASTVisitor. It will be instantiated for each basic block available in the Interpreter.
   For each basic block a new statement processor object will be instantiated and assigned to the IASTNode which we get by casting each basic block 
   which we get in the enter method in the interpreter class]
   
   [Other notes. Each statement is checked in this class regarding his type and a new symbolic variable is added to the attribute list]
   
   @author Andreas Ibing
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.quickfixes.information.exposure;

import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTArrayModifier;
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
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTParameterDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTPointerOperator;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTypeId;
import org.eclipse.cdt.core.dom.ast.IFunction;
import org.eclipse.cdt.core.dom.ast.IParameter;

import smtcodan.quickfixes.CGNodeVisitor;

// TODO: Auto-generated Javadoc
/**
 * The Class SmProcessor.
 */
public class CGNodeVisitorInformationExposure extends ASTVisitor {

	/** The found. */
	public static boolean found = false;
	private static int storeIndex;
	private static String funcName;
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
	 */
	public CGNodeVisitorInformationExposure() {

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
	// vasantha visit is for top to bottom traversal
	public int visit(IASTExpression expr) {
		// TODO: move function call return here?
		if (expr instanceof IASTFunctionCallExpression) {

			// System.out.println("func: " + expr.getRawSignature().toString());
			IASTInitializerClause[] r = ((IASTFunctionCallExpression) expr)
					.getArguments();

			IASTExpression fcexpr = ((IASTFunctionCallExpression) expr)
					.getFunctionNameExpression();
			IFunction binding = null;
			IASTName fname = null;
			if (fcexpr instanceof IASTIdExpression) {
				fname = ((IASTIdExpression) fcexpr).getName();
			} else if (fcexpr instanceof IASTFieldReference) {
				// TODO
			}

			// setting a new buggy variable for the new context
			// if (funcName != null) {
			// if (fname.getRawSignature().toString().equals(funcName)) {
			// IASTInitializerClause[] fcexpr2 = ((IASTFunctionCallExpression)
			// expr)
			// .getArguments();
			// if (fcexpr2.length > 0 && storeIndex < fcexpr2.length) {
			// AssertInformationExposure.buggyVariable = fcexpr2[storeIndex]
			// .getRawSignature().toString();
			//
			// }
			// }
			// }

			binding = (IFunction) fname.resolveBinding();
			IParameter[] pars = binding.getParameters();
			for (int i = 0; i < pars.length; i++) {
				if (AssertInformationExposure.getBuggyVariable().equals(
						pars[i].getName())) {
					storeIndex = i;
				}

			}
			funcName = fname.getRawSignature().toString();

		}

		return PROCESS_CONTINUE;
	}

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
	// vasantha visit is for bottom to top traversal

	public int leave(IASTExpression expr) {
		// for buffer[data] = 1;
		if (expr instanceof IASTFunctionCallExpression) {
			IASTFunctionCallExpression funexp = (IASTFunctionCallExpression) expr;
			IASTExpression op1 = funexp.getFunctionNameExpression();
			String fun = op1.getRawSignature().toString();
			IASTInitializerClause[] arg = funexp.getArguments();
			String conf = "\"PATH\"";
			System.out.print(conf);
			// if our expression is a assignment
			// if (fun.equals("getenv")||fun.equals("printLine")) {
			// for(int i=0;i<arg.length;i++){
			// if(arg[i].toString().equals(conf)||arg[i].toString().equals("getenv("+"\"PATH\""+")")){
			//

			// if (AssertBufferOverflow.getBuggyVariable() != null
			// && AssertBufferOverflow.getBuggyVariable().equals(
			// op1.getRawSignature().toString())) {
			System.out.println(AssertInformationExposure.getBuggyVariable()
					+ "buggy variable");
			if (AssertInformationExposure.getBuggyVariable() != null) {
				CGNodeVisitorInformationExposure.setFound(true);
				CGNodeVisitorInformationExposure.setSourceFileLocation(funexp
						.getFileLocation());
			}
			// }
			else {
				CGNodeVisitorInformationExposure.setFound(false);
			}
			return PROCESS_CONTINUE;
			// }
			// }
		}
		return PROCESS_CONTINUE;
	}

	/**
	 * Checks if is found.
	 * 
	 * @return true, if is found
	 */
	public static boolean isFound() {
		return found;
	}

	/**
	 * Sets the found.
	 * 
	 * @param found
	 *            the new found
	 */
	public static void setFound(boolean found) {
		CGNodeVisitor.found = found;
	}

}
