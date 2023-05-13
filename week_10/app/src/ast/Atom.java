package ast;

public class Atom implements Formula{

    private String prop;
    private final int precedence = 0;

    Atom (String prop) {
        this.prop = prop;
    }

    @Override
    public <R, A> R accept(FormulaVisitor<R, A> visitor, A a) {
        return visitor.visit(this, a);
    }

    int getPrecedence(){
        return this.precedence;
    }
    
    public String getProp() {
        return this.prop;
    }

}
