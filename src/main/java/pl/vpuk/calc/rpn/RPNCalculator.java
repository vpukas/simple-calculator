package pl.vpuk.calc.rpn;

import pl.vpuk.calc.exceptions.NoSuchFunctionFound;
import pl.vpuk.calc.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

public class RPNCalculator implements Function<String, BigDecimal> {
    public static final String ZERO = "0.0";
    public static final String EMPTY_SPACE = " ";
    public static final String COMMA = ",";
    private final int scale;

    protected final RPNChecking checker;
    protected final RPNExecuting executioner;
    protected final MathContext mathContext;

    public RPNCalculator(final int scale, final RPNChecking checker, final RPNExecuting executioner, final MathContext mathContext) {
        this.scale = scale;
        this.checker = checker;
        this.executioner = executioner;
        this.mathContext = mathContext;
    }


    public BigDecimal apply(String result) throws WrongArgumentException, NoSuchFunctionFound {
        final String[] factors = result.trim().split(EMPTY_SPACE);
        final Deque<String> stack = new LinkedList<>();
        String temp;
        String variable1;
        String variable2;
        BigDecimal value;
        for (final String factor : factors) {
            temp = factor;
            if (checker.isDigit(temp)) {
                stack.push(temp);
            } else if (checker.isOperator(temp)) {
                variable1 = stack.pop();
                if (!stack.isEmpty()) {
                    variable2 = stack.pop();
                } else {
                    variable2 = ZERO;
                }
                value = executioner.executeOperator(temp, mathContext, variable2, variable1);
                stack.push(value.toPlainString());
            } else if (checker.isFunction(temp)) {
                int count = checker.getFunctionParamsCount(temp);
                String[] table = new String[count];
                String params = stack.pop();
                String[] paramsTable = params.split(COMMA);
                if (count >= 0) System.arraycopy(paramsTable, 0, table, 0, count);
                value = executioner.executeFunction(temp, mathContext, table);
                stack.push(value.toPlainString());
            }
        }
        return new BigDecimal(stack.pop()).setScale(scale, mathContext.getRoundingMode());
    }
}
