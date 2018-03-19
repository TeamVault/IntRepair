package smtcodan.pathgen;

import java.util.Comparator;

public class IBBComparator implements Comparator<IndBasicBlock> {
	public int compare(IndBasicBlock ibb1, IndBasicBlock ibb2) {
		return (int) (ibb1.hashCode() - ibb2.hashCode()); 
	}		
	
}