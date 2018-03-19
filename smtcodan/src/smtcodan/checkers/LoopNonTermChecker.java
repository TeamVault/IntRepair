package smtcodan.checkers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.ICfgData;
import org.eclipse.cdt.codan.core.model.cfg.IDecisionNode;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTForStatement;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.core.resources.IFile;

import smtcodan.Config;
import smtcodan.IPathObserver;
import smtcodan.InfiniteLoopException;
import smtcodan.LoopPropertyFinder;
import smtcodan.PathExplorer;
import smtcodan.PathUnsatException;
import smtcodan.Solver;
import smtcodan.interpreter.Interpreter;
import smtcodan.interpreter.PThread;
import smtcodan.quickfixes.SMTConstraintObject;
import smtcodan.symvars.SymBoolSSA;
import smtcodan.symvars.SymVarSSA;

public class LoopNonTermChecker implements IPathObserver {

	public static String problemid = "smtcodan.checkers.mypsproblem";

	public static String infiniteLoopMessage = "Infinite loop";

	Interpreter ps;
	Solver sv;

	public LoopNonTermChecker(Interpreter ps, Solver sv) {
		this.ps = ps;
		this.sv = sv;
	}

	@Override
	public void enter(PThread pthread, IBasicBlock cfgnode)
			throws PathUnsatException {
		// TODO Auto-generated method stub

	}

	@Override
	public void goBackward(PThread pthread, IBasicBlock cfgnode) {
		// TODO Auto-generated method stub
	}

