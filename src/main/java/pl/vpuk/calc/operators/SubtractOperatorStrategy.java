package pl.vpuk.calc.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public class SubtractOperatorStrategy extends AbstractOperatorStrategy {


    public SubtractOperatorStrategy() {
        super("-", 1);
    }

    @Override
    public BigDecimal execute(String first, String second, final MathContext mathContext) {
        BigDecimal big1 = new BigDecimal(first);
        BigDecimal big2 = new BigDecimal(second);
        return big1.subtract(big2);
    }


}
