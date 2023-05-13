package ast;

import java.util.Map;

public class EvaluateVisitor implements FormulaVisitor<Boolean, Void>{

    private final Map<String, Boolean> environ;

    public EvaluateVisitor(Map<String, Boolean> environ) {
        this.environ = environ;
    }

    @Override
    public Boolean visit(Constant form, Void a) {
        return form.getValue();
    }

    @Override
    public Boolean visit(Atom form, Void a) {
        return environ.get(form.getProp());
    }

    @Override
    public Boolean visit(BinaryOperator form, Void a) {
        boolean left = form.getLeftFormula().accept(this, a);
        boolean right = form.getRightFormula().accept(this, a);
        switch(form.getBinOp()) {
            case AndOp: return left && right;
            case OrOp: return left || right;
            case ImpliesOp: return !left || right;
        }
        return true; //compiler doesn't think we returned something
    }

    @Override
    public Boolean visit(Not form, Void a) {
        return !(form.getOperand().accept(this, a));
    }
    
}
