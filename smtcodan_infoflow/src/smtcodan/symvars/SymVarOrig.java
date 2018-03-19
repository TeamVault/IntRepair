package smtcodan.symvars;

import java.util.ArrayDeque;

import org.eclipse.cdt.core.dom.IName;

// FIXME: implement some atomicity (together with ImpVarName and ActionLog ! )

// TODO: this should be forbidden: "SymIntSSA ssaCopy = orig.ssaCopy();", because interpreter needs to know... 
//    (maybe move in package together with interpreter only for reduced visibility)

public abstract class SymVarOrig implements ISymObject {

	protected eSymType soType;
	protected IName origName;
	protected Integer nextSSA;
	protected Integer origNumber;
	protected ArrayDeque<SymVarSSA> ssaCopies;
	boolean confidential;
	String label; // this can be L or H (low or high, public or private)

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isConfidential() {
		return confidential;
	}

	public void setConfidential(boolean confidential) {
		this.confidential = confidential;
	}

	static Integer globalOrigCount = 0;

	boolean isShared; // TODO: more accurate with pthread info -> better r/w
						// order reduction
						// TODO: maybe move to SymVarSSA to be more accurate?

	public static void clearOrigCount() {
		globalOrigCount = 0;
	}

	public SymVarOrig() { // e.g. for formal parameters in function signatures
	}

	public String toString() {
		return origName.toString();
	}

	public SymVarOrig(IName name) {
		origName = name;
		ssaCopies = new ArrayDeque<SymVarSSA>();
		nextSSA = 0;
		origNumber = globalOrigCount;
		isShared = false;
	}

	public static void incOrigCount() {
		globalOrigCount++;
	}

	public static void decOrigCount() {
		globalOrigCount--;
	}

	public SymVarSSA getCurrentSSACopy() {
		return ssaCopies.peekLast();
	}

	public void setShared() {
		isShared = true;
	}

	public boolean isShared() {
		return isShared;
	}

	public abstract SymVarSSA ssaCopy();

	public abstract void removeLastSSA();

	public abstract void addExistingSSA(SymVarSSA ssa);

	public eSymType getSymType() {
		return soType;
	}

	String newSSAname() {
		String ssaName = new String(origName + "_" + origNumber + "_"
				+ nextSSA.toString());
		nextSSA += 1;
		return ssaName;
	}

	public IName getOrigName() {
		return origName;
	}

	public ArrayDeque<SymVarSSA> getAllSSACopies() {
		return ssaCopies;
	}

}
