package pl.vpuk.calc.rpn;

public interface RPNChecking {

    boolean isDigit(String input);

    boolean isOperator(String input);

    boolean isLeftBracket(String input);

    boolean isRightBracket(String input);

    boolean isOperatorOrBracket(String c);

    boolean isLeftAssociativity(String c);

    boolean isRightAssociativity(String c);

    int compareOperators(String operator1, String operator2);

    boolean isFunction(String input);

    int getFunctionParamsCount(String functionName);
}
