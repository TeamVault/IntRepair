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
import smtcodan.quickfixes.introduceimpl.IntroduceRaceConditionInformation;
import smtcodan.quickfixes.race.condition.RefactoringFinderRaceCondition;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowClassInputPage.
 */
public class IntroduceRaceConditionClassInputPage extends UserInputWizardPage {

	/** The info. */
	private IntroduceRaceConditionInformation info;

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
	public IntroduceRaceConditionClassInputPage(String name,
			IntroduceRaceConditionInformation info) {
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

		final Button classRadioButton1 = new Button(result, SWT.RADIO);
		classRadioButton1.setText(IntroduceRaceConditionInformation.choice1);

		classRadioButton1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub#
				String selectedItem = classRadioButton1.getText();
				IntroduceRaceConditionInformation.setChoice(selectedItem);
				((IntroduceRaceConditionDetailsInputPage) getNextPage())
						.setFixText("Quick fix 1: "
								+ " "
								+ "\""
								+ RefactoringFinderRaceCondition.refactoringsList
										.get(0).getQuickFixString().toString()

										.replaceAll("\n+", " ") + "\"");
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

}
