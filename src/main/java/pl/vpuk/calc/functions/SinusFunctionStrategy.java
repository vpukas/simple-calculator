package pl.vpuk.calc.functions;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;

public class SinusFunctionStrategy extends AbstractFunctionStrategy {

    public SinusFunctionStrategy() {
        super("sin", 1);
    }

    @Override
    public BigDecimal execute(final MathContext mathContext, String... params) {
        return BigDecimalMath.sin(new BigDecimal(params[0]), mathContext);
    }

}
