/**
   [Class description.  The first sentence should be a meaningful summary of the class since it
   will be displayed as the class summary on the Javadoc package page.]
   
   [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
   about desired improvements, etc.]
   
   @author Andreas Ibing
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.environment;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;

// TODO: Auto-generated Javadoc
/**
 * The Class EnvVarName.
 */
public class EnvVarName implements IName {

	/** The number. */
	static int number = 0;

	/** The name. */
	String name;

	/**
	 * Instantiates a new env var name.
	 */
	public EnvVarName() {
		name = new String("envgen" + number);
		number++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.core.dom.IName#getSimpleID()
	 */
	@Override
	public char[] getSimpleID() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.core.dom.IName#toCharArray()
	 */
	@Override
	@Deprecated
	public char[] toCharArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.core.dom.IName#isDeclaration()
	 */
	@Override
	public boolean isDeclaration() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.core.dom.IName#isReference()
	 */
	@Override
	public boolean isReference() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.core.dom.IName#isDefinition()
	 */
	@Override
	public boolean isDefinition() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.core.dom.IName#getFileLocation()
	 */
	@Override
	public IASTFileLocation getFileLocation() {
		// TODO Auto-generated method stub
		return null;
	}

}
