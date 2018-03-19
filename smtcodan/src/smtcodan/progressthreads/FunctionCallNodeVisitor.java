package smtcodan.progressthreads;

import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTFieldReference;
import org.eclipse.cdt.core.dom.ast.IASTFunctionCallExpression;
import org.eclipse.cdt.core.dom.ast.IASTFunctionDefinition;
import org.eclipse.cdt.core.dom.ast.IASTIdExpression;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IBinding;

import smtcodan.ProgramStructureFacade;

// TODO: Auto-generated Javadoc
/**
 * The Class FunctionCallNodeVisitor.
 */
public class FunctionCallNodeVisitor extends ASTVisitor {

	/** The psf. */
	ProgramStructureFacade psf;

	/** The found. */
	public boolean found = false;

	/** The fdef. */
	public IASTFunctionDefinition fdef;

	/**
	 * Gets the psf.
	 *
	 * @return the psf
	 */
	public ProgramStructureFacade getPsf() {
		return psf;
	}

	/**
	 * Sets the psf.
	 *
	 * @param psf the new psf
	 */
	public void setPsf(ProgramStructureFacade psf) {
		this.psf = psf;
	}

	/**
	 * Gets the fdef.
	 *
	 * @return the fdef
	 */
	public IASTFunctionDefinition getFdef() {
		return this.fdef;
	}

	/**
	 * Sets the fdef.
	 *
	 * @param fdef the new fdef
	 */
	public void setFdef(IASTFunctionDefinition fdef) {
		this.fdef = fdef;
	}

	/**
	 * Checks if is found.
	 *
	 * @return true, if is found
	 */
	public boolean isFound() {
		return this.found;
	}

	/**
	 * Sets the found.
	 *
	 * @param found the new found
	 */
	public void setFound(boolean found) {
		this.found = found;

	}

	/**
	 * Instantiates a new function call node visitor.
	 *
	 * @param psf the psf
	 */
	public FunctionCallNodeVisitor(ProgramStructureFacade psf) {
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

		this.psf = psf;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.dom.ast.ASTVisitor#visit(org.eclipse.cdt.core.dom.ast.IASTExpression)
	 */
	public int visit(IASTExpression expr) {

		if (expr instanceof IASTFunctionCallExpression) {

			IASTFunctionCallExpression expr2 = (IASTFunctionCallExpression) expr;
			IASTExpression fcexpr = ((IASTFunctionCallExpression) expr)
					.getFunctionNameExpression();

			IASTName fname = null;
			IBinding binding = null;
			if (fcexpr instanceof IASTIdExpression) {
				fname = ((IASTIdExpression) fcexpr).getName();
			} else if (fcexpr instanceof IASTFieldReference) {

				fname = ((IASTFieldReference) fcexpr).getFieldName();
			}

			binding = fname.resolveBinding();
			if (this.psf.getCFGSFdefByFBinding(binding) != null) {
				this.setFdef(psf.getCFGSFdefByFBinding(binding));
				this.setFound(true);
				return PROCESS_ABORT;
			}
		} else if (expr instanceof IASTBinaryExpression) {
			IASTBinaryExpression binexp = (IASTBinaryExpression) expr;
			IASTExpression op1 = binexp.getOperand1();
			IASTExpression op2 = binexp.getOperand2();
			int binop = binexp.getOperator();
			if (op1 instanceof IASTFunctionCallExpression) {
				IASTName fname = null;
				IBinding binding = null;
				if (op1 instanceof IASTIdExpression) {
					fname = ((IASTIdExpression) op1).getName();
				} else if (op1 instanceof IASTFieldReference) {
					fname = ((IASTFieldReference) op1).getFieldName();
				}

				if (fname != null) {
					binding = fname.resolveBinding();
					if (this.psf.getCFGSFdefByFBinding(binding) != null) {
						this.setFdef(this.psf.getCFGSFdefByFBinding(binding));
						this.setFound(true);
						return PROCESS_ABORT;

					}
				}
			} else if (op2 instanceof IASTFunctionCallExpression) {
				IASTName fname = null;
				IBinding binding = null;

				if (op2 instanceof IASTIdExpression) {
					fname = ((IASTIdExpression) op2).getName();
				} else if (op2 instanceof IASTFieldReference) {
					fname = ((IASTFieldReference) op2).getFieldName();
				}

				if (fname != null) {
					binding = fname.resolveBinding();
					if (this.psf.getCFGSFdefByFBinding(binding) != null) {
						this.setFdef(this.psf.getCFGSFdefByFBinding(binding));
						this.setFound(true);
						return PROCESS_ABORT;
					}
				}
			}
		} else {
			this.setFound(false);
			return PROCESS_ABORT;
		}
		return PROCESS_ABORT;

	}
}
