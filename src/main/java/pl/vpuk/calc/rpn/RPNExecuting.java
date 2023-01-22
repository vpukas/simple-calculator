package pl.vpuk.calc.rpn;

import pl.vpuk.calc.exceptions.NoSuchFunctionFound;
import pl.vpuk.calc.exceptions.WrongArgumentException;

import java.math.BigDecimal;
import java.math.MathContext;

public interface RPNExecuting {

    BigDecimal executeOperator(String operator, MathContext mathContext, String var1, String var2) throws WrongArgumentException;

    BigDecimal executeFunction(String functionName, MathContext mathContext, String... arguments) throws NoSuchFunctionFound;
}
