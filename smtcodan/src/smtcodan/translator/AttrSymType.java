package smtcodan.translator;

import smtcodan.symvars.SymVarOrig;

public class AttrSymType implements ITrxAttribute {

	static String attrName = "symtype";
	SymVarOrig symtype;		// not to be declared
	
	public AttrSymType(SymVarOrig symtype) {
		this.symtype = symtype;
	}	
	
	public SymVarOrig getSymType() {
		return symtype;
	}	
	
	@Override
	public String getName() {
		return "symtype";
	}

}
