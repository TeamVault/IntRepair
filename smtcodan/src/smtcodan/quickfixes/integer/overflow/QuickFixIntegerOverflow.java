/*
 * 
 */

package smtcodan.quickfixes.integer.overflow;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.cdt.codan.internal.core.model.CodanMarkerProblemReporter;
import org.eclipse.cdt.codan.internal.core.model.CodanProblemMarker;
import org.eclipse.cdt.codan.internal.ui.cxx.Activator;
import org.eclipse.cdt.codan.ui.AbstractCodanCMarkerResolution;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.internal.ui.editor.CEditor;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.FindReplaceDocumentAdapter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import smtcodan.Config;
import smtcodan.ProgramStructureFacade;
import smtcodan.WorkPool;
import smtcodan.checkers.BoundsChecker;
import smtcodan.interpreter.Interpreter;
import smtcodan.logger.StatementLogger;
import smtcodan.quickfixes.Refactoring;
import smtcodan.quickfixes.RefactoringType;
import smtcodan.quickfixes.SMTConstraintObject;
import smtcodan.quickfixes.introduceimpl.IntroduceIntegerOverflowRefactoringWizard;
import smtcodan.quickfixes.introduceimpl.Messages;
import smtcodan.quickfixes.introduceimpl.actions.IntroduceIntegerOverflowAction;

// TODO: Auto-generated Javadoc
/**
 * quick fix for assignment in condition.
 */
public class QuickFixIntegerOverflow extends AbstractCodanCMarkerResolution {

	/** The replace string. */
	public static String replaceStringNew;

	/** The replace string old. */
	public static String replaceStringOld;

	/** The quick fix. */
	public static String quickFix;

	/** The logic op. */
	private static AssertIntegerOverflow logicOperation;

	/** The linear system. */
	public static SMTConstraintObject ob;

	/** The codan problem. */
	private boolean codanProblem;

	private static Interpreter ps;

	public static Interpreter getPs() {
		return ps;
	}

	public void setPs(Interpreter ps) {
		this.ps = ps;
	}

	/**
	 * Gets the ob.
	 * 
	 * @return the ob
	 */
	public static SMTConstraintObject getOb() {
		return ob;
	}

	/**
	 * Sets the ob.
	 * 
	 * @param ob1
	 *            the new ob
	 */
	public static void setOb(SMTConstraintObject ob1) {
		ob = ob1;
	}

	/**
	 * Gets the quick fix.
	 * 
	 * @return the quick fix
	 */
	public static String getQuickFixValue() {
		return quickFix;
	}

