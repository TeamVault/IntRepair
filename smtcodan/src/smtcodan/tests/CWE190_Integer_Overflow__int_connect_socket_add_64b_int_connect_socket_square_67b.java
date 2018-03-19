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

public class CWE190_Integer_Overflow__int_connect_socket_add_64b_int_connect_socket_square_67b{
	protected IMarker[] markers;
	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_64b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_64b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 52);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_64b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_65b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_65b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 48);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_65b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_66b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_66b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_66b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_67b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_67b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 54);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_67b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_68b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_68b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 53);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_68b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_72b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_72b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 34);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_72b.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_73b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_73b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 34);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_73b.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_74b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_74b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 34);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_74b.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_81_bad() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_81_bad");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 29);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_81_bad.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_82_bad() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_82_bad");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 29);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_82_bad.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_83_bad() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_83_bad");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 111);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_83_bad.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_add_84_bad() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_add_84_bad");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 111);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_add_84_bad.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 108);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_02() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_02");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 113);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_02.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_03() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_03");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 113);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_03.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_04() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_04");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 119);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_04.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_05() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_05");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 119);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_05.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_06() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_06");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 118);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_06.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_07() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_07");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 118);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_07.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_08() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_08");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 126);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_08.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_09() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_09");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 113);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_09.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_10");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 113);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_10.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_11");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 113);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_11.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_12");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 118);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_12.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_13");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 113);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_13.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_14");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 113);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_14.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_15");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 120);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_15.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_16");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_16.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_17");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_17.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_18() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_18");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 112);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_18.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_21() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_21");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 54);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_21.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_22b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_22b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 32);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_22b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_31() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_31");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 111);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_31.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_32() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_32");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 116);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_32.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_33() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_33");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_33.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_34() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_34");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 118);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_34.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_41() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_41");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_41.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_42() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_42");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_42.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_43() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_43");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 116);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_43.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_44() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_44");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_44.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_45() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_45");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 54);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_45.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_51b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_51b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_51b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_52c() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_52c");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_52c.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_53d() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_53d");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_53d.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_54e() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_54e");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_54e.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_61a() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_61a");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 56);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_61a.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_62a() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_62a");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 37);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_62a.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_63b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_63b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_63b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_64b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_64b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 53);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_64b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_65b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_65b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_65b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_66b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_66b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 51);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_66b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_67b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_67b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 55);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_67b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_68b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_68b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 54);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_68b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_72b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_72b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 35);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_72b.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_73b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_73b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 35);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_73b.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_74b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_74b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 35);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_74b.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_81_bad() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_81_bad");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 30);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_81_bad.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_82_bad() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_82_bad");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 30);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_82_bad.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_83_bad() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_83_bad");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 112);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_83_bad.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_multiply_84_bad() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_multiply_84_bad");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 112);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_multiply_84_bad.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 109);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_02() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_02");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_02.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_03() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_03");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_03.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_04() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_04");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 120);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_04.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_05() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_05");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 120);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_05.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_06() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_06");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 119);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_06.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_07() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_07");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 119);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_07.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_08() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_08");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 127);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_08.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_09() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_09");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_09.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_10");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_10.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_11");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_11.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_12");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 119);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_12.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_13");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_13.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_14");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 114);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_14.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_15");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 121);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_15.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_16");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 115);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_16.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_17");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 115);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_17.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_18() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_18");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 113);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_18.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_21() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_21");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 55);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_21.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_22b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_22b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 33);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_22b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_31() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_31");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 112);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_31.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_32() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_32");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 117);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_32.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_33() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_33");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 115);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_33.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_34() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_34");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 119);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_34.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_41() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_41");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_41.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_42() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_42");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 115);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_42.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_43() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_43");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 117);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_43.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_44() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_44");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_44.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_45() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_45");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 55);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_45.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_51b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_51b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_51b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_52c() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_52c");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_52c.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_53d() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_53d");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_53d.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_54e() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_54e");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_54e.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_61a() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_61a");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 57);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_61a.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_62a() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_62a");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 38);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_62a.cpp");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_63b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_63b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 51);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_63b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_64b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_64b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 54);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_64b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_65b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_65b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_65b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_66b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_66b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 52);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_66b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE190_Integer_Overflow__int_connect_socket_square_67b() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE190_Integer_Overflow__int_connect_socket_square_67b");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 56);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE190_Integer_Overflow__int_connect_socket_square_67b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
}
