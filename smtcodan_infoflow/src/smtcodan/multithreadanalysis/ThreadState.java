package smtcodan.multithreadanalysis;

import java.util.ArrayList;

public class ThreadState {

	boolean waitsForLock;
	String wantedLock;
	ArrayList<String> ownedLocks;
	
	boolean isAlive; 
	
	boolean wantsToJoin;
	int joinTarget;
	
	int threadnr;
	
	static int threadcounter = 0;
	
	static int nextThreadNr() {
		return threadcounter++;
	}
	
	public static int peekThreadNr() {
		return threadcounter;
	}

	static void resetThreadCounter() {
		threadcounter = 0;
	}
	
	public ThreadState() {
		waitsForLock = false;
		ownedLocks = new ArrayList<String>();
		wantsToJoin = false;
		isAlive = true;
		threadnr = nextThreadNr();
	}
	
	private ThreadState(boolean waitsForLock, String wantedLock, ArrayList<String> ownedLocks, boolean wantsToJoin, int joinTarget, boolean isAlive, int threadnr) {
		this.ownedLocks = new ArrayList<String>(); 
		this.waitsForLock = waitsForLock;
		this.wantedLock = wantedLock;
		this.ownedLocks.addAll(ownedLocks);
		this.wantsToJoin = wantsToJoin;
		this.joinTarget = joinTarget;		
		this.isAlive = isAlive;
		this.threadnr = threadnr;
	}
	
	public void setWaitsForLock(String lockname) {
		waitsForLock = true;
		wantedLock = lockname;
	}
	
	public void lock(String lockname) {
		waitsForLock = false;
		ownedLocks.add(lockname);
	}
	
	public void unlock(String lockname) {
		ownedLocks.remove(lockname);		
	}
	
	public void setWantsToJoin(int joinTarget) {
		wantsToJoin = true;
		this.joinTarget = joinTarget;
	}
	
	public boolean getWaitsForLock() {
		return waitsForLock;
	}
	
	public boolean getWaitsForLock(String lockname) {
		if (waitsForLock) {
			if (wantedLock.compareTo(lockname)==0) {
				return true;
			}
		}		
		return false;
	}	
	
	public String getWantedLock() {
		return wantedLock;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public boolean getWantsToJoin() {
		return wantsToJoin;
	}
	
	public int getJoinTarget() {
		return joinTarget;
	}
	
	public void setFinished() {
		isAlive = false;
	}
	
	public ThreadState clone() {
		ThreadState clone = new ThreadState(waitsForLock, wantedLock, ownedLocks, wantsToJoin, joinTarget, isAlive, threadnr);
		return clone;
	}

	public void unsetWantsToJoin() {
		wantsToJoin = false;
	}

	public Integer getThreadNr() {		
		return threadnr;
	}

	public boolean holdsLock(String lockname) {		
		return ownedLocks.contains(lockname);
	}
	
}
