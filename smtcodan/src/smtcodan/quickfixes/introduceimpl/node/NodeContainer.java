package smtcodan.quickfixes.introduceimpl.node;

import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.text.edits.TextEditGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class NodeContainer.
 * 
 * @param <T>
 *            the generic type
 */
public class NodeContainer<T extends IASTNode> {

	/** The node. */
	private T node;

	/** The rewrite. */
	private ASTRewrite rewrite;

	/**
	 * Instantiates a new node container.
	 * 
	 * @param node
	 *            the node
	 * @param rewrite
	 *            the rewrite
	 */
	public NodeContainer(T node, ASTRewrite rewrite) {
		this.node = node;
		this.rewrite = rewrite;
	}

	/**
	 * Insert before.
	 * 
	 * @param insertionPoint
	 *            the insertion point
	 * @param newNode
	 *            the new node
	 * @param editGroup
	 *            the edit group
	 * @return the AST rewrite
	 */
	public ASTRewrite insertBefore(IASTNode insertionPoint, IASTNode newNode,
			TextEditGroup editGroup) {
		return rewrite.insertBefore(node, insertionPoint, newNode, editGroup);
	}

	/**
	 * Removes the.
	 * 
	 * @param node
	 *            the node
	 * @param editGroup
	 *            the edit group
	 */
	public void remove(IASTNode node, TextEditGroup editGroup) {
		rewrite.remove(node, editGroup);
	}

	/**
	 * Replace.
	 * 
	 * @param node
	 *            the node
	 * @param replacement
	 *            the replacement
	 * @param editGroup
	 *            the edit group
	 * @return the AST rewrite
	 */
	public ASTRewrite replace(IASTNode node, IASTNode replacement,
			TextEditGroup editGroup) {
		return rewrite.replace(node, replacement, editGroup);
	}

	/**
	 * Sets the node.
	 * 
	 * @param classSpecifier
	 *            the new node
	 */
	public void setNode(T classSpecifier) {
		this.node = classSpecifier;
	}

	/**
	 * Gets the node.
	 * 
	 * @return the node
	 */
	public T getNode() {
		return node;
	}

	/**
	 * Sets the rewrite.
	 * 
	 * @param rewrite
	 *            the new rewrite
	 */
	public void setRewrite(ASTRewrite rewrite) {
		this.rewrite = rewrite;
	}

	/**
	 * Gets the rewrite.
	 * 
	 * @return the rewrite
	 */
	public ASTRewrite getRewrite() {
		return rewrite;
	}

}
