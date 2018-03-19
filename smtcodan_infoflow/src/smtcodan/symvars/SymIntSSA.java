package smtcodan.symvars;

import org.eclipse.cdt.core.dom.IName;


public class SymIntSSA extends SymVarSSA {

	SymIntSSA(String ssaName, SymIntOrig orig) {
		super(ssaName, orig);		
		ssType = eSymType.SymInt;
	}
	
}
