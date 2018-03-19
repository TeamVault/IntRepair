package smtcodan.quickfixes.introduceimpl;

import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;

import smtcodan.quickfixes.introduceimpl.ui.IntroduceInformationExposureClassInputPage;
import smtcodan.quickfixes.introduceimpl.ui.IntroduceInformationExposureDetailsInputPage;

// TODO: Auto-generated Javadoc
/**
 * The wizard page for Introduce PImpl Refactoring, creates the UI page.
 */
public class IntroduceInformationExposureRefactoringWizard extends RefactoringWizard {

	/** The info. */
	private IntroduceInformationExposureInformation info;
	public static boolean abortedWizard = false;

	/**
	 * Instantiates a new introduce buffer overflow refactoring wizard.
	 * 
	 * @param refactoring
	 *            the refactoring
	 * @param info
	 *            the info
	 */
	public IntroduceInformationExposureRefactoringWizard(Refactoring refactoring,
			IntroduceInformationExposureInformation info) {
		super(refactoring, WIZARD_BASED_USER_INTERFACE);
		this.info = info;
	}

	public boolean performCancel() {
		abortedWizard = true;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.ui.refactoring.RefactoringWizard#addUserInputPages()
	 */
	protected void addUserInputPages() {
		IntroduceInformationExposureClassInputPage chooseClassPage = new IntroduceInformationExposureClassInputPage(
				Messages.IntroduceInformationExposure_Choosetheoption, this.info);
		chooseClassPage.setTitle("Select the option below");
		addPage(chooseClassPage);
		IntroduceInformationExposureDetailsInputPage chooseDetailsPage = new IntroduceInformationExposureDetailsInputPage(
				Messages.IntroduceInformationExposure_Choosetheoption, this.info);
		chooseDetailsPage
				.setTitle("The refactory for the previous choosen option");
		addPage(chooseDetailsPage);

	}
}
