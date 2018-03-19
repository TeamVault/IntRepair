package smtcodan.symvars;

import org.eclipse.cdt.core.dom.IName;

public class SymArrayOrig extends SymVarOrig {

	SymIntOrig sizeSymInt;
	eSymType elemSymType;
	boolean hasElemType;

	public SymArrayOrig(IName name, SymIntOrig sizeSymInt) {
		super(name);
		this.sizeSymInt = sizeSymInt;
		soType = eSymType.SymArray;
	}

	public void setSize(SymIntOrig sizeSymInt) {
		this.sizeSymInt = sizeSymInt;
		SymArraySSA ssa = (SymArraySSA) getCurrentSSACopy();
		if (ssa != null) {
			ssa.setSize(sizeSymInt);
		}
	}

	public SymIntOrig getSize() {
		return sizeSymInt;
	}

	public void setElemType(eSymType type) {
		elemSymType = type;
		hasElemType = true;
	}

	public SymArraySSA ssaCopy() {
		String ssaName = newSSAname();
		SymArraySSA ssaCopy = new SymArraySSA(ssaName, this);
		if (sizeSymInt != null) {
			ssaCopy.setSize(sizeSymInt);
		}
		if (hasElemType) {
			switch (elemSymType) {
			case SymInt:
				ssaCopy.setElemType(eSymType.SymInt);
			case SymBool:
				ssaCopy.setElemType(eSymType.SymBool);
			case SymArray:
				ssaCopy.setElemType(eSymType.SymArray);
			case SymPointer:
				ssaCopy.setElemType(eSymType.SymPointer);
			}
		}
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
