package ast;

public interface FormulaVisitor <Result , AdditionalArg > {
    Result visit(Constant form , AdditionalArg a);
    Result visit(Atom form , AdditionalArg a);
    Result visit(BinaryOperator form , AdditionalArg a);
    Result visit(Not form , AdditionalArg a);
}
