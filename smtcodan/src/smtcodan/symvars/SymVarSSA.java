package smtcodan.symvars;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;

public class SymVarSSA implements ISymObject {

	public eSymType ssType;
	SymVarOrig orig;
	protected String ssaName;
	public boolean isInitialized;
	protected String smtformula;
	ArrayList<SymVarSSA> dependencies;

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

	protected SymVarSSA(String ssaName, SymVarOrig orig) {
		this.orig = orig;
		this.ssaName = ssaName;
		this.isInitialized = false;
		dependencies = new ArrayList<SymVarSSA>();
	}

	public String toString() {
		return ssaName;
	}

	public void addDependency(SymVarSSA dep) {
		dependencies.add(dep);
	}

	public SymVarOrig getOrig() {
		return orig;
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	public void addDependencies(ArrayList<SymVarSSA> deps) {
		dependencies.addAll(deps);
	}

	public ArrayList<SymVarSSA> getDependencies() {
		return dependencies;
	}

	public eSymType getESymType() {
		return ssType;
	}

	public IName getOrigName() {
		return orig.getOrigName();
	}

	public String getSSAName() {
		return ssaName;
	}

	public void setFormula(String formula) {
		assert (!isInitialized) : "trying to overwrite ssa symvar";
		smtformula = formula;
		isInitialized = true;
	}

	public String getFormula() {
		assert (isInitialized) : "trying to get formula from uninitialized syvar";
		return smtformula;
	}

	@Override
	public eSymType getSymType() {
		return orig.getSymType();
	}

}
