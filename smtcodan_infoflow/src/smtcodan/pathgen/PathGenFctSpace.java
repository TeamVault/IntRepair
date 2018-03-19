package smtcodan.pathgen;

import java.util.ArrayDeque;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public class PathGenFctSpace {

	IBasicBlock callNode;
	ArrayDeque <IBasicBlock> openFctCallStartNodes; 
	IBasicBlock	returnNode;
	
	public PathGenFctSpace(IBasicBlock returnNode) {
		openFctCallStartNodes = new ArrayDeque<IBasicBlock>();
		this.returnNode = returnNode;
	}
		
	public void setCallNode(IBasicBlock cn) {
		callNode = cn;
	}
	
	public void pushOpenStartNode(IBasicBlock sn) {
		openFctCallStartNodes.addLast(sn);
	}
	
	public boolean hasOpenCall() {
		return !openFctCallStartNodes.isEmpty();
	}
	
	public IBasicBlock popOpenStartNode() {
		return openFctCallStartNodes.pollLast();
	}
	
	public IBasicBlock getCallNode() {
		return callNode;
	}
	
	public IBasicBlock getReturnNode() {
		return returnNode;
	}	
	
}

