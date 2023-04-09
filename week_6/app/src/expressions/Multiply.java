package expressions;

import java.util.Map;

public class Multiply extends TwoArgExpr{

    public Multiply(Expression left, Expression right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    public double eval(Map<String, Double> env) {
        return super.left.eval(env) * super.right.eval(env);
    }

    @Override
	public Expression partialEval() {
        Expression leftPartial = super.left.partialEval();
        Expression rightPartial = super.right.partialEval();
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
