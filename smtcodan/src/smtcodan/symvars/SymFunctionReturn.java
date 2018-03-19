package smtcodan.symvars;

public class SymFunctionReturn {

	SymVarSSA rval;
	boolean hasRVal;

	public SymFunctionReturn() {
		hasRVal = false;
	}

	public SymFunctionReturn(SymVarSSA rval) {
		this.rval = rval;
		hasRVal = true;
	}

	public boolean hasRVal() {
		return hasRVal;
	}

	public SymVarSSA getRVal() {
		assert hasRVal : "trying to access non-existing return value";
		return rval;
	}

}
