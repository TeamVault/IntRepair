package smtcodan.quickfixes.introduceimpl;

import org.eclipse.cdt.core.dom.ast.IASTPreprocessorIncludeStatement;
import org.eclipse.cdt.core.dom.ast.IASTPreprocessorStatement;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.internal.ui.refactoring.CRefactoring;
import org.eclipse.jface.viewers.ISelection;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowCRefactoring.
 */
@SuppressWarnings("restriction")
public abstract class IntroduceIntegerOverflowCRefactoring extends CRefactoring {

	/** The info. */
	IntroduceIntegerOverflowInformation info;

	/**
	 * Instantiates a new introduce buffer overflow c refactoring.
	 * 
	 * @param celem
	 *            the celem
	 * @param selection
	 *            the selection
	 * @param info
	 *            the info
	 */
	public IntroduceIntegerOverflowCRefactoring(ICElement celem,
			ISelection selection, IntroduceIntegerOverflowInformation info) {
		super(celem, selection, null);
		this.info = info;
		name = Messages.dummy_message;
	}

	/**
	 * Exist include library.
	 * 
	 * @param libraryStmt
	 *            the library stmt
	 * @param unit
	 *            the unit
	 * @return true, if successful
	 */
	protected boolean existIncludeLibrary(String libraryStmt,
			IASTTranslationUnit unit) {
		final String INCLUDE_REPLACE_REGEX = "(<|>|\")";
		for (IASTPreprocessorStatement preprocStmt : unit
				.getAllPreprocessorStatements()) {
			if (preprocStmt instanceof IASTPreprocessorIncludeStatement) {
				IASTPreprocessorIncludeStatement include = (IASTPreprocessorIncludeStatement) preprocStmt;
				if (include
						.getName()
						.toString()
						.replaceAll(INCLUDE_REPLACE_REGEX, "")
						.equals(libraryStmt.replaceAll(INCLUDE_REPLACE_REGEX,
								""))) {
					return true;
				}
			}
		}
		return false;
	}
}
