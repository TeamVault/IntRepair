/**
   [Class description.  The class models the c function call  int atoi(const char *nptr);]
   
   [Other notes. -]
   
   @author Andreas Ibing
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.environment;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.eSymType;

/**
 * The Class Matoi.
 */
public class Mabs implements IFctModel {

	// int atoi(const char *nptr);

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new matoi.
	 * 
	 * @param ps
	 *            the ps interpreter
	 */
	public Mabs(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "abs";
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
		ArrayList<IName> plist = call.getParams();
		try {
			SymIntSSA destSSA = (SymIntSSA) ps.resolveOrigSymVar(plist.get(0))
					.getCurrentSSACopy();
			StringBuffer sformula = new StringBuffer();

			// (ite (>= a 0) a (- a))
			String s1 = "(ite (>= " + destSSA.getSSAName() + " 0) "
					+ destSSA.getSSAName() + " (- " + destSSA.getSSAName()
					+ "))";

			// after abs was applied to a number we can assume that that number
			// is > or = to 0
			String s2 = "(assert (>=  " + destSSA.getSSAName() + " 0 ))";

			destSSA.setFormula(s1 + "\n" + s2);

		} catch (Exception e) {
		}
		return new SymFunctionReturn(ps.getLocalOrigSymInt(plist.get(0))
				.getCurrentSSACopy());
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
		fsign.setRType(new SymIntOrig());
		return fsign;
	}

}
