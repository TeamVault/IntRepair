/*
 * 
 */
package smtcodan.environment;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class Mmod.
 */
public class Mmod implements IFctModel {

	// int rand(void);

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new mmod.
	 * 
	 * @param ps
	 *            the ps
	 */
	public Mmod(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "mod";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		IName newName = new EnvVarName();
		ps.declareLocal(eSymType.SymInt, newName);
		return new SymFunctionReturn(ps.getLocalOrigSymInt(newName)
				.getCurrentSSACopy());
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
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));

		fsign.setRType(new SymIntOrig());
		return fsign;
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
		// has no header
		return null;
	}

}
