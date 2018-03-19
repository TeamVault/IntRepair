package smtcodan.pathgen;

import java.util.ArrayList;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;

public interface IPathDecMap {

	void setUnsatLastDec(IndBasicBlock ibb);
	boolean hasFwNext(IndBasicBlock ibb);
	boolean hasBwNext(IndBasicBlock ibb);
	void remove(IndBasicBlock ibb);
	IBasicBlock getFwNext(IndBasicBlock ibb);
	IBasicBlock getBwNext(IndBasicBlock ibb);
	void dictateFwNext(IndBasicBlock ibb);	// for start path init; Attention: ibb.local is BRANCHNode
	ArrayList<IBasicBlock> peekOpenChildren(IndBasicBlock ibb); // for splitting
	
}
