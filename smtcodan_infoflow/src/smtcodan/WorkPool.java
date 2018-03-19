package smtcodan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;

import smtcodan.pathgen.ProgramPathIBB;
import smtcodan.visualization.ProgramTree;

public class WorkPool {

	ArrayList<ProgramPath> partitions;
	ArrayList<PathExplorer> workers;
	int num_threads;
	public HashMap<IFile, ArrayList<PSProblem>> problemmap;
	private Localizer loc;

	ProgramTree tree;

	ArrayList<ProgramPathIBB> satpaths;

	public WorkPool(int num_threads, Localizer loc) {
		this.num_threads = num_threads;
		this.loc = loc;
		workers = new ArrayList<PathExplorer>();
		partitions = new ArrayList<ProgramPath>();
		problemmap = new HashMap<IFile, ArrayList<PSProblem>>();
		tree = new ProgramTree();
		if (Config.shouldStoreSatPaths()) {
			satpaths = new ArrayList<ProgramPathIBB>();
		}
	}

	public boolean hasSatPath() {
		return !satpaths.isEmpty();
	}

	public ProgramPathIBB getNextSatPath() {
		return satpaths.remove(satpaths.size() - 1);
	}

	public ProgramTree getTree() {
		return tree;
	}

	public void showTree() {
		// tree.show();
		// TODO uncomment to use, needs JUNG
	}

	public void dumpTree() {
		// tree.dump();
		// TODO uncomment to use, needs JUNG + Batik
	}

	public synchronized void reportTreeUnsatPath(ProgramPathIBB pathIBB) {
		// tree.reportUnsat(pathIBB);
		// TODO uncomment to use, needs JUNG
	}

	public synchronized void reportTreeSatPath(ProgramPathIBB pathIBB) {
		loc.reportPath(pathIBB);
		// tree.reportSat(pathIBB); // TODO uncomment to use, needs JUNG
		if (Config.shouldStoreSatPaths()) {
			// needs to clone, because worker will backtrack path
			satpaths.add(pathIBB.clone());
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

	public synchronized void queueProblem(String problemid, IFile file,
			int startline, String arg1, String arg2) {
		PSProblem newProblem = new PSProblem(problemid, file, startline, arg1,
				arg2);
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

}
