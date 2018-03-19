package smtcodan.symvars;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;

import smtcodan.interpreter.ImpVarName;


public class SymComposite implements ISymObject {
	
	IName name;
	IName typedefname;
	ArrayList<SymVarOrig> fields;
	ArrayList<String> fieldNames;
	
	public SymComposite(IName typedefname, ImpVarName ivn) { 
		this.typedefname = typedefname;
		name = ivn;
		fields = new ArrayList<SymVarOrig>();
		fieldNames = new ArrayList<String>();
	}
	
	public SymComposite createAlias(IName aliasName) {
		SymComposite alias = new SymComposite(typedefname);
		alias.setName(aliasName);
		for (int i=0; i<fields.size(); i++) {
			alias.addField(fields.get(i), fieldNames.get(i));
		}
		return alias;
	}
	
	public IName getTypeDefName() {
		return typedefname;
	}		
	
	public SymComposite() {
		// only for function signatures (ProgramStructureFacade)
		// TODO cleanup data structure hierarchy
	}
	
	public SymComposite(IName name) {
		this.name = name;
		fields = new ArrayList<SymVarOrig>();
		fieldNames = new ArrayList<String>();
	}
	
	public eSymType getESymType() {
		return eSymType.SymComposite;
	}
	
	public void setName(IName name) {
		this.name = name;
	}
	
	public IName getName() {
		return name;
	}
	
	public void addField(SymVarOrig field, String fieldname) {
		fields.add(field);
		fieldNames.add(fieldname);
	}
	
	public SymVarSSA getField(String fieldname) {
		if (fieldNames.contains(fieldname)) {
			int idx = fieldNames.indexOf(fieldname);
			SymVarOrig so = fields.get(idx);
			SymVarSSA ssa = so.getCurrentSSACopy();
			return ssa;
		} else {
			return null;
		}
	}
	
	public SymVarOrig getFieldOrig(String fieldname) {
		if (fieldNames.contains(fieldname)) {
			int idx = fieldNames.indexOf(fieldname);
			SymVarOrig so = fields.get(idx);
			return so;
		} else {
			return null;
		}
	}
	
	public ArrayList<SymVarOrig> getFields() {
		return fields;
	}

	@Override
	public eSymType getSymType() {
		return eSymType.SymComposite;
	}
	
}
