package smtcodan.translator;

import smtcodan.symvars.eSymType;

public class AttrDeclType implements ITrxAttribute  {

	static String attrName = "declType";
	eSymType declType;
	
	public AttrDeclType(eSymType declType) {
		this.declType = declType;
	}
	
	public eSymType getType() {
		return declType;
	}
	
	@Override
	public String getName() {
		return attrName;
	}
	
}
