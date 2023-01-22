package pl.vpuk.calc.operators;

import java.math.BigDecimal;
import java.math.MathContext;

public class AddOperatorStrategy extends AbstractOperatorStrategy {


    public AddOperatorStrategy() {
        super("+", 1);
    }

    @Override
    public BigDecimal execute(String first, String second, final MathContext mathContext) {
        BigDecimal big1 = new BigDecimal(first, mathContext);
        BigDecimal big2 = new BigDecimal(second, mathContext);
        return big1.add(big2);
    }

}
