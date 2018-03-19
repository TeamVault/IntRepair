package smtcodan.multithreadanalysis;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ActionSet extends ArrayDeque<IMTANode> {

	ActionSet parent;
	
	public void setParent(ActionSet parent) {
		this.parent = parent;
	}
	
	public ActionSet getParent() {
		return parent;
	}
	
	public ActionSet cloneElements() {
		ActionSet clones = new ActionSet();
		clones.addAll(this);
		return clones;
	}
	
}
