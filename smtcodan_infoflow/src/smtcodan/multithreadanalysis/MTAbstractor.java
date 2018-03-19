package smtcodan.multithreadanalysis;

import java.util.ArrayList;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.ICfgData;
import org.eclipse.cdt.codan.core.model.cfg.IStartNode;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IBinding;

import smtcodan.IPThreadObserver;
import smtcodan.IPathObserver;
import smtcodan.PathUnsatException;
import smtcodan.ProgramPath;
import smtcodan.interpreter.Interpreter;
import smtcodan.interpreter.PThread;
import smtcodan.pathgen.IndBasicBlock;
import smtcodan.symvars.SymPointerOrig;

public class MTAbstractor implements IPThreadObserver, ISharedMemObserver {

	// ATTENTION: currently does not support backtracking!
	// use only for forward traversal of satisfiable path.
	
	// find definenodes, usenodes, joinnodes, locknodes, unlocknodes, exitnodes	
	
	MTAPath mtapath;
	IBasicBlock bb;
	ArrayList<PThread> pthreads;
	Interpreter ps;
	int activePThreadnr;
	int lastActive;
	
	
	public MTAbstractor(Interpreter ps) {
		this.ps = ps;
		mtapath = new MTAPath();
		pthreads = new ArrayList<PThread>();
		PThread.resetPThreadCounter();
		PThread mainpthread = new PThread(ps);
		pthreads.add(mainpthread);
		mainpthread.setInitialized();
		int lastActive = 0;
	}
	
	public MTAPath getMTAPath() {
		return mtapath;
	}
	
	public void createMain() {
		IMTANode node = new MTCreateNode(null, 0, 0);
		mtapath.addLast(node);
	}
	
	public void exitMain() {
		IMTANode node = new MTExitNode(null, 0, 0);
		mtapath.addLast(node);
	}
	
	public void enterNode(int pthreadnr, IBasicBlock block) {
		activePThreadnr = pthreadnr;
		this.bb = block;				
		ps.enter(pthreads.get(pthreadnr), bb);		

	}
	
	public void leaveNode(int pthreadnr, IBasicBlock block) {			
		this.bb = null;
		lastActive = activePThreadnr;
	}
	
	public ArrayList<Integer> getAlivePThreadnrs() {
		ArrayList<Integer> livenrs = new ArrayList<Integer>();
		for (PThread pthread: pthreads) {
			if (pthread.isAlive()) {
				livenrs.add(pthread.getPThreadNr());
			}
		}
		return livenrs;
	}
		
	@Override
	public void updateStartPThread(int tnr, IStartNode startnode, SymPointerOrig args) {
		PThread newthread = new PThread(ps);
		newthread.setNextNode(new IndBasicBlock(tnr, startnode, new ProgramPath()));
		newthread.setArgs(args);
		pthreads.add(newthread);		
		IMTANode newnode = new MTCreateNode(bb, activePThreadnr, tnr);
		mtapath.addLast(newnode);		
	}

	@Override
	public void updateJoinPThread(Integer tnr) {
		IMTANode newnode = new MTJoinNode(bb, activePThreadnr, tnr);
		mtapath.addLast(newnode);
		pthreads.get(activePThreadnr).setWantsToJoin(tnr);

	}

	@Override
	public void updateLock(String lockname) {
		IMTANode newnode = new MTLockNode(bb, activePThreadnr, lockname);
		mtapath.addLast(newnode);
	}

	@Override
	public void updateUnlock(String lockname) {
		IMTANode newnode = new MTUnlockNode(bb, activePThreadnr, lockname);
		mtapath.addLast(newnode);		
	}

	@Override
	public void updateExitThread(int pThreadNr) {
		IMTANode newnode = new MTExitNode(bb, activePThreadnr, pThreadNr);
		mtapath.addLast(newnode);		
		pthreads.get(pThreadNr).setFinished();		
	}
	
	@Override
	public void updateDefine(IBinding var) {		
		IMTANode newnode = new MTDefSharedNode(bb, activePThreadnr, var);
		mtapath.addLast(newnode);				
	}

	@Override
	public void updateUse(IASTName name) {
		// possibly multiple use nodes (and others) for one cfgnode
		IMTANode newnode = new MTUseSharedNode(bb, activePThreadnr, name);
		mtapath.addLast(newnode);		
	}
		
	@Override
	public void backtrackStartPThread(int tnr) {
		// no backtracking		
	}
	@Override
	public void backtrackJoinPThread(int waitingThread) {
		// no backtracking		
	}
	@Override
	public void backtrackExitPThread(int tnr) {
		// no backtracking		
	}

}
