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
public class Mwcscpy implements IFctModel {

	/** strcpy(a, b). */
	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new mprintf.
	 * 
	 * @param ps
	 *            the interpreter variable
	 */
	public Mwcscpy(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "wcscpy";
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
		// contained in wchar.h
		return "extern wchar_t *wcscpy (wchar_t *__restrict __dest, __const wchar_t *__restrict __src) __THROW;";
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
		// get the third parameter
		SymPointerSSA isp2 = (SymPointerSSA) ps.resolveOrigSymVar(plist.get(0))
				.getCurrentSSACopy();
		SymPointerSSA isp = (SymPointerSSA) ps.getLocalOrigSymVar(
				isp2.getOrigName()).getCurrentSSACopy();
		try {

			System.out
					.println("Make it confidential______________________________________________________"
							+ plist.get(0));
			isp.setConfidential(true);
			System.out
					.println("password was found1 ------------------------------------- "
							+ plist.toString());
			System.out
					.println("password was found1 ------------------------------------- "
							+ isp.getOrigName());
			System.out
					.println("password was found1 ------------------------------------- "
							+ isp.getESymType());

			// works also without this
			ps.declareLocal(eSymType.SymPointer, isp.getOrigName());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SymFunctionReturn(isp);
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
