package smtcodan.pathgen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeMap;

import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.IBranchNode;
import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;
import org.eclipse.cdt.core.dom.ast.IASTBreakStatement;
import org.eclipse.cdt.core.dom.ast.IASTCompoundStatement;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTForStatement;
import org.eclipse.cdt.core.dom.ast.IASTIfStatement;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.core.dom.ast.IASTSwitchStatement;
import org.eclipse.cdt.core.dom.ast.IASTWhileStatement;

public class PathDecMap implements IPathDecMap {

	// TODO: simplify !

	TreeMap<IndBasicBlock, ArrayDeque<IPathDec>> decMap;

	static int loopBound;

	static public void setLoopBound(int bound) {
		loopBound = bound;
	}

	static int getLoopBound() {
		return loopBound;
	}

	interface IPathDec {
		public boolean hasFwNext(); // forward

		public boolean hasBwNext(); // backward (backtracking)

		public IPathDec changeFwNext();

		public IPathDec changeBwNext();

		public IndBasicBlock getIBB();

		public int getBranchNr();

		public void setUnsat();

		public IPathDec clone();

		public ArrayList<IBasicBlock> peekOpenChildren(); // splitting

		public LoopDecState getState(); // to skup out for LOOP_BOUNDED
	}

	class FwDec implements IPathDec {
		IndBasicBlock decibb;
		int branchnr;

		public FwDec clone() {
			FwDec clone = new FwDec(decibb, branchnr);
			return clone;
		}

		FwDec(IndBasicBlock decibb) {
			this.decibb = decibb;
			this.branchnr = 0;
		}

		private FwDec(IndBasicBlock decibb, int branchnr) {
			this.decibb = decibb;
			this.branchnr = branchnr;
		}

		public boolean hasFwNext() {
			return true;
		}

		public IPathDec changeFwNext() {
			branchnr = 0;
			return this;
		}

		@Override
		public IndBasicBlock getIBB() {
			return this.decibb;
		}

		@Override
		public int getBranchNr() {
			return this.branchnr;
		}

