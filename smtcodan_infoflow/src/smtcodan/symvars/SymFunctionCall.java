package smtcodan.symvars;

import java.util.ArrayList;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTName;

public class SymFunctionCall {

	IName fname;
	ArrayList<IName> paramlist;
	
	public SymFunctionCall(IName fname) {
		paramlist = new ArrayList<IName>();
		this.fname = fname;
	}
	
	public void addParam(IName param) {
		paramlist.add(param);
	}
	
	public void addAllParams(ArrayList<IName> params) {
		paramlist.addAll(params);		
	}
	
	public IName getName() {
		return fname;
	}
	
	public ArrayList<IName> getParams() {
		return paramlist;
	}
	
}
