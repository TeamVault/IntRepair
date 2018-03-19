package smtcodan.checkers.tests;

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
import org.junit.*;


public class InfiniteLoopCheckerTest {

	@Test
	public void test_CWE835_Infinite_Loop__do_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE835_Infinite_Loop__do_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Infinite loop");
			assertEquals(map.get("lineNumber"), 19);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE835_Infinite_Loop__do_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE835_Infinite_Loop__do_true_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE835_Infinite_Loop__do_true_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Infinite loop");
			assertEquals(map.get("lineNumber"), 19);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE835_Infinite_Loop__do_true_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE835_Infinite_Loop__for_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE835_Infinite_Loop__for_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Infinite loop");
			assertEquals(map.get("lineNumber"), 15);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE835_Infinite_Loop__for_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE835_Infinite_Loop__for_empty_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE835_Infinite_Loop__for_empty_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Infinite loop");
			assertEquals(map.get("lineNumber"), 15);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE835_Infinite_Loop__for_empty_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void test_CWE835_Infinite_Loop__while_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE835_Infinite_Loop__while_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Infinite loop");
			assertEquals(map.get("lineNumber"), 15);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE835_Infinite_Loop__while_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test_CWE835_Infinite_Loop__while_true_01() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE835_Infinite_Loop__while_true_01");
		CodanRuntime.getInstance().getBuilder().processResource(proj, new NullProgressMonitor(), CheckerLaunchMode.RUN_ON_DEMAND);
		try {			
			IMarker[] markers = proj.findMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
			int number = markers.length;					
			Map<String, Object> map = markers[0].getAttributes();
			String type = markers[0].getType();
			String resourceName = markers[0].getResource().getName();
	
			proj.deleteMarkers(IProblemReporter.GENERIC_CODE_ANALYSIS_MARKER_TYPE, true, IResource.DEPTH_INFINITE);			
			
			assertEquals(number,1);	
			assertEquals(map.get("message"), "Infinite loop");
			assertEquals(map.get("lineNumber"), 15);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE835_Infinite_Loop__while_true_01.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}		
	
}
