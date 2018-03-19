/*
 * 
 */
package smtcodan.environment;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTName;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymVarSSA;
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
	 * @param ps the ps
	 */
	public Mmod(Interpreter ps) {
		this.ps = ps;
	}
	
	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "mod";
	}
	
	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		SymVarSSA ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);
		return new SymFunctionReturn(ssa);
	}

	/* (non-Javadoc)
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
}
