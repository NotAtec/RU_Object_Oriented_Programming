package ast;

public enum Constant implements Formula{
    TRUE(true), FALSE(false);

    private final boolean value;
    private final int precedence = 1;

    private Constant (boolean value) {
        this.value = value;
    }

    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A a) {
        return visitor.visit(this, a);
    }

    public boolean getValue() {
        return value;
    }

    public int getPrecedence() {
        return precedence;
    }
}
