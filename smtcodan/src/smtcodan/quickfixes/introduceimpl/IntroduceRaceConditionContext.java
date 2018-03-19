package smtcodan.quickfixes.introduceimpl;

import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTMacroExpansionLocation;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTNodeLocation;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.index.IIndexName;
import org.eclipse.cdt.internal.ui.refactoring.CRefactoring;
import org.eclipse.cdt.internal.ui.refactoring.CRefactoringContext;
import org.eclipse.cdt.internal.ui.refactoring.Container;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.Region;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowContext.
 */
@SuppressWarnings("restriction")
public class IntroduceRaceConditionContext extends CRefactoringContext {

	/**
	 * Instantiates a new introduce buffer overflow context.
	 * 
	 * @param refactoring
	 *            the refactoring
	 */
	public IntroduceRaceConditionContext(CRefactoring refactoring) {
		super(refactoring);
	}

	/**
	 * Find declaration in translation unit.
	 * 
	 * @param transUnit
	 *            the trans unit
	 * @param indexName
	 *            the index name
	 * @return the IAST name
	 */
	public IASTName findDeclarationInTranslationUnit(
			IASTTranslationUnit transUnit, final IIndexName indexName) {
		final Container<IASTName> defName = new Container<IASTName>();
		transUnit.accept(new ASTVisitor() {
			{
				shouldVisitNames = true;
			}

			@Override
			public int visit(IASTName name) {
				if (name.isDeclaration() && name.getNodeLocations().length > 0) {
					IASTNodeLocation nodeLocation = name.getNodeLocations()[0];
					if (indexName.getNodeOffset() == nodeLocation
							.getNodeOffset()
							&& indexName.getNodeLength() == nodeLocation
									.getNodeLength()
							&& new Path(indexName.getFileLocation()
									.getFileName())
									.equals(new Path(nodeLocation
											.asFileLocation().getFileName()))) {
						defName.setObject(name);
						return ASTVisitor.PROCESS_ABORT;
					}
				}
				return ASTVisitor.PROCESS_CONTINUE;
			}
		});
		return defName.getObject();
	}

	/**
	 * Checks if is selection on expression.
	 * 
	 * @param textSelection
	 *            the text selection
	 * @param expression
	 *            the expression
	 * @return true, if is selection on expression
	 */
	public boolean isSelectionOnExpression(Region textSelection,
			IASTNode expression) {
		int start = 0;
		int nodeLength = 0;
		IASTNodeLocation[] nodeLocations = expression.getNodeLocations();
		Region exprPos = new Region(start, nodeLength);
		if (nodeLocations.length != 1) {
			for (int i = nodeLocations.length - 1; 0 <= i; i--) {
				if (nodeLocations[i] instanceof IASTMacroExpansionLocation) {
					exprPos = getRegion(nodeLocations[i]);
					break;
				}
			}
		} else if (nodeLocations[0] instanceof IASTMacroExpansionLocation) {
			exprPos = getRegion(nodeLocations[0]);
		} else {
			start = expression.getFileLocation().getNodeOffset();
			nodeLength = expression.getFileLocation().getNodeLength();
			exprPos = new Region(start, nodeLength);
		}
		int selStart = textSelection.getOffset();
		int selEnd = textSelection.getLength() + selStart;
		return exprPos.getOffset() + exprPos.getLength() >= selStart
				&& exprPos.getOffset() <= selEnd;
	}

	/**
	 * Gets the region.
	 * 
	 * @param nodeLocations
	 *            the node locations
	 * @return the region
	 */
	private static Region getRegion(IASTNodeLocation nodeLocations) {
		int start = nodeLocations.asFileLocation().getNodeOffset();
		int nodeLength = nodeLocations.asFileLocation().getNodeLength();
		return new Region(start, nodeLength);
	}
}
