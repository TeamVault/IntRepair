package smtcodan.multithreadanalysis;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public class MTLockNode extends MTANode implements IMTANode {

	String lockname;
	
	public MTLockNode(IBasicBlock bb, int pthreadnr, String lockname) {
		super(bb, pthreadnr);
		this.lockname = lockname;
	}

	public String getLockName() {
		return lockname;
	}
	
}
