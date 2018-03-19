package smtcodan;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.core.resources.IFile;

public class BugInfo implements Comparable<BugInfo> {
	
	String id;
	IFile file;
	IASTFileLocation loc;
	String problemMessage;
	String problemDescription;
	
	private static Set<BugInfo> infos;
	
	private BugInfo(String id, IFile file, IASTFileLocation loc,
			String problemMessage, String problemDescription) {
		super();
		this.id = id;
		this.file = file;
		this.loc = loc;
		this.problemMessage = problemMessage;
		this.problemDescription = problemDescription;
	}
	
	public static BugInfo get(String id, IFile file, IASTFileLocation loc,
			String problemMessage, String problemDescription) {
		BugInfo ret = new BugInfo(id, file, loc, problemMessage, problemDescription);
		if (null == infos)
			infos = new HashSet<>();
		
		for (BugInfo b : infos)
			if (b.compareTo(ret) == 0)
				return b;
		infos.add(ret);
		return ret;
	}

	@Override
	public int compareTo(BugInfo o) {
		return (this.id == o.id &&
				this.file.equals(o.file) &&
				this.loc.getNodeOffset() == o.loc.getNodeOffset() &&
				this.loc.getNodeLength() == o.loc.getNodeLength() &&
				this.problemMessage.compareTo(o.problemMessage) == 0 &&
				this.problemDescription.compareTo(o.problemDescription) == 0) ? 0 : -1;
	}
}
