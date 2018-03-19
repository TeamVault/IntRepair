package smtcodan.progressthreads;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.IConnectorNode;
import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;

public class NumberedDecisionNode implements IDecisionNode {

	private int number;
	private IDecisionNode d;

	public NumberedDecisionNode(IDecisionNode d, int number) {
		this.d = d;
		this.number = number;

	}

	@Override
	public IBasicBlock[] getIncomingNodes() {
		// TODO Auto-generated method stub
		return d.getIncomingNodes();
	}

	@Override
	public IBasicBlock[] getOutgoingNodes() {
		// TODO Auto-generated method stub
		return d.getOutgoingNodes();
	}

	@Override
	public int getIncomingSize() {
		// TODO Auto-generated method stub
		return d.getIncomingSize();
	}

	@Override
	public int getOutgoingSize() {
		// TODO Auto-generated method stub
		return d.getOutgoingSize();
	}

	@Override
	public IBasicBlock getIncoming() {
		return d.getIncoming();

	}

	@Override
	public IConnectorNode getMergeNode() {
		return d.getMergeNode();

	}

	public NumberedBasicBlock getNumberedMergeNode(int h) {
		return new NumberedBasicBlock(getMergeNode(), h);
	}

	public IDecisionNode getDecNode() {
		return d;
	}

	public void setDecNode(IDecisionNode d) {
		this.d = d;
	}
}
