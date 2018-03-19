package smtcodan.translator;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IArrayType;
import org.eclipse.cdt.core.dom.ast.IBasicType;
import org.eclipse.cdt.core.dom.ast.ICompositeType;
import org.eclipse.cdt.core.dom.ast.IEnumeration;
import org.eclipse.cdt.core.dom.ast.IEnumerator;
import org.eclipse.cdt.core.dom.ast.IField;
import org.eclipse.cdt.core.dom.ast.IFunctionType;
import org.eclipse.cdt.core.dom.ast.IPointerType;
import org.eclipse.cdt.core.dom.ast.IQualifierType;
import org.eclipse.cdt.core.dom.ast.ISemanticProblem;
import org.eclipse.cdt.core.dom.ast.IType;
import org.eclipse.cdt.core.dom.ast.ITypedef;
import org.eclipse.cdt.core.dom.ast.IValue;

import smtcodan.interpreter.ImpVarName;
import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.ISymObject;
import smtcodan.symvars.SymComposite;
import smtcodan.symvars.SymFctPointerSSA;
import smtcodan.symvars.SymPointerOrig;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarOrig;
import smtcodan.symvars.SymVarSSA;
import smtcodan.symvars.eSymType;

public class SymTypeBuilder {

	static SymTypeBuilder instance;
	ArrayList<String> specialTypedefNames;

	private SymTypeBuilder() {
		specialTypedefNames = new ArrayList<String>();
		specialTypedefNames.add("pthread_mutex_t");

	}

	public static SymTypeBuilder getInstance() {
		if (instance == null) {
			instance = new SymTypeBuilder();
			return instance;
		} else {
			return instance;
		}
	}

	boolean isSpecialTypedef(ITypedef dtype) {
		if (specialTypedefNames.contains(dtype.getName())) {
			return true;
		} else {
			return false;
		}
	}

	ISymObject buildDeclareSpecialTypedef(Interpreter ps, ITypedef dtype,
			boolean declareGlobal) {
		String name = dtype.getName();
		switch (name) {
		case "pthread_mutex_t": {
			// map to SymBool (semaphor)
			SymVarSSA ssa;
			if (declareGlobal) {
				ssa = (SymVarSSA) ps.declareGlobal(eSymType.SymBool, null);
			} else {
				ssa = (SymVarSSA) ps.declareLocal(eSymType.SymBool, null);
			}
			return ssa;
		}
		}
		return null;
	}

	public ISymObject buildDeclareInit(Interpreter ps, IName iname, IType type,
			IValue val, boolean declareGlobal) {
		if (type instanceof IQualifierType) {
			return buildDeclareInit(ps, iname,
					((IQualifierType) type).getType(), val, declareGlobal);
		} else if (type instanceof IPointerType) {
			IType ttype = ((IPointerType) type).getType();
			if (ttype instanceof IFunctionType) {
				// function pointer
				SymFctPointerSSA ssa = (SymFctPointerSSA) ps.declareLocal(
						eSymType.SymFctPointer, iname);
				return ssa;
			} else {

				SymPointerOrig sp = null;
				SymPointerSSA ssa = null;
				if (declareGlobal) {
					ssa = (SymPointerSSA) ps.declareGlobal(eSymType.SymPointer,
							iname);
					sp = (SymPointerOrig) ssa.getOrig();
					iname = sp.getOrigName();
					if (ps.isMTA()) {
						if (iname instanceof ImpVarName) {
							// do nothing
						} else {
							IASTName in = (IASTName) iname;
							ps.notifySMemUse(in);
						}
					}
				} else {
					ssa = (SymPointerSSA) ps.declareLocal(eSymType.SymPointer,
							iname);
					sp = (SymPointerOrig) ssa.getOrig();
				}
				if (val != null) {
					if (val.numericalValue() == 0) {
						// null pointer
						return ssa;
					}
				}
				if (!(ttype instanceof IBasicType)) {
					ISymObject so = this.buildDeclareInit(ps, null, ttype,
							null, declareGlobal);
					sp.setTargetType(so.getSymType());
					ssa.setTarget(so);
					return ssa;
				} else {
					return ssa;
				}
			}
		} else if (type instanceof ICompositeType) {
			SymComposite sc = null;
			if (declareGlobal) {
				sc = (SymComposite) ps.declareGlobal(eSymType.SymComposite,
						iname);
			} else {
				sc = (SymComposite) ps.declareLocal(eSymType.SymComposite,
						iname);
			}

			IField[] fields = ((ICompositeType) type).getFields();
			for (IField field : fields) {
				if (field instanceof ISemanticProblem) {
					continue;
				}

				ISymObject ssa = this.buildDeclareInit(ps, null,
						field.getType(), null, declareGlobal);
				SymVarOrig svo = ((SymVarSSA) ssa).getOrig();
				sc.addField(svo, field.getName());
			}
			return sc;
		} else if (type instanceof ITypedef) {
			if (isSpecialTypedef((ITypedef) type)) {
				return buildDeclareSpecialTypedef(ps, (ITypedef) type,
						declareGlobal);
			} else {
				IType dtype = ((ITypedef) type).getType();
				return buildDeclareInit(ps, iname, dtype, val, declareGlobal);
			}
		} else if (type instanceof IBasicType) {
			SymVarSSA ssa = null;
			IBasicType btype = (IBasicType) type;
			switch (btype.getKind()) {
			case eChar: {
				if (declareGlobal) {
					ssa = (SymVarSSA) ps.declareGlobal(eSymType.SymInt, iname);
				} else {
					ps.declareLocal(eSymType.SymInt, iname);
					ssa = ps.resolveSSA(iname);
				}
				break;
			}

			case eInt: {
				if (declareGlobal) {
					ssa = (SymVarSSA) ps.declareGlobal(eSymType.SymInt, iname);
				} else {
					ps.declareLocal(eSymType.SymInt, iname);
					ssa = ps.resolveSSA(iname);

				}
				if (val != null) {
					ssa.setFormula(new String("(assert (= " + ssa.getSSAName()
							+ " " + val + " ))"));
				}
				break;
			}
			}
			return ssa;
		} else if (type instanceof IArrayType) {

		} else if (type instanceof IFunctionType) {

		} else if (type instanceof IEnumeration) {
			SymVarSSA ssa = null;
			IEnumeration btype = (IEnumeration) type;
			String str = btype.getName();

			IEnumerator[] ir = btype.getEnumerators();
			char ch[] = btype.getNameCharArray();
			System.out.print(str);
			if (declareGlobal) {
				ssa = (SymVarSSA) ps.declareGlobal(eSymType.SymInt, iname);
			} else {
				ps.declareLocal(eSymType.SymInt, iname);
				ssa = ps.resolveSSA(iname);
			}
			if (val != null) {
				ssa.setFormula(new String("(assert (= " + ssa.getSSAName()
						+ " " + val + " ))"));
			}
			return ssa;

		}
		(new Exception()).printStackTrace();
		return null;
	}

}
