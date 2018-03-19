package smtcodan.multithreadanalysis;

import java.util.ArrayList;

public class LRDefCoverage extends ArrayList<LRDef> {
	
	LRDefCoverage() {
		// for single interleaving		
	}
	
	public String toString() {
		int size = this.size();
		int trues = 0;
		for (LRDef def : this) {
			if (def.getLDef()) {
				trues++;
			}
			if (def.getRDef()) {
				trues++;
			}
		}
		return new String(" interleaving length " + size + ", " + trues + " true values\n");
	}
	
	LRDefCoverage(MTAPath mtapath) {
		// for interleaving set		
		for (IMTANode node : mtapath) {
			if (node instanceof MTUseSharedNode) {
				LRDef nc = new LRDef((MTUseSharedNode) node);
				this.add(nc);
			}
		}
	}		
	
	public LRDef getCoverage(MTUseSharedNode node) {
		for (LRDef def : this) {
			if (def.getNode().getRefNr() == node.getRefNr()) {
				return def;
			}
		}
		return null;		
	}
	
	void addLocalDef(MTUseSharedNode node) {
		LRDef d = new LRDef(node);
		d.setLDef();
		this.add(d);				
	}
	
	void addRemoteDef(MTUseSharedNode node) {
		LRDef d = new LRDef(node);
		d.setRDef();
		this.add(d);						
	}
	
	boolean possiblyNew(LRDefCoverage other) {
		// 'this' is reference, 'other' is partial		
		for (LRDef def : this) {
			if (def.getLDef() && def.getRDef()) {
				// node already completely covered
				continue;
			} else {
				if (other.getCoverage(def.getNode()) == null) {
					return true; // possibly new
				} else {
					// node coverage equal?
					boolean thisL = def.getLDef();
					boolean thisR = def.getRDef();
					LRDef otherDef = other.getCoverage(def.getNode());
					boolean otherL = otherDef.getLDef();
					boolean otherR = otherDef.getRDef();
					if (!( (thisL == otherL) && (thisR == otherR)  )) {
						return true; // new !
					}
				}								
			}			
		}						
		return false;
	}

	public void addCoverage(LRDefCoverage other) {
		for (LRDef def : this) {
			LRDef otherDef = other.getCoverage(def.getNode());
			
			// debug:
			if (otherDef == null) {
				(new Exception()).printStackTrace();
			}
			
			if (otherDef.getLDef()) {
				def.setLDef();
			}
			if (otherDef.getRDef()) {
				def.setRDef();
			}
		}		
	}

	public LRDefCoverage cloneElements() {
		LRDefCoverage res = new LRDefCoverage();
		res.addAll(this);
		return res;
	}	
	
}


class LRDef {
	MTUseSharedNode node;
	boolean definedLocal;
	boolean definedRemote;
	
	LRDef(MTUseSharedNode node) {
		definedLocal = false;
		definedRemote = false;
		this.node = node;
	}
	
	boolean getLDef() {
		return definedLocal;
	}
	
	boolean getRDef() {
		return definedRemote;
	}
	
	void setLDef() {
		definedLocal = true;
	}
	
	void setRDef() {
		definedRemote = true;
	}
	
	MTUseSharedNode getNode() {
		return node;
	}
}
