/**
   [Class description.  LogonUserA java model]
   
   [Other notes: -]
   
   @author Paul Muntean
   @version $Revision: A  Date: 20.02.2014 hour: 16:17:24
 **/
package smtcodan.environment;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.interpreter.Interpreter;
import smtcodan.parser.Comment;
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
public class MLogonUserA_gen implements IFctModel {

	/**
	 * (LogonUserA( username, domain, password, LOGON32_LOGON_NETWORK,
	 * LOGON32_PROVIDER_DEFAULT, &pHandle) != 0).
	 */
	/** The ps. */
	private Interpreter ps;

	/** The comment. */
	private Comment comment;

	/** The annotation type. */
	private String annotationType;

	/**
	 * Instantiates a new mprintf.
	 * 
	 * @param ps
	 *            the interpreter variable
	 */
	public MLogonUserA_gen(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "_LogonUserA";
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
		return "void _LogonUserA(char *a);";
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

		SymPointerSSA isp3 = (SymPointerSSA) ps
				.getLocalOrigSymVar(plist.get(0)).getCurrentSSACopy();
		// SymArrayOrig isp = (SymArrayOrig) isp2.getTarget();

		// CWE-259
		ps.notifyHardCodedPasswordTrustBoundary(isp3);

		return new SymFunctionReturn(isp3);
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

		// fsign.addParam(new SymPointerOrig(eSymType.SymPointer, new
		// Integer(1)));
		return fsign;
	}
}
