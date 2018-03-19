/*
 * 
 */
package smtcodan.quickfixes;

import org.eclipse.cdt.codan.core.cxx.Activator;
import org.eclipse.cdt.codan.core.cxx.CxxAstUtils;
import org.eclipse.cdt.codan.internal.checkers.ui.CheckersUiActivator;
import org.eclipse.cdt.codan.ui.AbstractAstRewriteQuickFix;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTIdExpression;
import org.eclipse.cdt.core.dom.ast.IASTInitializerClause;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.INodeFactory;
import org.eclipse.cdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.cdt.core.index.IIndex;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;

import smtcodan.checkers.BoundsChecker;

// TODO: Auto-generated Javadoc
/**
 * The Class QuickFixUsingBounds.
 */
public class QuickFixUsingBounds extends AbstractAstRewriteQuickFix {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IMarkerResolution#getLabel()
	 */
	public String getLabel() {
		return "Replaces with fgets";
	}

	/**
	 * Modify ast.
	 * 
	 * @param index
	 *            the index
	 * @param marker
	 *            the marker
	 */
	public void modifyAST(IIndex index, IMarker marker) {
		// CxxAstUtils utils = CxxAstUtils.getInstance();
		IASTTranslationUnit ast;
		try {
			ITranslationUnit tu = getTranslationUnitViaEditor(marker);
			ast = tu.getAST(index, ITranslationUnit.AST_SKIP_INDEXED_HEADERS);
		} catch (CoreException e) {
			Activator.log(e);
			return;
		}
		IASTName astName;

		astName = getASTNameFromMarker(marker, ast);

		if (astName == null) {
			return;
		}
		IASTNode targetStatement = CxxAstUtils.getEnclosingStatement(astName);
		if (targetStatement == null) {
			return;
		}

		ASTRewrite r = ASTRewrite.create(ast);
		INodeFactory factory = ast.getASTNodeFactory();

		IASTInitializerClause[] arguments = new IASTInitializerClause[] {
		// stdin,
		// buffer,
		// bufsize
		};
		IASTIdExpression id = factory.newIdExpression(factory.newName("fgets"
				.toCharArray()));
		IASTExpression call = factory.newFunctionCallExpression(id, arguments);
		IASTStatement newStatement = factory.newExpressionStatement(call);

		r.replace(targetStatement, newStatement, null);
		Change c = r.rewriteAST();
		try {
			c.perform(new NullProgressMonitor());
		} catch (CoreException e) {
			CheckersUiActivator.log(e);
			return;
		}
		try {
			marker.delete();
		} catch (CoreException e) {
			CheckersUiActivator.log(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.codan.ui.AbstractCodanCMarkerResolution#isApplicable(
	 * org.eclipse.core.resources.IMarker)
	 */
	@Override
	public boolean isApplicable(IMarker marker) {
		System.out.println("is app 2 " + marker.toString());
		if (BoundsChecker.problemid.equals(getProblemId(marker))) {
			return true;
		}
		return false;
	}
}