package ast;

public class Atom implements Formula{

    private String prop;
    private final int precedence = 1;

    Atom (String prop) {
        this.prop = prop;
    }

    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A a) {
        return visitor.visit(this, a);
    }
    
    public String getProp() {
        return this.prop;
    }

    int getPrecedence(){
        return this.precedence;
    }
}
