package ast;

import java.util.function.BinaryOperator;

public enum BinOp implements BinaryOperator<Boolean> {
    AndOp ("/\\", (left, right) -> left && right, 4),
    OrOp ("\\/", (left, right) -> left || right, 3),
    ImpliesOp ("=>", (left, right) -> !left || right, 2);

    public final String string;
    public final BinaryOperator<Boolean> op;
    public final int precedence;

    private BinOp(String string, BinaryOperator<Boolean> op, int precedence) {
        this.string = string;
        this.op = op;
        this.precedence = precedence;
    }

    public Boolean apply(Boolean left, Boolean right) {
        return op.apply(left, right);
    }
}
