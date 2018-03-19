package smtcodan.translator;

import org.eclipse.cdt.core.dom.ast.IASTName;

public class AttrPointer implements ITrxAttribute {

	static String attrName = "pointer";
	
	public AttrPointer() {		
	}
	
	@Override
	public String getName() {		
		return attrName;
	}

}
