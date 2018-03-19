/*
 * 
 */
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
public class Mstrlen implements IFctModel {

	// time_t time(time_t *timer)

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new mtime.
	 * 
	 * @param ps
	 *            the ps
	 */
	public Mstrlen(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "strlen";
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
		// contained in string.h
		return "extern size_t strlen (__const char *__s) __THROW __attribute_pure__ __nonnull ((1));";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		SymVarSSA ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt, call
				.getParams().get(0));
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
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, 1));

		fsign.setRType(new SymPointerOrig(eSymType.SymPointer, 1));
		return fsign;
	}
}
