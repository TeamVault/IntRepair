package smtcodan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxExitNode;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxPlainNode;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.IExitNode;
import org.eclipse.cdt.codan.core.model.cfg.ISingleIncoming;
import org.eclipse.cdt.codan.internal.core.cfg.BranchNode;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTExpressionStatement;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTFunctionCallExpression;
import org.eclipse.core.resources.IFile;

import smtcodan.pathgen.ProgramPathIBB;

public class Localizer {
	
	private static Set<PathLoc> locs;
	
	private class PathLoc implements Comparable<PathLoc>{
		IFile f;
		int sln;
		
		private PathLoc(IFile file, int starting_line_no) {
			f = file;
			sln = starting_line_no;
		}

		@Override
		public int compareTo(PathLoc o) {
			return (null != o &&
					((null == this.f && null == o.f) ||
					(null != this.f && null != o.f && this.f.equals(o.f))) &&
					this.sln == o.sln) ? 0 : -1;
		}
	}
	
	private PathLoc getloc(IFile file, int starting_line_no) {
		PathLoc ret = new PathLoc(file, starting_line_no);
		if (null == locs)
			locs = new HashSet<>();
		
		for (PathLoc p : locs)
			if (p.compareTo(ret) == 0)
				return p;
		locs.add(ret);
		return ret;
	}
	
	private class BugLoc {
		List<PathLoc> path;
		int index;
		PathLoc fail;
		BugInfo info;
		
		public BugLoc(List<PathLoc> path, int index, BugInfo info) {
			this.path = path;
			this.index = index;
			this.info = info;
			this.fail = path.get(index);
		}
	}
	
	WorkPoolManager wpm;
	// list<program path>
	List<List<PathLoc>> paths;
	// One list of bug <pathdepth, bugtype>
	List<BugLoc> bug_locations;
	
	private void reset() {
		paths = new ArrayList<>();
		bug_locations = new ArrayList<>();
		locs = null;
	}
	
	public Localizer(WorkPoolManager wpm) {
		reset();
		this.wpm = wpm;
	}
	
	public void reportPath(ProgramPathIBB path) {
		List<PathLoc> l = new ArrayList<PathLoc>();
		for (IBasicBlock node : path.toProgramPath()) {
			IASTNode in = null;
			
			if (node instanceof CxxPlainNode) {				
				in = ((CxxPlainNode)node).getNode();
			} else if (node instanceof CxxDecisionNode) {
				in = ((CxxDecisionNode)node).getNode();
			} else if (node instanceof IExitNode) {
				CxxExitNode en = (CxxExitNode) node;				
				in = en.getNode();
			}
			
			IFile f = null;
			int lno = -1;
			if (null != in &&
				null != in.getTranslationUnit() && 
				null != in.getTranslationUnit().getOriginatingTranslationUnit() &&
				null != in.getFileLocation()) {
				f = (IFile)in.getTranslationUnit().getOriginatingTranslationUnit().getResource();
				lno = in.getFileLocation().getStartingLineNumber();
				//TODO: dirty hack, remove when cfg does not contain a function call node twice (once before the call, once after)
				if (l.contains(getloc(f, lno)) &&
/* maybe remove */	in instanceof CASTExpressionStatement &&
/* these lines */	((CASTExpressionStatement)in).getExpression() instanceof CASTFunctionCallExpression) {
					f = null;
					lno = -1;
				}
			}
			l.add(getloc(f, lno));
		}
		paths.add(l);
		for (Map.Entry<Integer, BugInfo> loc : path.bug_locations) {
			bug_locations.add(new BugLoc(l, loc.getKey(), loc.getValue()));
		}
	}
	
	public void report() {
		// <buginfo, <location, bad_path_count>>
		Map<BugInfo, Map<PathLoc, Integer>> bugmap = new HashMap<>();
		List<PathLoc> badblocks = new ArrayList<>();
		int maxbad = 0;
	
		System.out.println("Found " + bug_locations.size() + " bugs in " + paths.size() + " valid paths.");		
		
		// mark all possibly bad nodes
		for (BugLoc loc : bug_locations) {
			if (!bugmap.containsKey(loc.info))
				bugmap.put(loc.info, new HashMap<PathLoc, Integer>());
			
			for (int i = 0; i <= loc.index; i++) {
				int count = bugmap.get(loc.info).containsKey(loc.path.get(i)) ?
							bugmap.get(loc.info).get(loc.path.get(i)) : 0;
				bugmap.get(loc.info).put(loc.path.get(i), count + 1);
			}
		}
		
		for (Map.Entry<BugInfo, Map<PathLoc, Integer>> problem : bugmap.entrySet()) {
			// remove all definitely good nodes (from paths without the bug) and nodes without a useful location
			//TODO: maybe calculate the set of good PathLocs before marking bad nodes and only add them to bugmap, if they are not in the good set.
			outer:
			for (List<PathLoc> p : paths) {
				for (BugLoc bl : bug_locations)
					if (bl.path == p)
						continue outer;
				for (PathLoc l : p)
					problem.getValue().remove(l);
			}
			problem.getValue().remove(getloc(null, -1));

			// get the locations with the highest count
			Map<PathLoc, Integer> badcount = problem.getValue();
			for(PathLoc node : badcount.keySet()) {
				if(badcount.get(node) > maxbad) {
					badblocks = new ArrayList<>();
					maxbad = badcount.get(node);
				}
				if(badcount.get(node) == maxbad) {
					badblocks.add(node);
				}
			}
			
			// report problematic locations
			for(PathLoc node : badblocks) {
				if (null != node.f && -1 != node.sln)
					wpm.psReportProblem(problem.getKey().id,
							node.f, node.sln,
							problem.getKey().problemMessage,
							problem.getKey().problemDescription);
			}
		}
		reset();
	}
}
