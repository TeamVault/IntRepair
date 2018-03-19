package smtcodan.quickfixes.introduceimpl;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.ast.IASTSimpleDeclaration;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTCompositeTypeSpecifier;
import org.eclipse.cdt.core.dom.ast.cpp.ICPPASTVisibilityLabel;
import org.eclipse.core.resources.IFile;

// TODO: Auto-generated Javadoc
/**
 * The Class IntroduceBufferOverflowInformation.
 */
public class IntroduceIntegerOverflowInformation {

	/** The line_number. */
	private int line_number;

	/** The file_name. */
	private String file_name;

	/** The source file. */
	private IFile sourceFile;

	/**
	 * Gets the source file.
	 * 
	 * @return the source file
	 */
	public IFile getSourceFile() {
		return sourceFile;
	}

	/**
	 * Sets the source file.
	 * 
	 * @param sourceFile
	 *            the new source file
	 */
	public void setSourceFile(IFile sourceFile) {
		this.sourceFile = sourceFile;
	}

	/** The choice. */
	private static String choice = "no selction";

	/** The choice2. */
	public static String choice1 = "In place quick fix(s)/repair(s)";

	/** The choice2. */
	public static String choice2 = "Not in place quick fix(s)/repair(s)";

	public ArrayList<IASTTranslationUnit> translationUnitList;

	/**
	 * Gets the choice.
	 * 
	 * @return the choice
	 */
	public static String getChoice() {
		return IntroduceIntegerOverflowInformation.choice;
	}

	/**
	 * Sets the choice.
	 * 
	 * @param choice
	 *            the new choice
	 */
	public static void setChoice(String choice) {
		IntroduceIntegerOverflowInformation.choice = choice;
	}

	/**
	 * Gets the file_name.
	 * 
	 * @return the file_name
	 */
	public String getFile_name() {
		return file_name;
	}

	/**
	 * Sets the file_name.
	 * 
	 * @param file_name
	 *            the new file_name
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	/**
	 * Gets the line_number.
	 * 
	 * @return the line_number
	 */
	public int getLine_number() {
		return line_number;
	}

	/**
	 * Sets the line_number.
	 * 
	 * @param line_number
	 *            the new line_number
	 */
	public void setLine_number(int line_number) {
		this.line_number = line_number;
	}

	/**
	 * The Enum PointerType.
	 */
	public enum PointerType {

		/** The standard. */
		STANDARD,
		/** The shared. */
		SHARED,
		/** The unique. */
		UNIQUE
	}

	/**
	 * The Enum LibraryType.
	 */
	public enum LibraryType {

		/** The boost. */
		BOOST,
		/** The std. */
		STD
	}

	/**
	 * The Enum CopyType.
	 */
	public enum CopyType {

		/** The deep. */
		DEEP,
		/** The shallow. */
		SHALLOW,
		/** The nocopy. */
		NOCOPY,
		/** The noncopyable. */
		NONCOPYABLE
	}

	/** The class type. */
	private int classType = ICPPASTCompositeTypeSpecifier.k_struct;

	/** The pointer type. */
	private PointerType pointerType = PointerType.UNIQUE;

	/** The library type. */
	private LibraryType libraryType = LibraryType.BOOST;

	/** The copy type. */
	private CopyType copyType = CopyType.DEEP;

	/** The class name impl. */
	private String classNameImpl;

	/** The pointer name impl. */
	private String pointerNameImpl;

	/** The class specifiers. */
	private ArrayList<ICPPASTCompositeTypeSpecifier> classSpecifiers = new ArrayList<ICPPASTCompositeTypeSpecifier>();

	/** The class specifier. */
	private ICPPASTCompositeTypeSpecifier classSpecifier = null;

	/** The header unit. */
	private IASTTranslationUnit sourceUnit0;

	/** The source unit1. */
	private IASTTranslationUnit sourceUnit1;

	/**
	 * Gets the source unit0.
	 * 
	 * @return the source unit0
	 */
	public IASTTranslationUnit getSourceUnit0() {
		return sourceUnit0;
	}

	/**
	 * Sets the source unit0.
	 * 
	 * @param sourceUnit0
	 *            the new source unit0
	 */
	public void setSourceUnit0(IASTTranslationUnit sourceUnit0) {
		this.sourceUnit0 = sourceUnit0;
	}

	/**
	 * Gets the source unit1.
	 * 
	 * @return the source unit1
	 */
	public IASTTranslationUnit getSourceUnit1() {
		return sourceUnit1;
	}

	/**
	 * Sets the source unit1.
	 * 
	 * @param sourceUnit1
	 *            the new source unit1
	 */
	public void setSourceUnit1(IASTTranslationUnit sourceUnit1) {
		this.sourceUnit1 = sourceUnit1;
	}

	/** The actual original visibility. */
	private int actualOriginalVisibility = ICPPASTVisibilityLabel.v_public;

	/** The actual header visibility. */
	private int actualHeaderVisibility = ICPPASTVisibilityLabel.v_public;

	/** The actual impl visibility. */
	private int actualImplVisibility = 0;

	/** The is file created. */
	boolean isConstructorInserted, isNodeStatic, isFileCreated;

	/** The private static list. */
	private ArrayList<IASTSimpleDeclaration> privateStaticList;

