package pl.vpuk.calc.strategy;



import pl.vpuk.calc.functions.AbstractFunctionStrategy;
import pl.vpuk.calc.functions.CosFunctionStrategy;
import pl.vpuk.calc.functions.SinusFunctionStrategy;
import pl.vpuk.calc.operators.*;

import java.util.HashMap;
import java.util.Map;

public class DefaultStrategyProvider implements StrategyProvider {

    private Map<String, AbstractOperatorStrategy> operators;
    private Map<String, AbstractFunctionStrategy> functions;

    public DefaultStrategyProvider() {
        operators = new HashMap<>();
        AbstractOperatorStrategy addOperatorStrategy = new AddOperatorStrategy();
        operators.put(addOperatorStrategy.getOperator(), addOperatorStrategy);
        AbstractOperatorStrategy subtractOperatorStrategy = new SubtractOperatorStrategy();
        operators.put(subtractOperatorStrategy.getOperator(), subtractOperatorStrategy);
        AbstractOperatorStrategy multiplyOperatorStrategy = new MultiplyOperatorStrategy();
        operators.put(multiplyOperatorStrategy.getOperator(), multiplyOperatorStrategy);
        AbstractOperatorStrategy divideOperatorStrategy = new DivideOperatorStrategy();
        operators.put(divideOperatorStrategy.getOperator(), divideOperatorStrategy);

        functions = new HashMap<>();
        AbstractFunctionStrategy cosFunction = new CosFunctionStrategy();
        functions.put(cosFunction.getName(), cosFunction);
        AbstractFunctionStrategy sinFunction = new SinusFunctionStrategy();
        functions.put(sinFunction.getName(), sinFunction);
    }

    @Override
    public AbstractOperatorStrategy getOperator(final String operator) {
        return operators.get(operator);
    }

    @Override
    public boolean isOperatorAvailable(final String operator) {
        return operators.containsKey(operator);
    }

    @Override
    public AbstractFunctionStrategy getFunction(final String name) {
        return functions.get(name);
    }

    @Override
    public boolean isFunctionAvailable(final String name) {
        return functions.containsKey(name);
    }

}
