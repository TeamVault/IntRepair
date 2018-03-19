package smtcodan.quickfixes;

import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.core.resources.IFile;

// TODO: Auto-generated Javadoc
/**
 * The Class PathObject.
 */
public class PathObject {

	/** The node. */
	private IASTNode node;

	/** The file. */
	private IFile file;

	/** The startlifile location. */
	private int startlifileLocation;

	/** The startup node. */
	private boolean startupNode = false;

	/** The Buffer size. */
	private SMTConstraintObject constraintOb;

	/**
	 * Instantiates a new path object.
	 * 
	 * @param node
	 *            the node
	 * @param file
	 *            the file
	 * @param startlifileLocation
	 *            the startlifile location
	 * @param startupNode
	 *            the startup node
	 * @param constraintOb
	 *            the constraint ob
	 */
	public PathObject(IASTNode node, IFile file, int startlifileLocation,
			boolean startupNode, SMTConstraintObject constraintOb) {
		super();
		this.node = node;
		this.file = file;
		this.startlifileLocation = startlifileLocation;
		this.startupNode = startupNode;
		this.constraintOb = constraintOb;
	}

	/**
	 * Gets the constraint ob.
	 * 
	 * @return the constraint ob
	 */
	public SMTConstraintObject getConstraintOb() {
		return constraintOb;
	}

	/**
	 * Sets the constraint ob.
	 * 
	 * @param constraintOb
	 *            the new constraint ob
	 */
	public void setConstraintOb(SMTConstraintObject constraintOb) {
		this.constraintOb = constraintOb;
	}

	/**
	 * Gets the node.
	 * 
	 * @return the node
	 */
	public IASTNode getNode() {
		return node;
	}

	/**
	 * Sets the node.
	 * 
	 * @param node
	 *            the new node
	 */
	public void setNode(IASTNode node) {
		this.node = node;
	}

	/**
	 * Gets the file.
	 * 
	 * @return the file
	 */
	public IFile getFile() {
		return file;
	}

	/**
	 * Sets the file.
	 * 
	 * @param file
	 *            the new file
	 */
	public void setFile(IFile file) {
		this.file = file;
	}

	/**
	 * Gets the startlifile location.
	 * 
	 * @return the startlifile location
	 */
	public int getStartlifileLocation() {
		return startlifileLocation;
	}

	/**
	 * Sets the startlifile location.
	 * 
	 * @param startlifileLocation
	 *            the new startlifile location
	 */
	public void setStartlifileLocation(int startlifileLocation) {
		this.startlifileLocation = startlifileLocation;
	}

	/**
	 * Checks if is startup node.
	 * 
	 * @return true, if is startup node
	 */
	public boolean isStartupNode() {
		return startupNode;
	}

	/**
	 * Sets the startup node.
	 * 
	 * @param startupNode
	 *            the new startup node
	 */
	public void setStartupNode(boolean startupNode) {
		this.startupNode = startupNode;
	}

}