package ast;

public interface FormulaVisitor <Result , AdditionalArg > {
    Result visit(Not form , AdditionalArg a);
}
