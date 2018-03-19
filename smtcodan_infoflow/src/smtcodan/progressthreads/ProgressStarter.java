package smtcodan.progressthreads;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

// TODO: Auto-generated Javadoc
/**
 * The Class ProgressStarter.
 */
public class ProgressStarter implements IProgressNotification {

	/** The progress window counter. */
	public static int progressWindowCounter1 = 0;
	public static int progressWindowCounter2 = 0;

	/** The pb. */
	private ProgressBarMonitorThread pb;

	/** The pw. */
	private ProgressWindowMonitorThread pw;

	/** The list. */
	private ArrayList<IProgressSynchronization> list = new ArrayList<IProgressSynchronization>();

	/**
	 * Start progress bars.
	 * 
	 * @param totalNumberOfSteps
	 *            the total number of steps
	 */
	public void startProgressBars(final int totalNumberOfSteps) {
		// open window once and the progress bar
		if (progressWindowCounter1 < 1 && progressWindowCounter2 < 1) {
			progressWindowCounter1++;
			progressWindowCounter2++;

			// start the progress bar
			pb = new ProgressBarMonitorThread(totalNumberOfSteps);
			pb.startProgrssBar();

			// window
			pw = new ProgressWindowMonitorThread(totalNumberOfSteps);

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
