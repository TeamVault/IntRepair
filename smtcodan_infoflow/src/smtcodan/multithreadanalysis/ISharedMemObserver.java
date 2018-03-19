package smtcodan.multithreadanalysis;

import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IBinding;

public interface ISharedMemObserver {

	// IASTNodeLocation available through CFGNode	
	void updateDefine(IBinding var);	
	void updateUse(IASTName name);  // position dependent, not IBinding	
	
}