		@Override
		public boolean hasBwNext() {
			int highestTaken = this.getBranchNr();
			int nrbranches = this.getIBB().getOutgoingSize();
			if (nrbranches > highestTaken + 1) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public IPathDec changeBwNext() {
			int highestTaken = this.getBranchNr();
			int nrbranches = this.getIBB().getOutgoingSize();
			int nextBranchNr = highestTaken + 1;
			assert (nextBranchNr <= nrbranches) : "problem";
			this.branchnr = nextBranchNr;
			return this;
		}

		@Override
		public void setUnsat() {
			// probably nothing to do
		}

		@Override
		public ArrayList<IBasicBlock> peekOpenChildren() {
			ArrayList<IBasicBlock> res = new ArrayList<IBasicBlock>();
			IBasicBlock allChildren[] = decibb.getLocal().getOutgoingNodes();
			int highestTaken = this.getBranchNr();
			int nrbranches = this.getIBB().getOutgoingSize();
			for (int i = highestTaken + 1; i < nrbranches; i++) {
				res.add(allChildren[i]);
			}
			return res;
		}

		@Override
		public LoopDecState getState() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	// TODO: BREAKED necessary?
	enum LoopDecState {
		NORMAL, ENTER_UNSAT, SKIP_UNSAT, LOOP_BOUNDED, BREAKED
	}

	class LoopDec implements IPathDec {

		int bound = PathDecMap.getLoopBound();
		static final int loopTaken = 0; // 'then' (body)
		static final int loopSkipped = 1; // 'else' (skipped)

		IndBasicBlock decibb;
		int loopIter;
		int branch;
		ArrayList<Integer> breakingBranches;
		LoopDecState state;

		LoopDec(IndBasicBlock decibb) {
			bound = PathDecMap.getLoopBound();
			this.decibb = decibb;
			loopIter = 0;
			branch = loopSkipped;
			state = LoopDecState.NORMAL;
			breakingBranches = getBreakingBranches(decibb);
		}

		private LoopDec(IndBasicBlock decibb, int loopIter, int branch,
				LoopDecState state) {
			this.bound = PathDecMap.getLoopBound();
			this.decibb = decibb;
			this.loopIter = loopIter;
			this.branch = branch;
			this.breakingBranches = getBreakingBranches(decibb);
			this.state = state;
		}

		public LoopDec clone() {
			return new LoopDec(decibb, loopIter, branch, state);
		}

		public boolean hasFwNext() {
			switch (state) {
			case NORMAL: {
				return true;
			}
			case LOOP_BOUNDED: {
				return false;
			}
			case BREAKED: {
				return false;
			}
			}
			assert false : "should not be reached";
			return false;
		}

		public LoopDec changeFwNext() {
			switch (state) {
			case NORMAL: {
				branch = loopSkipped;
				return this;
			}
			case LOOP_BOUNDED: {
				branch = loopSkipped;
				return this;
			}
			}
			assert false : "should not be reached";
			return null;
		}

		public IndBasicBlock getIBB() {
			return this.decibb;
		}

		public int getBranchNr() {
			return branch;
		}

		public int getIterNr() {
			return loopIter;
		}

		public boolean hasBwNext() {
			switch (state) {
			case NORMAL: {
				return true;
			}
			case SKIP_UNSAT: {
				return true;
			}
			case ENTER_UNSAT: {
				return false;
			}
			case LOOP_BOUNDED: {
				return false;
			}
			case BREAKED: {
				return false;
			}
			}
			assert false : "should not be reached";
			return false;
		}

		@Override
		public IPathDec changeBwNext() {
			switch (state) {
			case NORMAL: {
				if (loopIter + 1 < bound) {
					branch = loopTaken;
					loopIter++;
					if (breakingBranches.contains(loopTaken)) {
						state = LoopDecState.BREAKED;
					} else {
						state = LoopDecState.NORMAL;
					}
					return this;
				} else {
					branch = loopSkipped;
					state = LoopDecState.LOOP_BOUNDED;
					return this;
				}
			}
			case SKIP_UNSAT: {
				if (loopIter + 1 < bound) {
					branch = loopTaken;
					loopIter++;
					if (breakingBranches.contains(loopTaken)) {
						state = LoopDecState.BREAKED;
					} else {
						state = LoopDecState.NORMAL;
					}
					return this;
				} else {
					branch = loopTaken;
					loopIter++;
					state = LoopDecState.LOOP_BOUNDED;
					return this;
				}
			}
			}
			assert false : "should not be reached";
			return null;
		}

		public void setUnsat() {
			switch (state) {
			case NORMAL: {
				if (branch == loopTaken) {
					state = LoopDecState.ENTER_UNSAT;
				} else {
					state = LoopDecState.SKIP_UNSAT;
				}
				return;
			}
			}
			assert false : "should not be reached";
			return;
		}

		@Override
		public ArrayList<IBasicBlock> peekOpenChildren() {
			IBasicBlock allChildren[] = decibb.getOutgoingNodes();
			ArrayList<IBasicBlock> res = new ArrayList<IBasicBlock>();
			switch (state) {
			case NORMAL: {
				if (loopIter + 1 < bound) {
					res.add(allChildren[loopTaken]);
				} else {
					res.add(allChildren[loopSkipped]);
				}
				break;
			}
			case SKIP_UNSAT: {
				res.add(allChildren[loopTaken]);
				break;
			}
			}
			return res;
		}

		@Override
		public LoopDecState getState() {
			return state;
		}

	}

	public PathDecMap(int loopBound) {
		setLoopBound(loopBound);
		decMap = new TreeMap<IndBasicBlock, ArrayDeque<IPathDec>>(
				new IBBComparator());
	}

	public boolean contains(IndBasicBlock decibb) {
		return decMap.containsKey(decibb);
	}

	IPathDec peekLastPathDec(IndBasicBlock ibb) {
		ArrayDeque<IPathDec> ad = decMap.get(ibb);
		return ad.peekLast();
	}

	public void remove(IndBasicBlock decibb) {
		decMap.remove(decibb);
	}

	public void backRollLast(IndBasicBlock decibb) {
		ArrayDeque<IPathDec> ad = decMap.get(decibb);
		if (!ad.isEmpty()) {
			ad.removeLast();
		} else {
			// TODO: happened, but why?
		}
	}

	public boolean hasBwNext(IndBasicBlock actnode) {
		if (!decMap.containsKey(actnode)) {
			return false;
		}
		ArrayDeque<IPathDec> ad = decMap.get(actnode);
		IPathDec pd = ad.peekLast();
		if (pd == null) {
			// happens for loop with first unsat iteration number > 1
			return false;
		} else {
			return pd.hasBwNext();
		}
	}

	public IBasicBlock getBwNext(IndBasicBlock actnode) {
		ArrayDeque<IPathDec> ad = decMap.get(actnode);
		IPathDec pd = ad.pollLast();
		IPathDec nextpd = pd.clone();
		ad.addLast(pd);
		nextpd = nextpd.changeBwNext();
		ad.addLast(nextpd);
		IBasicBlock[] children = actnode.getOutgoingNodes();
		return children[nextpd.getBranchNr()];
	}

	public IBasicBlock getFwNext(IndBasicBlock actnode) {
		IPathDec nextpd;
		if (decMap.containsKey(actnode)) {
			ArrayDeque<IPathDec> ad = decMap.get(actnode);
			IPathDec pd = ad.pollLast();
			nextpd = pd.clone();
			ad.addLast(pd);
			nextpd = nextpd.changeFwNext();
			ad.addLast(nextpd);
			IBasicBlock[] children = actnode.getOutgoingNodes();
			if (nextpd.getState() == LoopDecState.LOOP_BOUNDED) {
				// skip out over branch node
				IBranchNode bb = (IBranchNode) children[nextpd.getBranchNr()];
				return bb.getOutgoing();
			} else {
				return children[nextpd.getBranchNr()];
			}
		} else {
			ArrayDeque<IPathDec> ad = new ArrayDeque<IPathDec>();
			nextpd = null;
			if (isFwDecNode((IDecisionNode) actnode.getLocal())) {
				nextpd = new FwDec(actnode);
			} else {
				nextpd = new LoopDec(actnode);
			}
			ad.addLast(nextpd);
			decMap.put(actnode, ad);

			IBasicBlock[] children = actnode.getOutgoingNodes();
			return children[nextpd.getBranchNr()];
		}

	}

	boolean isFwDecNode(IDecisionNode decNode) {
		CxxDecisionNode cdn = (CxxDecisionNode) decNode;
		IASTExpression branchexpr = (IASTExpression) cdn.getNode();
		if (branchexpr == null) {
			return false; // empty for loop
		}
		IASTNode decParent = branchexpr.getParent();
		if (decParent instanceof IASTIfStatement) {
			return true;
		}
		if (decParent instanceof IASTSwitchStatement) {
			return true;
		}
		return false;
	}

	boolean isLoopDecNode(IDecisionNode decNode) {
		CxxDecisionNode cdn = (CxxDecisionNode) decNode;
		IASTExpression branchexpr = (IASTExpression) cdn.getNode();
		if (branchexpr == null) {
			return true; // empty for loop
		}
		IASTNode decParent = branchexpr.getParent();
		if (decParent instanceof IASTForStatement) {
			return true;
		}
		if (decParent instanceof IASTWhileStatement) {
			return true;
		}
		return false;
	}

	public void setUnsatLastDec(IndBasicBlock decibb) {
		ArrayDeque<IPathDec> ad = decMap.get(decibb);
		if (ad == null) {
			// TODO: should never happen?
			return;
		} else {
			IPathDec pd = ad.pollLast();
			pd.setUnsat();
			ad.addLast(pd);
		}
	}

	ArrayList<Integer> getBreakingBranches(IndBasicBlock ibb) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		IBasicBlock dn = ibb.getLocal();
		IASTNode in = ((CxxDecisionNode) dn).getNode();
		if (in == null) { // empty for loop
			return result;
		}
		IASTNode parent = in.getParent();
		IBasicBlock[] children = dn.getOutgoingNodes();
		if (parent instanceof IASTWhileStatement) {
			// only check 'then' branch
			IASTCompoundStatement cs = (IASTCompoundStatement) ((IASTWhileStatement) parent)
					.getBody();
			IASTStatement[] smArray = cs.getStatements();
			IASTStatement lastSm = smArray[smArray.length - 1];
			if (lastSm instanceof IASTBreakStatement) {
				result.add(LoopDec.loopTaken);
			}
			return result;
		}
		return result;
	}

