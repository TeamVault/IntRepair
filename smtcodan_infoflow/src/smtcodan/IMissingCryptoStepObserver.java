/*
 * 
 */
package smtcodan;

import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.core.resources.IFile;

// TODO: Auto-generated Javadoc
/**
 * An asynchronous update interface for receiving notifications about IInfoFlow
 * information as the IInfoFlow is constructed.
 */
public interface IMissingCryptoStepObserver {

	/**
	 * This method is called when information about an IInfoFlow which was
	 * previously requested using an asynchronous interface becomes available.
	 * 
	 * @param access
	 *            the access
	 * @param file
	 *            the file
	 * @param loc
	 *            the loc
	 */
	public void updateChecker(String call, IFile file, IASTFileLocation loc);

}
