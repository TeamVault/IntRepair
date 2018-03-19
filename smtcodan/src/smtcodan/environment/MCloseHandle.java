/**
   [Class description. The CloseHandle() function model]
   
   [Other notes,  -]
   
   @author Paul Muntean
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.environment;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class Mtime.
 */
public class MCloseHandle implements IFctModel {

	// time_t time(time_t *timer)

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new mtime.
	 * 
	 * @param ps
	 *            the ps
	 */
	public MCloseHandle(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "CloseHandle";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getLibrarySignature()
	 */
	/**
	 * Gets the library signature.
	 * 
	 * @return the library signature
	 */
	public static String getLibrarySignature() {
		// contained in windows.h
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		SymVarSSA ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);
		return new SymFunctionReturn(ssa);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getSignature()
	 */
	@Override
	public SymFctSignature getSignature() {

		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));

		// fsign.setRType(new SymPointerOrig(eSymType.SymPointer, new
		// Integer(1)));
		return fsign;
	}

}