	/**
	 * Sets the quick fix.
	 * 
	 * @param quickFix
	 *            the new quick fix
	 */
	public static void setQuickFixValue(String quickFix) {
		QuickFixIntegerOverflow.quickFix = quickFix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IMarkerResolution#getLabel()
	 */
	public String getLabel() {
		String quickFixProposal = "Quick fix available ";
		// + getQuickFixValue();
		return quickFixProposal;
	}

	/**
	 * Gets the replace string.
	 * 
	 * @return the replace string
	 */
	public static String getReplaceStringNew() {
		return QuickFixIntegerOverflow.replaceStringNew;
	}

	/**
	 * Sets the replace string new.
	 * 
	 * @param replaceString
	 *            the new replace string new
	 */
	public void setReplaceStringNew(String replaceString) {
		QuickFixIntegerOverflow.replaceStringNew = replaceString;
	}

	/**
	 * Gets the replace string old.
	 * 
	 * @return the replace string old
	 */
	public static String getReplaceStringOld() {
		return QuickFixIntegerOverflow.replaceStringOld;
	}

	/**
	 * Sets the replace string.
	 * 
	 * @param replaceString
	 *            the new replace string
	 */
	public static void setReplaceStringOld(String replaceString) {
		QuickFixIntegerOverflow.replaceStringOld = replaceString;
	}

	/** The forward. */
	ArrayList<String> forward = new ArrayList<String>();

	/** The backward. */
	ArrayList<String> backward = new ArrayList<String>();

	/**
	 * Forward_list.
	 * 
	 * @param f
	 *            the f
	 */
	public void forward_list(String f) {
		forward.add(f);
		StatementLogger.log_navigation("forward navigation");

	}

	/**
	 * Backward_list.
	 * 
	 * @param b
	 *            the b
	 */
	public void backward_list(String b) {
		backward.add(b);
		StatementLogger.log_navigation("backward navigation");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.codan.ui.AbstractCodanCMarkerResolution#isApplicable(
	 * org.eclipse.core.resources.IMarker)
	 */
	@Override
	public boolean isApplicable(IMarker marker) {
		if (getProblemMessage(marker) != null
				&& getProblemMessage(marker)
						.equals(AssertIntegerOverflow.INTEGER_OVERFLOW_QUICK_FIX_MESSAGE)
				|| getProblemMessage(marker)
						.equals(AssertIntegerOverflow.INTEGER_OVERFLOW_BUG_LOCATION_MESSAGE)) {
			// set the constrain var and value
			setTheConstraintVarAndValueFromMarker(getProblemMessage(marker));
			return true;
		} else if (marker.equals("Quick fix available")) {
			return true;
		}
		return false;
	}

	/**
	 * Sets the the constraint var and value.
	 * 
	 * @param problemMessage
	 *            the new the constraint var and value
	 */
	/**
	 * Sets the the constraint var and value.
	 * 
	 * @param problemMessage
	 *            the new the constraint var and value
	 */
	public void setTheConstraintVarAndValueFromMarker(String problemMessage) {

		if (getOb() != null) {
			if ((getOb().getBufferSize() != null)
					&& getOb().getLinearSystem() != null) {
				// decision algorithm skipped for now, here the decision
				// algorithm should go in
				// here we should decide which concrete class to use
				/**
				 * here it should be decided which type of bug we are dealing
				 * with so that the right class containing the suited quick fix
				 * is selected. Currently we know that it is a buffer overflow
				 * from the marker message. This is why we use the
				 * AssertBufferOverflow class. This can be decided based on the
				 * bug message.
				 */

				String option = problemMessage;
				switch (option) {
				case "Quick-Fix Location":
					logicOperation = new AssertIntegerOverflow();
					break;
				case "Lower array bound violation":
					logicOperation = new AssertIntegerOverflow();
					break;
				case "Upper array bound violation":
					logicOperation = new AssertIntegerOverflow();
					break;
				case "Integer Overflow Error Detected":
					logicOperation = new AssertIntegerOverflow();
					break;

				default:
					// to do
					break;
				}
				String value = logicOperation.createLinearSystem(getOb());
				setQuickFixValue(value);
			}
		}
		ArrayList<String> arguments = new ArrayList<String>();
		StringTokenizer st = null;
		if (problemMessage
				.equals(AssertIntegerOverflow.INTEGER_OVERFLOW_QUICK_FIX_MESSAGE)) {
			// here the a statement processor could be used to he the components
			// of an expression
			st = new StringTokenizer(getReplaceStringNew(), ",;;[ ]", true);
		} else if (problemMessage.equals(BoundsChecker.problemMessageLower)
				|| problemMessage.equals(BoundsChecker.problemMessageUpper)) {
			st = new StringTokenizer(getReplaceStringOld(), ",;;[ ]", true);
		} else {
			st = new StringTokenizer(getReplaceStringOld(), ",;;[ ]", true);
		}

		if (st != null)
			while (st.hasMoreTokens()) {
				arguments.add(st.nextToken());
			}

		int len = arguments.size();
		int i = 0;
		boolean found = false;
		while (i < len && found == false) {
			StatementLogger.log_quickFixes("The args: " + arguments.get(i));
			if ((arguments.get(i).equals(";") && logicOperation != null)) {
				// we don't need the last ) from the substring, so it will be
				// removed
				String str = arguments.get(i - 1).substring(0,
						arguments.get(i - 1).length());
				logicOperation.setBuggyVariable(str);
				logicOperation.setConstraintValue(getQuickFixValue());

				found = true;
			}

			if ((arguments.get(i).equals("]") && logicOperation != null)) {
				String str = arguments.get(i - 1);
				logicOperation.setBuggyVariable(str);
				logicOperation.setConstraintValue(getQuickFixValue());

				found = true;
			}
			i++;
		}
	}

	/**
	 * Creates the local refactoring object.
	 * 
	 * @param refactoring
	 *            the refactoring
	 * @param node
	 *            the node
	 * @return the refactoring
	 */
	public Refactoring createLocalRefactoringObject(Refactoring refactoring,
			IASTNode node, WorkPool workPool) {

		refactoring.setReplaceString(logicOperation.getBuggyVariable());
		refactoring.setReplaceStatement(getReplaceStringOld());

		refactoring.setReplaceStatementNode(node);

		String[] bits = RefactoringFinderIntegerOverflow.getInitialBugFile()
				.getFileName().split("/");
		String lastOne = bits[bits.length - 1];

		refactoring.setSourceFileName(lastOne);

		refactoring.setQuickFixValue(getQuickFixValue());
		refactoring.setQuickFixString(AssertIntegerOverflow
				.getIntegerOverflowQuickFixString(workPool, node));
		refactoring.setSourceFileLocation(RefactoringFinderIntegerOverflow
				.getInitialBugFile());
		refactoring
				.setMarker(AssertIntegerOverflow.INTEGER_OVERFLOW_BUG_LOCATION_MESSAGE);
		refactoring.setLineNumber(RefactoringFinderIntegerOverflow
				.getInitialBugFile().getStartingLineNumber());

		refactoring.setType(RefactoringType.latestRefactoring);

		ArrayList<ITranslationUnit> tulist = ProgramStructureFacade.tulist;
		for (ITranslationUnit tu : tulist) {
			if (tu.getElementName().equals(refactoring.getSourceFileName())) {
				refactoring.setTu(tu);
			}
		}

		return refactoring;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.codan.ui.AbstractCodanCMarkerResolution#getProblemMessage
	 * (org.eclipse.core.resources.IMarker)
	 */
	@Override
	public String getProblemMessage(IMarker marker) {
		return CodanProblemMarker.getMessage(marker);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.codan.ui.AbstractCodanCMarkerResolution#apply(org.eclipse
	 * .core.resources.IMarker, org.eclipse.jface.text.IDocument)
	 */
	@Override
	public void apply(IMarker marker, IDocument document) {

		// start re-factoring wizard

		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchWindow window = win;
		// start re-factoring action
		IntroduceIntegerOverflowAction pimplAction = new IntroduceIntegerOverflowAction(
				Messages.dummy_message);

		if (window.getActivePage().getActivePart() instanceof CEditor) {
			pimplAction.setEditor(window.getActivePage().getActiveEditor());
			pimplAction.run();

		}

		// after the quick fix was inserted delete the marker
		// the cancel and finish buttons were not pressed
		if (!IntroduceIntegerOverflowRefactoringWizard.abortedWizard) {
			try {
				marker.delete();
				// remove all markers if the quick fixes were inserted
				CodanMarkerProblemReporter marker2 = new CodanMarkerProblemReporter();
				marker2.deleteAllProblems();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// set again on false
		IntroduceIntegerOverflowRefactoringWizard.abortedWizard = false;

		// disable quick fix insertion after the wizard has completed
		if (!Config.disableInPlaceQuickFixInsertion) {
			int pos = getOffset(marker, document);
			try {
				FindReplaceDocumentAdapter dad = new FindReplaceDocumentAdapter(
						document);
				StatementLogger.log_navigation(getProblemMessage(marker));

				// for quick fixes in previous nodes
				if (marker != null
						&& AssertIntegerOverflow.INTEGER_OVERFLOW_QUICK_FIX_MESSAGE != null
						&& getProblemMessage(marker) != null)
					if (getProblemMessage(marker)
							.equals(AssertIntegerOverflow.INTEGER_OVERFLOW_QUICK_FIX_MESSAGE)) {
						dad.find(pos, getReplaceStringNew(),
						/* forwardSearch *///$NON-NLS-1$
								false,
								/* caseSensitive */
								false,
								/* wholeWord */
								false,
								/* regExSearch */
								false);
						dad.replace(
								getReplaceStringNew()
										+ "\n"
										+ "\t"
										+ "\t"
										+ "\t"
										+ AssertIntegerOverflow
												.getIntegerOverflowQuickFixString(
														"bla1", "bla2"), false);
						// after the quick fix was inserted delete the marker
						if (RefactoringFinderIntegerOverflow.eraseQuickFixMarker) {
							marker.delete();
						}
						// buffer overflows
					} else if (getProblemMessage(marker).equals(
							BoundsChecker.problemMessageLower)
							|| getProblemMessage(marker).equals(
									BoundsChecker.problemMessageUpper)) {
						dad.find(pos, getReplaceStringOld(),
						/* forwardSearch *///$NON-NLS-1$
								false,
								/* caseSensitive */
								false,
								/* wholeWord */
								false,
								/* regExSearch */
								false);
						// for quick fix in the place where the bug was
						// discovered
						dad.replace(
								AssertIntegerOverflow
										.getIntegerOverflowQuickFixString(
												"bla1", "bla2")
										+ "\n"
										+ "\t"
										+ "\t"
										+ "\t"
										+ getReplaceStringOld(), false);
						// after the quick fix was inserted delete the marker
						if (RefactoringFinderIntegerOverflow.eraseQuickFixMarker) {
							marker.delete();
						}
					}

			} catch (BadLocationException e) {
				Activator.log(e);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}