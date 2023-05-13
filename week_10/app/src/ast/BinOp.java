package ast;

import java.util.function.BinaryOperator;

public enum BinOp implements BinaryOperator<Boolean> {
    AndOp ("/\\", (left, right) -> left && right),
    OrOp ("\\/", (left, right) -> left || right),
    ImpliesOp ("=>", (left, right) -> !left || right);

    public final String string;
    public final BinaryOperator<Boolean> op;

    private BinOp(String string, BinaryOperator<Boolean> op) {
        this.string = string;
        this.op = op;
    }

    public Boolean apply(Boolean left, Boolean right) {
        return op.apply(left, right);
    }
}
