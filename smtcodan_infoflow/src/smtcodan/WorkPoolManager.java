package smtcodan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.cdt.codan.core.model.AbstractCheckerWithProblemPreferences;
import org.eclipse.cdt.codan.core.model.IChecker;
import org.eclipse.cdt.codan.core.model.IProblemLocation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.OperationCanceledException;

import smtcodan.interpreter.PThread;
import smtcodan.multithreadanalysis.MTAnalyzer;
import smtcodan.pathgen.ProgramPathIBB;
import smtcodan.progressthreads.ProgressStarter;
import smtcodan.symvars.SymVarOrig;
import smtcodan.visualization.ProgramTree;

public class WorkPoolManager extends AbstractCheckerWithProblemPreferences
		implements IChecker {

	// TODO: set access rights appropriately (for all classes...)
	// TODO: create extension point for checkers?
	public ProgramStructureFacade psf;
	public IProject actualproject;

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

				if (Config.shouldRunProgressBars()) {
					ProgressStarter my_ps = new ProgressStarter();
					my_ps.startProgressBars(100);
				}

				// only run on complete projects, indicated by ".project"
				String filename = ((IFile) resource).getName();
				if (filename.compareTo(".project") != 0) {
					return false;
				}
				// reset for repeated runs
				SymVarOrig.clearOrigCount();
				PThread.resetPThreadCounter();
				// get project data
				actualproject = resource.getProject();

				psf = new ProgramStructureFacade(actualproject);
				WorkPool workPool = new WorkPool(Config.getNumThreads(),
						this.loc);
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
				// get and forward all problems
				HashMap<IFile, ArrayList<PSProblem>> problems = workPool
						.getProblems();
				reportProblems(problems);
				// locator
				// loc.report();
				if (Config.shouldShowTree()) {
					workPool.dumpTree();
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new OperationCanceledException();
			}
			return false;
		}
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
	public void psReportProblem(String problemid, IFile file, int startline,
			String arg1, String arg2) {
		IProblemLocation ploc = createProblemLocation(file, startline);
		reportProblem(problemid, ploc, arg1, arg2);
		// reportProblem(problemid, file, startline);
	}

	void reportProblems(HashMap<IFile, ArrayList<PSProblem>> problems) {
		Set<Map.Entry<IFile, ArrayList<PSProblem>>> entries = problems
				.entrySet();
		for (Map.Entry<IFile, ArrayList<PSProblem>> entry : entries) {
			IFile file = entry.getKey();
			ArrayList<PSProblem> problemsInFile = entry.getValue();
			ArrayList<PSProblem> problemsReported = new ArrayList<PSProblem>();
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
				}
			}

		}

	}

}
