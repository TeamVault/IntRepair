package smtcodan.symvars;

public class SymIntSSA extends SymVarSSA {

	SymIntSSA(String ssaName, SymIntOrig orig) {
		super(ssaName, orig);
		ssType = eSymType.SymInt;
	}

}