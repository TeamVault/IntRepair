package smtcodan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFile;

import smtcodan.interpreter.ActionLog;
import smtcodan.logger.StatementLogger;
import smtcodan.pathgen.ProgramPathIBB;
import smtcodan.quickfixes.SMTConstraintObject;
import smtcodan.visualization.ProgramTree;

public class WorkPool implements Cloneable {

	ArrayList<ProgramPath> partitions;
	ArrayList<PathExplorer> workers;
	int num_threads;
	public HashMap<IFile, ArrayList<PSProblem>> problemmap;
	public ArrayList<ValuePath> pathsBufferSizes;

	private Localizer loc;

	public static float numberOfSatPathsVisited = 0;

	public static float numberOfUnsatPathsVisited = 0;

	ProgramTree tree;

	ArrayList<ProgramPathIBB> satpaths;

	ArrayList<ProgramPathIBB> satpaths2;

	public WorkPool(int num_threads, Localizer loc) {

		// public WorkPool(int num_threads)
		// {
		this.num_threads = num_threads;
		this.loc = loc;
		workers = new ArrayList<PathExplorer>();
		partitions = new ArrayList<ProgramPath>();
		problemmap = new HashMap<IFile, ArrayList<PSProblem>>();
		pathsBufferSizes = new ArrayList<ValuePath>();
		tree = new ProgramTree();
		if (Config.shouldStoreSatPaths()) {
			satpaths = new ArrayList<ProgramPathIBB>();
			satpaths2 = new ArrayList<ProgramPathIBB>();
		}
	}

	public boolean hasSatPath() {
		return !satpaths.isEmpty();
	}

	public boolean hasSatPath2() {
		return !satpaths2.isEmpty();
	}

	public ProgramPathIBB getNextSatPath() {
		return satpaths.remove(satpaths.size() - 1);
	}

	public ProgramPathIBB getNextSatPath2() {
		return satpaths2.remove(satpaths2.size() - 1);
	}

	public ProgramTree getTree() {
		return tree;
	}

	public void showTree() {

		tree.show(); // TODO uncomment to use, needs JUNG

	}

	public void dumpTree() {

		tree.dump(); // TODO uncomment to use, needs JUNG + Batik

	}

	public synchronized void reportTreeUnsatPath(ProgramPathIBB pathIBB) {
		tree.reportUnsat(pathIBB); // TODO uncomment to use, needs JUNG
		// add also the unsat paths afterwards and check afterwards if they
		// contain the bug node
		satpaths2.add(pathIBB.clone());

		// count unsat paths visited
		numberOfUnsatPathsVisited++;

	}

	public synchronized void reportTreeSatPath(ProgramPathIBB pathIBB) {
		// count sat path visited
		numberOfSatPathsVisited++;
		tree.reportSat(pathIBB); // TODO uncomment to use, needs JUNG
		loc.reportPath(pathIBB);
		// tree.reportSat(pathIBB); // TODO uncomment to use, needs JUNG
		if (Config.shouldStoreSatPaths()) {
			// needs to clone, because worker will backtrack path
			satpaths.add(pathIBB.clone());
			satpaths2.add(pathIBB.clone());
		}
	}

	public synchronized void addNewWorker(PathExplorer pe) {
		workers.add(pe);
	}

	public synchronized ProgramPath newWorkerPossible() {
		if (allWorkFinished()) {
			return null;
		}
		if (partitions.isEmpty() || (workers.size() == num_threads)) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		} else {
			Iterator<ProgramPath> iter = partitions.iterator();
			ProgramPath nextPart = iter.next();
			partitions.remove(nextPart);
			return nextPart;
		}
	}

	public synchronized boolean allWorkFinished() {
		return (workers.isEmpty() && partitions.isEmpty());
	}

	public synchronized void reportDead(PathExplorer pe) {
		workers.remove(pe);
		System.out.println("  thread reported dead, notifyAll().");
		notifyAll();
	}

	public synchronized boolean splitNeeded() {
		if ((workers.size() < num_threads) && (partitions.size() < 1)) {
			return true;
		} else {
			return false;
		}
	}

	public synchronized void addSplitPaths(ArrayList<ProgramPath> paths) {
		if (paths == null) {
			System.out.println("  0 split path(s) added");
			return;
		}
		partitions.addAll(paths);
		System.out.println("  " + paths.size()
				+ " split path(s) added, notifyAll().");
		notifyAll();
	}

	public String getConstraintValue(SMTConstraintObject ob) {
		String newline = System.getProperty("line.separator");
		String symbolicValue = "imp_quick_0";
		String produceModels = new String("(set-option :produce-models true)"
				+ newline);
		StringBuffer quickFixSymbolicValue = new StringBuffer("(declare-fun "
				+ symbolicValue + " () Int)" + newline);
		String assertLessThen = "(assert (< " + symbolicValue + " "
				+ ob.getBufferSize() + "))" + newline;
		String assertGreatherThenEqual = "(assert (== (+ " + symbolicValue
				+ " 1" + ") " + ob.getBufferSize() + "))" + newline;

		String newConstraintsSystem = quickFixSymbolicValue + assertLessThen
				+ assertGreatherThenEqual;

		String checkSatExit = "(check-sat)" + newline + "(get-value ("
				+ symbolicValue + "))" + newline + "(exit)" + newline;

		String finalLinearSystem = produceModels + ob.getLinearSystem()
				+ newConstraintsSystem + checkSatExit;
		// the z3 solver complains about the null string
		if (finalLinearSystem.contains("null")) {
			finalLinearSystem = finalLinearSystem.replaceAll("null", "");
		}
		StatementLogger.log_quickFixes("Linear system \n" + finalLinearSystem);
		String reply = new Solver().queryReply(new String(finalLinearSystem));

		if (reply.contains("unsat")) {
			StatementLogger.log_quickFixes("unsat");
		} else {
			StatementLogger.log_quickFixes("sat");
		}
		StatementLogger.log_quickFixes("reply: \n" + reply);

		boolean found2 = false;
		StringTokenizer st2 = new StringTokenizer(reply.toString(), " ()");
		String value = null;
		StatementLogger.log_quickFixes("st: " + st2.toString());
		while (!found2 && st2.hasMoreTokens()) {
			String nexttoken = st2.nextToken();
			StatementLogger.log_quickFixes("nexttoken: " + nexttoken);
			if (nexttoken.contains(symbolicValue)) {
				value = st2.nextToken();
				found2 = true;
			}
		}
		StatementLogger.log_quickFixes("val: \n" + value);
		return value;
	}

	public synchronized void queueProblem(String problemid, IFile file,
			int startline, String arg1, String arg2, SMTConstraintObject co,
			ActionLog nvlist) {
		PSProblem newProblem = new PSProblem(problemid, file, startline, arg1,
				arg2, co);

		// associate a buffer size value for each path
		String value = null;
		if (co != null) {
			value = getConstraintValue(co);
		}

		if (nvlist != null)
			pathsBufferSizes.add(new ValuePath(value, new String(nvlist
					.getTrace()), nvlist.getNvlist().clone()));

		ArrayList<PSProblem> problemsInFile = problemmap.get(file);
		if (problemsInFile != null) {
			problemsInFile.add(newProblem);
			return;
		}
		// first PSproblem in file, add queue, store and report
		ArrayList<PSProblem> newList = new ArrayList<PSProblem>();
		newList.add(newProblem);
		problemmap.put(file, newList);

	}

	public synchronized HashMap<IFile, ArrayList<PSProblem>> getProblems() {
		return problemmap;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}