package smtcodan.translator;

import smtcodan.symvars.SymVarSSA;

public class AttrSymVar implements ITrxAttribute {

	static String attrName = "symvar";
	SymVarSSA symvar;
	
	public AttrSymVar(SymVarSSA symVar) {
		this.symvar = symVar;
	}
	
	public SymVarSSA getSymVar() {
		return symvar;
	}
	
	@Override
	public String getName() {
		return attrName;
	}

}
