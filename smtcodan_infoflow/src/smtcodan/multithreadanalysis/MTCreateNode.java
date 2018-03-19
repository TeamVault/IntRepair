package smtcodan.multithreadanalysis;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public class MTCreateNode extends MTANode implements IMTANode  {

	int createnr;	
	
	public MTCreateNode(IBasicBlock bb, int pthreadnr, int createnr) {
		super(bb, pthreadnr);
		this.createnr = createnr;
	}

	public int getCreateNr() {
		return createnr;
	}
	
}

