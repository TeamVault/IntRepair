package smtcodan.translator;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.cdt.core.dom.ast.IASTNode;

public class TrxAttributeList {

	HashMap< IASTNode, ArrayList<ITrxAttribute> > map;
		
	public TrxAttributeList() {	
		map = new HashMap< IASTNode, ArrayList<ITrxAttribute> > ();
	}
	
	public void add(IASTNode owner, ITrxAttribute attr) {
		ArrayList<ITrxAttribute> list = map.get(owner);
		if (list == null) {
			list = new ArrayList<ITrxAttribute>();
			list.add(attr);
			map.put(owner, list);
		} else {
			list.add(attr);
		}		
	}
	
	public Object getAttribute(IASTNode owner, String name) {
		ArrayList<ITrxAttribute> list = map.get(owner);
		if (list == null) {		
			return null;
		} else {
			for (ITrxAttribute elem : list) {
				if (elem.getName().equalsIgnoreCase(name)) {
					return elem;
				}
			}
			return null;
		}
	}
	
	public void reset() {
		map = new HashMap< IASTNode, ArrayList<ITrxAttribute> > ();
	}
	
}

