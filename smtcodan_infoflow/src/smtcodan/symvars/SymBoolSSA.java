package smtcodan.symvars;

import org.eclipse.cdt.core.dom.IName;


public class SymBoolSSA extends SymVarSSA {

	SymBoolSSA(String ssaName, SymBoolOrig orig) {
		super(ssaName, orig);		
		ssType = eSymType.SymBool;
	}
	
}
