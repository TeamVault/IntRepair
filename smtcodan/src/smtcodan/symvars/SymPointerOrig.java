package smtcodan.symvars;

import org.eclipse.cdt.core.dom.IName;

public class SymPointerOrig extends SymVarOrig {

	eSymType targetType;
	boolean hasTargetType;
	Integer level;

	public SymPointerOrig(IName name) {
		super(name);
		soType = eSymType.SymPointer;
		hasTargetType = false;
		level = 1;
	}

	public SymPointerOrig() {
		// for fct signatures
		soType = eSymType.SymPointer;
		hasTargetType = false;
		level = 1;
	}

	public SymPointerOrig(eSymType targetType, Integer level) {
		// for fct signatures
		this.targetType = targetType;
		this.level = level;
	}

	public void setTargetType(eSymType targetType) {
		this.targetType = targetType;
		hasTargetType = true;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public SymPointerSSA ssaCopy() {
		String ssaName = newSSAname();
		SymPointerSSA ssaCopy = new SymPointerSSA(ssaName, this);
		if (hasTargetType) {
			switch (targetType) {
			case SymInt: {
				ssaCopy.setTargetType(eSymType.SymInt);
				break;
			}
			case SymArray: {
				ssaCopy.setTargetType(eSymType.SymArray);
				break;
			}
			case SymBool: {
				ssaCopy.setTargetType(eSymType.SymBool);
				break;
			}
			case SymPointer: {
				ssaCopy.setTargetType(eSymType.SymPointer);
				break;
			}
			case SymComposite: {
				ssaCopy.setTargetType(eSymType.SymComposite);
				break;
			}
			}
		}
		ssaCopy.setLevel(this.level);
		ssaCopies.addLast(ssaCopy);
		return ssaCopy;
	}

	public void removeLastSSA() {
		ssaCopies.removeLast();
		nextSSA -= 1;
	}

	@Override
	public void addExistingSSA(SymVarSSA ssa) {
		ssaCopies.add(ssa);
		nextSSA += 1;
	}

}
