package pl.vpuk.calc.strategy;

import pl.vpuk.calc.functions.AbstractFunctionStrategy;
import pl.vpuk.calc.operators.AbstractOperatorStrategy;

public interface StrategyProvider {

    AbstractOperatorStrategy getOperator(String operator);

    boolean isOperatorAvailable(String operator);

    AbstractFunctionStrategy getFunction(String name);

    boolean isFunctionAvailable(String name);

}
