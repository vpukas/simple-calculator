package pl.vpuk.calc.functions;


import java.math.BigDecimal;
import java.math.MathContext;

public abstract class AbstractFunctionStrategy {

    private final String name;
    private final int paramCount;
    private volatile int hashCode = 0;

    public AbstractFunctionStrategy(String name, int paramCount) {
        this.name = name;
        this.paramCount = paramCount;
    }

    public String getName() {
        return name;
    }

    public int getParamCount() {
        return paramCount;
    }

    public abstract BigDecimal execute(final MathContext mathContext, String... params);

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractFunctionStrategy rpn) {
            return (name != null && name.equals(rpn.name)) && paramCount == rpn.paramCount;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (hashCode == 0) {
            int result = 17;
            result = 31 * result + name.hashCode();
            result = 31 * result + paramCount;
            hashCode = result;
        }
        return hashCode;
    }
}
