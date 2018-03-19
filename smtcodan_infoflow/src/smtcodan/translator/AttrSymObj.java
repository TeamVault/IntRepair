package smtcodan.translator;

import smtcodan.symvars.ISymObject;

public class AttrSymObj implements ITrxAttribute {

	static String attrName = "symobj";
	ISymObject symobj;
	
	public AttrSymObj(ISymObject symobj) {
		this.symobj = symobj;
	}
	
	public ISymObject getSymObj() {
		return symobj;
	}
	
	@Override
	public String getName() {
		return attrName;
	}

}
