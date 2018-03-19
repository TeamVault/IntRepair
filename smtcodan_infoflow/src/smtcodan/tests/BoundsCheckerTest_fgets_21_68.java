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
import org.junit.*;

// TODO: Auto-generated Javadoc
/**
 * The Class BoundsCheckerTest_fgets_21_68.
 */
public class BoundsCheckerTest_fgets_21_68 {

	/** The markers. */
	protected IMarker[] markers;	
	

	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_21.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_21() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_21");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_21.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_22.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_22() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_22");
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
			assertEquals(map.get("lineNumber"), 36);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_22b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_31.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_31() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_31");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_31.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_32.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_32() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_32");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_32.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_34.
	 */
	@Ignore("unions not yet implemented")
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_34() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_34");
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
			assertEquals(map.get("lineNumber"), 59);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_34.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_41.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_41() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_41");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_41.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_42.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_42() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_42");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_42.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_44.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_44() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_44");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_44.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}		
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_45.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_45() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_45");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_45.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_51.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_51() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_51");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_51b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_52.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_52() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_52");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_52c.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_53.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_53() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_53");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_53d.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_54.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_54() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_54");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_54e.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_61.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_61() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_61");
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
			assertEquals(map.get("lineNumber"), 40);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_61a.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_63.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_63() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_63");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_63b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_64.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_64() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_64");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_64b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_65.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_65() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_65");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_65b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_66.
	 */
	@Ignore("solver error with array logic")
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_66() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_66");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_66b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}	
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_67.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_67() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_67");
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
			assertEquals(map.get("lineNumber"), 39);
			assertEquals(type, "org.eclipse.cdt.codan.core.codanProblem");
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_67b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test_ cw e121_ stack_ based_ buffer_ overflow__ cw e129_fgets_68.
	 */
	@Test
	public void test_CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_68() {
		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_68");
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
			assertEquals(resourceName, "CWE121_Stack_Based_Buffer_Overflow__CWE129_fgets_68b.c");									
							
		} catch (CoreException e) {			
			fail(e.getMessage());
		}
	}
	
}
