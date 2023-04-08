package expressions;

public class Constant extends NoArgExpr{
    
    private double constant;

    public Constant (double constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "" + getConstant();
    }

    @Override
    public double eval(Map<String, Double> env) {
        return getConstant();
    }

    @Override
    public Expression partialEval() {
        return new Constant(constant);
    }

	// Return a value only if it is a Constant
    @Override
	public Double getConstantValue()
	{
		return this.constant;
	}
}
