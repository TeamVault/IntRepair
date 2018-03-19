package smtcodan;

import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.core.resources.IFile;

import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarSSA;

// TODO: Auto-generated Javadoc
/**
 * An asynchronous update interface for receiving notifications
 * about IIntegerOverflow information as the IIntegerOverflow is constructed.
 */
public interface IIntegerOverflowObserver {
	
	
	/**
	 * This method is called when information about an IIntegerOverflow
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param access the access
	 * @param file the file
	 * @param loc the loc
	 */
	public void updateIntegerOverflow(SymVarSSA access, IFile file, IASTFileLocation loc);


}
