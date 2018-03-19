package smtcodan.symvars;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.DOMException;
import org.eclipse.cdt.core.dom.ast.EScopeKind;
import org.eclipse.cdt.core.dom.ast.IFunction;
import org.eclipse.cdt.internal.core.dom.parser.c.CFunction;


public class SymFctSignature {

	IFunction binding;
	SymVarOrig rtype;
	boolean hasRType;
	ArrayList<ISymObject> params; // not to be declared
	ArrayList<IName> pnames;
	
	public SymFctSignature() {
		hasRType = false;
		params = new ArrayList<ISymObject>();
		pnames = new ArrayList<IName>();
	}
	
	public SymFctSignature(IFunction binding) {
		hasRType = false;
		params = new ArrayList<ISymObject>();
		pnames = new ArrayList<IName>();
		this.binding = binding;
	}
	
	public boolean isStaticGlobal() {
		try {
			EScopeKind esk;		
			esk = binding.getScope().getKind();
			boolean isstatic = ((CFunction) binding).isStatic();
			if (isstatic && (esk == EScopeKind.eGlobal)) {
				return true;
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public IFunction getBinding() {
		return binding;
	}
	
	public boolean hasRType() {
		return hasRType;
	}
	
	public SymVarOrig getRType() {
		assert hasRType : "trying to read non-existing return value from signature";
		return rtype;
	}
	
	public void setRType(SymVarOrig rtype) {
		this.rtype = rtype;
		hasRType = true;
	}
	
	public void addParam(ISymObject param) {
		params.add(param);	
	}	
	
	public ArrayList<ISymObject> getParams() {
		return params;
	}

	public void addParamName(IName pname) {
		pnames.add(pname);
	}	
	
	public ArrayList<IName> getParamNames() {
		return pnames;
	}
	
}