	@Override
	public void loopClosed(PathExplorer pe, IBasicBlock decnode,
			int stemLength, boolean firstClosed) throws InfiniteLoopException {
		// FIXME cleanup this method

		if (!(Config.shouldCheckNonTerm() || Config.shouldCheckTerm())) {
			return;
		}

		if (ps.getTerminatesContextFree((IDecisionNode) decnode)) {
			return;
		}

		LoopPropertyFinder mf = new LoopPropertyFinder();
		IASTNode decnodeData = (IASTNode) ((ICfgData) decnode).getData();
		boolean containsModulo = false;
		boolean isMultiPath = false;
		boolean emptyFor = false;
		IASTNode emptyForNode = null;
		if (decnodeData == null) {
			// empty for-loop
			// find IASTForStatement
			emptyFor = true;
			IBasicBlock bb = decnode;
			while (((ICfgData) bb).getData() == null) {
				bb = bb.getOutgoingNodes()[0];
			}
			IASTNode in = (IASTNode) ((ICfgData) bb).getData();
			while (!(in instanceof IASTForStatement)) {
				in = in.getParent();
			}
			emptyForNode = in;
			in.accept(mf);
			containsModulo = mf.getContainsModulo();
			isMultiPath = mf.getIsMultiPath();
		} else {
			IASTNode parent = decnodeData.getParent();
			parent.accept(mf);
			containsModulo = mf.getContainsModulo();
			isMultiPath = mf.getIsMultiPath();
		}
		ArrayList<ArrayDeque<SymVarSSA>> partssas = ps
				.getPartialPathSSAs(stemLength);
		// get defs and equations
		// collect bools and ints
		StringBuffer stemdefs = new StringBuffer();
		StringBuffer stemeqs = new StringBuffer();
		StringBuffer loopdefs = new StringBuffer();
		StringBuffer loopeqs = new StringBuffer();
		ArrayList<SymVarSSA> stemBools = new ArrayList<SymVarSSA>();
		ArrayList<SymVarSSA> stemInts = new ArrayList<SymVarSSA>();
		ArrayList<SymVarSSA> loopBools = new ArrayList<SymVarSSA>();
		ArrayList<SymVarSSA> loopInts = new ArrayList<SymVarSSA>();
		ArrayList<SymVarSSA> declared = new ArrayList<SymVarSSA>();
		for (int j = 0; j < 2; j++) {
			ArrayDeque<SymVarSSA> ssas = partssas.get(j);
			for (SymVarSSA ssa : ssas) {
				StringBuffer formula = new StringBuffer("(declare-fun "
						+ ssa.getSSAName() + " () ");
				switch (ssa.getESymType()) {
				case SymBool: {
					formula.append("Bool)\n");
					if (j == 0) {
						stemBools.add(ssa);
					} else {
						loopBools.add(ssa);
					}
					break;
				}
				case SymInt: {
					formula.append("Int)\n");
					if (j == 0) {
						stemInts.add(ssa);
					} else {
						loopInts.add(ssa);
					}
					break;
				}
				case SymPointer: {
					continue;
				}
				case SymArray: {
					formula.append("(Array Int Int))\n");
					break;
				}
				case SymFctPointer: {
					continue;
				}
				default:
					(new Exception("TODO")).printStackTrace();
				}
				if (!declared.contains(ssa)) {
					if (j == 0) {
						stemdefs.append(formula);
						if (ssa.getFormula() != null) {
							stemeqs.append(ssa.getFormula() + "\n");
						}
					} else {
						loopdefs.append(formula);
						if (ssa.getFormula() != null) {
							loopeqs.append(ssa.getFormula() + "\n");
						}
					}
					declared.add(ssa);
				}
			}
		}
		// get loop source ints
		ArrayList<SymVarSSA> loopSrcInts = new ArrayList<SymVarSSA>();
		ArrayList<SymVarSSA> prevInts = new ArrayList<SymVarSSA>();
		for (SymVarSSA ssa : loopInts) {
			if (ssa.getOrigName() instanceof IASTName) {
				loopSrcInts.add(ssa);
			}
		}
		// filter overwritten ones
		ArrayDeque<SymVarSSA> toBeRemoved = new ArrayDeque<SymVarSSA>();
		ArrayDeque<SymVarSSA> toBeAdded = new ArrayDeque<SymVarSSA>();
		for (SymVarSSA ssa : loopSrcInts) {
			// filter if later ssa also in loop
			SymVarSSA lastSSACopy = ssa.getOrig().getAllSSACopies().getLast();
			if (lastSSACopy.equals(ssa)) {
				continue;
				// } else if (!loopInts.contains(lastSSACopy)) {
				// // e.g. empty for loop?
				// prevInts.add(ssa);
				// toBeAdded.add(lastSSACopy);
				// toBeRemoved.add(ssa);
				// continue;
			} else {
				toBeRemoved.add(ssa);
			}
		}
		for (SymVarSSA r : toBeRemoved) {
			loopSrcInts.remove(r);
		}
		for (SymVarSSA r : toBeAdded) {
			loopSrcInts.add(r);
			loopdefs.append("(declare-fun " + r.getSSAName() + " () Int )\n");
			loopeqs.append(r.getFormula() + "\n");
		}
		// get corresponding stem value
		for (SymVarSSA ssa : loopSrcInts) {
			ArrayDeque<SymVarSSA> prevs = ssa.getOrig().getAllSSACopies();
			Iterator<SymVarSSA> decIter = prevs.descendingIterator();
			boolean found = false;
			while (decIter.hasNext()) {
				SymVarSSA cand = decIter.next();
				if (stemInts.contains(cand)) {
					prevInts.add(cand);
					found = true;
					break;
				}
			}
			if (!found) {
				// e.g. non-accessed global prev:
				// use the predecessor
				Iterator<SymVarSSA> iter = prevs.iterator();
				SymVarSSA oldcand = null;
				while (iter.hasNext()) {
					SymVarSSA cand = iter.next();
					if (cand.equals(ssa) && (oldcand != null)) {
						prevInts.add(oldcand);
						found = true;
						break;
					}
					oldcand = cand;
				}
			}
			if (!found) {
				// can't resolve... (TODO)
				return;
			}
		}
		// get loop source bools
		ArrayList<SymVarSSA> loopSrcBools = new ArrayList<SymVarSSA>();
		ArrayList<SymVarSSA> prevBools = new ArrayList<SymVarSSA>();
		for (SymVarSSA ssa : loopBools) {
			if (ssa.getOrigName() instanceof IASTName) {
				loopSrcBools.add(ssa);
				// get corresponding stem value
				ArrayDeque<SymVarSSA> prevs = ssa.getOrig().getAllSSACopies();
				Iterator<SymVarSSA> decIter = prevs.descendingIterator();
				while (decIter.hasNext()) {
					SymVarSSA cand = decIter.next();
					if (stemBools.contains(cand)) {
						prevBools.add(cand);
						break;
					}
				}

			}
		}
		// /////////////// fixed-point constraint
		String logicDef = "(set-logic AUFLIA)\n";
		String checkSat = "(check-sat)\n";
		String exit = "(exit)\n";

		Boolean founderror = false;
		IASTNode data = (IASTNode) ((ICfgData) decnode).getData();
		StringBuffer fp = new StringBuffer();
		for (int i = 0; i < loopSrcInts.size(); i++) {
			fp.append("(assert (= " + loopSrcInts.get(i).getSSAName() + " "
					+ prevInts.get(i).getSSAName() + " ))");
		}
		fp.append("\n");

		// 1. for single-path unnested loop: check context-free infinite
		// (tautology)
		// if always infinite return
		StringBuffer loopbodyadds = new StringBuffer();
		if (!isMultiPath) {
			// remove path constraint
			// remove G(x')
			// add: not G(x'); unsat <=> always infinite

			// query last dec-bool, invert
			SymBoolSSA sbdec = ps.getLastDecBool();

			// ArrayList<IName> nameList = new ArrayList<IName>();
			// for (SymVarSSA ssa : loopSrcInts) {
			// nameList.add(ssa.getOrigName());
			// }
			// loopbodyadds = ps.getEQS(nameList);
			// FIXME: don't resolve stem vars !!!

			ArrayDeque<SymVarSSA> worklist = new ArrayDeque<SymVarSSA>();
			ArrayDeque<SymVarSSA> visited = new ArrayDeque<SymVarSSA>();
			for (SymVarSSA ssa : loopSrcInts) {
				worklist.add(ssa);
			}
			while (worklist.size() > 0) {
				SymVarSSA cand = worklist.pollFirst();
				if (!visited.contains(cand) && !partssas.get(0).contains(cand)) {
					loopbodyadds.append(cand.getFormula());
					for (SymVarSSA dep : cand.getDependencies()) {
						if (!visited.contains(dep)
								&& !partssas.get(0).contains(dep)) {
							worklist.addLast(dep);
						}
					}
				}
			}
			String skipUnsat = sbdec.getFormula() + "\n" + "(assert (= "
					+ sbdec.getSSAName() + " false ))\n";

			String query = logicDef + stemdefs.toString() + loopdefs + loopeqs
					+ loopbodyadds + skipUnsat + checkSat + exit;
			String reply = sv.queryReply(query).toString();

			if (reply.contains("unsat")) {
				founderror = true;
			}

		}
		// 2. for single-path unnested loop: check context-free finite
		// (fixed-point absence)
		// if always finite return
		if (!founderror && !isMultiPath) {
			String query = logicDef + stemdefs.toString() + loopdefs + loopeqs
					+ loopbodyadds + fp + checkSat + exit;
			String reply = sv.queryReply(query).toString();

			if (reply.contains("unsat")) {
				ps.setTerminatesContextFree((IDecisionNode) decnode);
				founderror = false;
				return;
			}

		}

		// 3. for any other loop
		// unroll, test fixed-point
		if (!founderror) {
			String query = logicDef + stemdefs.toString() + loopdefs + stemeqs
					+ loopeqs + fp + checkSat + exit;
			String reply = sv.queryReply(query).toString();
			if (reply.contains("unsat")) {
				founderror = false;
			} else {
				founderror = true;
			}
		}

		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// evaluate
		//
		// boolean founderror = (evec_unbound_G && evec_unboundG_evlge1);
		// founderror = founderror || T_fp_g;

		if (founderror) {
			// found error
			String problemMessage = new String(infiniteLoopMessage);
			String trace = ps.getTrace();
			if (trace.length() > 10000) {
				trace = (String) trace.subSequence(trace.length() - 10000,
						trace.length());
			}
			String problemDescription = new String(" trace: \n" + trace + "\n"
					+ " verification condition: TODO");

			if (data == null) {
				// find marker position empty for loop
				data = emptyForNode;
			}
			IFile file = (IFile) data.getTranslationUnit()
					.getOriginatingTranslationUnit().getResource();
			IASTFileLocation loc = data.getFileLocation();

			int startline = loc.getStartingLineNumber();

			System.out.println(" PathVal: found sat infinite loop (thread "
					+ Thread.currentThread().getId() + " )");
			pe.reportProblem(problemid, file, startline, problemMessage,
					problemDescription, new SMTConstraintObject(null, null,
							null), ps.getNvlist());

			System.out
					.println("   PathVal: Path unsat due to INFINITE LOOP (thread id "
							+ Thread.currentThread().getId() + ")");
			throw new InfiniteLoopException();
		}

	}

}