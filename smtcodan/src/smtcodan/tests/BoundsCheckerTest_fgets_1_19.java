/**
 [Class description.  JUnit test case for fgets test cases 1-19]

 [Other notes, including guaranteed invariants, usage instructions and/or examples, reminders
 about desired improvements, etc.]

 @author Andreas Ibing
 @version $Revision: x  Date: x hour: 
 **/

/*
 * 
 */

package smtcodan.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;

import org.eclipse.cdt.codan.core.CodanRuntime;
import org.eclipse.cdt.codan.core.model.CheckerLaunchMode;
import org.eclipse.cdt.codan.core.model.IProblemReporter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Ignore;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class BoundsCheckerTest_fgets_1_19.
 */
public class BoundsCheckerTest_fgets_1_19 {

	/** The markers. */
	protected IMarker[] markers;

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_1.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_1() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_1");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_1.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_2.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_2() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_2");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 61);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_2.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_3.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_3() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_3");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 61);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_3.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_4.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_4() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_4");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_4.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_5.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_5() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_5");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_5.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_6.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_6() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_6");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_6.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_7.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_7() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_7");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_7.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_8.
	 */
	@Ignore("why?")
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_8() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_8");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_8.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_9.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_9() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_9");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 61);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_9.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_10.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_10");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 61);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_10.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_11.
	 */
	@Ignore("why?")
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_11");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_11.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_12.
	 */
	@Ignore("why?")
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_12");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_12.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_13.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_13");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 61);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_13.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_14.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_14");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 61);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_14.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_15.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_15");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 63);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_15.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_16.
	 */
	@Ignore("why?")
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_16");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_16.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_17.
	 */
	@Ignore("why?")
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_17");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_17.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_18.
	 */
	@Ignore("cfgbuilder bug for goto statement")
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_18() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_18");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_18.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_19.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_19() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_19");
		CodanRuntime
				.getInstance()
				.getBuilder()
				.processResource(proj, new NullProgressMonitor(),
						CheckerLaunchMode.RUN_ON_DEMAND);
		try {
			markers = proj.findMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);
			int number = markers.length;
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();

			proj.deleteMarkers(
					IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true,
					IResource.DEPTH_INFINITE);

			assertEquals(number, 1);
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_19.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

}
