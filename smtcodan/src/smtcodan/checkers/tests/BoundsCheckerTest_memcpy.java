package smtcodan.checkers.tests;

import java.util.Map;

import org.eclipse.cdt.codan.core.model.CheckerLaunchMode;

import org.eclipse.cdt.codan.core.CodanRuntime;
import org.eclipse.cdt.codan.core.model.IProblemReporter;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.*;

import static org.junit.Assert.*;

public class BoundsCheckerTest_memcpy {
	
	// TODO: parameterized test method
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 42);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
		
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_02() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_02");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			 
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_02.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_03() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_03");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_03.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}

	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_04() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_04");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_04.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_05() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_05");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 50);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_05.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_06() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_06");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_06.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_07() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_07");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 49);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_07.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_08() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_08");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 57);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_08.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_09() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_09");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_09.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_10() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_10");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_10.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_11() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_11");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_11.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}		
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_12() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_12");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_12.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_13() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_13");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_13.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_14() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_14");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_14.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_15() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_15");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 45);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_15.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_16() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_16");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 44);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_16.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	

	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_17() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_17");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 45);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_17.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}		
	
	@Ignore
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_18() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_18");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 46);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_18.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}		
	
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_19() {			
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_19");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Upper array bound violation");
			assertEquals(map.get("lineNumber"), 42);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_19.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
		
	
}