	@Override
	public boolean hasFwNext(IndBasicBlock ibb) {
		if (decMap.containsKey(ibb)) {
			ArrayDeque<IPathDec> ad = decMap.get(ibb);
			if (isLoopDecNode((IDecisionNode) ibb.getLocal())) {
				if (!ad.isEmpty()) {
					IPathDec pd = ad.peekLast();
					return pd.hasFwNext();
				} else {
					(new Exception("TODO debug")).printStackTrace();
					return false;
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	int getBranchNr(IDecisionNode decnode, IBranchNode bnode) {
		IBasicBlock[] branches = (IBasicBlock[]) decnode.getOutgoingNodes();
		for (int i = 0; i < decnode.getOutgoingSize(); i++) {
			if (bnode.equals(branches[i])) {
				return i;
			}
		}
		assert false : "error";
		return -1;
	}

	@Override
	public void dictateFwNext(IndBasicBlock ibb) {
		IndBasicBlock branchIbb = ibb; // just for clarity
		IBasicBlock parents[] = branchIbb.getLocal().getIncomingNodes();
		IDecisionNode parent = (IDecisionNode) parents[0];
		IndBasicBlock decibb = new IndBasicBlock(ibb.getPThreadNr(), parent,
				branchIbb.getEntryPath());
		if (decMap.containsKey(decibb)) {
			ArrayDeque<IPathDec> decDeque = decMap.get(decibb);
			if (isFwDecNode(parent)) {
				FwDec newDec = new FwDec(decibb, getBranchNr(parent,
						(IBranchNode) branchIbb.getLocal()));
				decDeque.addLast(newDec);
			} else {
				// LoopDec
				LoopDec oldDec = (LoopDec) decDeque.peekLast();
				int oldIterNr = oldDec.getIterNr();
				int oldBranchNr = oldDec.getBranchNr();
				int newIterNr = 0;
				if (oldBranchNr == LoopDec.loopTaken) {
					newIterNr = oldIterNr + 1;
				}
				LoopDec newDec = new LoopDec(decibb, newIterNr, getBranchNr(
						parent, (IBranchNode) branchIbb.getLocal()),
						LoopDecState.NORMAL);
				decDeque.addLast(newDec);
			}
		} else {
			ArrayDeque<IPathDec> decDeque = new ArrayDeque<IPathDec>();
			if (isFwDecNode(parent)) {
				FwDec newDec = new FwDec(decibb, getBranchNr(parent,
						(IBranchNode) branchIbb.getLocal()));
				decDeque.addLast(newDec);
			} else {
				LoopDec newDec = new LoopDec(decibb, 0, getBranchNr(parent,
						(IBranchNode) branchIbb.getLocal()),
						LoopDecState.NORMAL);
				decDeque.addLast(newDec);
			}
			decMap.put(decibb, decDeque);
		}
	}

	@Override
	public ArrayList<IBasicBlock> peekOpenChildren(IndBasicBlock ibb) {
		if (!decMap.containsKey(ibb)) {
			return null;
		}
		ArrayDeque<IPathDec> dd = decMap.get(ibb);
		IPathDec lastDec = dd.peekLast();
		return lastDec.peekOpenChildren();
	}

}
