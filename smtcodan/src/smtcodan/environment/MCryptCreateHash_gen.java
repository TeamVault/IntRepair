/*
 * 
 */
package smtcodan.environment;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class Matoi.
 */
public class MCryptCreateHash_gen implements IFctModel {

	// int atoi(const char *nptr);

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new matoi.
	 * 
	 * @param ps
	 *            the ps
	 */
	public MCryptCreateHash_gen(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "_CryptCreateHash";
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
		// contained in stdlib.h
		return "void _CryptCreateHash();";
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
		// fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));
		fsign.setRType(new SymIntOrig());
		return fsign;
	}

}