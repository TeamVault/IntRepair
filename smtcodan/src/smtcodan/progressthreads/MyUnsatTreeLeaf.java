package smtcodan.progressthreads;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

import smtcodan.visualization.IProgramTreeEntry;

// TODO: Auto-generated Javadoc
/**
 * The Class MyUnsatTreeLeaf.
 */
public class MyUnsatTreeLeaf implements IProgramTreeEntry, IBasicBlock {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "UNSAT";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.codan.core.model.cfg.IBasicBlock#getIncomingNodes()
	 */
	@Override
	public IBasicBlock[] getIncomingNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.codan.core.model.cfg.IBasicBlock#getIncomingSize()
	 */
	@Override
	public int getIncomingSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.codan.core.model.cfg.IBasicBlock#getOutgoingNodes()
	 */
	@Override
	public IBasicBlock[] getOutgoingNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.codan.core.model.cfg.IBasicBlock#getOutgoingSize()
	 */
	@Override
	public int getOutgoingSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
