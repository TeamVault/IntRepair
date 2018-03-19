package smtcodan.translator;

import smtcodan.symvars.SymComposite;

public class AttrSymComposite implements ITrxAttribute {

	SymComposite sc;
	
	public AttrSymComposite(SymComposite sc) {
		this.sc = sc;
	}
	
	public SymComposite getSymComposite() {
		return sc;
	}
	
	@Override
	public String getName() {
		return "symcomposite";
	}

}
