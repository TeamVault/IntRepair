package smtcodan.multithreadanalysis;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public interface IMTANode {

	public IBasicBlock getBlock();
	public int getPThreadNr();
	public void setLockAcquiredFromScheduler(String lock);
	public boolean hasLockAcquiredFromScheduler();
	public String getSchedAcquiredLock();
	public void clearSchedAcquiredLock();
	public Iterable<IMTANode> getChildren();
	public void addChild(IMTANode node);
	public int getRefNr();
	
}
