package smtcodan.quickfixes.introduceimpl;

import org.eclipse.cdt.core.model.ICElement;

import org.eclipse.cdt.internal.ui.refactoring.RefactoringRunner;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;

import smtcodan.PSProblem;


// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowRefactoringRunner.
 */
@SuppressWarnings("restriction")
public class IntroduceIntegerOverflowRefactoringRunner extends RefactoringRunner {

	/**
	 * Instantiates a new introduce buffer overflow refactoring runner.
	 * 
	 * @param selection
	 *            the selection
	 * @param element
	 *            the element
	 * @param shellProvider
	 *            the shell provider
	 */
	public IntroduceIntegerOverflowRefactoringRunner(ISelection selection,
			ICElement element, IShellProvider shellProvider) {
		super(element, selection, shellProvider, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.internal.ui.refactoring.RefactoringRunner#run()
	 */
	@Override
	public void run() {
		IntroduceIntegerOverflowInformation info = new IntroduceIntegerOverflowInformation();
		IntroduceIntegerOverflowRefactoring refactoring = new IntroduceIntegerOverflowRefactoring(
				element, selection, info);
		IntroduceIntegerOverflowContext context = new IntroduceIntegerOverflowContext(
				refactoring);
		refactoring.setContext(context);
		IntroduceIntegerOverflowRefactoringWizard wizard = new IntroduceIntegerOverflowRefactoringWizard(
				refactoring, info);

		RefactoringWizardOpenOperation operator = new RefactoringWizardOpenOperation(
				wizard);
		try {
			operator.run(shellProvider.getShell(), refactoring.getName());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} finally {
			context.dispose();
		}
	}
		
	}
		