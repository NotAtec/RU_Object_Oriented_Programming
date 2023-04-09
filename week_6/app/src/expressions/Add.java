package expressions;

public class Add extends TwoArgExpr{
    
    Expression left;
    Expression right;

    public Add(Expression left, Expresion right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }

    @Override
    public double eval(Map<String, Double> env) {
        return left.eval + right.eval;
    }

    @Override
	public Expression partialEval() {
        Expression leftPartial = left.partialEval();
        Expression rightPartial = right.partialEval();
        Expression zero = new Constant(0);


        if (leftPartial.equals(zero)) {
            if (rightPartial.equals(zero)) {
                return rightPartial;
            }
            return rightPartial;
        } else if (rightpartial.equals(zero)) {
            if (leftPartial.equals(zero)) {
                return new Constant(0);
            }
            return leftPartial;
        } else if (leftpartial.getConstantValue != null && rightPartial.getConstantValue() != null) {
            return new Constant(leftPartial.getConstantValue() + rightPartial.getConstantValue());
        } else {
            return new Add(leftPartial, rightPartial);
        }

    }
    
}
