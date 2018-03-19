package smtcodan.symvars;

import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IBinding;

public class SymFctPointerSSA extends SymVarSSA {

	IBinding target;
	boolean hasBinding;	
	IASTName fname;
	
	protected SymFctPointerSSA(String ssaName, SymFctPointer orig) {
		super(ssaName, orig);
		hasBinding = false;
		super.ssType = eSymType.SymFctPointer;
	}
	
	public void setTarget(IBinding binding) {
		this.target = binding;
		hasBinding = true;
		super.isInitialized = true;
	}
	
	public void setFunctionName(IASTName fname) {
		this.fname = fname;
	}
	
	public IASTName getFctName() {
		return fname;
	}	
	
	public IBinding getTarget() {
		return target;
	}

}