	/**
	 * Sets the class type.
	 * 
	 * @param classType
	 *            the new class type
	 */
	public void setClassType(int classType) {
		this.classType = classType;
	}

	/**
	 * Gets the class type.
	 * 
	 * @return the class type
	 */
	public int getClassType() {
		return classType;
	}

	/**
	 * Sets the pointer type.
	 * 
	 * @param pointerType
	 *            the new pointer type
	 */
	public void setPointerType(PointerType pointerType) {
		this.pointerType = pointerType;
	}

	/**
	 * Gets the pointer type.
	 * 
	 * @return the pointer type
	 */
	public PointerType getPointerType() {
		return pointerType;
	}

	/**
	 * Sets the library type.
	 * 
	 * @param libraryType
	 *            the new library type
	 */
	public void setLibraryType(LibraryType libraryType) {
		this.libraryType = libraryType;
	}

	/**
	 * Gets the library type.
	 * 
	 * @return the library type
	 */
	public LibraryType getLibraryType() {
		return libraryType;
	}

	/**
	 * Sets the copy type.
	 * 
	 * @param copyType
	 *            the new copy type
	 */
	public void setCopyType(CopyType copyType) {
		this.copyType = copyType;
	}

	/**
	 * Gets the copy type.
	 * 
	 * @return the copy type
	 */
	public CopyType getCopyType() {
		return copyType;
	}

	/**
	 * /** Sets the class specifier.
	 * 
	 * @param classSpecifier
	 *            the new class specifier
	 */
	public void setClassSpecifier(ICPPASTCompositeTypeSpecifier classSpecifier) {
		this.classSpecifier = classSpecifier;
	}

	/**
	 * Gets the class specifier.
	 * 
	 * @return the class specifier
	 */
	public ICPPASTCompositeTypeSpecifier getClassSpecifier() {
		return classSpecifier;
	}

	/**
	 * Sets the class name impl.
	 * 
	 * @param classNameImpl
	 *            the new class name impl
	 */
	public void setClassNameImpl(String classNameImpl) {
		this.classNameImpl = classNameImpl;
	}

	/**
	 * Gets the class name impl.
	 * 
	 * @return the class name impl
	 */
	public String getClassNameImpl() {
		return classNameImpl;
	}

	/**
	 * Sets the pointer name impl.
	 * 
	 * @param pointerNameImpl
	 *            the new pointer name impl
	 */
	public void setPointerNameImpl(String pointerNameImpl) {
		this.pointerNameImpl = pointerNameImpl;
	}

	/**
	 * Gets the pointer name impl.
	 * 
	 * @return the pointer name impl
	 */
	public String getPointerNameImpl() {
		return pointerNameImpl;
	}

	/**
	 * Sets the class specifiers.
	 * 
	 * @param classSpecifiers
	 *            the new class specifiers
	 */
	public void setClassSpecifiers(
			ArrayList<ICPPASTCompositeTypeSpecifier> classSpecifiers) {
		this.classSpecifiers = classSpecifiers;
	}

	/**
	 * Gets the class specifiers.
	 * 
	 * @return the class specifiers
	 */
	public ArrayList<ICPPASTCompositeTypeSpecifier> getClassSpecifiers() {
		return classSpecifiers;
	}

	/**
	 * Gets the private static list.
	 * 
	 * @return the private static list
	 */
	public ArrayList<IASTSimpleDeclaration> getPrivateStaticList() {
		return privateStaticList;
	}

	/**
	 * Sets the private static list.
	 * 
	 * @param privateStaticList
	 *            the new private static list
	 */
	public void setPrivateStaticList(
			ArrayList<IASTSimpleDeclaration> privateStaticList) {
		this.privateStaticList = privateStaticList;
	}

	/**
	 * Gets the actual original visibility.
	 * 
	 * @return the actual original visibility
	 */
	public int getActualOriginalVisibility() {
		return actualOriginalVisibility;
	}

	/**
	 * Sets the actual original visibility.
	 * 
	 * @param actualOriginalVisibility
	 *            the new actual original visibility
	 */
	public void setActualOriginalVisibility(int actualOriginalVisibility) {
		this.actualOriginalVisibility = actualOriginalVisibility;
	}

	/**
	 * Gets the actual impl visibility.
	 * 
	 * @return the actual impl visibility
	 */
	public int getActualImplVisibility() {
		return actualImplVisibility;
	}

	/**
	 * Sets the actual impl visibility.
	 * 
	 * @param actualImplVisibility
	 *            the new actual impl visibility
	 */
	public void setActualImplVisibility(int actualImplVisibility) {
		this.actualImplVisibility = actualImplVisibility;
	}

	/**
	 * Gets the actual header visibility.
	 * 
	 * @return the actual header visibility
	 */
	public int getActualHeaderVisibility() {
		return actualHeaderVisibility;
	}

	/**
	 * Sets the actual header visibility.
	 * 
	 * @param actualHeaderVisibility
	 *            the new actual header visibility
	 */
	public void setActualHeaderVisibility(int actualHeaderVisibility) {
		this.actualHeaderVisibility = actualHeaderVisibility;
	}

	/**
	 * Sets the unit.
	 * 
	 * @param ast
	 *            the new unit
	 */
	public void setUnit(IASTTranslationUnit ast) {
		// TODO Auto-generated method stub
	}

}
