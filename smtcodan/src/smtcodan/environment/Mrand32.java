/**
   [Class description.  The class models the  int rand(void); function call]
   
   [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
   about desired improvements, etc.]
   
   @author Andreas Ibing
   @version $Revision: x  Date: x hour: 
**/
package smtcodan.environment;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTName;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.eSymType;

/**
 * The Class Mrand.
 */
public class Mrand32 implements IFctModel {

	// int rand(void);
	
	/** The ps. */
	Interpreter ps;
	
	/**
	 * Instantiates a new mrand.
	 *
	 * @param ps the ps
	 */
	public Mrand32(Interpreter ps) {
		this.ps = ps;
	}
	
	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "RAND32";
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
		fsign.setRType(new SymIntOrig());
		return fsign;
	}

}
