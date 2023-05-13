package ast;

import java.util.Map;

public class FormulaFactory {

	public static Formula atom(String atomId) {
		return (new Atom(atomId));
	}

	public static Formula and(Formula leftOp, Formula rightOp) {
		return (new BinaryOperator(leftOp, rightOp, BinOp.AndOp));
	}

	public static Formula or(Formula leftOp, Formula rightOp) {
		return (new BinaryOperator(leftOp, rightOp, BinOp.OrOp));
	}

	public static Formula implies(Formula leftOp, Formula rightOp) {
		return (new BinaryOperator(leftOp, rightOp, BinOp.ImpliesOp));
	}

	public static Formula not(Formula notOp) {
		return (new Not(notOp));
	}

	public static final Formula TRUE = Constant.TRUE;

	public static final Formula FALSE = Constant.FALSE;

	public static String prettyPrint(Formula f) {
		return "";
	}

	public static Boolean evaluate(Formula f, Map<String,Boolean> env) {
		EvaluateVisitor evaluateVisitor = new EvaluateVisitor(env);
		return f.accept(evaluateVisitor, null);
	}
}
