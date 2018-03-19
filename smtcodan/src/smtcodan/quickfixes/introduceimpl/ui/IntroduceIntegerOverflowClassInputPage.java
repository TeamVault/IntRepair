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
import smtcodan.quickfixes.integer.overflow.RefactoringFinderIntegerOverflow;
import smtcodan.quickfixes.introduceimpl.IntroduceIntegerOverflowInformation;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowClassInputPage.
 */
public class IntroduceIntegerOverflowClassInputPage extends UserInputWizardPage {

	/** The info. */
	private IntroduceIntegerOverflowInformation info;

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
	public IntroduceIntegerOverflowClassInputPage(String name,
			IntroduceIntegerOverflowInformation info) {
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
	@Override
	public void createControl(Composite parent) {
		Composite result = new Composite(parent, SWT.NONE);
		setControl(result);

		result.setLayout(new GridLayout());
		// Label infoText = new Label(result, SWT.NONE);

		// not in place quick fix
		final Button classRadioButton2 = new Button(result, SWT.RADIO);
		classRadioButton2.setText(IntroduceIntegerOverflowInformation.choice2);
		classRadioButton2.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub#
				String selectedItem = classRadioButton2.getText();
				IntroduceIntegerOverflowInformation.setChoice(selectedItem);
				// if (RefactoringFinderIntegerOverflow.refactoringsList.size()
				// > 1) {
				// String s = "";
				// for (int i = 1; i <
				// RefactoringFinderIntegerOverflow.refactoringsList
				// .size(); i++) {
				// s = s
				// + RefactoringFinderIntegerOverflow.refactoringsList
				// .get(i).getQuickFixString().toString();
				// }
				// ((IntroduceIntegerOverflowDetailsInputPage) getNextPage())
				// .setFixText(" Quick fix 2: " + " " + "\""
				// + s.replaceAll("((?!\n+)\\s+)", " ") + "\"");
				// } else {
				// ((IntroduceIntegerOverflowDetailsInputPage) getNextPage())
				// .setFixText("No Pre-fix is available only quick fix is available");
				// }

				// Notice: for integer overflow bugs we do not have currently
				// any not in-place repairs
				((IntroduceIntegerOverflowDetailsInputPage) getNextPage())
						.setFixText("Not in-place quick-fix (repair) not available");
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// in place quick fix
		final Button classRadioButton1 = new Button(result, SWT.RADIO);
		classRadioButton1.setText(IntroduceIntegerOverflowInformation.choice1);

		classRadioButton1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub#
				String selectedItem = classRadioButton1.getText();
				IntroduceIntegerOverflowInformation.setChoice(selectedItem);
				((IntroduceIntegerOverflowDetailsInputPage) getNextPage())
						.setFixText(RefactoringFinderIntegerOverflow.refactoringsList
								.get(0).getQuickFixString().toString());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}
}
