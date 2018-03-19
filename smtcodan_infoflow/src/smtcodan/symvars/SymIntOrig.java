package smtcodan.symvars;

import org.eclipse.cdt.core.dom.IName;


public class SymIntOrig extends SymVarOrig {
	
	public SymIntOrig(IName name) {
		super(name);
		soType = eSymType.SymInt;
	}	
	
	public SymIntOrig() {
		soType = eSymType.SymInt;
	}

	public SymIntSSA ssaCopy() {
		String ssaName = newSSAname();											
		SymIntSSA ssaCopy = new SymIntSSA(ssaName, this);					
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
