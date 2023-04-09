package expressions;

import java.util.Map;

public class Multiply extends TwoArgExpr{

    Expression left;
    Expression right;

    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " x " + right.toString();
    }

    @Override
    public double eval(Map<String, Double> env) {
        return left.eval(env) * right.eval(env);
    }

    @Override
	public Expression partialEval() {
        Expression leftPartial = left.partialEval();
        Expression rightPartial = right.partialEval();
        Expression zero = new Constant(0);
        Expression one = new Constant(1);


        if (leftPartial.equals(zero) || rightPartial.equals(zero)) {
            return new Constant(0);
        } else if (leftPartial.equals(one)) {
            return rightPartial;
        } else if (rightPartial.equals(one)) {
            return leftPartial;
        } //if both leftpartial and rightpartial are constants
          else if (leftPartial.getConstantValue() != null && rightPartial.getConstantValue() != null) {
            return new Constant(leftPartial.getConstantValue() * rightPartial.getConstantValue());
        } else {
            return new Multiply(leftPartial, rightPartial);
        }

    }
}
