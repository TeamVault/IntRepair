package smtcodan.checkers;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.core.resources.IFile;

import smtcodan.IMemObserver;
import smtcodan.PathExplorer;
import smtcodan.Solver;
import smtcodan.interpreter.Interpreter;
import smtcodan.symvars.SymArraySSA;
import smtcodan.symvars.SymIntSSA;
import smtcodan.symvars.SymPointerSSA;
import smtcodan.symvars.SymVarSSA;

public class BoundsChecker implements IMemObserver {

	Interpreter ps;
	Solver sv;
	PathExplorer pe;
	public static String problemid = "smtcodan.checkers.mypsproblem";

	public BoundsChecker(Interpreter ps, Solver sv, PathExplorer pe) {
		this.ps = ps;
		this.sv = sv;
		this.pe = pe;
	}

	public void updateWrite(SymPointerSSA access, IFile file,
			IASTFileLocation loc) {
		ArrayList<IName> varSlice = new ArrayList<IName>();
		SymArraySSA arrayTarget = (SymArraySSA) access.getTargetSSA();
		SymIntSSA size_si = arrayTarget.getSizeSymInt();
		varSlice.add(access.getOrigName());
		varSlice.add(size_si.getOrigName());
		varSlice.add(access.getOrigName());
		String offset = access.getSSAName();
		String newline = System.getProperty("line.separator");
		String sliceDefs = ps.getEQSDefs(varSlice);
		String sliceEqs = ps.getEQS(varSlice);
		// path deps: finer slicing possible...
		String pathDefs = ps.getPathDecDefs();
		String pathEqs = ps.getPathDecEQS();
		// (join defs:) TODO: avoid doubles directly
		StringBuffer jointDefs = new StringBuffer(pathDefs);
		StringTokenizer stokens = new StringTokenizer(sliceDefs, "\n");
		while (stokens.hasMoreTokens()) {
			String line = stokens.nextToken();
			if (!(jointDefs.toString().contains(line))) {
				jointDefs.append(line + "\n");
			}
		}
		// join slices:
		StringBuffer jointEqs = new StringBuffer(pathEqs);
		stokens = new StringTokenizer(sliceEqs, "\n");
		while (stokens.hasMoreTokens()) {
			String line = stokens.nextToken();
			if (!(jointEqs.toString().contains(line))) {
				jointEqs.append(line + "\n");
			}
		}
		String logicDef = "(set-logic AUFNIRA)" + newline;
		String checkSatExit = "(check-sat)" + newline + "(exit)" + newline;
		String bufferSize = size_si.getSSAName();
		String assertLower = "(assert (< " + offset + " 0))" + newline;
		String assertUpper = "(assert (> " + offset + " " + bufferSize + "))"
				+ newline;
		String verifyLower = logicDef + jointDefs + jointEqs + assertLower
				+ checkSatExit;
		String verifyUpper = logicDef + jointDefs + jointEqs + assertUpper
				+ checkSatExit;
		boolean foundError = false;
		String problemMessage = null;
		String reply;
		String problemDescription = null;

		// FIXME: activate
		// reply = sv.queryReply(verifyLower).toString();
		// if (!reply.contains("unsat")) {
		// problemMessage = new String("Lower array bound violation");
		// problemDescription = new String(" trace: " + newline +
		// ps.getTrace() + newline +
		// " verification condition: " + newline + verifyLower + reply +
		// newline);
		// foundError = true;
		// }
		reply = sv.queryReply(verifyUpper).toString();
		if (reply.contains("error")) {
			// TODO
		}
		if (!reply.contains("unsat")) {
			problemMessage = new String("Upper array bound violation");
			problemDescription = new String(" trace: " + newline
					+ ps.getTrace() + newline + " verification condition: "
					+ newline + verifyUpper + reply + newline);
			foundError = true;
		}
		if (foundError) {
			int startline = loc.getStartingLineNumber();
			System.out.println(" BoundsChecker: found error (thread "
					+ Thread.currentThread().getId() + " )");
			pe.reportProblem(problemid, file, startline, problemMessage,
					problemDescription);
		}
	}

	@Override
	public void updateRead(SymPointerSSA access, IFile file,
			IASTFileLocation loc) {
		// TODO
	}

	// TODO: remove. duplicate code
	@Override
	public void updateWrite(SymVarSSA target, String offset, IFile file,
			IASTFileLocation loc) {
		ArrayList<IName> varSlice = new ArrayList<IName>();

		SymArraySSA arrayTarget = (SymArraySSA) target;
		SymIntSSA size_si = arrayTarget.getSizeSymInt();

		varSlice.add(size_si.getOrigName());

		String newline = System.getProperty("line.separator");
		String sliceDefs = ps.getEQSDefs(varSlice);
		String sliceEqs = ps.getEQS(varSlice);
		String logicDef = "(set-logic AUFNIRA)" + newline;
		String checkSatExit = "(check-sat)" + newline + "(exit)" + newline;

		// String bufferSize = ( (SymArraySSA)
		// ps.getOrigSymBuffer(target.getOrigName()).getCurrentSSACopy()
		// ).getSize();
		String bufferSize = size_si.getSSAName();

		String assertLower = "(assert (< " + offset + " 0))" + newline;
		String assertUpper = "(assert (> " + offset + " " + bufferSize + "))"
				+ newline;

		String verifyLower = logicDef + sliceDefs + sliceEqs + assertLower
				+ checkSatExit;
		String verifyUpper = logicDef + sliceDefs + sliceEqs + assertUpper
				+ checkSatExit;

		boolean foundError = false;
		String problemMessage = null;
		String problemDescription = null;

		String reply = sv.queryReply(verifyLower).toString();
		if (!reply.contains("unsat")) {
			problemMessage = new String("Lower array bound violation");
			problemDescription = new String(" trace: " + newline
					+ ps.getTrace() + newline + " verification condition: "
					+ newline + verifyLower + reply + newline);
			foundError = true;
		}

		reply = sv.queryReply(verifyUpper).toString();
		if (!reply.contains("unsat")) {
			problemMessage = new String("Upper array bound violation");
			problemDescription = new String(" trace: " + newline
					+ ps.getTrace() + newline + " verification condition: "
					+ newline + verifyUpper + reply + newline);
			foundError = true;
		}
		if (foundError) {
			int startline = loc.getStartingLineNumber();
			System.out.println(" BoundsChecker: found error (thread "
					+ Thread.currentThread().getId() + " )");
			pe.reportProblem(problemid, file, startline, problemMessage,
					problemDescription);
		}
	}

	@Override
	public void updateRead(SymVarSSA target, String offset, IFile file,
			IASTFileLocation loc) {
		// TODO Auto-generated method stub
	}

}
