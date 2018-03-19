package smtcodan.symvars;

import org.eclipse.cdt.core.dom.IName;

public class SymArraySSA extends SymVarSSA {

	SymIntOrig sizeSymInt;
	eSymType elemSymType;
	boolean hasElemType;
	
	SymArraySSA(String ssaName, SymArrayOrig orig) {
		super(ssaName, orig);		
		ssType = eSymType.SymArray;		
		hasElemType = false;
	}	
	
	void setElemType(eSymType type) {
		elemSymType = type;
	}
	
	public String getSize() {
		assert sizeSymInt.getCurrentSSACopy().isInitialized : "trying to access uninitialized array size formula";		
		return sizeSymInt.getCurrentSSACopy().getSSAName();
	}	
	
	public SymIntSSA getSizeSymInt() {
		return (SymIntSSA) sizeSymInt.getCurrentSSACopy();
	}
	
	public eSymType getType() {
		assert hasElemType : "trying to access non-existing element type";		
		return elemSymType;	
	}

	public void setSize(SymIntOrig sizeSymInt) {
		this.sizeSymInt = sizeSymInt;
		SymArrayOrig sao = (SymArrayOrig) getOrig();
		if (sao.getSize() == null) {
			sao.setSize(sizeSymInt);
		}
	}
	
}

