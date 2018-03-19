package smtcodan.quickfixes.introduceimpl;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.ast.IASTDeclaration;
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
import smtcodan.quickfixes.introduceimpl.node.NodeContainer;
import smtcodan.quickfixes.race.condition.AssertRaceCondition;
import smtcodan.quickfixes.race.condition.RefactoringFinderRaceCondition;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowRefactoring.
 */
@SuppressWarnings("restriction")
public class IntroduceRaceConditionRefactoring extends
		IntroduceRaceConditionCRefactoring {

	/** The Constant CPP_FILE_EXTENSION. */
	private static final String CPP_FILE_EXTENSION = "cpp";

	/** The Constant C_FILE_EXTENSION. */
	private static final String C_FILE_EXTENSION = "c";

	/** The my node1. */
	private IASTNode myNode1 = null;

	/** The my node2. */
	private IASTNode myNode2 = null;

	public static String lockName = "my_personal_lock";

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
	public IntroduceRaceConditionRefactoring(ICElement celem,
			ISelection selection, IntroduceRaceConditionInformation info) {
		super(celem, selection, info);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.internal.ui.refactoring.CRefactoring#checkInitialConditions
	 * (org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) {
		// get the refactorings array
		// System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		// System.out.println("Refactorings list size: "
		// + RefactoringFinder.refactorings.size());
		// System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		// System.out.println("");
		// if (RefactoringFinder.refactorings == null)
		// System.out.println("null");

		// for (Refactoring r : RefactoringFinder.refactorings) {
		// System.out.println("---------------------------------------------");
		// System.out.println("marker: " + r.getMarker());
		// System.out.println("Quick Fix String:" + r.getQuickFixString());
		// System.out.println("Quick Fix Value: " + r.getQuickFixValue());
		// System.out.println("Replace Statement: " + r.getReplaceStatement());
		// System.out.println("IASTNode Replace Statement: "
		// + r.getReplaceStatementNode().getRawSignature());
		// System.out.println("Replace String: " + r.getReplaceString());
		// System.out
		// .println("Source File Path: " + r.getSourceFileLocation());
		// System.out.println("Source File Name: " + r.getSourceFileName());
		//
		// System.out.println("ITranslation Unit File: " + r.getTu());
		// System.out.println("Line Number: " + r.getLineNumber());
		// System.out.println("---------------------------------------------");
		// }

		int workTickAvailable = 4;
		SubMonitor sm = SubMonitor.convert(pm, workTickAvailable);
		RefactoringStatus result = new RefactoringStatus();
		try {
			result = super.checkInitialConditions(sm.newChild(6));
			if (result.hasError()) {
				return result;
			}
			sm.worked(1);

			System.out.print("ref list size: "

			+ RefactoringFinderRaceCondition.refactoringsList.size());

			// remove duplicates, same replacement string, same line, same file
			// and the same quick fix string

			for (int i = 0; i < RefactoringFinderRaceCondition.refactoringsList
					.size(); i++) {
				for (int j = i + 1; j < RefactoringFinderRaceCondition.refactoringsList
						.size(); j++) {

					if (RefactoringFinderRaceCondition.refactoringsList
							.get(i)
							.getReplaceStatementNode()
							.getRawSignature()
							.toString()
							.equals(RefactoringFinderRaceCondition.refactoringsList
									.get(j).getReplaceStatementNode()
									.getRawSignature().toString())

							&& RefactoringFinderRaceCondition.refactoringsList
									.get(i).getLineNumber() == RefactoringFinderRaceCondition.refactoringsList

							.get(j).getLineNumber()
							&& RefactoringFinderRaceCondition.refactoringsList
									.get(i)
									.getSourceFileName()
									.toString()
									.equals(RefactoringFinderRaceCondition.refactoringsList
											.get(j).getSourceFileName()
											.toString())

							&& RefactoringFinderRaceCondition.refactoringsList
									.get(i)
									.getQuickFixString()
									.toString()
									.equals(RefactoringFinderRaceCondition.refactoringsList
											.get(j).getQuickFixString()
											.toString())) {

						RefactoringFinderRaceCondition.refactoringsList
								.remove(j);

					}
				}
			}
			System.out.println("after duplicates removal list size: "

			+ RefactoringFinderRaceCondition.refactoringsList.size());

			sm.worked(2);
			// vasantha just seeing the different refactorings
			for (int i = 0; i < RefactoringFinderRaceCondition.refactoringsList
					.size(); i++) {
				System.out
						.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out
						.println(RefactoringFinderRaceCondition.refactoringsList
								.get(i).getQuickFixString());
				System.out
						.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}

			for (int i = 0; i < RefactoringFinderRaceCondition.refactoringsList
					.size(); i++) {
				info.setSourceUnit0(getAST(
						RefactoringFinderRaceCondition.refactoringsList.get(i)
								.getTu(), null));

				IASTTranslationUnit tu = info.getSourceUnit0();

				IASTTranslationUnit sourceFile = info.getSourceUnit0();
				if (sourceFile == null || !((ICElement) sourceFile).exists()) {
					result.addFatalError("renamePropertyDelegate_noSourceFile");
				} else if (((ICElement) info.getSourceUnit0()).isReadOnly()) {
					result.addFatalError("renamePropertyDelegate_roFile");
				}

			}

			sm.worked(3);

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

			sm.worked(2);

			// sm.worked(4);

			info.translationUnitList = new ArrayList<IASTTranslationUnit>();
			for (int i = 0; i < RefactoringFinderRaceCondition.refactoringsList
					.size(); i++) {
				ITranslationUnit tu = RefactoringFinderRaceCondition.refactoringsList
						.get(i).getTu();
				info.translationUnitList.add(getAST(tu, sm));
			}

			sm.worked(4);

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
					IntroduceIntegerOverflowInformation.choice2)) {
				sm.worked(workTick++);
				// NodeContainer<IASTNode> sourceClassNode0 =
				// getSecondContainer(sourceRewrite0);

				for (int i = 0; i < RefactoringFinderRaceCondition.refactoringsList
						.size(); i++) {

					sm.worked(workTick++);
					// only the earliest quick fixes
					if (RefactoringFinderRaceCondition.refactoringsList.get(i)
							.getType()

							.equals(RefactoringType.latestRefactoring)) {
						ASTRewrite sourceRewrite = collector
								.rewriterForTranslationUnit(info.translationUnitList
										.get(i));

						NodeContainer<IASTNode> sourceClassNode = getSecondContainer(
								sourceRewrite, i);
					}
				}
			}
			sm.done();
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * Gets the second container.
	 * 
	 * @param sourceRewrite
	 *            the source rewrite
	 * @return the second container
	 */
	private synchronized NodeContainer<IASTNode> getSecondContainer(
			ASTRewrite sourceRewrite, int index) {
		final NodeContainer<IASTNode> container2 = new NodeContainer<IASTNode>(
				info.translationUnitList.get(index), sourceRewrite);

		IASTNode sam2 = container2.getNode();

		ASTRewrite rewrite2 = container2.getRewrite();

		TranslationUnitNodesVisitor obSecond = new TranslationUnitNodesVisitor(

		RefactoringFinderRaceCondition.refactoringsList.get(index)
				.getReplaceStatementNode().getRawSignature().toString(),

		RefactoringFinderRaceCondition.refactoringsList.get(index)
				.getLineNumber());

		sam2.accept(obSecond);
		myNode2 = obSecond.myNode;

		IASTNode newNode2 = rewrite2

		.createLiteralNode(RefactoringFinderRaceCondition.refactoringsList.get(
				index).getQuickFixString());

		// insertion of acquire and release lock
		rewrite2.replace(myNode2, newNode2, new TextEditGroup(
				Messages.IntroducePImpl_Rewrite_NamespaceInserted));

		IASTNode newNode3 = rewrite2
				.createLiteralNode(RefactoringFinderRaceCondition.thread_declaration_node
						.getNode().getRawSignature().toString()
						+ "\n if (!std_thread_lock_create(&"
						+ lockName
						+ "))\n" + "{\n" + "return;\n" + "}");

		// create the thread lock lock
		String node = RefactoringFinderRaceCondition.thread_declaration_node
				.getNode().getRawSignature().toString();
		TranslationUnitNodesVisitor obSecond3 = new TranslationUnitNodesVisitor(

		node,
				RefactoringFinderRaceCondition.thread_declaration_node
						.getStartlifileLocation()

		);
		IASTNode sam3 = container2.getNode();
		sam3.accept(obSecond3);
		myNode1 = obSecond3.myNode;
		rewrite2.replace(myNode1, newNode3, new TextEditGroup(
				Messages.IntroducePImpl_Rewrite_NamespaceInserted));

		// create declaration and add it
		IASTDeclaration[] declarationsList = info.translationUnitList
				.get(index).getDeclarations();
		IASTNode firstFileDeclaration = null;

		int x = 10000000;
		// find the first declaration in the translation unit if any in the file
		for (int i = 0; i < declarationsList.length; i++) {
			if (declarationsList[i].getFileLocation().getStartingLineNumber() < x) {
				x = declarationsList[i].getFileLocation()
						.getStartingLineNumber();
				firstFileDeclaration = declarationsList[i].getOriginalNode();
			}

		}

		IASTNode newNode4 = rewrite2.createLiteralNode(AssertRaceCondition
				.getRaceConditionLockDeclaration()
				+ "\n"
				+ firstFileDeclaration.getRawSignature().toString());

		rewrite2.replace(firstFileDeclaration, newNode4, new TextEditGroup(
				Messages.IntroducePImpl_Rewrite_NamespaceInserted));

		container2.setNode(newNode4);
		container2.setNode(newNode3);
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
