/**
 [Class description.  An asynchronous update interface for receiving notifications
 about IMem information as the IMem is constructed.]

 [Other notes, -]

 @author Andreas Ibing
 @version $Revision: x  Date: x hour: 
 **/
package smtcodan;

import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTInitializer;
import org.eclipse.core.resources.IFile;

import smtcodan.symvars.SymVarSSA;

public interface IIntegerOverflowObserver {

	/**
	 * This method is called when information about an IMem which was previously
	 * requested using an asynchronous interface becomes available.
	 * 
	 * @param access
	 *            the current SymPointerSAA variable received from the
	 *            Interpreter
	 * @param file
	 *            the file where the bug was detected
	 * @param loc
	 *            the location in the file where the bug was detected
	 * @param dspec
	 */
	public void updateLimitChecker(SymVarSSA access, IFile file,
			IASTFileLocation loc, IASTInitializer dspec);

}
