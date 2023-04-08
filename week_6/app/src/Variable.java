import expressions.NoArgExpr;

public class Variable extends NoArgExpr{
    
    private String name;

    public Variable (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
	public double eval(Map<String, Double> env) {
        return env.get(this.name);
    }

    @Override
	public Expression partialEval() {
        return new Variable(name);
    }
}
