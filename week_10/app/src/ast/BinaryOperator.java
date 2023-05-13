package ast;

public class BinaryOperator implements Formula{
    private final Formula leftFormula;
    private final Formula rightFormula;
    private final BinOp operator;

    public BinaryOperator(Formula leftFormula, Formula rightFormula, BinOp operator) {
        this.leftFormula = leftFormula;
        this.rightFormula = rightFormula;
        this.operator = operator;
    }

    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A a) {
        return visitor.visit(this, a);
    }

    public Formula getLeftFormula() {
        return leftFormula;
    }

    public Formula getRightFormula() {
        return rightFormula;
    }

    public BinOp getBinOp() {
        return operator;
    }
}
