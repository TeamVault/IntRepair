package smtcodan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxDecisionNode;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxExitNode;
import org.eclipse.cdt.codan.core.cxx.internal.model.cfg.CxxPlainNode;
import org.eclipse.cdt.codan.core.model.AbstractCheckerWithProblemPreferences;
import org.eclipse.cdt.codan.core.model.IChecker;
import org.eclipse.cdt.codan.core.model.IProblemLocation;
import org.eclipse.cdt.codan.core.model.cfg.IBasicBlock;
import org.eclipse.cdt.codan.core.model.cfg.IExitNode;
import org.eclipse.cdt.codan.core.model.cfg.ISingleIncoming;
import org.eclipse.cdt.codan.internal.core.cfg.BranchNode;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.OperationCanceledException;

import smtcodan.checkers.BoundsChecker;
import smtcodan.checkers.IntegerOverFlowChecker;
import smtcodan.interpreter.PThread;
import smtcodan.multithreadanalysis.MTAnalyzer;
import smtcodan.pathgen.IndBasicBlock;
import smtcodan.pathgen.ProgramPathIBB;
import smtcodan.progressthreads.ProgressStarter;
import smtcodan.quickfixes.PathObject;
import smtcodan.quickfixes.Refactoring;
import smtcodan.quickfixes.SMTConstraintObject;
import smtcodan.quickfixes.information.exposure.QuickFixInformationExposure;
import smtcodan.quickfixes.information.exposure.RefactoringFinderInformationExposure;
import smtcodan.quickfixes.integer.overflow.QuickFixIntegerOverflow;
import smtcodan.quickfixes.integer.overflow.RefactoringFinderIntegerOverflow;
import smtcodan.quickfixes.race.condition.QuickFixRaceCondition;
import smtcodan.quickfixes.race.condition.RefactoringFinderRaceCondition;
import smtcodan.symvars.SymVarOrig;
import smtcodan.util.TimeWatch;
import smtcodan.visualization.ProgramTree;

