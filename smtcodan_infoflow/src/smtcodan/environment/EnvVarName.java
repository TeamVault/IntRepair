/*
 * 
 */
package smtcodan.environment;

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

// TODO: Auto-generated Javadoc
/**
 * The Class EnvVarName.
 */
public class EnvVarName implements IName {

	/** The number. */
	static int number=0;
	
	/** The name. */
	String name;	
	
	/**
	 * Instantiates a new env var name.
	 */
	EnvVarName() {
		name = new String("envgen" + number);
		number++;		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.dom.IName#getSimpleID()
	 */
	@Override
	public char[] getSimpleID() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.dom.IName#toCharArray()
	 */
	@Override
	@Deprecated
	public char[] toCharArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.dom.IName#isDeclaration()
	 */
	@Override
	public boolean isDeclaration() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.dom.IName#isReference()
	 */
	@Override
	public boolean isReference() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.dom.IName#isDefinition()
	 */
	@Override
	public boolean isDefinition() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.dom.IName#getFileLocation()
	 */
	@Override
	public IASTFileLocation getFileLocation() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
