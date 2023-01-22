package pl.vpuk.calc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import pl.vpuk.calc.exceptions.NoSuchFunctionFound;
import pl.vpuk.calc.exceptions.WrongArgumentException;
import pl.vpuk.calc.rpn.*;
import pl.vpuk.calc.strategy.DefaultStrategyProvider;
import pl.vpuk.calc.strategy.StrategyProvider;

public class Calculator {

    protected final UnaryOperator<String> transformer;
    protected final UnaryOperator<String> rpnFactory;
    protected final Function<String, BigDecimal> rpnCalculator;
    private final MathContext mathContext;

    public static Calculator createCalculator() {
        final MathContext mathContext = MathContext.DECIMAL64;
        final StrategyProvider strategyProvider = new DefaultStrategyProvider();
        final RPNChecking rpnChecking = new RPNChecker(strategyProvider);
        final RPNExecuting rpnExecuting = new DefaultRPNExecutor(strategyProvider);
        return new Calculator(
                new InputTransformer(rpnChecking),
                new RPNFactory(rpnChecking),
                new RPNCalculator(2, rpnChecking, rpnExecuting, mathContext)
                , mathContext);
    }



    private Calculator(final UnaryOperator<String> transformer,
                       final UnaryOperator<String> rpnFactory,
                       final Function<String, BigDecimal> rpnCalculator,
                       final MathContext mathContext) {
        this.transformer = transformer;
        this.rpnFactory = rpnFactory;
        this.rpnCalculator = rpnCalculator;
        this.mathContext = mathContext;
    }

    public BigDecimal calculate(final String input) throws WrongArgumentException, NoSuchFunctionFound {
        return Optional.of(input)
                .map(transformer)
                .map(rpnFactory)
                .map(rpnCalculator)
                .orElseThrow(() -> new WrongArgumentException("Incorrect input"));
    }

    public MathContext getMathContext() {
        return new MathContext(mathContext.getPrecision(), mathContext.getRoundingMode());
    }
}
