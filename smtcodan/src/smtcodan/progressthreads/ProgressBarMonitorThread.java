package smtcodan.progressthreads;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

// TODO: Auto-generated Javadoc
/**
 * The Class ProgressBarMonitorThread.
 */
public class ProgressBarMonitorThread implements IProgressSynchronization {
	/** The total number of nodes. */
	public int totalNumberOfNodes;

	/** The current number of processed nodes. */
	private int currentNumberOfProcessedNodes;

	/** The remaining time estimate. */
	private static int timeEstimate = 0;

	/** The delay. */
	private static long delay = 100;

	/**
	 * Instantiates a new progress bar monitor thread.
	 * 
	 * @param totalNumberOfNodes
	 *            the total number of nodes
	 */
	public ProgressBarMonitorThread(int totalNumberOfNodes) {
		this.totalNumberOfNodes = totalNumberOfNodes;
	}

	/**
	 * Start progrss bar.
	 * 
	 * @param pgs
	 *            the pgs
	 */
	public void startProgrssBar(final ProgressStarter pgs) {
		Job job = new Job("SAE Processing...") {
			@SuppressWarnings("deprecation")
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				// Tell the user what you are doing
				// workload represents the current number of preocessed Nodes
				monitor.beginTask(" ", totalNumberOfNodes);

				// Do your work
				for (int i = 0; i < totalNumberOfNodes; i++) {
					// Optionally add subtasks
					// i+1 has to be replaced with currentNumberOfProcessedNodes
					monitor.subTask(" Best Time " + " 0 "
							+ "                         " + " Remaining Time: "
							+ " 0 " + "                         "
							+ " Worse Time " + " 0 ");

					// sleep one second
					// this has to be changed. Put on sleep based on the current
					// number of
					// threads so that the window remains in sink with the
					// real static analysis processing. When the algorithm
					// processing is done than the window should disappear.
					try {
						Thread.sleep(getDelay());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// Tell the monitor that you successfully finished one item
					// of "workload"-many
					monitor.worked(1);

					// Check if the user pressed "cancel"
					if (monitor.isCanceled()) {
						monitor.done();

						// stop SAE monitor thread
						pgs.stop();

						// set the window counter back to stop 10
						ProgressStarter.progressWindowCounter1 = 10;
						return Status.CANCEL_STATUS;
					}
				}

				// You are done
				monitor.done();

				pgs.stop();

				// set the window counter back to 0
				ProgressStarter.progressWindowCounter1 = 0;
				return Status.CANCEL_STATUS;
			}
		};
		job.schedule();
	}

	/**
	 * Gets the total number of nodes.
	 * 
	 * @return the total number of nodes
	 */
	public int getTotalNumberOfNodes() {
		return totalNumberOfNodes;
	}

	/**
	 * Sets the total number of nodes.
	 * 
	 * @param totalNumberOfNodes
	 *            the new total number of nodes
	 */
	public void setTotalNumberOfNodes(int totalNumberOfNodes) {
		this.totalNumberOfNodes = totalNumberOfNodes;
	}

	/**
	 * Gets the current number of processed nodes.
	 * 
	 * @return the current number of processed nodes
	 */
	public int getCurrentNumberOfProcessedNodes() {
		return currentNumberOfProcessedNodes;
	}

	/**
	 * Sets the current number of processed nodes.
	 * 
	 * @param currentNumberOfProcessedNodes
	 *            the new current number of processed nodes
	 */
	public void setCurrentNumberOfProcessedNodes(
			int currentNumberOfProcessedNodes) {
		this.currentNumberOfProcessedNodes = currentNumberOfProcessedNodes;
	}

	/**
	 * Gets the time estimate.
	 * 
	 * @return the time estimate
	 */
	public static int getTimeEstimate() {
		return timeEstimate;
	}

	/**
	 * Sets the time estimate.
	 * 
	 * @param timeEstimate
	 *            the new time estimate
	 */
	public void setTimeEstimate(int timeEstimate) {
		this.timeEstimate = timeEstimate;
	}

	/**
	 * Gets the delay.
	 * 
	 * @return the delay
	 */
	public static long getDelay() {
		return delay;
	}

	/**
	 * Sets the delay.
	 * 
	 * @param delay
	 *            the new delay
	 */
	public static void setDelay(long delay) {
		ProgressBarMonitorThread.delay = delay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see smtcodan.progressthreads.IProgressSynchronization#updateData(long)
	 */
	@Override
	public void updateData(long delay) {
		setDelay(delay);

	}

}
