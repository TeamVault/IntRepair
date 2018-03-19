package smtcodan.progressthreads;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
// TODO: Auto-generated Javadoc

// TODO: Auto-generated Javadoc
/**
 * The Class ProgressMonitorThread.
 */
public class ProgressWindowMonitorThread implements IRunnableWithProgress,
		IProgressSynchronization {

	/** The total number of nodes. */
	private int totalNumberOfNodes;

	/** The current number of processed nodes. */
	private int currentNumberOfProcessedNodes;

	/** The remaining time estimate. */
	private int timeEstimate = 0;

	/** The delay. */
	private static long delay = 100;

	/**
	 * Instantiates a new progress monitor thread.
	 * 
	 * @param workload
	 *            the workload
	 */
	public ProgressWindowMonitorThread(int workload) {
		this.totalNumberOfNodes = workload;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core
	 * .runtime.IProgressMonitor)
	 */
	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		// Tell the user what you are doing
		// workload represents the current number of preocessed Nodes
		monitor.beginTask("SAE Processing...", totalNumberOfNodes);

		// Do your work
		for (int i = 0; i < totalNumberOfNodes; i++) {
			// Optionally add subtasks
			// i+1 has to be replaced with currentNumberOfProcessedNodes
			monitor.subTask("Node: " + (i + 1) + "                          "
					+ "                          "
					+ "                          "

					+ "                             " + " Remaining Time: "
					+ " to do");

			// sleep one second
			// this has to be changed. Put on sleep based on the current number
			// of
			// threads so that the window remains in sink with the
			// real static analysis processing. When the algorithm processing is
			// done than the window should disappear.
			Thread.sleep(getDelay());

			// Tell the monitor that you successfully finished one item of
			// "workload"-many
			monitor.worked(1);

			// Check if the user pressed "cancel"
			if (monitor.isCanceled()) {
				monitor.done();
				// set the window counter back to stop 10
				ProgressStarter.progressWindowCounter2 = 10;
				return;
			}
		}

		// You are done
		monitor.done();
		// set the window counter back to 0
		ProgressStarter.progressWindowCounter2 = 0;
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
	 * Gets the remaining time estimate.
	 * 
	 * @return the remaining time estimate
	 */
	public int getTimeEstimate() {
		return timeEstimate;
	}

	/**
	 * Sets the remaining time estimate.
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
		ProgressWindowMonitorThread.delay = delay;
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
