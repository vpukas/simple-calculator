package pl.vpuk.calc.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public class MultiplyOperatorStrategy extends AbstractOperatorStrategy {


    public MultiplyOperatorStrategy() {
        super("*", 2);
    }

    @Override
    public BigDecimal execute(String first, String second, final MathContext mathContext) {
        BigDecimal firstDecimal = new BigDecimal(first);
        BigDecimal secondDecimal = new BigDecimal(second);
        return firstDecimal.multiply(secondDecimal);
    }


}
