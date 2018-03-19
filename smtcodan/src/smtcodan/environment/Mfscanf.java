/**
  [Class description. The class models the char *fgets(char *s, int size, FILE *stream);	function call]
  
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
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarOrig;
import smtcodan.symvars.eSymType;

/**
 * The Class Mfscanf.
 */
public class Mfscanf implements IFctModel {

	// char *fgets(char *s, int size, FILE *stream);

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new Mfscanf.
	 * 
	 * @param ps
	 *            the ps
	 */
	public Mfscanf(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "fscanf";
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
		SymPointerSSA isp = (SymPointerSSA) ps.resolveOrigSymVar(plist.get(2))
				.getCurrentSSACopy();
		SymPointerSSA spo = null;

		try {
			((SymVarOrig) isp.getTarget()).getCurrentSSACopy().setFormula("");
			isp.setTargetType(eSymType.SymPointer);
			ps.declareLocal(eSymType.SymPointer, isp.getOrigName());
			spo = (SymPointerSSA) ps.declareLocal(eSymType.SymPointer, null);
			spo.setTargetType(eSymType.SymPointer);
			isp.getTargetSSA().addDependency(spo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SymFunctionReturn(spo);
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
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, 1));
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, 1));
		fsign.addParam(new SymPointerOrig(eSymType.SymPointer, 1));

		fsign.setRType(new SymPointerOrig(eSymType.SymPointer, 1));
		return fsign;
	}

}
