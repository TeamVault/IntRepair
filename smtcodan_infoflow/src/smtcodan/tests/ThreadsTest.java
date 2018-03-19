package smtcodan.tests;

//import static org.junit.Assert.fail;
//
//import java.util.Collection;
//import java.util.Iterator;
//
//import org.eclipse.cdt.codan.core.CodanRuntime;
//import org.eclipse.cdt.codan.core.model.IChecker;
//import org.eclipse.cdt.codan.core.model.ICheckersRegistry;
//import org.eclipse.core.resources.IProject;
//import org.eclipse.core.resources.IWorkspaceRoot;
//import org.eclipse.core.resources.ResourcesPlugin;
//import org.junit.Ignore;
//import org.junit.Test;
//
//import smtcodan.ProgramPath;
//import smtcodan.WorkPoolManager;
//import smtcodan.pathgen.IndBasicBlock;
//import smtcodan.visualization.IProgramTreeEntry;
//import smtcodan.visualization.TreeEdge;
//import edu.uci.ics.jung.graph.DelegateTree;

   // TODO Uncomment to use, needs JUNG graph lib loaded as plug-in

public class ThreadsTest {

//	@Test
//	public void test_ExecutionTreeEquivalence() {
//		IWorkspaceRoot wsr = ResourcesPlugin.getWorkspace().getRoot();
//		IProject proj = wsr.getProject("CWE121_Stack_Based_Buffer_Overflow__char_type_overrun_memcpy_16");
//		ICheckersRegistry reg = CodanRuntime.getInstance().getCheckersRegistry();
//		Iterator<IChecker> iter = reg.iterator();
//		WorkPoolManager see = null;
//		while (iter.hasNext()) {
//			IChecker checker = iter.next();
//			if (checker instanceof WorkPoolManager) {
//				see = (WorkPoolManager) checker;
//			}
//		}
//		if (see == null) {
//			fail();
//		}		
//		try {			
//			DelegateTree<IProgramTreeEntry, TreeEdge> tree1 = see.getProgramTree(proj, 1).getTree();
//			DelegateTree<IProgramTreeEntry, TreeEdge> tree2 = see.getProgramTree(proj, 4).getTree();
//			int num_v1 = tree1.getVertexCount();
//			int num_e1 = tree1.getEdgeCount();
//			int num_v2 = tree2.getVertexCount();
//			int num_e2 = tree2.getVertexCount();
//			
//			Collection<IProgramTreeEntry> verts1 = tree1.getVertices();
//			Collection<IProgramTreeEntry> verts2 = (Collection<IProgramTreeEntry>) tree2.getVertices();
//			
//			Iterator<IProgramTreeEntry> iter1 = verts1.iterator();			
//			int i = 0;
//			String missingPath = null;
//			boolean foundMissingPath = false;
//			while (iter1.hasNext() && (!foundMissingPath)) {
//				i++;
//				IProgramTreeEntry te1 = iter1.next();
//				if (te1 instanceof IndBasicBlock) {
//					boolean ok = tree2.containsVertex(te1);
//					if (!ok) {
//						ProgramPath startPath = ((IndBasicBlock) te1).getEntryPath();
//						Iterator<IProgramTreeEntry> iter2 = verts2.iterator();
//						boolean contained2 = false;
//						while (iter2.hasNext()) {
//							IProgramTreeEntry te2 = iter2.next();
//							if (te2 instanceof IndBasicBlock) {
//								ProgramPath path2 = ((IndBasicBlock) te2).getEntryPath();
//								if (startPath.toString().compareTo(path2.toString()) == 0) {
//									contained2 = true;
//								}
//							}							
//						}
//						if (!contained2) {
//							foundMissingPath = true;
//							missingPath = startPath.toString();
//						}
//					}
//				}				
//			}
//		} catch (Exception e) {			
//			fail(e.getMessage());
//		}
//	}
	
}