public class WorkPoolManager extends AbstractCheckerWithProblemPreferences
		implements IChecker {

	// TODO: set access rights appropriately (for all classes...)
	// TODO: create extension point for checkers?

	public ProgramStructureFacade psf;
	public IProject actualproject;
	private int index = 0;
	public HashMap<String, ArrayList<PathObject>> nodesmap;
	public HashMap<String, ProgramPathIBB> programPathsmap;
	public ArrayList<PathObject> nodes;
	TimeWatch watchTotalTime;
	RefactoringFinderIntegerOverflow quickFixSearchIntegerOverflow;
	RefactoringFinderRaceCondition quickFixSearchRaceCondition;
	RefactoringFinderInformationExposure quickFixSearchInformationExposure;
	CSVFileOutput csvFile = new CSVFileOutput();

	private Localizer loc;

	public WorkPoolManager() {
		this.loc = new Localizer(this);
	}

	@Override
	public synchronized boolean processResource(IResource resource)
			throws OperationCanceledException {

		if (resource.getType() != IResource.FILE) {
			return false;
		} else {
			try {

				// only run on complete projects, indicated by ".project"
				String filename = ((IFile) resource).getName();
				if (filename.compareTo(".project") != 0) {
					return false;
				}

				watchTotalTime = TimeWatch.start();

				// init the limits from limits.h
				IntegersUpperBounds.readLimitsFile(Config.limitFilePath);

				// reset for repeated runs
				SymVarOrig.clearOrigCount();
				PThread.resetPThreadCounter();
				// get project data
				actualproject = resource.getProject();
				psf = new ProgramStructureFacade(actualproject);
				nodesmap = new HashMap<String, ArrayList<PathObject>>();
				programPathsmap = new HashMap<String, ProgramPathIBB>();
				WorkPool workPool = new WorkPool(Config.getNumThreads(),
						this.loc);

				// start a worker
				PathExplorer pe = new PathExplorer(this, psf, workPool);

				pe.run();
				workPool.addNewWorker(pe);
				pe.start();

				// estimation should run before the progress bars are presented
				// Alexandra Mai Work
				// RuntimeEstimator est = new RuntimeEstimator(psf);

				// start progress bar and window
				if (Config.shouldRunProgressBars()) {
					// number of steps is 50
					ProgressStarter pgs = new ProgressStarter(psf, pe, 50);
				}

				while (!workPool.allWorkFinished()) {
					ProgramPath newPartition = workPool.newWorkerPossible(); // might
																				// block
					if (newPartition != null) {
						// start new worker
						pe = new PathExplorer(this, psf, workPool, newPartition);
						workPool.addNewWorker(pe);
						pe.start();
						System.out.println("partition ");

					}
				} // all work and workers finished

				if (Config.shouldCheckRaces()) {
					// multi-thread problems:
					// TODO: only if pthreads used!
					while (workPool.hasSatPath()) {
						ProgramPathIBB anapath = workPool.getNextSatPath();
						if (anapath.getUsesMultiThreading()) {
							MTAnalyzer ana = new MTAnalyzer(anapath, psf);
							ana.doAnalyze(workPool);
						}
					}
				}

				// collect all paths
				while (workPool.hasSatPath2()) {
					ProgramPathIBB path2 = workPool.getNextSatPath2();
					nodes = new ArrayList<PathObject>();
					nodes = getNodeList(path2);

					// collect sat paths
					index++;
					String key = Integer.toString(index);
					String index = "Path " + key;
					nodesmap.put(index, nodes);
					programPathsmap.put(index, path2);
				}

				// create a re-factoring list
				// start search for quick fix locations for buffer overflows
				quickFixSearchIntegerOverflow = new RefactoringFinderIntegerOverflow(
						nodesmap, BoundsChecker.problemid,
						new ArrayList<Refactoring>(),
						(WorkPool) workPool.clone());

				// create a re-factoring list
				// start search for quick fix locations for race condition bugs
				quickFixSearchRaceCondition = new RefactoringFinderRaceCondition(
						nodesmap, BoundsChecker.problemid,
						new ArrayList<Refactoring>());
				// create a re-factoring list
				// start search for quick fix locations for InformationExposure
				// bugs
				quickFixSearchInformationExposure = new RefactoringFinderInformationExposure(
						nodesmap, BoundsChecker.problemid,
						new ArrayList<Refactoring>(),
						(WorkPool) workPool.clone());

				// get and forward all problems
				HashMap<IFile, ArrayList<PSProblem>> problems = workPool
						.getProblems();
				System.out.println("problems.size()" + problems.size());
				if (problems.size() > 0) {
					reportProblems(problems);
				} else {
					// there is nothing to report
				}

				// disable/enable the localizer
				if (!Config.disableLocalizer) {
					// locator M.T. work
					loc.report(pe.ps);
				}

				if (Config.shouldShowTree()) {
					workPool.dumpTree();
				}

				if (!Config.showRunQuickFixWindow) {
					// todo
				}

				// print out some analyzed program statistics
				csvFile.printIntoCSVFile(csvFile.builder, csvFile.pw,
						WorkPool.numberOfSatPathsVisited,
						WorkPool.numberOfUnsatPathsVisited,
						PathExplorer.countBranchNodes);
				csvFile.pw.flush();
				// csvFile.pw.close();

				// System.err.println("Sat paths visited: "
				// + WorkPool.numberOfSatPathsVisited);
				// System.err.println("Unsat paths visited: "
				// + WorkPool.numberOfUnsatPathsVisited);

			} catch (Exception e) {
				e.printStackTrace();
				throw new OperationCanceledException();
			}
			return false;
		}
	}

	private PathObject constructPathObject(IASTNode in) {
		// TODO Auto-generated method stub
		PathObject ob = null;
		if (in != null) {
			IFile file = (IFile) in.getTranslationUnit()
					.getOriginatingTranslationUnit().getResource();
			IASTFileLocation loc = in.getFileLocation();
			int startline = loc.getStartingLineNumber();

			ob = new PathObject(in, file, startline, false,
					new SMTConstraintObject("null", "null", "null"));
			return ob;
		}
		return ob;
	}

	public ArrayList<PathObject> getNodeList(ProgramPathIBB list) {

		// TODO Auto-generated method stub
		IBasicBlock node = null;
		IASTNode in = null;
		ArrayList<PathObject> nodes = new ArrayList<PathObject>();
		for (IndBasicBlock blocks : list) {
			node = blocks.getLocal();
			if (node instanceof CxxPlainNode) {
				CxxPlainNode pn = (CxxPlainNode) node;
				in = pn.getNode();
			} else if (node instanceof CxxDecisionNode) {
				CxxDecisionNode pn = (CxxDecisionNode) node;
				in = pn.getNode();
			} else if (node instanceof IExitNode) {
				CxxExitNode pn = (CxxExitNode) node;
				in = pn.getNode();
			} else if (node instanceof BranchNode) {
				CxxDecisionNode pn = (CxxDecisionNode) ((ISingleIncoming) node)
						.getIncoming();
				in = pn.getNode();
			}

			if (in != null) {
				PathObject po = constructPathObject(in);
				nodes.add(po);
			}
		}

		return nodes;
	}

	public ArrayList<PathObject> getNodeList(ArrayList<IBasicBlock> list) {

		// TODO Auto-generated method stub
		IBasicBlock node = null;
		IASTNode in = null;
		ArrayList<PathObject> nodes = new ArrayList<PathObject>();
		for (IBasicBlock block : list) {
			node = block;
			if (node instanceof CxxPlainNode) {
				CxxPlainNode pn = (CxxPlainNode) node;
				in = pn.getNode();
			} else if (node instanceof CxxDecisionNode) {
				CxxDecisionNode pn = (CxxDecisionNode) node;
				in = pn.getNode();
			} else if (node instanceof IExitNode) {
				CxxExitNode pn = (CxxExitNode) node;
				in = pn.getNode();
			} else if (node instanceof BranchNode) {
				CxxDecisionNode pn = (CxxDecisionNode) ((ISingleIncoming) node)
						.getIncoming();
				in = pn.getNode();
			}

			if (in != null) {
				PathObject po = constructPathObject(in);
				nodes.add(po);
			}
		}

		return nodes;
	}

	public int totalNumberOfNodesInTheMap(Map mp) {
		Iterator it = mp.entrySet().iterator();
		int totalNumberOfNodes = 0;
		boolean var;
		while (it.hasNext()) {
			var = false;
			Map.Entry pairs = (Map.Entry) it.next();
			totalNumberOfNodes = totalNumberOfNodes
					+ ((ArrayList<PathObject>) pairs.getValue()).size();
		}

		return totalNumberOfNodes;
	}

	public Map removeNotBuggyPaths(Map mp) {
		Iterator it = mp.entrySet().iterator();
		boolean var;
		while (it.hasNext()) {
			var = false;
			Map.Entry pairs = (Map.Entry) it.next();
			for (int i = 0; i < ((ArrayList<PathObject>) pairs.getValue())
					.size(); i++) {
				if (((ArrayList<PathObject>) pairs.getValue()).get(i)
						.isStartupNode()) {
					var = true;
				} else {
				}
			}
			if (var == false) {
				it.remove();
			} else {
			}
		}
		return mp;
	}

	// for testing
	public ProgramTree getProgramTree(IProject proj, int num_threads)
			throws OperationCanceledException {
		try {
			// reset for repeated runs
			SymVarOrig.clearOrigCount();
			// get project data
			actualproject = proj;
			psf = new ProgramStructureFacade(actualproject);

			WorkPool workPool = new WorkPool(num_threads, this.loc);
			// start a worker
			PathExplorer pe = new PathExplorer(this, psf, workPool);
			workPool.addNewWorker(pe);
			pe.start();
			while (!workPool.allWorkFinished()) {
				ProgramPath newPartition = workPool.newWorkerPossible(); // might
																			// block
				if (newPartition != null) {
					// start new worker
					pe = new PathExplorer(this, psf, workPool, newPartition);
					workPool.addNewWorker(pe);
					pe.start();
				}
			} // all work and workers finished
				// get and forward all problems
			return workPool.getTree();
		} catch (Exception e) {
			e.printStackTrace();
			throw new OperationCanceledException();
		}
	}

	public void before(IResource resource) {
		super.before(resource);
	}

	public void flagQuickFixStartNodes(ArrayList<PSProblem> problemsInFile,
			IFile file) {
		Iterator it = nodesmap.entrySet().iterator();
		boolean var;
		System.out.print("\n Number of paths " + nodesmap.size());
		int counter = 0;
		ArrayList<PathObject> nodes = null;
		while (it.hasNext()) {
			var = false;
			Map.Entry pairs = (Map.Entry) it.next();
			nodes = ((ArrayList<PathObject>) pairs.getValue());
			// here we flag the possible starting nodes
			for (int i = 0; i < nodes.size(); i++) {
				for (PSProblem problem : problemsInFile) {
					if (nodes.get(i).getFile() == file
							&& nodes.get(i).getStartlifileLocation() == problem
									.getStartLine()) {
						nodes.get(i).setStartupNode(true);
						counter++;
						// add the constraint object
						nodes.get(i).setConstraintOb(problem.getCo());
					}
				}
			}
		}
		System.out.print("\n Number of buggy paths " + counter + "\n");
	}

	public void after(IResource resource) {
		// override to avoid deletion of markers in file context that have been
		// generated in project context
		// only run on complete projects, indicated by ".project"
		String filename = ((IFile) resource).getName();
		if (filename.compareTo(".project") != 0) {
			return;
		}
		super.after(resource);
	}

	// /**
	// * Ps report problem.
	// *
	// * @param problemid the problemid
	// * @param file the file
	// * @param startline the startline
	// * @param arg1 the arg1
	// * @param arg2 the arg2
	// */
	public void psReportProblem(String problemid, IASTNode in, IFile file,
			int startline, String arg1, String arg2) {
		IProblemLocation ploc = createProblemLocation(file, startline);
		reportProblem(problemid, ploc, arg1, arg2);
		// reportProblem(problemid, file, startline);
		// createQuickFixFromBugReportMessage(problemid, ploc, arg1, arg2);
		createQuickFixFromBugReportMessage(arg1, in);

	}

	private void createQuickFixFromBugReportMessage(String message, IASTNode in) {
		// TODO Auto-generated method stub
		TimeWatch watch = TimeWatch.start();
		if (message.equals("Integer Overflow Error Detected")) {
			quickFixSearchIntegerOverflow.runQuickFixSearchingAlgorithm(in,
					new QuickFixIntegerOverflow());
			// refactoring time
			long passedTimeInMs = watch.time();
			long passedTimeInMilisecs = watch.time(TimeUnit.MILLISECONDS);
			System.out.println("\nRefactoring Time: " + passedTimeInMilisecs
					+ " [ms]");

			// total time
			long passedTimeInMs2 = watchTotalTime.time();
			long passedTimeInMilisecs2 = watchTotalTime
					.time(TimeUnit.MILLISECONDS);
			System.out
					.println("Total Time: " + passedTimeInMilisecs2 + " [ms]");

		}

	}

	void reportProblems(HashMap<IFile, ArrayList<PSProblem>> problems) {
		Set<Map.Entry<IFile, ArrayList<PSProblem>>> entries = problems
				.entrySet();
		for (Map.Entry<IFile, ArrayList<PSProblem>> entry : entries) {
			IFile file = entry.getKey();
			ArrayList<PSProblem> problemsInFile = entry.getValue();
			ArrayList<PSProblem> problemsReported = new ArrayList<PSProblem>();

			// mark the nodes on the paths which are start up nodes

			flagQuickFixStartNodes(problemsInFile, file);

			for (PSProblem problem : problemsInFile) {
				boolean isMultiple = false;
				for (PSProblem oldProblem : problemsReported) {
					if (problem.isEqual(oldProblem)) {
						isMultiple = true;
					}
				}
				if (!isMultiple) {
					IProblemLocation ploc = createProblemLocation(file,
							problem.getStartLine());
					reportProblem(problem.getId(), ploc, problem.getMessage(),
							problem.getDescription());

					problemsReported.add(problem);

					problem.getMessage();
					createQuickFixFromBugReportMessage(problem.getMessage());

				}
			}

		}

	}

	public void createQuickFixFromBugReportMessage(String message) {

		TimeWatch watch = TimeWatch.start();

		if (message.equals("Race condition")) {
			quickFixSearchRaceCondition.runQuickFixSearchingAlgorithm(nodesmap,
					new QuickFixRaceCondition());
			// refactoring time
			long passedTimeInMs = watch.time();
			long passedTimeInMilisecs = watch.time(TimeUnit.MILLISECONDS);
			System.out.println("\nRefactoring Time: " + passedTimeInMilisecs
					+ " [ms]");

			// total time
			long passedTimeInMs2 = watchTotalTime.time();
			long passedTimeInMilisecs2 = watchTotalTime
					.time(TimeUnit.MILLISECONDS);
			System.out
					.println("Total Time: " + passedTimeInMilisecs2 + " [ms]");

			// Total number of paths
			System.out.println("Total # of Paths: " + nodesmap.size());

			// Total number of nodes
			System.out.println("Total # of Nodes: "
					+ totalNumberOfNodesInTheMap(nodesmap));

			// Number influenciable paths
			System.out.println("# Influenciable Paths: "
					+ RefactoringFinderRaceCondition.countInfluenciablePaths);

		}
		if (message.equals("Information Exposure Bug Detected")) {
			quickFixSearchInformationExposure.runQuickFixSearchingAlgorithm(
					nodesmap, new QuickFixInformationExposure());
			// refactoring time
			long passedTimeInMs = watch.time();
			long passedTimeInMilisecs = watch.time(TimeUnit.MILLISECONDS);
			System.out.println("\nRefactoring Time: " + passedTimeInMilisecs
					+ " [ms]");

			// total time
			long passedTimeInMs2 = watchTotalTime.time();
			long passedTimeInMilisecs2 = watchTotalTime
					.time(TimeUnit.MILLISECONDS);
			System.out
					.println("Total Time: " + passedTimeInMilisecs2 + " [ms]");

			// Total number of paths
			System.out.println("Total # of Paths: " + nodesmap.size());

			// Total number of nodes
			System.out.println("Total # of Nodes: "
					+ totalNumberOfNodesInTheMap(nodesmap));

			// Number influenciable paths
			System.out
					.println("# Influenciable Paths: "
							+ RefactoringFinderInformationExposure.countInfluenciablePaths);

		}
		if (message.equals("localizer not-in-place Quick fix available")) {
			quickFixSearchInformationExposure.runQuickFixSearchingAlgorithm(
					nodesmap, new QuickFixInformationExposure());
			// refactoring time
			long passedTimeInMs = watch.time();
			long passedTimeInMilisecs = watch.time(TimeUnit.MILLISECONDS);
			System.out.println("\nRefactoring Time: " + passedTimeInMilisecs
					+ " [ms]");

			// total time
			long passedTimeInMs2 = watchTotalTime.time();
			long passedTimeInMilisecs2 = watchTotalTime
					.time(TimeUnit.MILLISECONDS);
			System.out
					.println("Total Time: " + passedTimeInMilisecs2 + " [ms]");

			// Total number of paths
			System.out.println("Total # of Paths: " + nodesmap.size());

			// Total number of nodes
			System.out.println("Total # of Nodes: "
					+ totalNumberOfNodesInTheMap(nodesmap));

			// Number influenciable paths
			System.out
					.println("# Influenciable Paths: "
							+ RefactoringFinderInformationExposure.countInfluenciablePaths);

		}

		if (message
				.equals(IntegerOverFlowChecker.integerOverflowCheckerMessage)) {

			quickFixSearchIntegerOverflow.addRefactroingToRefactoringList(
					nodesmap, new QuickFixIntegerOverflow());
			// refactoring time
			long passedTimeInMs = watch.time();
			long passedTimeInMilisecs = watch.time(TimeUnit.MILLISECONDS);
			System.out.println("\nRefactoring Time: " + passedTimeInMilisecs
					+ " [ms]");

			// total time
			long passedTimeInMs2 = watchTotalTime.time();
			long passedTimeInMilisecs2 = watchTotalTime
					.time(TimeUnit.MILLISECONDS);
			System.out
					.println("Total Time: " + passedTimeInMilisecs2 + " [ms]");

			// Total number of paths
			System.out.println("Total # of Paths: " + nodesmap.size());

			// Total number of nodes
			System.out.println("Total # of Nodes: "
					+ totalNumberOfNodesInTheMap(nodesmap));

			// Number influenciable paths
			System.out.println("# Influenciable Paths: "
					+ RefactoringFinderIntegerOverflow.countInfluenciablePaths);

		}

	}

	private void createQuickFixFromBugReportMessage(String problemid,
			IProblemLocation ploc, String arg1, String arg2) {
		// TODO Auto-generated method stub

		// quickFixSearchInformationExposure.runQuickFixSearchingAlgorithm(arg1,arg2,
		// new QuickFixInformationExposure());

	}
}