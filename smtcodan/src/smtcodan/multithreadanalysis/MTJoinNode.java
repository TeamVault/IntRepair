package smtcodan.multithreadanalysis;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public class MTJoinNode extends MTANode implements IMTANode {

	int joinTarget;
	
	public MTJoinNode(IBasicBlock bb, int activePThreadnr, int joinTarget) {
		super(bb, activePThreadnr);
		this.joinTarget = joinTarget;
	}

	public int getJoinTarget() {
		return joinTarget;
	}
	
}

