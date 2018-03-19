package smtcodan.multithreadanalysis.checkers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.ICfgData;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.core.resources.IFile;

import smtcodan.WorkPool;
import smtcodan.multithreadanalysis.IMTANode;
import smtcodan.multithreadanalysis.MTDefSharedNode;
import smtcodan.multithreadanalysis.MTUseSharedNode;
import smtcodan.multithreadanalysis.ThreadState;

public class RaceChecker {
	
	public static String problemid = "smtcodan.checkers.mypsproblem";

	WorkPool wp;
	
	public RaceChecker(WorkPool wp) {
		this.wp = wp;
	}
	
	public void	findRace(ArrayDeque<IMTANode> interleaving) {
		int numthreads = ThreadState.peekThreadNr() -1;
		ArrayList<HashMap<IBinding,Integer>> openUses = new ArrayList<HashMap<IBinding,Integer>>();
		for (int i=0; i<numthreads; i++) {
			openUses.add(new HashMap<IBinding,Integer>());
		}		
		Iterator<IMTANode> iter = interleaving.iterator();
		for (Integer i=0; i<interleaving.size(); i++) {			
			IMTANode node = iter.next();
			if (node instanceof MTUseSharedNode) {
				IBinding var = ((MTUseSharedNode) node).getName().resolveBinding();
				openUses.get(node.getPThreadNr()).put(var, i); // store index of node nr of last read						
			} else if (node instanceof MTDefSharedNode) {																		
				IBinding var = ((MTDefSharedNode) node).getBinding();		
				boolean openReadOther = false;
				int otherThread = -1;
				// open read in other thread?
				for (int j=0; j<numthreads; j++) {
					if (j == node.getPThreadNr()) {
						continue;
					}
					if (openUses.get(j).containsKey(var)) {
						// overlapping reads in different threads detected
						openReadOther = true;
						otherThread = j;
					}										
				}
				if (openReadOther) {
					boolean futureWriteOther = false;
					Object[] fnodes = interleaving.toArray();
					for (int f = i; f<interleaving.size(); f++) {
						IMTANode fnode = (IMTANode) fnodes[f];
						if ((fnode instanceof MTDefSharedNode) && (fnode.getPThreadNr() == otherThread) && (((MTDefSharedNode) fnode).getBinding().equals(var) )) {
							futureWriteOther = true;
							// race found: overlapping reads and writes
							IBasicBlock bb = ((MTDefSharedNode) node).getBlock();
							ICfgData cfgd = (ICfgData) bb;
							IASTNode in = (IASTNode) cfgd.getData();							
							IFile file = (IFile) in.getTranslationUnit().getOriginatingTranslationUnit().getResource();														
							IASTFileLocation floc = getFileLocation(bb);									
							int startline = floc.getStartingLineNumber();				
							String problemMessage = new String("Race condition");
							String problemDescription = new String(" overlapping define by thread " + node.getPThreadNr() + " and thread " + otherThread);
							wp.queueProblem(problemid, file, startline, problemMessage, problemDescription);	
						}
					}										
				} 											
			}
		}
		return;
	}
	
	public IASTFileLocation getFileLocation(IBasicBlock block) {
		IASTFileLocation loc;
		if (block instanceof ICfgData) {
			Object data = ((ICfgData) block).getData();
			IASTNode in = (IASTNode) data;
			loc = in.getFileLocation();
		} else {
			loc = null;
		}
		return loc;
	}
	
}
