package smtcodan.progressthreads;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public class NumberedBasicBlock implements IBasicBlock {

	private int number;
	private IBasicBlock b;
	private CxxDecisionNode d;

	private List<IBasicBlock> next = new ArrayList<IBasicBlock>(2);

	public NumberedBasicBlock(IBasicBlock b, int number) {
		this.b = b;
		this.number = number;

	}

	public NumberedBasicBlock(CxxDecisionNode d, int number) {
		this.d = d;
		this.number = number;
	}

	public CxxDecisionNode getD() {
		return d;
	}

	public void setD(CxxDecisionNode d) {
		this.d = d;
	}

	public IBasicBlock getB() {
		return b;
	}

	public void setB(IBasicBlock b) {
		this.b = b;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public IBasicBlock[] getIncomingNodes() {
		return b.getIncomingNodes();
	}

	public IBasicBlock[] getOutgoingNodes() {
		return b.getOutgoingNodes();
	}

	public int getIncomingSize() {
		return b.getIncomingSize();
	}

	public int getOutgoingSize() {
		return b.getOutgoingSize();
	}

	@Override
	public String toString() {
		return b.toString();
	}

}
