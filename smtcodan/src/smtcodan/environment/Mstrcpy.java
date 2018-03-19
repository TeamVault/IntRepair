/**
   [Class description.  strcpy java model]
   
   [Other notes: -]
   
   @author Paul Muntean
   @version $Revision: A  Date: 20.02.2014 hour: 16:17:24
**/package smtcodan.environment;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTName;

import smtcodan.ImpVarName;
import smtcodan.interpreter.Interpreter;
import smtcodan.logger.MyLogger;
import smtcodan.symvars.SymArrayOrig;
import smtcodan.symvars.SymArraySSA;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarOrig;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;


// TODO: Auto-generated Javadoc
/**
 * The Class MLogonUserA.
 */
public class Mstrcpy implements IFctModel {

	/** strcpy(a, b). */
	/** The ps. */
	Interpreter ps;
	
	/**
	 * Instantiates a new mprintf.
	 *
	 * @param ps the interpreter variable
	 */
	public Mstrcpy(Interpreter ps) {
		this.ps = ps;
	}
	
	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "strcpy";
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
		// contained in string.h
		return "extern char *strcpy (char *__restrict __dest, __const char *__restrict __src) __THROW __nonnull ((1, 2));";
	}
	
	/* (non-Javadoc)
	 * @see smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {
		ArrayList<IName> plist = call.getParams();
		//get the third parameter
		SymPointerSSA isp2 = (SymPointerSSA) ps.resolveOrigSymVar(plist.get(0)).getCurrentSSACopy();
		SymPointerSSA isp = (SymPointerSSA) ps.getLocalOrigSymVar(isp2.getOrigName()).getCurrentSSACopy();
	
		try {	
			isp.setConfidential(true);
			MyLogger.log_b("Make it confidential______________________________________________________"+plist.get(0));
			MyLogger.log_b("password was found1 ------------------------------------- "+plist.toString());
			MyLogger.log_b("password was found1 ------------------------------------- "+isp.getOrigName());
			MyLogger.log_b("password was found1 ------------------------------------- "+isp.getESymType());
			//works also without this
			ps.declareLocal(eSymType.SymPointer, isp.getOrigName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SymFunctionReturn(isp);	
	}

	/* (non-Javadoc)
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

