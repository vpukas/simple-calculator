package pl.vpuk.calc.rpn;


import pl.vpuk.calc.strategy.StrategyProvider;

public class RPNChecker implements RPNChecking {

    private final StrategyProvider strategyProvider;

    public RPNChecker(final StrategyProvider strategyProvider) {
        this.strategyProvider = strategyProvider;
    }

    @Override
    public boolean isDigit(String input) {
        return Character.isDigit(input.charAt(0));
    }

    @Override
    public boolean isLeftBracket(String input) {
        return "(".equals(input);
    }

    @Override
    public boolean isOperator(String input) {
        return strategyProvider.isOperatorAvailable(input);
    }

    @Override
    public boolean isRightBracket(String input) {
        return ")".equals(input);
    }

    @Override
    public boolean isOperatorOrBracket(String c) {
        return isOperator(c) || isRightBracket(c) || isLeftBracket(c);
    }

    @Override
    public boolean isLeftAssociativity(String c) {
        return ("*".equals(c) || "+".equals(c) || "/".equals(c) || "-".equals(c));
    }

    @Override
    public boolean isRightAssociativity(String c) {
        return "^".equals(c);
    }

    @Override
    public int compareOperators(String operator1, String operator2) {
        Integer i1 = strategyProvider.getOperator(operator1).getPriority();
        Integer i2 = strategyProvider.getOperator(operator2).getPriority();
        return i1 - i2;
    }

    @Override
    public boolean isFunction(String input) {
        return strategyProvider.isFunctionAvailable(input);
    }

    @Override
    public int getFunctionParamsCount(String functionName) {
        return strategyProvider.getFunction(functionName).getParamCount();
    }

}
