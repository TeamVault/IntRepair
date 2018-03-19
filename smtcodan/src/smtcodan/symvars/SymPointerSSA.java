package smtcodan.symvars;

public class SymPointerSSA extends SymVarSSA {

	public boolean hasTargetType;
	ISymObject target;
	eSymType targetType;
	Integer level;

	// offset is super.smtformula
	// hasTarget is super.isinitialized

	SymPointerSSA(String ssaName, SymPointerOrig orig) {
		super(ssaName, orig);
		ssType = eSymType.SymPointer;
		isInitialized = false;
		hasTargetType = false;
	}

	public void setTargetType(eSymType type) {
		targetType = type;
		hasTargetType = true;
	}

	public void setTarget(ISymObject so) {
		this.target = so;
		isInitialized = true;
	}

	public ISymObject getTarget() {
		return target;
	}

	public SymVarSSA getTargetSSA() {
		return ((SymVarOrig) target).getCurrentSSACopy();
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

	public boolean isNull() {
		return !isInitialized;
	}

}
