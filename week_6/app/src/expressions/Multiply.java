package expressions;

public class Multiply extends TwoArgExpr{

    Expression left;
    Expression right;

    public Add(Expression left, Expresion right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " x " + right.toString();
    }

    @Override
    public double eval(Map<String, Double> env) {
        return left.eval * right.eval;
    }

    @Override
	public Expression partialEval() {
        Expression leftPartial = left.partialEval();
        Expression rightPartial = right.partialEval();
        Expression zero = new Constant(0);
        Expression one = new Constant(1);


        if (leftPartial.equals(zero) || rightPartial.equals(zero)) {
            return new Constant(zero);
        } else if (leftPartial.equals(one)) {
            return rightPartial;
        } else if (rightPartial.equals(one)) {
            return leftPartial;
        } //if both leftpartial and rightpartial are constants
          else if (leftpartial.getConstantValue != null && rightPartial.getConstantValue() != null) {
            return new Constant(leftPartial.getConstantValue() * rightPartial.getConstantValue());
        } else {
            return new Multiply(leftPartial, rightPartial);
        }

    }
}
