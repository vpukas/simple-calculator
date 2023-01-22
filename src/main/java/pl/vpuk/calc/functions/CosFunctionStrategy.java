package pl.vpuk.calc.functions;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.MathContext;

public class CosFunctionStrategy extends AbstractFunctionStrategy {

    public CosFunctionStrategy() {
        super("cos", 1);
    }


    @Override
    public BigDecimal execute(final MathContext mathContext, final String... params) {
        return BigDecimalMath.cos(new BigDecimal(params[0]), mathContext);
    }

}
