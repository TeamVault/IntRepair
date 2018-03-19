package smtcodan.translator;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTName;

public class AttrName implements ITrxAttribute {

	static String attrName = "name";
	IName name;
	
	public AttrName(IName name) {
		this.name = name;
	}
	
	public IName getIName() {
		return name;
	}
	
	public String getName() {
		return attrName;
	}

}
