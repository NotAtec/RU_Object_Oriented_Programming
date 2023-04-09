package expressions;

import java.util.Map;

public class Negate extends OneArgExpr{

    public Negate (Expression expr) {
        super.expr = expr;
    }

    @Override
    public String toString() {
        return "-" + super.expr.toString();
    }

	public double eval(Map<String, Double> env) {
        return -super.expr.eval(env);
    }
	
    public Expression partialEval() {
        return new Negate(super.expr);
    }
}
