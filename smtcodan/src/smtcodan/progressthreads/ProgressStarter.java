package smtcodan.progressthreads;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import smtcodan.PathExplorer;
import smtcodan.ProgramStructureFacade;
import smtcodan.interpreter.ActionLog.Action;
import smtcodan.interpreter.ActionLog.CfgNodeActions;
import smtcodan.symvars.ISymObject;
import smtcodan.symvars.SymVarSSA;

// TODO: Auto-generated Javadoc
/**
 * The Class ProgressStarter.
 */
public class ProgressStarter extends Thread implements IProgressNotification {

	/** The progress window counter. */
	public static int progressWindowCounter1 = 0;

	/** The progress window counter2. */
	public static int progressWindowCounter2 = 0;

	/** The psf. */
	private ProgramStructureFacade psf = null;

	/** The pb. */
	private ProgressBarMonitorThread pb;

	/** The pw. */
	private ProgressWindowMonitorThread pw;
	
	/** The pe. */
	private PathExplorer pe;

	/** The list. */
	private ArrayList<IProgressSynchronization> list = new ArrayList<IProgressSynchronization>();

	/**
	 * Instantiates a new progress starter.
	 *
	 * @param psf            the psf
	 * @param pe the pe
	 * @param totalNumberOfSteps            the total number of steps
	 */
	public ProgressStarter(ProgramStructureFacade psf,PathExplorer pe,
			final int totalNumberOfSteps) {
		super();
		this.psf = psf;
		this.pe = pe;

		// monitors the real static analysis execution
		this.startExecutionMonitoringAlgorithm();

		// start the progress bars threads
		this.startProgressBars(totalNumberOfSteps, this);

	}


	// SAE monitor thread runs in parallel witht the SAE execution
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		// stop the thread when one of the progress threads is done
		while (true) {
			System.out.println("Monitor the SAE as long as it runs");
			

			// 1.get execution updates here, number of processed nodes
			// 2.number of remaining nodes
			// 3.make time estimate, worse and best case, remaining time
			// 4.update the delay time for drawing each progress step
			// notifyProgressDelay(1000);
			// 5. when SAE execution ended set the progress thread delay to 0
			// 6.this assures that the progress bar drawing is synchronized with
			// the SAE execution stop
		}
	}

	/**
	 * Start execution monitoring algorithm.
	 */
	public void startExecutionMonitoringAlgorithm() {
		System.out.println("main() function CFG size: "
				+ psf.getRootCFunctionCFG().getNodes().size());

		System.out.println("Total Number of Nodes: "
				+ psf.getTotalNumberOfNodesInTheFunctionCFGmap());

		// start SAE monitor thread
		this.start();

	}

	/**
	 * Start progress bars.
	 * 
	 * @param totalNumberOfSteps
	 *            the total number of steps
	 * @param pgs
	 *            the pgs
	 */
	public void startProgressBars(final int totalNumberOfSteps,
			ProgressStarter pgs) {
		// open window once and the progress bar
		if (progressWindowCounter1 < 1 && progressWindowCounter2 < 1) {
			progressWindowCounter1++;
			progressWindowCounter2++;

			// start the progress bar
			pb = new ProgressBarMonitorThread(totalNumberOfSteps);
			pb.startProgrssBar(pgs);

			// window
			pw = new ProgressWindowMonitorThread(totalNumberOfSteps, pgs);

			// 10 is the workload, so in your case the number of total nodes
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {

					Shell activeShell = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell();

					try {
						new ProgressMonitorDialog(activeShell).run(true, true,
								pw);
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * smtcodan.progressthreads.IProgressNotification#notifyProgressDelay(long)
	 */
	public void notifyProgressDelay(long delay) {
		for (IProgressSynchronization element : list) {
			element.updateData(delay);
		}
	}

}
