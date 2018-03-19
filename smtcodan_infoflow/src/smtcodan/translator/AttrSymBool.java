package smtcodan.translator;

import smtcodan.symvars.SymBoolSSA;

public class AttrSymBool implements ITrxAttribute {

	static String attrName = "symbool";
	SymBoolSSA sbool_ssa;
	
	public AttrSymBool(SymBoolSSA sbool_ssa) {
		this.sbool_ssa = sbool_ssa;
	}
	
	public SymBoolSSA getSymBool() {
		return sbool_ssa;
	}
	
	@Override
	public String getName() {
		return attrName;
	}

}
