package smtcodan.multithreadanalysis;

import java.util.ArrayList;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public class MTANode implements IMTANode {

	IBasicBlock bb;
	int pthreadnr;
	boolean lockAcquiredFromScheduler;
	String slockAcquiredFromScheduler;	
	ArrayList<IMTANode> children;
	int refnr;
	
	public void setRefNr(int refnr) {
		this.refnr = refnr;
	}
	
	public String toString() {
		return (new Integer(refnr)).toString();
	}
	
	public int getRefNr() {
		return refnr;
	}
	
	public MTANode(IBasicBlock bb, int pthreadnr) {
		this.bb = bb;
		this.pthreadnr = pthreadnr;
		this.lockAcquiredFromScheduler = false;		
		this.children = new ArrayList<IMTANode>();
	}

	@Override
	public IBasicBlock getBlock() {
		return bb;
	}

	@Override
	public int getPThreadNr() {
		return pthreadnr;
	}
	
	@Override
	public void setLockAcquiredFromScheduler(String lock) {
		this.lockAcquiredFromScheduler = true;
		this.slockAcquiredFromScheduler = lock;
	}
	@Override
	public boolean hasLockAcquiredFromScheduler() {		
		return lockAcquiredFromScheduler;
	}
	@Override
	public String getSchedAcquiredLock() {
		return slockAcquiredFromScheduler;
	}
	@Override
	public void clearSchedAcquiredLock() {
		lockAcquiredFromScheduler = false;
		slockAcquiredFromScheduler = null;		
	}
	
	@Override
	public Iterable<IMTANode> getChildren() {
		return children;
	}
	
	@Override
	public void addChild(IMTANode node) {
		children.add(node);
	}


	
}
