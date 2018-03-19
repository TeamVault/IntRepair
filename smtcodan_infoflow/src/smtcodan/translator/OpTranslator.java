package smtcodan.translator;

import org.eclipse.cdt.core.dom.ast.IASTBinaryExpression;
import org.eclipse.cdt.core.dom.ast.IASTUnaryExpression;
import org.eclipse.cdt.core.dom.ast.IBasicType;

public class OpTranslator {

	static String unaryOp(int op) {
		switch (op) {
			case IASTUnaryExpression.op_minus : return "-";
			case IASTUnaryExpression.op_not : return "not";
			case IASTUnaryExpression.op_bracketedPrimary: return " "; // "()"
		}
		return null;
	}
	
	static IBasicType.Kind unOpResType(int op) {
		switch (op) {
			// logical:
			case IASTUnaryExpression.op_not : return IBasicType.Kind.eBoolean;
			// arithmetic:			

		}
		return null;
	}

	static String binaryOp(int op) {
		switch (op) {
			// logical:
			case IASTBinaryExpression.op_equals : return "=";
			case IASTBinaryExpression.op_notequals : return "distinct";
			case IASTBinaryExpression.op_greaterThan : return ">";
			case IASTBinaryExpression.op_greaterEqual : return ">=";
			case IASTBinaryExpression.op_lessThan : return "<";
			case IASTBinaryExpression.op_lessEqual : return "<=";
			case IASTBinaryExpression.op_logicalAnd : return "and";
			case IASTBinaryExpression.op_logicalOr : return "or";
			// arithmetic:
			case IASTBinaryExpression.op_plus : return "+";
			case IASTBinaryExpression.op_minus : return "-";
			case IASTBinaryExpression.op_multiply : return "*";
			case IASTBinaryExpression.op_divide : return "/";
			case IASTBinaryExpression.op_assign : return "=";
			case IASTBinaryExpression.op_modulo : return "mod";
		}
		return null;
	}	

	static IBasicType.Kind binOpResType(int op) {
		switch (op) {
			// logical:
			case IASTBinaryExpression.op_equals : 
			case IASTBinaryExpression.op_notequals : 
			case IASTBinaryExpression.op_greaterThan : 
			case IASTBinaryExpression.op_greaterEqual : 
			case IASTBinaryExpression.op_lessThan : 
			case IASTBinaryExpression.op_lessEqual : 
			case IASTBinaryExpression.op_logicalAnd : 
			case IASTBinaryExpression.op_logicalOr : return IBasicType.Kind.eBoolean;
			// arithmetic:			
			default: return IBasicType.Kind.eInt;
		}
		
	}
	
}
