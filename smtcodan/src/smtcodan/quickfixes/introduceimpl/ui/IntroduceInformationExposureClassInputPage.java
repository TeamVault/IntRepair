package smtcodan.quickfixes.introduceimpl.ui;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import smtcodan.quickfixes.Refactoring;
import smtcodan.quickfixes.information.exposure.RefactoringFinderInformationExposure;
import smtcodan.quickfixes.introduceimpl.IntroduceInformationExposureInformation;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceInformationExposureClassInputPage.
 */
public class IntroduceInformationExposureClassInputPage extends
		UserInputWizardPage {

	/** The info. */
	private IntroduceInformationExposureInformation info;

	/** The next page. */
	private IWizardPage nextPage = null;

	/** The refactor. */
	private Refactoring refactor;

	/**
	 * Instantiates a new introduce buffer overflow class input page.
	 * 
	 * @param name
	 *            the name
	 * @param info
	 *            the info
	 */
	public IntroduceInformationExposureClassInputPage(String name,
			IntroduceInformationExposureInformation info) {
		super(name);
		this.info = info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ltk.ui.refactoring.UserInputWizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		return super.getNextPage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	public void createControl(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);
		setControl(result);

		result.setLayout(new GridLayout());
		// Label infoText = new Label(result, SWT.NONE);
		final Button classRadioButton2 = new Button(result, SWT.RADIO);
		classRadioButton2
				.setText(IntroduceInformationExposureInformation.choice2);
		classRadioButton2.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub#
				String selectedItem = classRadioButton2.getText();
				IntroduceInformationExposureInformation.setChoice(selectedItem);
				if (RefactoringFinderInformationExposure.refactoringsList
						.size() > 1) {
					String s = "";
					for (int i = 1; i < RefactoringFinderInformationExposure.refactoringsList
							.size(); i++) {
						s = s
								+ RefactoringFinderInformationExposure.refactoringsList
										.get(i).getQuickFixString().toString();
					}
					((IntroduceInformationExposureDetailsInputPage) getNextPage())
							.setFixText(" Quick fix 2: " + " " + "\"" + s);
				} else {
					((IntroduceInformationExposureDetailsInputPage) getNextPage())
							.setFixText("No Pre-fix is available only quick fix is available");
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		final Button classRadioButton1 = new Button(result, SWT.RADIO);
		classRadioButton1
				.setText(IntroduceInformationExposureInformation.choice1);

		classRadioButton1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub#
				String selectedItem = classRadioButton1.getText();
				IntroduceInformationExposureInformation.setChoice(selectedItem);
				((IntroduceInformationExposureDetailsInputPage) getNextPage())
						.setFixText("Quick fix 1: "
								+ " "
								+ "\""
								+ RefactoringFinderInformationExposure.refactoringsList
										.get(0).getQuickFixString().toString());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

}
