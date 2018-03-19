package smtcodan.symvars;

import org.eclipse.cdt.core.dom.IName;

public class SymBoolOrig extends SymVarOrig {

	public SymBoolOrig(IName name) {
		super(name);
		soType = eSymType.SymBool;
	}

	public SymBoolOrig() {
		soType = eSymType.SymBool;
	}

	public SymBoolSSA ssaCopy() {
		String ssaName = newSSAname();
		SymBoolSSA ssaCopy = new SymBoolSSA(ssaName, this);
		ssaCopies.addLast(ssaCopy);
		return ssaCopy;
	}

	public void removeLastSSA() {
		ssaCopies.removeLast();
		nextSSA -= 1;
	}

	@Override
	public void addExistingSSA(SymVarSSA ssa) {
		ssaCopies.add(ssa);
		nextSSA += 1;
	}

}