package smtcodan.symvars;

public class SymBoolSSA extends SymVarSSA {

	SymBoolSSA(String ssaName, SymBoolOrig orig) {
		super(ssaName, orig);
		ssType = eSymType.SymBool;
	}

}