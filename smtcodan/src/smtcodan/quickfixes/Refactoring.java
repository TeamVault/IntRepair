package smtcodan.quickfixes;

import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.model.ITranslationUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class Refactoring.
 */
public class Refactoring {
	// the part of the statement which is used in the quickFixString
	/** The replace string. */
	private String replaceString;
	// the whole replacement string
	/** The replace statement. */
	private String replaceStatement;
	/** The replace statement node. */
	private IASTNode replaceStatementNode;
	// the quick fix value
	/** The quick fix value. */
	private String quickFixValue;
	// the quick fix string
	/** The quick fix string. */
	private String quickFixString;
	// the source file where the quick fix should be introduced
	/** The source file name. */
	private String sourceFileName;
	// source file location
	/** The source file location. */
	private IASTFileLocation sourceFileLocation;
	// the marker message
	/** The marker. */
	private String marker;
	// the bug line number
	/** The line number. */
	private int lineNumber;
	// the type of the refactoring

	private RefactoringType type;

	public RefactoringType getType() {
		return type;
	}

	public void setType(RefactoringType earliestrefactoring) {
		this.type = earliestrefactoring;
	}

	/** The tu. */
	private ITranslationUnit tu;

	/**
	 * Gets the tu.
	 * 
	 * @return the tu
	 */
	public ITranslationUnit getTu() {
		return tu;
	}

	/**
	 * Sets the tu.
	 * 
	 * @param tu
	 *            the new tu
	 */
	public void setTu(ITranslationUnit tu) {
		this.tu = tu;
	}

	/**
	 * Instantiates a new refactoring.
	 */
	public Refactoring() {
		super();
	}

	/**
	 * Gets the replace statement node.
	 * 
	 * @return the replace statement node
	 */
	public IASTNode getReplaceStatementNode() {
		return replaceStatementNode;
	}

	/**
	 * Sets the replace statement node.
	 * 
	 * @param replaceStatementNode
	 *            the new replace statement node
	 */
	public void setReplaceStatementNode(IASTNode replaceStatementNode) {
		this.replaceStatementNode = replaceStatementNode;
	}

	/**
	 * Gets the source file name.
	 * 
	 * @return the source file name
	 */
	public String getSourceFileName() {
		return sourceFileName;
	}

	/**
	 * Sets the source file name.
	 * 
	 * @param sourceFileName
	 *            the new source file name
	 */
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	/**
	 * Gets the line number.
	 * 
	 * @return the line number
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * Sets the line number.
	 * 
	 * @param lineNumber
	 *            the new line number
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * Gets the quick fix value.
	 * 
	 * @return the quick fix value
	 */
	public String getQuickFixValue() {
		return quickFixValue;
	}

	/**
	 * Sets the quick fix value.
	 * 
	 * @param quickFixValue
	 *            the new quick fix value
	 */
	public void setQuickFixValue(String quickFixValue) {
		this.quickFixValue = quickFixValue;
	}

	/**
	 * Gets the source file location.
	 * 
	 * @return the source file location
	 */
	public IASTFileLocation getSourceFileLocation() {
		return sourceFileLocation;
	}

	/**
	 * Sets the source file location.
	 * 
	 * @param sourceFileLocation
	 *            the new source file location
	 */
	public void setSourceFileLocation(IASTFileLocation sourceFileLocation) {
		this.sourceFileLocation = sourceFileLocation;
	}

	/**
	 * Gets the replace string.
	 * 
	 * @return the replace string
	 */
	public String getReplaceString() {
		return replaceString;
	}

	/**
	 * Sets the replace string.
	 * 
	 * @param replaceString
	 *            the new replace string
	 */
	public void setReplaceString(String replaceString) {
		this.replaceString = replaceString;
	}

	/**
	 * Gets the replace statement.
	 * 
	 * @return the replace statement
	 */
	public String getReplaceStatement() {
		return replaceStatement;
	}

	/**
	 * Sets the replace statement.
	 * 
	 * @param replaceStatement
	 *            the new replace statement
	 */
	public void setReplaceStatement(String replaceStatement) {
		this.replaceStatement = replaceStatement;
	}

	/**
	 * Gets the quick fix string.
	 * 
	 * @return the quick fix string
	 */
	public String getQuickFixString() {
		return quickFixString;
	}

	/**
	 * Sets the quick fix string.
	 * 
	 * @param quickFixString
	 *            the new quick fix string
	 */
	public void setQuickFixString(String quickFixString) {
		this.quickFixString = quickFixString;
	}

	/**
	 * Gets the marker.
	 * 
	 * @return the marker
	 */
	public String getMarker() {
		return marker;
	}

	/**
	 * Sets the marker.
	 * 
	 * @param marker
	 *            the new marker
	 */
	public void setMarker(String marker) {
		this.marker = marker;
	}

	/**
	 * Gets the i file.
	 * 
	 * @param iastFileLocation
	 *            the iast file location
	 * @return the i file
	 */

}
