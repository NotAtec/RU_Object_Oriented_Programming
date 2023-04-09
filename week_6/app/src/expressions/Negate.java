package expressions;

import java.util.Map;

public class Negate extends OneArgExpr{

    private Expression expr;

    public Negate (Expression expr) {
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "-" + expr.toString();
    }

	public double eval(Map<String, Double> env) {
        double result = expr.eval(env);
        return -result;
    }
	
    public Expression partialEval() {
        return new Negate(expr);
    }
}
