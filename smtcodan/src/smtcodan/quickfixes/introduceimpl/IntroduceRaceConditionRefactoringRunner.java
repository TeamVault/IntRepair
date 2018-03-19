package smtcodan.quickfixes.introduceimpl;

import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.internal.ui.refactoring.RefactoringRunner;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowRefactoringRunner.
 */
@SuppressWarnings("restriction")
public class IntroduceRaceConditionRefactoringRunner extends RefactoringRunner {

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
	public IntroduceRaceConditionRefactoringRunner(ISelection selection,
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
		IntroduceRaceConditionInformation info = new IntroduceRaceConditionInformation();
		IntroduceRaceConditionRefactoring refactoring = new IntroduceRaceConditionRefactoring(
				element, selection, info);
		IntroduceRaceConditionContext context = new IntroduceRaceConditionContext(
				refactoring);
		refactoring.setContext(context);
		IntroduceRaceConditionRefactoringWizard wizard = new IntroduceRaceConditionRefactoringWizard(
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
