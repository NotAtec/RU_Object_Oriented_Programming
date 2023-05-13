package ast;

public class Not implements Formula{

    private Formula operand ;
    private final int precedence = 4;
    
    public Not( Formula oper ) {
        this. operand = oper;
    }

    public Formula getOperand () {
        return operand ;
    }

    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A a) {
        return visitor.visit(this, a);       
    }

    public int getPrecedence() {
        return precedence;
    }
}
