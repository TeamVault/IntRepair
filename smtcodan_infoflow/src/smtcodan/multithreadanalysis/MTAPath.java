package smtcodan.multithreadanalysis;

import java.util.ArrayDeque;

public class MTAPath extends ArrayDeque<IMTANode> {

	public String toString() {
		StringBuffer sbuf = new StringBuffer();
		for (IMTANode node: this) {
			sbuf.append((MTANode) node + " ");
		}
		return sbuf.toString();
	}
	
}
