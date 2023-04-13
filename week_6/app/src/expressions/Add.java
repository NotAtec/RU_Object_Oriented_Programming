package expressions;

import java.util.Map;

public class Add extends TwoArgExpr{

    public Add(Expression left, Expression right) {
        super.left = left;
        super.right = right;
    }

    @Override
    public String getOperator() {
        return "+";
    }

    @Override
    public double eval(Map<String, Double> env) {
        return super.left.eval(env) + super.right.eval(env);
    }

    @Override
	public Expression partialEval() {
        Expression leftPartial = super.left.partialEval();
        Expression rightPartial = super.right.partialEval();
        Expression zero = new Constant(0);


        if (leftPartial.equals(zero)) {
            if (rightPartial.equals(zero)) {
                return rightPartial;
            }
            return rightPartial;
        } else if (rightPartial.equals(zero)) {
            if (leftPartial.equals(zero)) {
                return new Constant(0);
            }
            return leftPartial;
        } else if (leftPartial.getConstantValue() != null && rightPartial.getConstantValue() != null) {
            return new Constant(leftPartial.getConstantValue() + rightPartial.getConstantValue());
        } else {
            return new Add(leftPartial, rightPartial);
        }

    }
    
}
