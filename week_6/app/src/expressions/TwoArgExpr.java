package expressions;

import java.util.Map;

public abstract class TwoArgExpr implements Expression{
    
    protected Expression left;
    protected Expression right;

    protected abstract String getOperator();
    public abstract double eval(Map<String, Double> env);
    public abstract Expression partialEval();

    @Override
    public String toString() {
        return "(" + this.left.toString() + getOperator() + this.right.toString() + ")";
    }
}
