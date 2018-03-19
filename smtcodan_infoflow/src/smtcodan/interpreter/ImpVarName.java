package smtcodan.interpreter;

import org.eclipse.cdt.core.dom.ILinkage;
import org.eclipse.cdt.core.dom.IName;
import org.eclipse.cdt.core.dom.ast.ASTNodeProperty;
import org.eclipse.cdt.core.dom.ast.ASTVisitor;
import org.eclipse.cdt.core.dom.ast.ExpansionOverlapsBoundaryException;
import org.eclipse.cdt.core.dom.ast.IASTCompletionContext;
import org.eclipse.cdt.core.dom.ast.IASTFileLocation;
import org.eclipse.cdt.core.dom.ast.IASTImageLocation;
import org.eclipse.cdt.core.dom.ast.IASTName;
import org.eclipse.cdt.core.dom.ast.IASTNode;
import org.eclipse.cdt.core.dom.ast.IASTNodeLocation;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.dom.ast.IBinding;
import org.eclipse.cdt.core.parser.IToken;

public class ImpVarName implements IName {

	static int number=0;
	String name;	
	
	public ImpVarName() {
		name = new String("imp" + number);
	}

	static void incImpVarCounter() {
		number++;
	}
	
	static void decImpVarCoutner() {
		number--;
	}
	
	public String toString() {
		return name;
	}

	@Override
	public char[] getSimpleID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Deprecated
	public char[] toCharArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDeclaration() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReference() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDefinition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IASTFileLocation getFileLocation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
