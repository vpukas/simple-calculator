package pl.vpuk.calc.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class AbstractOperatorStrategy {

    private final String operator;
    private final int priority;
    private volatile int hashCode = 0;


    public AbstractOperatorStrategy(final String operator, int priority) {
        this.operator = operator;
        this.priority = priority;
    }

    public abstract BigDecimal execute(final String first, final String second, final MathContext mathContext);


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final AbstractOperatorStrategy that = (AbstractOperatorStrategy) o;
        return operator.equals(that.operator);
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 31 * result + operator.hashCode();
            hashCode = result;
        }
        return hashCode;
    }


    public String getOperator() {
        return operator;
    }

    public int getPriority() {
        return priority;
    }

}
