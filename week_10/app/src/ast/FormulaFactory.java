package ast;

import java.util.Map;

public class FormulaFactory {

	public static Formula atom(String atomId) {
		return null;
	}

	public static Formula and(Formula leftOp, Formula rightOp) {
		return null;
	}

	public static Formula or(Formula leftOp, Formula rightOp) {
		return null;
	}

	public static Formula implies(Formula leftOp, Formula rightOp) {
		return null;
	}

	public static Formula not(Formula notOp) {
		return null;
	}

	public static final Formula TRUE = null;

	public static final Formula FALSE = null;

	public static String prettyPrint(Formula f) {
		return "";
	}

	public static Boolean evaluate(Formula f, Map<String,Boolean> env) {
		return null;
	}
}
