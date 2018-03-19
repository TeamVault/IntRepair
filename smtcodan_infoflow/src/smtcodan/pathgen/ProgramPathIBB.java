package smtcodan.pathgen;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import smtcodan.BugInfo;
import smtcodan.ProgramPath;

public class ProgramPathIBB extends ArrayDeque<IndBasicBlock> {

	// <pathdepth, bugtype>
	public List<Map.Entry<Integer,BugInfo>> bug_locations;
	
	static int pathcounter;
	int number;
	boolean usesMultiThreading;

	public ProgramPathIBB() {
		super();
		bug_locations = new ArrayList<>();
		number = pathcounter++;
		usesMultiThreading = false;
	}
	
	public void addBugInfo(int pathdepth, BugInfo info) {
		bug_locations.add(new AbstractMap.SimpleEntry<>(pathdepth, info));
	}

	static void resetPathCounter() {
		pathcounter = 1;
	}

	public ProgramPath toProgramPath() {
		ProgramPath bbPath = new ProgramPath();
		for (IndBasicBlock ibb : this) {
			bbPath.add(ibb.getLocal());
		}
		return bbPath;
	}

	public String toString() {
		// return toProgramPath().toString();
		StringBuffer res = new StringBuffer();
		Iterator<IndBasicBlock> deciter = this.descendingIterator();
		int i = 0;
		while (deciter.hasNext() && i < 20) {
			res.insert(0, deciter.next().getLocal() + "\n");
			i++;
		}
		return res.toString();
	}

	public IndBasicBlock peekThirdLast() {
		// FIXME: this must be pthread-wise
		Iterator<IndBasicBlock> iter = super.descendingIterator();
		if (iter.hasNext()) {
			iter.next();
		} else {
			return null;
		}
		if (iter.hasNext()) {
			iter.next();
		} else {
			return null;
		}
		if (iter.hasNext()) {
			return iter.next();
		} else {
			return null;
		}
	}

	public IndBasicBlock peekSecondLast() {
		// pthread-wise
		int pthreadnr;
		Iterator<IndBasicBlock> iter = super.descendingIterator();
		if (iter.hasNext()) {
			IndBasicBlock last = iter.next();
			pthreadnr = last.getPThreadNr();
		} else {
			return null;
		}
		while (iter.hasNext()) {
			IndBasicBlock ibb = iter.next();
			if (ibb.getPThreadNr() == pthreadnr) {
				return ibb;
			}
		}
		return null;
	}

	public void setUsesMultiThreading() {
		usesMultiThreading = true;
	}

	public boolean getUsesMultiThreading() {
		return usesMultiThreading;
	}

	public ProgramPathIBB clone() {
		ProgramPathIBB newpath = new ProgramPathIBB();
		for (IndBasicBlock ibb : this) {
			newpath.add(ibb);
		}
		if (usesMultiThreading) {
			newpath.setUsesMultiThreading();
		}
		return newpath;
	}

}
