/*
 * 
 */

package smtcodan.quickfixes.information.exposure;

import java.util.ArrayList;
import java.util.HashMap;
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
import smtcodan.checkers.InformationExposureChecker;
import smtcodan.logger.StatementLogger;
import smtcodan.multithreadanalysis.checkers.RaceChecker;
import smtcodan.pathgen.ProgramPathIBB;
import smtcodan.quickfixes.Refactoring;
import smtcodan.quickfixes.RefactoringType;
import smtcodan.quickfixes.SMTConstraintObject;
import smtcodan.quickfixes.introduceimpl.IntroduceInformationExposureRefactoringWizard;
import smtcodan.quickfixes.introduceimpl.Messages;
import smtcodan.quickfixes.introduceimpl.actions.IntroduceInformationExposureAction;

// TODO: Auto-generated Javadoc
/**
 * quick fix for assignment in condition.
 */
public class QuickFixInformationExposure extends AbstractCodanCMarkerResolution {

	/** The replace string. */
	public static String replaceStringNew;

	/** The replace string old. */
	public static String replaceStringOld;

	/** The quick fix. */
	public static String quickFix;

	/** The logic op. */
	private static AssertInformationExposure logicOperation;

	/** The linear system. */
	public static SMTConstraintObject ob;

	/** The codan problem. */
	private boolean codanProblem;

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
		QuickFixInformationExposure.quickFix = quickFix;
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
		return QuickFixInformationExposure.replaceStringNew;
	}

	/**
	 * Sets the replace string new.
	 * 
	 * @param replaceString
	 *            the new replace string new
	 */
	public void setReplaceStringNew(String replaceString) {
		QuickFixInformationExposure.replaceStringNew = replaceString;
	}

	/**
	 * Gets the replace string old.
	 * 
	 * @return the replace string old
	 */
	public static String getReplaceStringOld() {
		return QuickFixInformationExposure.replaceStringOld;
	}

	/**
	 * Sets the replace string.
	 * 
	 * @param replaceString
	 *            the new replace string
	 */
	public static void setReplaceStringOld(String replaceString) {
		QuickFixInformationExposure.replaceStringOld = replaceString;
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
	//vasantha here you have to check the problem message and then get the node to be refactored
	@Override
	public boolean isApplicable(IMarker marker) {
		if (getProblemMessage(marker) != null
				&& getProblemMessage(marker).equals(
						InformationExposureChecker.problemMessageInfoFlowChecker)||
						getProblemMessage(marker) != null
						&& getProblemMessage(marker).equals(
								InformationExposureChecker.problemMessageInfoFlowChecker_localizer)) {
			// set the constrain var and value
			setTheConstraintVarAndValueFromMarker(getProblemMessage(marker));
			return true;
		} else if (marker.equals("Quick fix available for Information Exposure")) {
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
	public void setTheConstraintVarAndValueFromMarker(String problemMessage) {
   	      logicOperation = new AssertInformationExposure();

		ArrayList<String> arguments = new ArrayList<String>();
		StringTokenizer st = null;
		if (problemMessage
				.equals(AssertInformationExposure.INFORMATION_EXPOSURE_QUICK_FIX_MESSAGE)) {
			st = new StringTokenizer(getReplaceStringNew(), ",;;( )", true);
		} else {
			st = new StringTokenizer(getReplaceStringOld(), ",;;( )", true);
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
			if (arguments.get(i).equals(logicOperation.getBuggyVariable())) {
//			
//				String str = arguments.get(i - 1).substring(0,
//						arguments.get(i - 1).length());
//				logicOperation.setBuggyVariable(str);

				found = true;
			}

			i++;
		}
	}

	/**
	 * Creates the pre refactoring object.
	 * 
	 * @param refactoring
	 *            the refactoring
	 * @param node
	 *            the node
	 * @param workPool 
	 * @param programPathsmap 
	 * @return the refactoring
	 */
	// vasantha
	public Refactoring createPreRefactoringObject(Refactoring refactoring,
			IASTNode node, HashMap<String, ProgramPathIBB> programPathsmap, WorkPool workPool) {

			refactoring.setReplaceString(logicOperation.getBuggyVariable());
			refactoring.setReplaceStatement(getReplaceStringNew());
			refactoring.setReplaceStatementNode(node);

			String[] bits = CGNodeVisitorInformationExposure.getSourceFileLocation().getFileName()
					.split("/");
			String lastOne = bits[bits.length - 1];
			refactoring.setSourceFileName(lastOne);

			refactoring.setQuickFixValue(getQuickFixValue());
			refactoring.setQuickFixString(AssertInformationExposure
					.getInformationExposureQuickFixString2());
			refactoring.setSourceFileLocation(CGNodeVisitorInformationExposure
					.getSourceFileLocation());
			refactoring
					.setMarker(AssertInformationExposure.INFORMATION_EXPOSURE_QUICK_FIX_MESSAGE);
			refactoring.setLineNumber(CGNodeVisitorInformationExposure.getSourceFileLocation()
					.getStartingLineNumber());

			refactoring.setType(RefactoringType.earliestRefactoring);

			ArrayList<ITranslationUnit> tulist = ProgramStructureFacade.tulist;
			for (ITranslationUnit tu : tulist) {
				if (tu.getElementName().equals(refactoring.getSourceFileName())) {
					refactoring.setTu(tu);
				}
			}
		
		return refactoring;

	}

	/**
	 * Creates the local refactoring object.
	 * 
	 * @param refactoring
	 *            the refactoring
	 * @param node
	 *            the node
	 * @param workPool 
	 * @return the refactoring
	 */
	// i think local refactory is no more needed
	public Refactoring createLocalRefactoringObject(Refactoring refactoring,
			IASTNode node, WorkPool workPool) {

		refactoring.setReplaceString(logicOperation.getBuggyVariable());
		refactoring.setReplaceStatement(getReplaceStringOld());

		refactoring.setReplaceStatementNode(node);

		String[] bits = RefactoringFinderInformationExposure.getInitialBugFile()
				.getFileName().split("/");
		String lastOne = bits[bits.length - 1];

		refactoring.setSourceFileName(lastOne);
		refactoring.setQuickFixString(AssertInformationExposure
				.getInformationExposureQuickFixString1());
		refactoring.setSourceFileLocation(RefactoringFinderInformationExposure
				.getInitialBugFile());
		refactoring
				.setMarker(AssertInformationExposure.INFORMATION_EXPOSURE_BUG_LOCATION_MESSAGE);
		refactoring.setLineNumber(RefactoringFinderInformationExposure
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
		IntroduceInformationExposureAction pimplAction = new IntroduceInformationExposureAction(
				Messages.dummy_message);
		if (window.getActivePage().getActivePart() instanceof CEditor) {
			pimplAction.setEditor(window.getActivePage().getActiveEditor());
			pimplAction.run();

		}

		// after the quick fix was inserted delete the marker
		// the cancel and finish butons were not pressed
		if (!IntroduceInformationExposureRefactoringWizard.abortedWizard) {
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
		IntroduceInformationExposureRefactoringWizard.abortedWizard = false;

		// disable quick fix insertion after the wizard has completed
		if (!Config.disableInPlaceQuickFixInsertion) {
			int pos = getOffset(marker, document);
			try {
				FindReplaceDocumentAdapter dad = new FindReplaceDocumentAdapter(
						document);
				StatementLogger.log_navigation(getProblemMessage(marker));

				// for quick fixes in previous nodes
				if (getProblemMessage(marker).equals(
						AssertInformationExposure.INFORMATION_EXPOSURE_QUICK_FIX_MESSAGE)) {
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
									+ AssertInformationExposure
											.getInformationExposureQuickFixString2(),
							false);
					// after the quick fix was inserted delete the marker
					if (RefactoringFinderInformationExposure.eraseQuickFixMarker) {
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

	public Refactoring createLocalRefactoringObject1(
			Refactoring refactoring, IASTNode in, WorkPool workPool) {
		// TODO Auto-generated method stub
		refactoring.setReplaceString(logicOperation.getBuggyVariable());
		refactoring.setReplaceStatement(getReplaceStringOld());

		refactoring.setReplaceStatementNode(in);

		String[] bits = RefactoringFinderInformationExposure.getInitialBugFile()
				.getFileName().split("/");
		String lastOne = bits[bits.length - 1];

		refactoring.setSourceFileName(lastOne);
		refactoring.setQuickFixString(AssertInformationExposure
				.getInformationExposureQuickFixString2());
		refactoring.setSourceFileLocation(RefactoringFinderInformationExposure
				.getInitialBugFile());
		refactoring
				.setMarker(AssertInformationExposure.INFORMATION_EXPOSURE_BUG_LOCATION_MESSAGE);
		refactoring.setLineNumber(RefactoringFinderInformationExposure
				.getInitialBugFile().getStartingLineNumber());

		refactoring.setType(RefactoringType.earliestRefactoring);

		ArrayList<ITranslationUnit> tulist = ProgramStructureFacade.tulist;
		for (ITranslationUnit tu : tulist) {
			if (tu.getElementName().equals(refactoring.getSourceFileName())) {
				refactoring.setTu(tu);
			}
		}

		return refactoring;
	}

}
