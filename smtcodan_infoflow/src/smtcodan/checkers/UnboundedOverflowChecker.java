package smtcodan.checkers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.ICfgData;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTExpression;
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
import smtcodan.interpreter.ImpVarName;
import smtcodan.interpreter.Interpreter;
import smtcodan.interpreter.PThread;
import smtcodan.symvars.SymVarSSA;

public class UnboundedOverflowChecker implements IPathObserver {

	public static String problemid = "smtcodan.checkers.mypsproblem";
	
	Interpreter ps;
	Solver sv;
	
	public UnboundedOverflowChecker (Interpreter ps, Solver sv) {
		this.ps = ps;
		this.sv = sv;
	}
			
	public void loopClosed(PathExplorer pe, IBasicBlock decnode, int stemLength, boolean firstClosed) throws InfiniteLoopException {
		if (Config.shouldCheckUnboundedOverflow()) {
			checkUnboundedOverflow(pe, decnode, stemLength, firstClosed);
		}									
		
	}	
	
	public void checkUnboundedOverflow(PathExplorer pe, IBasicBlock decnode, int stemLength, boolean firstClosed) throws InfiniteLoopException {
		// FIXME don't use this method
	
		if (!firstClosed) {
			return;
		}
		
		LoopPropertyFinder mf = new LoopPropertyFinder();
		IASTNode decnodeData = (IASTNode) ((ICfgData) decnode).getData();
		boolean containsModulo = false;
		boolean isMultiPath = false;
		boolean emptyFor = false;
		IASTNode emptyForNode = null;
		if (decnodeData == null) {
			// empty for loop
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

		ArrayList<ArrayDeque<SymVarSSA>> partssas = ps.getPartialPathSSAs(stemLength);
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
		for (int j=0; j<2; j++) {
			ArrayDeque<SymVarSSA> ssas = partssas.get(j);
			for (SymVarSSA ssa : ssas) {								
				StringBuffer formula = new StringBuffer("(declare-fun " + ssa.getSSAName() + " () ");
				switch(ssa.getESymType()) {
				case SymBool: {
					formula.append("Bool)\n");
					if (j==0) {
						stemBools.add(ssa);
					} else {
						loopBools.add(ssa);
					}
					break;
				}	
				case SymInt: {
					formula.append("Int)\n"); 
					if (j==0) {
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
				default : (new Exception("TODO")).printStackTrace();
				}				
				if (!declared.contains(ssa)) {
					if (j==0) {
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
		for (SymVarSSA ssa: loopInts) {
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
				//			} else if (!loopInts.contains(lastSSACopy)) {
				//				// e.g. empty for loop?
				//				prevInts.add(ssa);
				//				toBeAdded.add(lastSSACopy);
				//				toBeRemoved.add(ssa);
				//				continue; 
			} else {
				toBeRemoved.add(ssa);
			}
		}
		for (SymVarSSA r : toBeRemoved) {
			loopSrcInts.remove(r);
		}		
		for (SymVarSSA r : toBeAdded) {
			loopSrcInts.add(r);
			loopdefs.append("(declare-fun "+ r.getSSAName() +" () Int )\n");
			loopeqs.append(r.getFormula() + "\n");
		}	
		// get corresponding stem value
		for (SymVarSSA ssa: loopSrcInts) {		
			ArrayDeque<SymVarSSA> prevs = ssa.getOrig().getAllSSACopies();
			Iterator<SymVarSSA> decIter = prevs.descendingIterator();
			while (decIter.hasNext()) {
				SymVarSSA cand = decIter.next();
				if (stemInts.contains(cand)) {						
					prevInts.add(cand);
					break;
				}
			}
		}						
		// get loop source bools
		ArrayList<SymVarSSA> loopSrcBools = new ArrayList<SymVarSSA>();
		ArrayList<SymVarSSA> prevBools = new ArrayList<SymVarSSA>();
		for (SymVarSSA ssa: loopBools) {
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

		String logicDef = "(set-logic AUFLIA)\n";
		String checkSat = "(check-sat)\n";
		String exit =  "(exit)\n";

		Boolean founderror = false;
		IASTNode data = (IASTNode) ((ICfgData) decnode).getData();
		String query;
		String reply;			

		/////////////////////////////////////
		// restrict normal form coefficients:
		// 1. map (prevInts, loopSrcInts) = (x,x')
		// 2. normal form equations
		// 3. forall (x,x') (normal -> loop,stem)
		//    forall (x,x') (loop,stem -> normal)

		int dims = loopSrcInts.size();					
		ConstraintCounter ccnt = new ConstraintCounter();

		data.accept(ccnt);
		int numconjuncts = ccnt.getConjunctCount();					
		int numinequalities = ccnt.getIneqCount();
		int numconstraints = -1;
		if (numinequalities == 0) {
			numconstraints = 0;
		} else {
			numconstraints = numconjuncts +1;
		}

		// 1. x, x'
		StringBuffer xdefs = new StringBuffer();
		StringBuffer xeqs = new StringBuffer();
		for (int i=0; i<prevInts.size(); i++) {
			xdefs.append("(declare-fun x"+i+" () Int)\n");
			xeqs.append("(assert (= x"+i+ " " + prevInts.get(i).getSSAName() + " ))\n");
		}
		for (int i=0; i<loopSrcInts.size(); i++) {
			xdefs.append("(declare-fun xp"+i+" () Int)\n");
			xeqs.append("(assert (= xp"+i+ " " + loopSrcInts.get(i).getSSAName() + " ))\n");
		}						
		// 2. U, u				
		StringBuffer Uudefs = new StringBuffer();
		StringBuffer Uueqs = new StringBuffer(); 
		StringBuffer Ux = new StringBuffer();
		ArrayList<StringBuffer> Uxj = new ArrayList<StringBuffer>();
		for (int j=0; j<dims; j++) {
			Uudefs.append("(declare-fun u" + j + " () Int)\n");
			StringBuffer line = new StringBuffer();
			StringBuffer Uxline = new StringBuffer();
			line.append("(assert (= xp"+j + " (+ ");
			Uxline.append("(= xp"+j + " (+ ");
			for (int i=0; i<dims; i++) {				
				Uudefs.append("(declare-fun U" + j + i + " () Int)\n" );		
				line.append("(* U"+j+i + " x"+i + " ) ");
				Uxline.append("(* U"+j+i + " x"+i + " ) ");
			}
			line.append(" u"+j +" )))\n");
			Uueqs.append(line);			
			Uxline.append(" u"+j +" ))");
			Ux.append(Uxline);			
			Uxj.add(Uxline);
		}	
		// G, g, Gnorm
		StringBuffer Ggdefs = new StringBuffer();
		StringBuffer Ggeqs = new StringBuffer();
		StringBuffer Gx = new StringBuffer();
		StringBuffer Gnorm = new StringBuffer();
		for (int j=0; j<numconstraints; j++) {
			Ggdefs.append("(declare-fun g"+j+ " () Int)\n");
			StringBuffer line = new StringBuffer();
			StringBuffer Gxline = new StringBuffer();
			StringBuffer Gnline = new StringBuffer();
			Gnline.append("(assert (= (+ ");
			line.append("(assert (<= (+ ");
			Gxline.append("(<= (+ ");			
			for (int i=0; i<dims; i++) {
				Ggdefs.append("(declare-fun G"+j+i+ " () Int)\n");
				line.append(" (* G"+j+i + " x"+i+ " ) ");
				Gxline.append(" (* G"+j+i + " x"+i+ " ) ");
				Gnline.append(" (abs G"+j+i+ ") ");
			}			
			Gnline.append(" 0 ) 1 ))\n");
			Gnorm.append(Gnline.toString());
			line.append(" 0 ) g"+j + " ))\n");
			Gxline.append(" 0 ) g"+j + " )");
			Ggeqs.append(line);		
			Gx.append(Gxline);
		}

		String equivs=null;
		String equivG = null;
		if (dims == 1) {

			// 3a. equiv. loop
			// "=>"
			StringBuffer equiv1 = new StringBuffer();
			StringBuffer loopPosts = new StringBuffer();
			equiv1.append("(assert (forall (");
			for (int i=0;i<prevInts.size(); i++) {
				equiv1.append("(t"+i +" Int) ");
			}
			for (int i=0; i<loopSrcInts.size(); i++) {
				equiv1.append("(tp"+i + " Int) ");
				loopPosts.append(removeImps(loopSrcInts.get(i)));
			}		
			equiv1.append(") (implies " + XtoT(Ux.toString()) + " " + assertsToAndsInsetNormalTp(loopPosts.toString(),loopSrcInts) + " ) )) \n");	
			for (int i=0;i<prevInts.size(); i++) {
				String cur = equiv1.toString();
				if (cur.contains(prevInts.get(i).getSSAName())) {
					cur = cur.replace(prevInts.get(i).getSSAName(), " t"+i +" ");
				}
				equiv1 = new StringBuffer(cur);
			}		
			// "<="
			StringBuffer equiv2 = new StringBuffer();
			equiv2.append("(assert (forall (");
			for (int i=0;i<prevInts.size(); i++) {
				equiv2.append("(t"+i +" Int) ");
			}
			for (int i=0; i<loopSrcInts.size(); i++) {
				equiv2.append("(tp"+i + " Int) ");
			}
			equiv2.append(") (implies " + assertsToAndsInsetNormalTp(loopPosts.toString(), loopSrcInts)  + " " + XtoT(Ux.toString()) + " " + " ) ))\n");
			for (int i=0;i<prevInts.size(); i++) {
				String cur = equiv2.toString();
				if (cur.contains(prevInts.get(i).getSSAName())) {
					cur = cur.replace(prevInts.get(i).getSSAName(), " t"+i +" ");
				}
				equiv2 = new StringBuffer(cur);
			}
			// 3b. equiv. guard
			// "=>"
			StringBuffer equiv3 = new StringBuffer();
			StringBuffer loopPres = new StringBuffer();
			equiv3.append("(assert (forall (");		
			for (int i=0;i<prevInts.size(); i++) {
				equiv3.append("(t"+i +" Int) ");
				loopPres.append(prevInts.get(i).getFormula());
			}
			equiv3.append(") (implies " + Sharpen(XtoT(Gx.toString())) + " " + assertsToAndsInsetNormalT(loopPres.toString(),prevInts) + " ) )) \n");			
			// "<="
			StringBuffer equiv4 = new StringBuffer();
			equiv4.append("(assert (forall (");	
			for (int i=0;i<prevInts.size(); i++) {
				equiv4.append("(t"+i +" Int) ");			
			}
			equiv4.append(") (implies " + assertsToAndsInsetNormalT(loopPres.toString(),prevInts) + " " + Sharpen(XtoT(Gx.toString())) + " ) )) \n");		

			equivs = equiv1.toString() + equiv2;		
			equivG = equiv3.toString() + equiv4;

		} else if (dims == 2) {
			ArrayList<String> loopPosts = new ArrayList<String>();
			for (int i=0; i<loopSrcInts.size(); i++) {
				String line = removeImps(loopSrcInts.get(i));
				line = removeAssert(line);
				// get in equal x, xp
				line = removeAssert(propToPrevInts(loopSrcInts.get(i), prevInts));			
				line = insertNormalT(line, prevInts);
				line = insertNormalTp(line, loopSrcInts);
				loopPosts.add(line);				
				//loopPosts.append(removeImps(loopSrcInts.get(i)));
			}					
			ArrayList<StringBuffer> equiv = new ArrayList<StringBuffer>();
			for (int j=0; j< dims; j++) {
				StringBuffer line = new StringBuffer();
				StringBuffer line2 = new StringBuffer();
				line.append("(assert (forall (");
				for (int i=0; i<dims; i++) {
					line.append("(t"+i +" Int) ");
				}
				line.append("(tp"+j +" Int) ");	
				line2.append(line.toString());
				line.append(") (implies " + XtoT(Uxj.get(j).toString()) + " " + loopPosts.get(j) + " ) )) \n");													
				line2.append(") (implies " + loopPosts.get(j) + " " + XtoT(Uxj.get(j).toString()) + " ) )) \n");				
				equiv.add(line);
				equiv.add(line2);
			}				
			StringBuffer eqconc = new StringBuffer();
			for (int e=0; e<equiv.size(); e++) {
				eqconc.append(equiv.get(e));
			}
			equivs = eqconc.toString();
		}			

		String basicU = stemdefs.toString() + loopdefs + xdefs + Uudefs  + stemeqs + loopeqs +  xeqs + Uueqs  ;
		String basicG = xdefs.toString() + Ggdefs + "(assert "+ Sharpen(Gx.toString()) + ")\n";
		String basicset = stemdefs.toString() + loopdefs + xdefs + Uudefs + Ggdefs  + stemeqs + loopeqs +  xeqs + Uueqs + Ggeqs ;				

		// check integrity: must be sat.
		//				query = basicU  +  checkSat + exit;	
		//				reply = sv.queryReply(query).toString();

		StringBuffer getNormal = new StringBuffer();
		StringBuffer getU = new StringBuffer();
		StringBuffer getG = new StringBuffer();
		getNormal.append("(get-value ( ");
		getU.append("(get-value ( ");
		getG.append("(get-value ( ");
		for (int j=0; j< dims; j++) {
			for (int i=0; i< dims; i++) {
				getNormal.append("U"+j+i +" ");
				getU.append("U"+j+i +" ");
			}				
			getNormal.append(" u"+j + " ");
			getU.append(" u"+j + " ");;
		}			
		for (int c=0; c<numconstraints; c++) {
			for (int i=0; i< dims; i++) {
				getNormal.append("G"+c+i +" ");										
				getG.append("G"+c+i +" ");		
			}				
			getNormal.append(" g"+c + " ");
			getG.append(" g"+c + " ");
		}
		getNormal.append(" ))\n");
		getU.append(" ))\n");
		getG.append(" ))\n");

		query = basicU + equivs +  checkSat + getU + exit;	
		reply = sv.queryReply(query).toString();

		// parse U
		ArrayList<ArrayList<Integer>> U = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> u = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
		G.add(new ArrayList<Integer>());
		ArrayList<Integer> g = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(reply," )(\n",false);
		String token = st.nextToken("\n");
		String line;
		StringTokenizer ltokenz;
		for (int j=0; j<dims; j++) {		
			U.add(new ArrayList<Integer>());				
			for (int i=0; i<dims; i++) {
				// per line
				line = st.nextToken("\n");
				ltokenz = new StringTokenizer(line, " ()");					
				// get Uji
				token = ltokenz.nextToken(" ");
				token = ltokenz.nextToken(")");
				token = token.replace("(", "").replace(" ", ""); // brackets for negative numbers... and white spaces
				//Integer coeff = Integer.parseInt(token.trim());
				Integer coeff = Integer.parseInt(token);
				U.get(j).add(coeff);			
			}
			// get uj		
			line = st.nextToken("\n");
			ltokenz = new StringTokenizer(line, " ()");		
			token = ltokenz.nextToken(" ");
			token = ltokenz.nextToken(")");
			token = token.replace("(", "").replace(" ", "").replace("\n", ""); // brackets for negative numbers... and white spaces
			Integer coeff = Integer.parseInt(token);
			u.add(coeff);	
		}

		// normal form assertions
		StringBuffer normU = new StringBuffer();
		for (int j=0; j<dims; j++) {
			for (int i=0; i<dims; i++) {					
				normU.append("(assert (= U"+j+i +" " + U.get(j).get(i) + " ))\n");
			}				
			normU.append("(assert (= u"+j + " "+ u.get(j) + " ))\n");
		}

		if (dims == 1) {
			query = basicset + normU + equivG + checkSat + getG + exit;	
		} else if (dims == 2) {
			//  equiv. guard
			// FIXME?
			SymVarSSA rootBool = stemBools.get(0);
			String guard1 = removeImps(rootBool);
			String guard2 = insertNormalT(guard1, prevInts);
			String guard3 = Sharpen(guard2);			
			StringBuffer equiv3 = new StringBuffer();
			StringBuffer equiv4 = new StringBuffer();
			equiv3.append("(assert (forall (");		
			for (int i=0;i<prevInts.size(); i++) {
				equiv3.append("(t"+i +" Int) ");				
			}
			equiv4.append(equiv3.toString());
			equiv3.append(") (implies " + Sharpen(XtoT(Gx.toString())) + " " + guard3 + " ) )) \n");			
			equiv4.append(") (implies " + guard3 + " " + Sharpen(XtoT(Gx.toString())) + " ) )) \n");
			equivG = equiv3.toString() + equiv4;
			query = basicG + equivG + checkSat + getG + exit;	
		}

		// get G,g

		reply = sv.queryReply(query).toString();			

		st = new StringTokenizer(reply," )(\n",false);
		token = st.nextToken("\n");
		for (int i=0; i<dims; i++) {
			line = st.nextToken("\n");
			ltokenz = new StringTokenizer(line, " ()");		
			ltokenz  = new StringTokenizer(line, " ()");
			// get Gij
			token = ltokenz.nextToken(" ");
			token = ltokenz.nextToken(")");
			token = token.replace("(", "").replace(" ", ""); // brackets for negative numbers... and white spaces
			//Integer coeff = Integer.parseInt(token.trim());
			Integer coeff = Integer.parseInt(token);
			G.get(0).add(coeff);				
		}
		// get gj		
		line = st.nextToken("\n");
		ltokenz = new StringTokenizer(line, " ()");		
		token = ltokenz.nextToken(" ");
		token = ltokenz.nextToken(")");
		token = token.replace("(", "").replace(" ", "").replace("\n", ""); // brackets for negative numbers... and white spaces
		Integer coeff = Integer.parseInt(token);
		g.add(coeff);	
		// normal form assertions
		StringBuffer normG = new StringBuffer();
		for (int j=0; j<numconstraints; j++) {
			for (int i=0; i<dims; i++) {
				normG.append("(assert (= G"+j+i +" "+ G.get(j).get(i) + " ))\n");				
			}
			normG.append("(assert (= g"+j +" "+ g.get(j) + " ))\n");
		}
		String normcoeffs = normU.toString() + normG;

		// check properties
		//
		boolean U_evec_unbound_G;
		boolean u_KerU;
		boolean u_isEvecU_unbound_G;
		boolean u_x_lindep;		
		boolean case4;
		
		// U has EV in unbounded G-direction(s)		
		StringBuffer evalue = new StringBuffer();
		StringBuffer evaluedefs = new StringBuffer();
		// not compute determinant, not linear
		evaluedefs.append((new String("(declare-fun lambda () Int)\n")));			
		evalue.append("(assert (>= lambda 0 ))\n");
		StringBuffer evec = new StringBuffer();
		StringBuffer evecdef = new StringBuffer();
		if (dims == 1) {
			evecdef.append(new String("(declare-fun v0 () Int)\n"));
			evec.append(new String("(assert (= (* U00 v0) (* lambda v0 ) ))\n"));			
			// evec not zero vector
			evec.append("(assert (> (abs v0) 0))\n");
		} else if (dims == 2) {
			evecdef.append(new String("(declare-fun v0 () Int)\n"));
			evecdef.append(new String("(declare-fun v1 () Int)\n"));												
			evec.append(new String("(assert (= (+ (* U00 v0) (* U01 v1) ) (* lambda v0 ) ))\n"));	
			evec.append(new String("(assert (= (+ (* U10 v0) (* U11 v1) ) (* lambda v1 ) ))\n"));	
			// evec not zero vector
			evec.append("(assert (> (+ (abs v0) (abs v1) ) 0))\n");
		} else {				
			(new Exception("TODO")).printStackTrace();
			return;
		}
		// unbounded ? G-lines point to outside!
		StringBuffer evec_unboundG = new StringBuffer();
		if (dims == 1) {
			for (int c=0; c<numconstraints; c++) {
				evec_unboundG.append(new String("(assert (<= "));
				evec_unboundG.append(new String("(* G"+c+ "0 v"+c +" )"));				
				evec_unboundG.append(new String("   0))\n"));			
			}		
		} else {
			for (int c=0; c<numconstraints; c++) {
				evec_unboundG.append(new String("(assert (<= (+ "));
				for (int i=0; i<dims; i++) {
					evec_unboundG.append(new String("(* G"+c+i + " v"+i +" ) "));				
				}
				evec_unboundG.append(new String(" )  0) )\n"));			
			}
		}

		query = evecdef.toString() + evaluedefs + basicset + normcoeffs + evalue + evec + evec_unboundG +  checkSat + exit;
		reply = sv.queryReply(query).toString();
		if (reply.contains("unsat")) {
			U_evec_unbound_G = false;
		} else {
			U_evec_unbound_G = true;
		}	
		
		// u is element of Ker(U)
		StringBuffer ukernel = new StringBuffer();
		ukernel.append("(assert (= 0 (+ ");
		for (int j=0; j<dims; j++) {
			for (int i=0; i<dims; i++) {
				ukernel.append("(* U"+j+i+ " u"+i + " )"  );
			}						
		}
		ukernel.append(" 0 )))\n");
		query = basicset + normcoeffs + ukernel + checkSat + exit;
		reply = sv.queryReply(query).toString();
		if (reply.contains("unsat")) {
			u_KerU = false;
		} else {
			u_KerU = true;
		}
		
		// u is eigenvector of U in unbounded G-direction	
		StringBuffer u_evalue = new StringBuffer();
		StringBuffer u_evaluedefs = new StringBuffer();
		// not compute determinant, not linear
		u_evaluedefs.append((new String("(declare-fun lambdau () Int)\n")));			
		u_evalue.append("(assert (>= lambdau 0 ))\n");
		StringBuffer u_evec = new StringBuffer();
		if (dims == 1) {
			u_evec.append(new String("(assert (= (* U00 u0) (* lambdau u0 ) ))\n"));			
			// evec not zero vector
			u_evec.append("(assert (> (abs u0) 0))\n");
		} else if (dims == 2) {											
			u_evec.append(new String("(assert (= (+ (* U00 u0) (* U01 u1) ) (* lambdau u0 ) ))\n"));	
			u_evec.append(new String("(assert (= (+ (* U10 u0) (* U11 u1) ) (* lambdau u1 ) ))\n"));	
			// evec not zero vector
			u_evec.append("(assert (> (+ (abs u0) (abs u1) ) 0))\n");
		} else {				
			(new Exception("TODO")).printStackTrace();
			return;
		}
		// unbounded ? G-lines point to outside!
		StringBuffer u_evec_unboundG = new StringBuffer();
		if (dims == 1) {
			for (int c=0; c<numconstraints; c++) {
				u_evec_unboundG.append(new String("(assert (<= "));
				u_evec_unboundG.append(new String("(* G"+c+ "0 u"+c +" )"));				
				u_evec_unboundG.append(new String("   0))\n"));			
			}		
		} else {
			for (int c=0; c<numconstraints; c++) {
				u_evec_unboundG.append(new String("(assert (<= (+ "));
				for (int i=0; i<dims; i++) {
					u_evec_unboundG.append(new String("(* G"+c+i + " u"+i +" ) "));				
				}
				u_evec_unboundG.append(new String(" )  0) )\n"));			
			}
		}
		query = u_evaluedefs + basicset + normcoeffs + u_evalue + u_evec + u_evec_unboundG +  checkSat + exit;
		reply = sv.queryReply(query).toString();
		if (reply.contains("unsat")) {
			u_isEvecU_unbound_G = false;
		} else {
			u_isEvecU_unbound_G = true;
		}
		
		if (dims == 1) {
			u_x_lindep = true;
		} else {
			// FIXME: correct formula    ax + bu =0 
			StringBuffer uxlindep = new StringBuffer("(assert (= (+ ");
			for (int j=0; j<dims; j++) {
				uxlindep.append("(* x"+j + " u"+j +" ) ");
			}
			uxlindep.append(" 0) ");
			uxlindep.append(" 0 ))\n");
			query = u_evaluedefs + basicset + normcoeffs + u_evalue + u_evec + u_evec_unboundG + uxlindep + checkSat + exit;
			reply = sv.queryReply(query).toString();
			if (reply.contains("unsat")) {
				u_x_lindep= false;
			} else {
				u_x_lindep = true;
			}
		}
		
		// concrete evec for case 4:
		case4 = false;
		if (U_evec_unbound_G && u_x_lindep) {
			int lambda;
			String getEval = new String("(get-value (lambda))\n");
			query = evecdef.toString() + evaluedefs + basicset + normcoeffs + evalue + evec + evec_unboundG +  checkSat + getEval + exit;
			reply = sv.queryReply(query).toString();
			String parts[] = reply.split("lambda");
			String part = parts[1].replace(")", "").replace(" ", "").replace("\n", "");
			lambda = Integer.parseInt(part);
			// FIXME multi-dim!
			String geom = new String("(assert (>= (* (- lambda 1) (abs x0) )  (* lambda (abs u0) ) ))\n");
			query = evecdef.toString() + evaluedefs + basicset + normcoeffs + evalue + evec + evec_unboundG + geom +  checkSat + exit;
			reply = sv.queryReply(query).toString();
			if (reply.contains("unsat")) {
				case4 = false;
			} else {
				case4 = true;
			}			
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// evaluate
		//
		// case 1:
		founderror = U_evec_unbound_G && (u_KerU || u_isEvecU_unbound_G);
		// case 2:
		founderror = founderror || case4;
		
		if (founderror) {
			// found error
			String problemMessage = new String("Overflow in loop");
			String trace = ps.getTrace();
			if (trace.length() > 10000) {
				trace = (String) trace.subSequence(trace.length()-10000, trace.length());
			}
			String problemDescription = new String(" trace: \n"  + 
					trace + "\n" + 
					" verification condition: TODO"); 

			IFile file = (IFile) data.getTranslationUnit().getOriginatingTranslationUnit().getResource();
			IASTFileLocation loc = data.getFileLocation();

			int startline = loc.getStartingLineNumber();	

			System.out.println(" PathVal: found sat unbounded (loop) overflow, (thread " + Thread.currentThread().getId() + " )");
			pe.reportProblem(problemid, file, startline, problemMessage, problemDescription);
		
			// FIXME workaraound to stop further unrolling
			throw new InfiniteLoopException();
		}		

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
	
	public String IntToReal(String input) {
		String result;
		result = input.replace("Int", "Real");
		result = result.replace("div", "/");
		return result;
	}

	public String removeImps(SymVarSSA ssa) {
		String expformula = new String();
		expformula = ssa.getFormula();
		for (SymVarSSA dep : ssa.getDependencies()) {
			if (dep.getOrigName() instanceof ImpVarName) {
				expformula = expformula.replace(dep.getSSAName(), removeImps(dep));
			}
		}		
		if (ssa.getOrigName() instanceof ImpVarName) {
			expformula = expformula.substring(10, expformula.length() - 2);
			expformula = expformula.replace(ssa.getSSAName(), "");
			return expformula;
		} else {
			return expformula;
		}

	}

	public String propToPrevInts(SymVarSSA ssa, ArrayList<SymVarSSA> prevInts) {
		// FIXME
		String expformula = new String();
		expformula = ssa.getFormula();
		for (SymVarSSA dep : ssa.getDependencies()) {
			for (SymVarSSA prev : prevInts) {
				if (dep.getFormula().contains(prev.getSSAName()) ) {				
					expformula = expformula.replace(dep.getSSAName(), prev.getSSAName());							
					return expformula;
				}				
			}			
		}		
		return expformula;
	}

	public String XtoT(String input) {
		return input.replace("x", "t");
	}

	public String Sharpen(String input) {
		String result = new String(input);
		result = result.replace(">=", "=");
		result = result.replace("<=", "=");
		result = result.replace("<", "=");
		result = result.replace(">", "=");		
		return result;
	}

	public String removeAssert(String input) {
		String filtered = input.substring(8, input.length() - 1) + " ";
		return filtered;
	}

	public String assertsToAnds(String input) {
		StringBuffer filtered = new StringBuffer();
		StringTokenizer tokenz = new StringTokenizer(input, "\n");
		String line = tokenz.nextToken("\n");
		filtered.append(line.substring(8, line.length() - 1) + " ");		
		while (tokenz.hasMoreElements()) {
			line = tokenz.nextToken("\n");
			line = line.substring(8, line.length() - 1 ) + " ";
			filtered.insert(0, "(and ");
			filtered.append(line);						
			filtered.append(" )");
		}		
		return filtered.toString();
	}

	public String insertNormalTp(String input, ArrayList<SymVarSSA> loopSrcInts) {
		StringBuffer filtered = new StringBuffer();
		StringTokenizer tokenz = new StringTokenizer(input, "\n");
		String line = tokenz.nextToken("\n");
		for (int i=0; i< loopSrcInts.size(); i++) {
			SymVarSSA ssa = loopSrcInts.get(i);
			if (line.contains(ssa.getSSAName())) {
				line = line.replace(ssa.getSSAName(), "tp"+i);
			}			
		}
		return line;
	}

	public String insertNormalT(String input, ArrayList<SymVarSSA> prevInts) {
		StringBuffer filtered = new StringBuffer();
		StringTokenizer tokenz = new StringTokenizer(input, "\n");
		String line = tokenz.nextToken("\n");
		for (int i=0; i< prevInts.size(); i++) {
			SymVarSSA ssa = prevInts.get(i);
			if (line.contains(ssa.getSSAName())) {
				line = line.replace(ssa.getSSAName(), "t"+i);
			}			
		}
		return line;
	}

	public String assertsToAndsInsetNormalTp(String input, ArrayList<SymVarSSA> loopSrcInts) {
		StringBuffer filtered = new StringBuffer();
		StringTokenizer tokenz = new StringTokenizer(input, "\n");
		String line = tokenz.nextToken("\n");
		for (int i=0; i< loopSrcInts.size(); i++) {
			SymVarSSA ssa = loopSrcInts.get(i);
			if (line.contains(ssa.getSSAName())) {
				line = line.replace(ssa.getSSAName(), "tp"+i);
			}
		}
		filtered.append(line.substring(8, line.length() - 1) + " ");		
		while (tokenz.hasMoreElements()) {
			line = tokenz.nextToken("\n");
			for (int i=0; i< loopSrcInts.size(); i++) {
				SymVarSSA ssa = loopSrcInts.get(i);
				if (line.contains(ssa.getSSAName())) {
					line = line.replace(ssa.getSSAName(), "tp"+i);
				}
			}
			line = line.substring(8, line.length() - 1 ) + " ";
			filtered.insert(0, "(and ");
			filtered.append(line);						
			filtered.append(" )");
		}		
		return filtered.toString();
	}

	public String assertsToAndsInsetNormalT(String input, ArrayList<SymVarSSA> loopSrcInts) {
		StringBuffer filtered = new StringBuffer();
		StringTokenizer tokenz = new StringTokenizer(input, "\n");
		String line = tokenz.nextToken("\n");
		for (int i=0; i< loopSrcInts.size(); i++) {
			SymVarSSA ssa = loopSrcInts.get(i);
			if (line.contains(ssa.getSSAName())) {
				line = line.replace(ssa.getSSAName(), "t"+i);
			}
		}
		filtered.append(line.substring(8, line.length() - 1) + " ");		
		while (tokenz.hasMoreElements()) {
			line = tokenz.nextToken("\n");
			for (int i=0; i< loopSrcInts.size(); i++) {
				SymVarSSA ssa = loopSrcInts.get(i);
				if (line.contains(ssa.getSSAName())) {
					line = line.replace(ssa.getSSAName(), "t"+i);
				}
			}
			line = line.substring(8, line.length() - 1 ) + " ";
			filtered.insert(0, "(and ");
			filtered.append(line);						
			filtered.append(" )");
		}		
		return filtered.toString();
	}	
	
	class ConstraintCounter extends ASTVisitor {
		// TODO: move functionality to PolygonParser
		int conjunctCounter;
		int ineqCounter;

		public ConstraintCounter() {
			shouldVisitExpressions = true;
			conjunctCounter = 0;
			ineqCounter = 0;
		}

		public int getConjunctCount() {
			return conjunctCounter;
		}

		public int getIneqCount() {
			return ineqCounter;
		}

		public int visit(IASTExpression expr) {		
			if (expr instanceof IASTBinaryExpression) {
				IASTBinaryExpression binexp = (IASTBinaryExpression) expr;
				int binop = binexp.getOperator();	
				if (binop == IASTBinaryExpression.op_logicalAnd) {
					conjunctCounter++;
				} else if (binop == IASTBinaryExpression.op_lessEqual ||
						binop == IASTBinaryExpression.op_greaterEqual) {
					ineqCounter++;
				}
			}			
			return PROCESS_CONTINUE;
		}

	}

}
