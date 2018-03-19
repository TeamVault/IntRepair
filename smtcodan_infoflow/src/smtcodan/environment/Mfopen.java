/*
 * 
 */
package smtcodan.environment;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTName;

import smtcodan.ImpVarName;
import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymArrayOrig;
import smtcodan.symvars.SymArraySSA;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;


// TODO: Auto-generated Javadoc
/**
 * The Class .
 */
public class Mfopen implements IFctModel {

	// FILE * pFile = fopen("debug.txt", "a+");		
	
	/** The ps. */
	Interpreter ps;
	
	/**
	 * Instantiates a new mfgets.
	 *
	 * @param ps the ps
	 */
	public Mfopen(Interpreter ps) {
		this.ps = ps;
	}
	
	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {	
		return "fopen";
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
		// contained in stdio.h
		return "extern FILE *fopen (__const char *__restrict __filename, __const char *__restrict __modes) __wur;";
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
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, 1));
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, 1));
		
		fsign.setRType(new SymPointerOrig(eSymType.SymPointer, 1));
		
		return fsign;
	}
		
}

