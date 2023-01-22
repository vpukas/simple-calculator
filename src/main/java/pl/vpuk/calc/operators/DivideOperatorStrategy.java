package pl.vpuk.calc.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public class DivideOperatorStrategy extends AbstractOperatorStrategy {

    public DivideOperatorStrategy() {
        super("/", 2);
    }

    @Override
    public BigDecimal execute(String first, String second, final MathContext mathContext) {
        BigDecimal big1 = new BigDecimal(first, mathContext);
        BigDecimal big2 = new BigDecimal(second, mathContext);
        return big1.divide(big2, 4,  mathContext.getRoundingMode());
    }
}
