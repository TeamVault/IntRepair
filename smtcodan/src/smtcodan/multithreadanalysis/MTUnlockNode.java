package smtcodan.multithreadanalysis;

import java.util.ArrayList;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public class MTUnlockNode extends MTANode implements IMTANode {

	String lockname;
	
	public MTUnlockNode(IBasicBlock bb, int activenr, String lockname) {
		super(bb, activenr);
		this.lockname = lockname;
	}

	public String getLockName() {
		return lockname;
	}
	
}
