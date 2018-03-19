/**
   [Class description.  strcpy java model]
   
   [Other notes: -]
   
   @author Paul Muntean
   @version $Revision: A  Date: 20.02.2014 hour: 16:17:24
 **/
package smtcodan.environment;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class MLogonUserA.
 */
public class Mstrcpy_gen implements IFctModel {

	/** strcpy(a, b). */
	/** The ps. */
	Interpreter ps;
	private String labelLow = "L";
	private String labelHigh = "H";

	/**
	 * Instantiates a new mprintf.
	 * 
	 * @param ps
	 *            the interpreter variable
	 */
	public Mstrcpy_gen(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "_strcpy";
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
		return "char _strcpy(char *a, char *b);";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		ArrayList<IName> plist = call.getParams();
		// strcpy() copies parameter 2 in parameter 1
		// label the label of parameter 2 has to be assigned to parameter 1
	
		SymPointerSSA isp0 = (SymPointerSSA) ps.resolveOrigSymVar(plist.get(0))
				.getCurrentSSACopy();
		SymPointerSSA isp1 = (SymPointerSSA) ps
				.getLocalOrigSymVar(plist.get(1)).getCurrentSSACopy();
		
		SymPointerOrig isp12 = (SymPointerOrig) ps.getLocalOrigSymPointer(plist.get(1));

		// the label is passed from one parameter to the other inside the strcpy
		// function
		try {

			if (isp1 != null)
			if (isp1.getLabel() != null) {
				if (isp1.getLabel().equals(labelHigh)) {
					isp0.setLabel(labelHigh);
				} else if (isp1.getLabel().equals(labelLow)) {
					isp0.setLabel(labelLow);
				}
			}

			// isp.setConfidential(true);

			// works also without this
			// ps.declareLocal(eSymType.SymPointer, isp0.getOrigName());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SymFunctionReturn(isp0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getSignature()
	 */
	@Override
	public SymFctSignature getSignature() {
		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));

		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));
		return fsign;
	}
}
