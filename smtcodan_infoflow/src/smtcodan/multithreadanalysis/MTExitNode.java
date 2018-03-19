package smtcodan.multithreadanalysis;

import java.util.ArrayList;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

import smtcodan.interpreter.PThread;

public class MTExitNode extends MTANode implements IMTANode {

	int exitnr;
	ArrayList<Integer> joiners;
	
	public MTExitNode(IBasicBlock bb, int pthreadnr, int exitnr) {
		super(bb, pthreadnr);
		this.exitnr = exitnr;
		this.joiners = new ArrayList<Integer>();
	}

	public int getExitNr() {
		return exitnr;
	}
	
	public void addJoiner(Integer threadnr) {
		joiners.add(threadnr);
	}
	
	public ArrayList<Integer> getJoiners() {
		return joiners;
	}
	
	public void clearJoiners() {
		joiners.clear();
	}
	
}
