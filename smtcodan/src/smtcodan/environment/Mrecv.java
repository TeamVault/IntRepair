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
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

/**
 * The Class Matoi.
 */
public class Mrecv implements IFctModel {

	// int atoi(const char *nptr);

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new matoi.
	 * 
	 * @param ps
	 *            the ps interpreter
	 */
	public Mrecv(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "recv";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	/**
	 * the exec method is called in order to get the function return value
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		IName newName = new EnvVarName();
		ps.declareLocal(eSymType.SymInt, newName);
		SymVarSSA var = ps.getLocalOrigSymInt(newName).getCurrentSSACopy();
		String formula = new String(" (  assert ( = " + var.getSSAName() + " "
				+ "10" + " ))");
		StringBuffer sformula = new StringBuffer();
		sformula.append(formula);
		var.setFormula(sformula.toString());
		return new SymFunctionReturn(var);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getSignature()
	 */
	/**
	 * returns the function signature
	 */
	@Override
	public SymFctSignature getSignature() {
		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));

		fsign.setRType(new SymIntOrig());
		return fsign;
	}

}
