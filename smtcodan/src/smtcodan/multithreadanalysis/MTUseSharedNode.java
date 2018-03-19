package smtcodan.multithreadanalysis;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IBinding;

public class MTUseSharedNode extends MTANode implements IMTANode, IMTDUNode {

	IASTName name;	
	
	public MTUseSharedNode(IBasicBlock bb, int activenr, IASTName name) {
		super(bb, activenr);		
		this.name = name;
	}
	
	public IASTName getName() {
		return name;
	}

	@Override
	public IBinding getBinding() {
		return name.resolveBinding();
	}
	
}
