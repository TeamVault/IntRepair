package smtcodan.multithreadanalysis;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.core.dom.ast.IBinding;

public class MTDefSharedNode extends MTANode implements IMTANode, IMTDUNode {

	IBinding var;
	
	public MTDefSharedNode(IBasicBlock bb, int pthreadnr, IBinding var) {
		super(bb, pthreadnr);
		this.var = var;
	}

	public IBinding getBinding() {
		return var;
	}
	
}
