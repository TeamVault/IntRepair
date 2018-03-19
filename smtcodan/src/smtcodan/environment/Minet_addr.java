/**
   [Class description.  The class models the c function call  int atoi(const char *nptr);]
   
   [Other notes. -]
   
   @author Andreas Ibing
   @version $Revision: x  Date: x hour: 
**/
package smtcodan.environment;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.eSymType;

/**
 * The Class Matoi. 
 */
public class Minet_addr implements IFctModel {

	// int atoi(const char *nptr);
	
	/** The ps. */
	Interpreter ps;
	
	/**
	 * Instantiates a new matoi.
	 *
	 * @param ps the ps interpreter
	 */
	public Minet_addr(Interpreter ps) {
		this.ps = ps;
	}
	
	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "inet_addr";
	}

	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	/**
	 * the exec method is called in order to get the function return value
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		IName newName = new EnvVarName();
		ps.declareLocal(eSymType.SymInt, newName);
		return new SymFunctionReturn(ps.getLocalOrigSymInt(newName).getCurrentSSACopy());
	}

	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#getSignature()
	 */
	/**
	 * returns the function signature
	 */
	@Override
	public SymFctSignature getSignature() {
		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));
		fsign.setRType(new SymIntOrig());
		return fsign;
	}

}
