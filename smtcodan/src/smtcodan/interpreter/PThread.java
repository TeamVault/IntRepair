package smtcodan.interpreter;

import java.util.ArrayDeque;
import java.util.ArrayList;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.cdt.core.dom.ast.IFunction;
import org.eclipse.cdt.core.dom.ast.IParameter;

import smtcodan.environment.ExpVarName;
import smtcodan.pathgen.IndBasicBlock;
import smtcodan.symvars.ISymObject;
import smtcodan.symvars.SymComposite;
import smtcodan.symvars.SymFctPointer;
import smtcodan.symvars.SymFctSignature;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarOrig;

public class PThread {

	FunctionSpaceStack stack;
	int pthreadnr;
	
	IndBasicBlock actnode;
	boolean alive;
	boolean isInitialized;
	boolean wantsToJoin;
	int joinTarget;
	boolean waitsForLock;
	String wantedlockname;
	ArrayDeque<String> ownedLocks;
	
	SymPointerOrig startArgs;
	SymPointerSSA startArgsSSA;
	Interpreter ps;	
		
	boolean debugmode;
	
	static int pthreadcounter = 0;				
	
	static public void resetPThreadCounter() {
		pthreadcounter = 0;
	}
	
	static public void decPThreadCounter() {
		pthreadcounter--;
	}
	
	public PThread (Interpreter ps, SymFctSignature fsign) {
		this.ps = ps;
		stack = new FunctionSpaceStack(ps, fsign);
		pthreadnr = pthreadcounter;
		pthreadcounter++;
		alive = true;
		wantsToJoin = false;
		waitsForLock = false;
		isInitialized = false;
		ownedLocks = new ArrayDeque<String>();
		debugmode = false;
	}		
	
	public PThread(Interpreter ps) {
		// FIXME: constructor only with startnode -> for stack for path merging
		this.ps = ps;
		stack = new FunctionSpaceStack(ps);
		pthreadnr = pthreadcounter;
		pthreadcounter++;
		alive = true;
		wantsToJoin = false;
		waitsForLock = false;
		isInitialized = false;
		ownedLocks = new ArrayDeque<String>();
		debugmode = false;
	}
	
	public PThread() {
		// only for debug!
		debugmode = true;
		alive = true;
		wantsToJoin = false;
		waitsForLock = false;
		isInitialized = false;
		ownedLocks = new ArrayDeque<String>();		
	}
	
	public boolean isDebug() {
		return debugmode;
	}
	
	public boolean getWaitsForLock() {
		return waitsForLock;
	}
	
	public ArrayDeque<String> getOwnedLocks() {
		return ownedLocks;
	}
	
	public boolean getWaitsForLock(String lockname) {
		if (getWaitsForLock()) {
			if (getWantedLockName().compareTo(lockname)==0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean holdsLock(String lockname) {
		for (String owned : ownedLocks) {
			if (owned.compareTo(lockname)==0) {
				return true;
			}
		}
		return false;
	}
	
	public void lock(String lockname) {
		if (ownedLocks.contains(lockname)) {
			(new Exception("double lock")).printStackTrace();
		} else {
			ownedLocks.addLast(lockname);
			unsetWaitsForLock();
		}	
	}
	
	public void releaseLock(String lockname) {
		if (!ownedLocks.contains(lockname)) {
			(new Exception("double unlock")).printStackTrace();
		}
		ownedLocks.remove(lockname);
	}
	
	public void setWaitsForLock(String lockname) {
		waitsForLock = true;
		this.wantedlockname = lockname;
	}
	
	public void unsetWaitsForLock() {
		waitsForLock = false;
	}
	
	public String getWantedLockName() {
		return wantedlockname;
	}
	
	public boolean isInitialized() {
		return isInitialized;
	}
	
	public void setInitialized() {
		isInitialized = true;
	}
	
	public void setArgs(SymPointerOrig args) {			
		startArgs = args;		
		if (ps.isMTA()) {
			setSharedRecursion(args);
			
		}
		startArgsSSA = (SymPointerSSA) args.getCurrentSSACopy();
	}
	
	public void setSharedRecursion(ISymObject arg) {
		if (arg instanceof SymPointerOrig) {
			SymPointerOrig sparg = (SymPointerOrig) arg;
			sparg.setShared();
			SymPointerSSA spssa = (SymPointerSSA) sparg.getCurrentSSACopy();
			setSharedRecursion(spssa.getTarget());
		} else if (arg instanceof SymComposite) {
			SymComposite sc = (SymComposite) arg;
			ArrayList<SymVarOrig> svarr = sc.getFields();
			for (SymVarOrig sv : svarr) {
				setSharedRecursion(sv);
			}
		} else if (arg instanceof SymVarOrig) {
			if (arg instanceof SymFctPointer) {
				return;
			}
			// no sympointer
			((SymVarOrig) arg).setShared();
		}
		else {			
		}
	}
	
	
	public SymPointerOrig getArgs() {
		return startArgs;
	}
	
	public void setNextNode(IndBasicBlock actnode) {
		this.actnode = actnode;
	}
	
	public IndBasicBlock getNextNode() {
		return actnode;
	}
	
	public void setFinished() {
		alive = false;
	}
	
	public void unsetAlive() {
		// for mta
		alive = false;
	}
	
	public void setAlive() {
		// for mta
		alive = true;
		wantsToJoin = false;
	}
	
	
	public boolean isAlive() {
		return alive;
	}	
	
	public boolean getWantsToJoin() {
		return wantsToJoin;
	}
	
	public void setWantsToJoin(int target) {
		wantsToJoin = true;
		joinTarget = target;
	}
	
	public void unsetWantsToJoin() {
		wantsToJoin = false;
	}
	
	public int getJoinTarget() {
		return joinTarget;
	}
	
	public int getPThreadNr() {
		return pthreadnr;
	}
	
	static int peekNextPThreadnr() {
		return pthreadcounter;
	}
	
	public FunctionSpaceStack getStack() {
		return stack;
	}

	public void unsetFinished() {
		// backtracking
		alive = true;
	}

	public void unsetInitialized() {
		isInitialized = false;
		stack = new FunctionSpaceStack(ps);		
		// restore start arg ssa?
	}
	
}

