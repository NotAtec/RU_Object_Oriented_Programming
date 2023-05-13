package ast;

public class PrintVisitor implements FormulaVisitor<Void, Integer>{

    private StringBuilder result;

    public PrintVisitor (StringBuilder result) {
        this.result = result;
    }

    @Override
    public Void visit(Constant form, Integer a) {
        if (form.getValue()) {
            result.append("True");
            return null;
        }
        result.append("False");
        return null;
    }

    @Override
    public Void visit(Atom form, Integer a) {
        result.append(form.getProp());
        return null;
    }

    @Override
    public Void visit(BinaryOperator form, Integer a) {
        if (form.getPrecedence() <= a) {
            result.append("(");
        }
        form.getLeftFormula().accept(this, form.getPrecedence());
        result.append(form.getBinOp().string);
        form.getRightFormula().accept(this, form.getPrecedence());

        if (form.getPrecedence() <= a) {
            result.append(")");
        }
        return null;
    }

    @Override
    public Void visit(Not form, Integer a) {
        result.append("!");
        form.getOperand().accept(this, form.getPrecedence());
        return null;
    }
    
    public String getResult() {
        return result.toString();
    }
}
