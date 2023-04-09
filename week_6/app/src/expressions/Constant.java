package expressions;

import java.util.Map;

public class Constant extends NoArgExpr{
    
    private double constant;

    public Constant (double constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "" + getConstantValue();
    }

    @Override
    public double eval(Map<String, Double> env) {
        return getConstantValue();
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

    @Override
    public boolean equals (Object cons) {
        if (cons == null || getClass() != cons.getClass()) {
            return false;
        } else {
            return this.constant == ((Constant) cons).getConstantValue();
        }
    }
}
