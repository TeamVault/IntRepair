/*
 * The following test cases will not pass since our info flow exposure checker 
 * can not find any bug into them because currently Codan can not generate an
 * CFG C goto x; statements
 * 
 * test_CWE526_Info_Exposure_Environment_Variables__basic_18
 * test_CWE534_Info_Exposure_Debug_Log__w32_char_18
 * test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_18
 * test_CWE535_Info_Exposure_Shell_Error__w32_char_18
 * test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_18
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
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class CWE526CheckerTests.
 */
public class InformationExposurejUnitTests {

	/** The markers. */
	protected IMarker[] markers;

	// /////////////////////////////////////////////////////////cwe 526 jUnit
	// tests
	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_01.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_01");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_02.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_02() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_02");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_03.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_03() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_03");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_04.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_04() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_04");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_05.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_05() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_05");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_06.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_06() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_06");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_07.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_07() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_07");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_08.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_08() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_08");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_09.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_09() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_09");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_10.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_10");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_11.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_11");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_12.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_12");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_13.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_13");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_14.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_14");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_15.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_15");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_16.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_16");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e526_ info_ exposure_ environment_ variables__basic_17.
	 */
	@Test
	public void test_CWE526_Info_Exposure_Environment_Variables__basic_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_17");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 13);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "io.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	// /////////////////////////////////////////////////////////cwe 534 jUnit
	// tests

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_01.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_char_01");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 65);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_01.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_02.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_02() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_02");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_02.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_03.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_03() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_03");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 65);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_03.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_04.
	 */
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_04() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_04");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 72);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_04.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_05.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_05() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_05");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 73);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_05.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_06.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_06() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_06");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 71);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_06.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_07.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_07() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_07");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 71);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_07.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_08.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_08() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_08");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 79);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_08.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_09.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_09() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_09");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_09.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_10.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_10");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_10.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_11.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_11");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_11.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_12.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_12");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_12.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_13.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_13");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_13.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_14.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_14");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_14.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_15.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_15");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_15.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_16.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_16");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_16.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_17.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_17");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 68);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_17.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_char_18.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_char_18() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE526_Info_Exposure_Environment_Variables__basic_18");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_char_18.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_01.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_01");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 65);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_01.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_02.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_02() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_02");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_02.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_03.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_03() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_03");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_03.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_04.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_04() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_04");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 72);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_04.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_05.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_05() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_05");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 72);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_05.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_06.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_06() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_06");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 70);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_06.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_07.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_07() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_07");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 71);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_07.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_08.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_08() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_08");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 79);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_08.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_09.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_09() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_09");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_09.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_10.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_10");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_10.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_11.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_11");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_11.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_12.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_12");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_12.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_13.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_13");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_13.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_14.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_14");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_14.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_15.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_15");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 68);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_15.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_16.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_16");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_16.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_17.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_17");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_17.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e534_ info_ exposure_ debug_ log__w32_wchar_t_18.
	 */
	@Test
	public void test_CWE534_Info_Exposure_Debug_Log__w32_wchar_t_18() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE534_Info_Exposure_Debug_Log__w32_wchar_t_18");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE534_Info_Exposure_Debug_Log__w32_wchar_t_18.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	// /////////////////////////////////////////////////////////cwe 535 jUnit
	// tests

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_01.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_01");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 64);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_01.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_02.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_02() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_02");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 62);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_02.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_03.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_03() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_03");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_03.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_04.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_04() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_04");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 72);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_04.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_05.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_05() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_05");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 72);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_05.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_06.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_06() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_06");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 71);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_06.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_07.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_07() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_07");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 71);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_07.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_08.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_08() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_08");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 79);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_08.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_09.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_09() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_09");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_09.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_10.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_10");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_10.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_11.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_11");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_11.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_12.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_12");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_12.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_13.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_13");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_13.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_14.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_14");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_14.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_15.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_15");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_15.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_16.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_16");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_16.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_17.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_17");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_17.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_char_18.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_char_18() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_char_18");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_char_18.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_01.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_01");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 64);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_01.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_02.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_02() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_02");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_02.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_03.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_03() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_03");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_03.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_04.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_04() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_04");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 72);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_04.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_05.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_05() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_05");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 72);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_05.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_06.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_06() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_06");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 71);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_06.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_07.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_07() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_07");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 71);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_07.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_08.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_08() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_08");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 79);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_08.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_09.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_09() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_09");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_09.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_10.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_10");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_10.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_11.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_11");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_11.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_12.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_12");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_12.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_13.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_13");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_13.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_14.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_14");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_14.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_15.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_15");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_15.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_16.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_16");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_16.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_17.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_17");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 67);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_17.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test_ cw e535_ info_ exposure_ shell_ error__w32_wchar_t_18.
	 */
	@Test
	public void test_CWE535_Info_Exposure_Shell_Error__w32_wchar_t_18() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr
				.getProject("CWE535_Info_Exposure_Shell_Error__w32_wchar_t_18");
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
			assertEquals(map.get("message"),
					"Information Exposure Bug Detected");
			assertEquals(map.get("lineNumber"), 66);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName,
					"CWE535_Info_Exposure_Shell_Error__w32_wchar_t_18.c");

		} catch (CoreException e) {
			fail(e.getMessage());
		}
	}

}
