/*
 * 
 */
package smtcodan.environment;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.ImpVarName;
import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymArrayOrig;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class MprintLine.
 */
public class MprintLine implements IFctModel {

	// TODO: variable argument list

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new mprint line.
	 * 
	 * @param ps
	 *            the ps
	 */
	public MprintLine(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "printLine";
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
		// contained in std_testcase_io.h
		return "void printLine(const char * line);";
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
		SymPointerOrig isp = ps.getLocalOrigSymPointer(plist.get(0));

		IName nebn = new EnvVarName();
		SymIntOrig sb_size = new SymIntOrig(new ImpVarName());
		SymArrayOrig sb = new SymArrayOrig(nebn, sb_size);
		SymPointerSSA isp_ssa = null;
		try {
			sb.setElemType(eSymType.SymPointer);
			SymVarSSA ssa = (SymVarSSA) ps.declareLocal(eSymType.SymInt, null);
			// SymArraySSA sb_ssa = (SymArraySSA)
			// ps.getLocalOrigSymArray(nebn).getCurrentSSACopy();
			// return pointer
			isp_ssa = (SymPointerSSA) ps.ssaCopy(isp);
			isp_ssa.setTargetType(eSymType.SymPointer);
			isp_ssa.setTarget(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SymFunctionReturn(isp_ssa);
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

		fsign.setRType(new SymPointerOrig(eSymType.SymPointer, new Integer(1)));
		return fsign;
	}

}
