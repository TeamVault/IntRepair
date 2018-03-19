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
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTExpressionStatement;
import org.eclipse.cdt.internal.core.dom.parser.c.CASTFunctionCallExpression;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import smtcodan.interpreter.Interpreter;
import smtcodan.pathgen.ProgramPathIBB;
import smtcodan.symvars.SymFunctionCall;
import smtcodan.symvars.SymFunctionReturn;

public class Localizer {

	private static Set<PathLoc> setofPathlocs;

	boolean found = false;

	ArrayList<IASTName> fcnames = new ArrayList<IASTName>();

	private class PathLoc implements Comparable<PathLoc> {
		IFile filename;
		int startinglinenumber;
		IBasicBlock node;

		private PathLoc(IFile file, int starting_line_no, IBasicBlock n) {
			filename = file;
			startinglinenumber = starting_line_no;
			node = n;
		}

		@Override
		public int compareTo(PathLoc o) {
			return (null != o
					&& ((null == this.filename && null == o.filename) || (null != this.filename
							&& null != o.filename && this.filename
								.equals(o.filename))) && this.startinglinenumber == o.startinglinenumber) ? 0
					: -1;
		}
	}

	private PathLoc getloc(IFile file, int starting_line_no, IBasicBlock node) {
		PathLoc ret = new PathLoc(file, starting_line_no, node);
		if (null == setofPathlocs)
			setofPathlocs = new HashSet<>();
		// it checks if the file and line number is already in the
		// pathloc else it adds it to the pathloc and then returns
		for (PathLoc p : setofPathlocs)
			if (p.compareTo(ret) == 0)
				return p;
		setofPathlocs.add(ret);
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

	SymFunctionCall nextCall;
	SymFunctionReturn nextRVal;
	WorkPoolManager wpm;
	Interpreter ps;
	// list<program path>
	List<List<PathLoc>> listofpathLocslist;
	// One list of bug <pathdepth, bugtype>
	List<BugLoc> localizer_bug_locations;

	private void reset() {
		listofpathLocslist = new ArrayList<>();
		localizer_bug_locations = new ArrayList<>();
		setofPathlocs = null;
	}

	public Localizer(WorkPoolManager wpm) {
		reset();
		this.wpm = wpm;
	}

	public void reportPath(ProgramPathIBB path) {
		List<IBasicBlock> nodeslist = new ArrayList<IBasicBlock>();
		List<PathLoc> pathlocation = new ArrayList<PathLoc>();

		for (IBasicBlock node : path.toProgramPath()) {
			IASTNode in = null;
			if (node instanceof CxxPlainNode) {
				in = ((CxxPlainNode) node).getNode();
			} else if (node instanceof CxxDecisionNode) {
				in = ((CxxDecisionNode) node).getNode();
			} else if (node instanceof IExitNode) {
				CxxExitNode en = (CxxExitNode) node;
				in = en.getNode();
			}

			IFile filename = null;
			int line_number = -1;
			if (null != in
					&& null != in.getTranslationUnit()
					&& null != in.getTranslationUnit()
							.getOriginatingTranslationUnit()
					&& null != in.getFileLocation()) {
				filename = (IFile) in.getTranslationUnit()
						.getOriginatingTranslationUnit().getResource();
				line_number = in.getFileLocation().getStartingLineNumber();
				// TODO: dirty hack, remove when cfg does not contain a function
				// call node twice (once before the call, once after)
				if (pathlocation.contains(getloc(filename, line_number, node))
						&&
						/* maybe remove */in instanceof CASTExpressionStatement
						&&
						/* these lines */((CASTExpressionStatement) in)
								.getExpression() instanceof CASTFunctionCallExpression) {
					filename = null;
					line_number = -1;
				}
				nodeslist.add(node);

			}
			pathlocation.add(getloc(filename, line_number, node));

		}
		// here we have the SatPaths
		listofpathLocslist.add(pathlocation);
		for (Map.Entry<Integer, BugInfo> loc : path.bug_locations) {
			// System.out.println(loc.getKey() + "it is the path ");
			// adding buginfo ,the depth and list of pathlocs
			localizer_bug_locations.add(new BugLoc(pathlocation, loc.getKey(),
					loc.getValue()));
		}
	}

	public void report(Interpreter ps) throws CoreException {
		// <buginfo, <location, bad_path_count>>
		Map<BugInfo, Map<PathLoc, Integer>> bugmap = new HashMap<>();
		List<PathLoc> badblocks = new ArrayList<>();
		int maxbad = 0;

		System.out.println("Found " + localizer_bug_locations.size()
				+ " bugs in " + listofpathLocslist.size() + " valid paths.");
		int j = 0;

		// mark all possibly bad nodes
		// if the bugmap initially doesnot contain the same buginfo as that of
		// Bugloc then add it to the bugmap
		for (BugLoc buglocation : localizer_bug_locations) {
			if (!bugmap.containsKey(buglocation.info))
				bugmap.put(buglocation.info, new HashMap<PathLoc, Integer>());
			// traverse untill the end of the path depth
			for (int i = 0; i <= buglocation.index; i++) {
				// if the bugmap has the key loc.path pathloc(file,line number)
				// then count is that key which is the index else increement the
				// counter
				// if the bug info is not present then increement the value
				int count = bugmap.get(buglocation.info).containsKey(
						buglocation.path.get(i)) ? bugmap.get(buglocation.info)
						.get(buglocation.path.get(i)) : 0;
				;
				// now add the bug pathloc and the count
				bugmap.get(buglocation.info).put(buglocation.path.get(i),
						count + 1);

			}

		}

		for (Map.Entry<BugInfo, Map<PathLoc, Integer>> problem : bugmap
				.entrySet()) {
			// remove all definitely good nodes (from paths without the bug) and
			// nodes without a useful location
			// TODO: maybe calculate the set of good PathLocs before marking bad
			// nodes and only add them to bugmap, if they are not in the good
			// set.
			// here we remove the not buggy path from the list of paths which
			// doesnot contain the bug_locations and the pathloc which doesnot
			// have a
			// file location and starting line
			outer: for (List<PathLoc> listofpathloc : listofpathLocslist) {
				for (BugLoc buglocationsbylocalizer : localizer_bug_locations)
					if (buglocationsbylocalizer.path == listofpathloc)
						continue outer;
				for (PathLoc l : listofpathloc)
					problem.getValue().remove(l);
			}
			problem.getValue().remove(getloc(null, -1, null));
			// get the locations with the highest count
			Map<PathLoc, Integer> badcount = problem.getValue();
			for (PathLoc node : badcount.keySet()) {

				if (badcount.get(node) > maxbad) {

					badblocks = new ArrayList<>();
					maxbad = badcount.get(node);
				}
				// here we collect the nodes with the same keyvalue
				if (badcount.get(node) == maxbad) {
					badblocks.add(node);

				}

			}
			// report problematic locations
			ArrayList<PathLoc> badnode = new ArrayList<PathLoc>();
			ArrayList<PathLoc> same_path = new ArrayList<PathLoc>();
			HashMap<PathLoc, List<PathLoc>> node_path = new HashMap<PathLoc, List<PathLoc>>();
			for (List<PathLoc> listofpathloc : listofpathLocslist) {
				for (PathLoc node : badblocks) {
					if (listofpathloc.contains(node)) {
						// maintain hashmap of the node and its corresponding
						// path
						node_path.put(node, listofpathloc);
					}

				}
			}

			for (PathLoc node : node_path.keySet()) {
				IASTNode in = null;
				LocalizerVisitor lvisitor = new LocalizerVisitor(ps);
				// check for the confidential data
				if (node.node instanceof CxxPlainNode) {
					CxxPlainNode pn = (CxxPlainNode) node.node;
					in = pn.getNode();

					if (in != null) {
						synchronized (in) {
							in.accept(lvisitor);

						}
					}
				} else if (node.node instanceof CxxDecisionNode) {
					CxxDecisionNode dn = (CxxDecisionNode) node.node;
					in = dn.getNode();
					if (in != null) {
						synchronized (in) {
							in.accept(lvisitor);

						}
					}
				} else if (node.node instanceof CxxExitNode) {
					CxxExitNode en = (CxxExitNode) node.node;
					in = en.getNode();
					if (in != null) {
						synchronized (in) {
							in.accept(lvisitor);

						}
					}
				}
				// add all the buggy nodes
				if (null != node.filename && -1 != node.startinglinenumber
						&& lvisitor.isStatus() == true) {
					// add all buggy nodes
					badnode.add(node);
				}
			}
			// check if all the nodes belong to different paths

			IASTNode in = null;
			// if the buggy nodes are more than 1
			if (badnode.size() > 1) {

				for (int l = 0; l < badnode.size(); l++) {
					for (int k = l + 1; k < badnode.size(); k++) {
						// check if the nodes belong to same path
						if (node_path.get(badnode.get(l)).equals(
								node_path.get(badnode.get(k)))) {
							// maintain nodes belonging to same path
							same_path.add(badnode.get(l));

						} else {
							// if does not belong to same path report all
							wpm.psReportProblem(problem.getKey().id, in,
									badnode.get(l).filename,
									badnode.get(l).startinglinenumber,
									problem.getKey().problemMessage,
									problem.getKey().problemDescription);

						}

					}
				}
				// now traverse through the paths of those nodes in the same
				// path

				List<PathLoc> newlist = node_path.get(same_path.get(0));
				for (int p = 0; p < newlist.size(); p++) {
					for (int q = 0; q < same_path.size(); q++) {
						// here we get to know the earliest node to be fixed
						if (newlist.get(p).equals(same_path.get(q))) {
							if (newlist.get(p).node instanceof CxxPlainNode) {
								CxxPlainNode pn = (CxxPlainNode) newlist.get(p).node;
								in = pn.getNode();

							} else if (newlist.get(p).node instanceof CxxDecisionNode) {
								CxxDecisionNode dn = (CxxDecisionNode) newlist
										.get(p).node;
								in = dn.getNode();

							} else if (newlist.get(p).node instanceof CxxExitNode) {
								CxxExitNode en = (CxxExitNode) newlist.get(p).node;
								in = en.getNode();
							}
							wpm.psReportProblem(problem.getKey().id, in,
									badnode.get(p).filename,
									badnode.get(p).startinglinenumber,
									problem.getKey().problemMessage,
									problem.getKey().problemDescription);
							break;
						}

					}
				}
			} else {
				if (badnode.size() != 0) {
					if (badnode.get(0).node instanceof CxxPlainNode) {
						CxxPlainNode pn = (CxxPlainNode) badnode.get(0).node;
						in = pn.getNode();

					} else if (badnode.get(0).node instanceof CxxDecisionNode) {
						CxxDecisionNode dn = (CxxDecisionNode) badnode.get(0).node;
						in = dn.getNode();

					} else if (badnode.get(0).node instanceof CxxExitNode) {
						CxxExitNode en = (CxxExitNode) badnode.get(0).node;
						in = en.getNode();
					}
					wpm.psReportProblem(problem.getKey().id, in,
							badnode.get(0).filename,
							badnode.get(0).startinglinenumber,
							problem.getKey().problemMessage,
							problem.getKey().problemDescription);
				}
			}

		}
		reset();
	}
}
