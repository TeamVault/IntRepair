package smtcodan.symvars;

import org.eclipse.cdt.core.dom.IName;

public class SymFctPointer extends SymVarOrig {

	
	public SymFctPointer(IName name) {
		super(name);
		soType = eSymType.SymFctPointer;
	}
	
	public SymFctPointer() {
		// only for fct signatures
		soType = eSymType.SymFctPointer;
	}
	
	@Override
	public SymFctPointerSSA ssaCopy() {
		String ssaName = newSSAname();											
		SymFctPointerSSA ssaCopy = new SymFctPointerSSA(ssaName, this);
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
		nextSSA +=1;		
	}
	
}
