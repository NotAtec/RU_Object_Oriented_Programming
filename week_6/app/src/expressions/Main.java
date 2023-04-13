package expressions;
import static expressions.ExpressionFactory.*;


public class Main {
	public static void main(String[] args) {
		Expression e = var("x");
		System.out.println(e.toString());
	}
}
