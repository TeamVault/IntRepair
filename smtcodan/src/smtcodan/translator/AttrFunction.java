package smtcodan.translator;

import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IBinding;

public class AttrFunction implements ITrxAttribute {

	IBinding function;
	IASTName fname;

	public AttrFunction(IASTName astname, IBinding function) {
		this.function = function;
		this.fname = astname;
	}

	@Override
	public String getName() {
		return "function";
	}

	public IBinding getBinding() {
		return function;
	}

	public IASTName getASTName() {
		return fname;
	}

}
