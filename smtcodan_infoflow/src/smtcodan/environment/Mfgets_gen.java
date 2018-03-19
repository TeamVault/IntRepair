/*
 * 
 */
package smtcodan.environment;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymArrayOrig;
import smtcodan.symvars.SymArraySSA;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class Mfgets.
 */
public class Mfgets_gen implements IFctModel {

	// char *fgets(char *s, int size, FILE *stream);

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new mfgets.
	 * 
	 * @param ps
	 *            the ps
	 */
	public Mfgets_gen(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "_fgets";
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
		// contained in stdio.h
		return "void _fgets(char *a);";
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

		// declare SymBuffer from env, and return SymPointer to it
		SymArraySSA sb_ssa = (SymArraySSA) ps.declareLocal(eSymType.SymArray,
				null);
		SymArrayOrig sb = (SymArrayOrig) sb_ssa.getOrig();
		SymIntSSA sb_size_ssa = (SymIntSSA) ps.declareLocal(eSymType.SymInt,
				null);
		SymPointerSSA isp_ssa = null;
		sb.setElemType(eSymType.SymInt);
		try {
			// return pointer
			isp_ssa = (SymPointerSSA) ps.ssaCopy(isp);
			isp_ssa.setTargetType(eSymType.SymArray);
			isp_ssa.setTarget(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SymFunctionReturn(isp_ssa);
	}

	@Override
	public SymFctSignature getSignature() {
		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));

		// fsign.setRType(new SymPointerOrig(eSymType.SymInt, 1));
		return fsign;
	}
}
