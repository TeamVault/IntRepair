package smtcodan.quickfixes.introduceimpl;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.cdt.core.model.ICElement;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.internal.ui.refactoring.ModificationCollector;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.text.edits.TextEditGroup;

import smtcodan.quickfixes.Refactoring;
import smtcodan.quickfixes.RefactoringType;
import smtcodan.quickfixes.integer.overflow.RefactoringFinderIntegerOverflow;
import smtcodan.quickfixes.introduceimpl.node.NodeContainer;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowRefactoring.
 */
@SuppressWarnings("restriction")
public class IntroduceIntegerOverflowRefactoring extends
		IntroduceIntegerOverflowCRefactoring {

	/** The Constant CPP_FILE_EXTENSION. */
	private static final String CPP_FILE_EXTENSION = "cpp";

	/** The Constant C_FILE_EXTENSION. */
	private static final String C_FILE_EXTENSION = "c";

	/** The my node1. */
	private IASTNode myNode1 = null;

	/** The my node2. */
	private IASTNode myNode2 = null;

	private IASTNode myNode3 = null;

	/** The refactor. */
	Refactoring refactor;

	/**
	 * Instantiates a new introduce buffer overflow refactoring.
	 * 
	 * @param celem
	 *            the celem
	 * @param selection
	 *            the selection
	 * @param info
	 *            the info
	 */
	public IntroduceIntegerOverflowRefactoring(ICElement celem,
			ISelection selection, IntroduceIntegerOverflowInformation info) {
		super(celem, selection, info);
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) {

		int workTickAvailable = 4;
		SubMonitor sm = SubMonitor.convert(pm, workTickAvailable);
		RefactoringStatus result = new RefactoringStatus();
		try {
			result = super.checkInitialConditions(sm.newChild(6));
			if (result.hasError()) {
				return result;
			}
			sm.worked(0);
			sm.worked(3);
			for (int i = 0; i < RefactoringFinderIntegerOverflow.refactoringsList
					.size(); i++) {
				info.setSourceUnit0(getAST(
						RefactoringFinderIntegerOverflow.refactoringsList
								.get(i).getTu(), null));

				IASTTranslationUnit tu = info.getSourceUnit0();

				IASTTranslationUnit sourceFile = info.getSourceUnit0();
				if (sourceFile == null || !((ICElement) sourceFile).exists()) {
					result.addFatalError("renamePropertyDelegate_noSourceFile");
				} else if (((ICElement) info.getSourceUnit0()).isReadOnly()) {
					result.addFatalError("renamePropertyDelegate_roFile");
				}

			}

			sm.worked(4);

			sm.done();

		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.internal.ui.refactoring.CRefactoring#checkFinalConditions
	 * (org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext)
	 */
	@Override
	protected RefactoringStatus checkFinalConditions(IProgressMonitor pm,
			CheckConditionsContext checkContext) {

		int workTickAvailable = 5;
		SubMonitor sm = SubMonitor.convert(pm, workTickAvailable);
		RefactoringStatus status = null;
		try {
			sm.worked(0);
			status = super.checkFinalConditions(pm, checkContext);
			sm.worked(1);

			ITranslationUnit tu0 = RefactoringFinderIntegerOverflow.refactoringsList
					.get(0).getTu();

			sm.worked(2);
			info.setSourceUnit0(getAST(tu0, sm));

			sm.worked(3);

			if (RefactoringFinderIntegerOverflow.refactoringsList.size() > 1) {
				ITranslationUnit tu1 = RefactoringFinderIntegerOverflow.refactoringsList
						.get(1).getTu();

				info.setSourceUnit1(getAST(tu1, sm));
				info.translationUnitList = new ArrayList<IASTTranslationUnit>();
				for (int i = 0; i < RefactoringFinderIntegerOverflow.refactoringsList
						.size(); i++) {
					ITranslationUnit tu = RefactoringFinderIntegerOverflow.refactoringsList

					.get(i).getTu();
					info.translationUnitList.add(getAST(tu, sm));
				}

				sm.worked(4);

			}

			sm.done();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.internal.ui.refactoring.CRefactoring#collectModifications
	 * (org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.cdt.internal.ui.refactoring.ModificationCollector)
	 */
	@Override
	protected void collectModifications(IProgressMonitor pm,
			ModificationCollector collector) {
		final int TICK_COUNT_COLLECT_MODIFICATIONS = 9;

		int tickCount = TICK_COUNT_COLLECT_MODIFICATIONS;
		SubMonitor sm = SubMonitor.convert(pm, tickCount);
		try {
			int workTick = 0;
			sm.worked(workTick++);

			sm.worked(workTick++);
			ASTRewrite sourceRewrite0 = collector
					.rewriterForTranslationUnit(info.getSourceUnit0());

			sm.worked(workTick++);

			if (info.getChoice().equals(
					IntroduceIntegerOverflowInformation.choice1)) {
				sm.worked(workTick++);
				// NodeContainer<IASTNode> sourceClassNode0 =
				// getSecondContainer(sourceRewrite0);

				int size = RefactoringFinderIntegerOverflow.refactoringsList
						.size();
				// call once
				for (int i = 0; i < size - (size - 1); i++) {
					sm.worked(workTick++);
					// only the latest quick fixes
					if (RefactoringFinderIntegerOverflow.refactoringsList
							.get(i).getType()
							.equals(RefactoringType.latestRefactoring)) {
						ASTRewrite sourceRewrite = collector
								.rewriterForTranslationUnit(info.translationUnitList
										.get(i));

						NodeContainer<IASTNode> sourceClassNode = getSecondContainers(
								sourceRewrite, i);
					}
				}
			}

			// Choice two was selected and the two counters are equal.
			// The counters are equal if for each buggy path a not in place
			// quick fix was created. It can be that there the ration is
			// 1/2. This means twice as many buggy paths than generated
			// quick fixes. Than
			// it should be also allowed to insert the pre quick fixes
			// else if (info.getChoice().equals(
			// IntroduceInformationExposureInformation.choice2)
			// && (RefactoringFinderInformationExposure.counterBuggyPaths ==
			// RefactoringFinderInformationExposure.counterNotInPlaceQuickFixes
			// || RefactoringFinderInformationExposure.counterBuggyPaths
			// /
			// RefactoringFinderInformationExposure.counterNotInPlaceQuickFixes
			// == 2)) {
			else if (info.getChoice().equals(
					IntroduceInformationExposureInformation.choice2)) {
				for (int i = 0; i < RefactoringFinderIntegerOverflow.refactoringsList
						.size(); i++) {
					sm.worked(workTick++);
					// only the earliest quick fixes
					System.out.println("Type:"
							+ RefactoringFinderIntegerOverflow.refactoringsList
									.get(i).getType()
							+ "size: "
							+ RefactoringFinderIntegerOverflow.refactoringsList
									.size());

					if (RefactoringFinderIntegerOverflow.refactoringsList
							.get(i).getType()
							.equals(RefactoringType.earliestRefactoring)) {
						ASTRewrite sourceRewrite = collector
								.rewriterForTranslationUnit(info.translationUnitList
										.get(i));

						NodeContainer<IASTNode> sourceClassNode = getSecondContainers(
								sourceRewrite, i);
					}
				}
			}
			sm.done();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int countLines(String str) {
		String[] lines = str.split("\r\n|\r|\n");
		return lines.length;
	}

	/**
	 * Removes the last char.
	 * 
	 * @param str
	 *            the str
	 * @return the string
	 */
	private static String removeLastChar(String str) {
		return str.substring(0, str.length() - 1);
	}

	private synchronized NodeContainer<IASTNode> getSecondContainers(
			ASTRewrite sourceRewrite, int index) {
		NodeContainer<IASTNode> container2 = new NodeContainer<IASTNode>(
				info.translationUnitList.get(index), sourceRewrite);

		IASTNode sam2 = container2.getNode();

		ASTRewrite rewrite2 = container2.getRewrite();
		IASTNode[] childs2 = sam2.getChildren();

		TranslationUnitNodesVisitor obSecond = new TranslationUnitNodesVisitor(
				RefactoringFinderIntegerOverflow.refactoringsList.get(index)

				.getReplaceStatementNode().getRawSignature().toString(),

				RefactoringFinderIntegerOverflow.refactoringsList.get(index)
						.getLineNumber());

		sam2.accept(obSecond);
		myNode2 = obSecond.myNode;

		// get second node, this is the node after the node containing the bug
		TranslationUnitNodesVisitor obThird = new TranslationUnitNodesVisitor(
				RefactoringFinderIntegerOverflow.refactoringsList.get(index)

				.getReplaceStatementNode().getRawSignature().toString(),

				RefactoringFinderIntegerOverflow.refactoringsList.get(index)
						.getLineNumber() + 1);// goto next line number
		sam2.accept(obThird);
		myNode3 = obThird.myNode;

		// replace old node with the new node plus the old node
		String refactoring = RefactoringFinderIntegerOverflow.refactoringsList
				.get(index).getQuickFixString();

		// replace inside this string some place holder witht the two nodes as
		// string.
		String nodeOne = "" + myNode2.getRawSignature().toString();
		String nodeTwo = "\n" + myNode3.getRawSignature().toString() + "";

		String replaced = refactoring.replace("placeHolder", nodeOne + nodeTwo);

		IASTNode newNode2 = rewrite2.createLiteralNode(replaced);

		// replace one node with the whole refactoring
		rewrite2.replace(myNode2, newNode2, new TextEditGroup(
				Messages.IntroducePImpl_Rewrite_NamespaceInserted));

		IASTNode newNode3 = rewrite2.createLiteralNode("");

		// delete the second node
		rewrite2.remove(myNode3, new TextEditGroup(
				Messages.IntroducePImpl_Rewrite_NamespaceInserted));
		// rewrite2.replace(myNode3, newNode3, new TextEditGroup(
		// Messages.IntroducePImpl_Rewrite_NamespaceInserted));

		// this is the not used insert before version
		// IASTNode newNode2 = rewrite2
		// .createLiteralNode(removeLastChar(RefactoringFinderIntegerOverflow.refactoringsList
		// .get(index).getQuickFixString()));
		//
		// rewrite2.insertBefore(myNode2.getParent(), myNode2, newNode2,
		// new TextEditGroup(
		// Messages.IntroducePImpl_Rewrite_NamespaceInserted));

		container2.setNode(newNode2);
		container2.setRewrite(rewrite2);
		return container2;

	}

	/**
	 * Gets the second container.
	 * 
	 * @param sourceRewrite
	 *            the source rewrite
	 * @return the second container
	 */
	private synchronized NodeContainer<IASTNode> getFirstContainer(
			ASTRewrite sourceRewrite, int index) {
		final NodeContainer<IASTNode> container2 = new NodeContainer<IASTNode>(
				info.translationUnitList.get(index), sourceRewrite);

		IASTNode sam2 = container2.getNode();

		ASTRewrite rewrite2 = container2.getRewrite();
		IASTNode[] childs2 = sam2.getChildren();

		TranslationUnitNodesVisitor obSecond = new TranslationUnitNodesVisitor(

		RefactoringFinderIntegerOverflow.refactoringsList.get(index)

		.getReplaceStatementNode().getRawSignature().toString(),

		RefactoringFinderIntegerOverflow.refactoringsList.get(index)
				.getLineNumber());

		sam2.accept(obSecond);
		myNode2 = obSecond.myNode;

		IASTNode newNode = rewrite2

		.createLiteralNode(RefactoringFinderIntegerOverflow.refactoringsList

		.get(index).getQuickFixString());

		IASTNode newNode2 = null;
		// one type of quick fix, the multi-line quick fix
		if (countLines(RefactoringFinderIntegerOverflow.refactoringsList.get(
				index).getQuickFixString()) > 1) {
			newNode2 = rewrite2
					.createLiteralNode(RefactoringFinderIntegerOverflow.refactoringsList
							.get(index).getQuickFixString());
		} else {
			newNode2 = rewrite2
					.createLiteralNode(RefactoringFinderIntegerOverflow.refactoringsList
							.get(index).getQuickFixString()
							+ "\n"
							+ myNode2.getRawSignature().toString());
		}

		rewrite2.replace(myNode2, newNode2, new TextEditGroup(
				Messages.IntroducePImpl_Rewrite_NamespaceInserted));

		container2.setNode(newNode2);
		container2.setRewrite(rewrite2);
		return container2;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.internal.ui.refactoring.CRefactoring#getRefactoringDescriptor
	 * ()
	 */
	@Override
	protected RefactoringDescriptor getRefactoringDescriptor() {
		return null;
	}
}