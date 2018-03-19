package smtcodan.quickfixes.introduceimpl.actions;

import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.ISourceReference;
import org.eclipse.cdt.core.model.IStructureDeclaration;
import org.eclipse.cdt.core.model.IWorkingCopy;
import org.eclipse.cdt.internal.ui.cview.CView;
import org.eclipse.cdt.ui.refactoring.actions.RefactoringAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.navigator.resources.ProjectExplorer;
import org.eclipse.ui.views.contentoutline.ContentOutline;

import smtcodan.quickfixes.introduceimpl.IntroduceIntegerOverflowRefactoringRunner;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowAction.
 */
@SuppressWarnings("restriction")
public class IntroduceIntegerOverflowAction extends RefactoringAction {

	/**
	 * Instantiates a new introduce buffer overflow action.
	 * 
	 * @param label
	 *            the label
	 */
	public IntroduceIntegerOverflowAction(String label) {
		super(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.ui.refactoring.actions.RefactoringAction#run(org.eclipse
	 * .jface.window.IShellProvider, org.eclipse.cdt.core.model.ICElement)
	 */
	public void run(IShellProvider shellProvider, ICElement elem) {
		if (elem instanceof ISourceReference) {
			ITextSelection sel = null;

			IWorkbenchPart part = ((IViewSite) shellProvider)
					.getWorkbenchWindow().getActivePage().getActivePart();
			// Call from Project-Explorer or C/C++ Projects
			if (part instanceof ProjectExplorer || part instanceof CView) {
				if (elem.getResource().getFileExtension().equals("c")
						|| elem.getResource().getFileExtension().equals("cpp")
						|| elem.getResource().getFileExtension().equals("h")) {
					sel = new TextSelection(0, 0);
				}
			}
			// Call from Outline
			if (part instanceof ContentOutline) {
				// Find class of selected declaration
				while (!(elem instanceof IStructureDeclaration)
						&& elem.getParent() != null
						&& !(elem.getParent() instanceof IWorkingCopy)) {
					elem = elem.getParent();
				}
				// Get selection from active Editor
				for (IWorkbenchPage page : ((IViewSite) shellProvider)
						.getWorkbenchWindow().getPages()) {
					if (sel == null) {
						if (page.getActiveEditor() != null) {
							sel = (ITextSelection) page.getActiveEditor()
									.getEditorSite().getSelectionProvider()
									.getSelection();
						} else {
							sel = new TextSelection(0, 0);
						}
					} else {
						// Editor found
						break;
					}
				}
				ICElement parent = elem;
				while (!(parent instanceof IWorkingCopy)) {
					parent = parent.getParent();
				}
			}
			// call the runner with the selection(if any), element and
			// shellProvider
			new IntroduceIntegerOverflowRefactoringRunner(sel, elem,
					shellProvider).run();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.ui.refactoring.actions.RefactoringAction#run(org.eclipse
	 * .jface.window.IShellProvider, org.eclipse.cdt.core.model.IWorkingCopy,
	 * org.eclipse.jface.text.ITextSelection)
	 */
	public void run(IShellProvider shellProvider, IWorkingCopy wc,
			ITextSelection selection) {
		new IntroduceIntegerOverflowRefactoringRunner(selection, wc,
				shellProvider).run();
	}
}
