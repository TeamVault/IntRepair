package smtcodan.pathgen;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.IBranchNode;
import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;

import smtcodan.ProgramPath;
import smtcodan.visualization.IProgramTreeEntry;

public class IndBasicBlock implements IProgramTreeEntry {

	// cfg node with call string

	final int pthreadnr;
	final ProgramPath entryPath;
	final IBasicBlock localNode;

	int hashCache;
	boolean hashAvailable;

	static int maxChar = 22;

	public IndBasicBlock(int pthreadnr, IBasicBlock localNode,
			ProgramPath entryPath) {
		this.pthreadnr = pthreadnr;
		this.localNode = localNode;
		this.entryPath = entryPath;
		hashAvailable = false;
	}

	public int getPThreadNr() {
		return pthreadnr;
	}

	public String toString() {
		String res = new String(pthreadnr + " " + localNode.toString());
		if (localNode instanceof IDecisionNode) {
			res = res.substring(17);
			res = res.concat(" ?");
		} else if (localNode instanceof IBranchNode) {
			res = res.substring(12);
		}
		if (res.length() > maxChar) {
			res = res.substring(0, maxChar);
			res = res.concat("...");
		}
		// return new String(" (" + Thread.currentThread().getId() + ") " +
		// res);
		return res;
	}

	public IBasicBlock getLocal() {
		return localNode;
	}

	public ProgramPath getEntryPath() {
		return entryPath;
	}

	public boolean equals(IndBasicBlock other) {
		if (this.hashCode() == other.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		if (hashAvailable) {
			return hashCache;
		} else {
			int hash;
			if (entryPath == null) {
				hash = localNode.hashCode();
			} else {
				hash = entryPath.toString().hashCode() ^ localNode.hashCode()
						+ pthreadnr;
			}
			hashCache = hash;
			hashAvailable = true;
			return hash;
		}
	}

	public int getOutgoingSize() {
		return localNode.getOutgoingSize();
	}

	public IBasicBlock[] getOutgoingNodes() {
		return localNode.getOutgoingNodes();
	}

}