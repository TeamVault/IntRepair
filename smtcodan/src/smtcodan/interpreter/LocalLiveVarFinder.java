package smtcodan.interpreter;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.ICfgData;
import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;
import org.eclipse.cdt.codan.core.model.cfg.IExitNode;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.cdt.core.dom.ast.IFunction;
import org.eclipse.ui.internal.ide.dialogs.ProjectReferencePage;

import smtcodan.symvars.SymVarSSA;

public class LocalLiveVarFinder {
	
	ArrayList<SymVarSSA> lives;
	ArrayList<SymVarSSA> deads;
	Interpreter ps;
	
	public LocalLiveVarFinder(Interpreter ps) {
		this.ps = ps;
		lives = new ArrayList<SymVarSSA>();
		deads = new ArrayList<SymVarSSA>();
	} 
	
	ArrayList<SymVarSSA> doFind(IBasicBlock bb) {
		while (!(bb instanceof IExitNode)) {
			if (bb instanceof IDecisionNode) {
				// clone
				// find
				// join
			} else {
				// get ASTnode
				IASTNode an = (IASTNode) ((ICfgData) bb).getData();
				if (an != null) {
					// get Names in node
					RightSideNameVisitor v = new RightSideNameVisitor(ps);
					an.accept(v);
					lives.addAll(v.getLives());
					deads.addAll(v.getDeads());
				}				
				// next node
				bb = bb.getOutgoingNodes()[0];
			}
		}
		return lives;
	}
	
}


class RightSideNameVisitor extends ASTVisitor {
	// TODO declarations, initializers...
	
	boolean isWrite;	
	ArrayList<SymVarSSA> lives;
	ArrayList<SymVarSSA> deads;
	Interpreter ps;
	
	public RightSideNameVisitor(Interpreter ps) {
		this.ps = ps;
		shouldVisitExpressions = true;
		shouldVisitNames = true;
		lives = new ArrayList<SymVarSSA>();
		deads = new ArrayList<SymVarSSA>();
		isWrite = false;
	}
	
	public Collection<? extends SymVarSSA> getDeads() {		
		return deads;
	}

	public Collection<? extends SymVarSSA> getLives() {		
		return lives;
	}

	public int visit(IASTExpression expr) {
		// check enter assignee
		if (expr.getParent() instanceof IASTBinaryExpression) {
			IASTBinaryExpression p = (IASTBinaryExpression) expr.getParent();
			int op = p.getOperator();
			IASTExpression assignee = p.getOperand1();
			if (op == IASTBinaryExpression.op_assign && assignee.equals(expr)) {
				isWrite = true;
			}
		}		
		return PROCESS_CONTINUE;
	}
	
	public int leave(IASTExpression expr) {
		// check leave assignee
		if (expr.getParent() instanceof IASTBinaryExpression) {
			IASTBinaryExpression p = (IASTBinaryExpression) expr.getParent();
			int op = p.getOperator();
			IASTExpression assignee = p.getOperand1();
			if (op == IASTBinaryExpression.op_assign && assignee.equals(expr)) {
				isWrite = false;
			}
		}		
		return PROCESS_CONTINUE;
	}
	
	
	
	public int visit(IASTName name) {
		IBinding b = name.getBinding();
		if (b instanceof IFunction) {
			return PROCESS_CONTINUE;
		}
		SymVarSSA ssa = ps.resolveSSA(name);
		if (ssa != null) {
			if (isWrite) {			
				deads.add(ssa);
			} else {
				lives.add(ssa);
			}
		}		
		return PROCESS_CONTINUE;
	}
	
	
}