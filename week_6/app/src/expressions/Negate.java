package expressions;

public class Negate extends OneArgExpr{

    private Expression expr;

    public Expression (Expression expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "-" + expr.toString();
    }

	public double eval(Map<String, Double> env) {
        double result = expr.eval;
        return -result;
    }
	
    public Expression partialEval() {
        //return -1 * expr
        //construct product expresion
        return null;
    }
}
