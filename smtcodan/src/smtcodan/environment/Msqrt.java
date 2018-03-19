/**
   [Class description.  The class models the c function call  int atoi(const char *nptr);]
   
   [Other notes. -]
   
   @author Andreas Ibing
   @version $Revision: x  Date: x hour: 
 **/
package smtcodan.environment;

import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;
import smtcodan.symvars.SymIntOrig;
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.eSymType;

// TODO: Auto-generated Javadoc
/**
 * The Class Matoi.
 */
public class Msqrt implements IFctModel {

	// int atoi(const char *nptr);

	/** The ps. */
	Interpreter ps;

	/**
	 * Instantiates a new matoi.
	 * 
	 * @param ps
	 *            the ps interpreter
	 */
	public Msqrt(Interpreter ps) {
		this.ps = ps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getName()
	 */
	@Override
	public String getName() {
		return "sqrt";
	}

	/**
	 * Sqrt.
	 * 
	 * @param n
	 *            the n
	 * @return the big integer
	 */
	public static BigInteger sqrt(BigInteger n) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8"))
				.toString());
		while (b.compareTo(a) >= 0) {
			BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
			if (mid.multiply(mid).compareTo(n) > 0)
				b = mid.subtract(BigInteger.ONE);
			else
				a = mid.add(BigInteger.ONE);
		}
		return a.subtract(BigInteger.ONE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.environment.IFctModel#exec(smtcodan.symvars.SymFunctionCall)
	 */
	/**
	 * the exec method is called in order to get the function return value.
	 * 
	 * @param call
	 *            the call
	 * @return the sym function return
	 */
	@Override
	public SymFunctionReturn exec(SymFunctionCall call) {

		//IName newName = new EnvVarName();
		SymIntSSA newName = (SymIntSSA) ps.declareLocal(eSymType.SymInt, null);

		ArrayList<IName> plist = call.getParams();
		SymIntSSA destSSA = (SymIntSSA) ps.resolveOrigSymVar(plist.get(0))
				.getCurrentSSACopy();

		BigInteger k = ps.getConcreteBigInt(destSSA);

		destSSA.setFormula("(assert (=  " + destSSA.getSSAName() + " "
				+ sqrt(k).toString() + "))");

		return new SymFunctionReturn(newName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.environment.IFctModel#getSignature()
	 */
	/**
	 * returns the function signature.
	 * 
	 * @return the signature
	 */
	@Override
	public SymFctSignature getSignature() {
		SymFctSignature fsign = new SymFctSignature();
		fsign.addParam(new SymPointerOrig(eSymType.SymInt, 1));
		fsign.setRType(new SymIntOrig());
		return fsign;
	}

}
