package smtcodan.quickfixes.introduceimpl;

import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

import smtcodan.quickfixes.introduceimpl.ui.IntroduceIntegerOverflowClassInputPage;
import smtcodan.quickfixes.introduceimpl.ui.IntroduceIntegerOverflowDetailsInputPage;

// TODO: Auto-generated Javadoc
/**
 * The wizard page for Introduce PImpl Refactoring, creates the UI page.
 */
public class IntroduceIntegerOverflowRefactoringWizard extends RefactoringWizard {

	/** The info. */
	private IntroduceIntegerOverflowInformation info;
	public static boolean abortedWizard = false;

	/**
	 * Instantiates a new introduce buffer overflow refactoring wizard.
	 * 
	 * @param refactoring
	 *            the refactoring
	 * @param info
	 *            the info
	 */
	public IntroduceIntegerOverflowRefactoringWizard(Refactoring refactoring,
			IntroduceIntegerOverflowInformation info) {
		super(refactoring, WIZARD_BASED_USER_INTERFACE);
		this.info = info;
	}

	public boolean performCancel() {
		abortedWizard = true;
		return true;
	}

	// public boolean canFinish() {
	// System.out.println("rr1");
	// CodanMarkerProblemReporter marker = new CodanMarkerProblemReporter();
	// marker.deleteAllProblems();
	// return false;
	//
	// }

	// public boolean performFinish() {
	// System.out.println("rr1");
	// CodanMarkerProblemReporter marker = new CodanMarkerProblemReporter();
	// marker.deleteAllProblems();
	// return true;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.ui.refactoring.RefactoringWizard#addUserInputPages()
	 */
	protected void addUserInputPages() {
		IntroduceIntegerOverflowClassInputPage chooseClassPage = new IntroduceIntegerOverflowClassInputPage(
				Messages.IntroduceBufferOverflow_Choosetheoption, this.info);
		chooseClassPage.setTitle("Select the option below");
		addPage(chooseClassPage);
		IntroduceIntegerOverflowDetailsInputPage chooseDetailsPage = new IntroduceIntegerOverflowDetailsInputPage(
				Messages.IntroduceBufferOverflow_Choosetheoption, this.info);
		chooseDetailsPage
				.setTitle("The refactory for the previous choosen option");
		addPage(chooseDetailsPage);

	}
}
