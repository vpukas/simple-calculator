package pl.vpuk.calc;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.createCalculator();

        BigDecimal result = calc.calculate("3*(12/6)+18/3+5.0/2");
        BigDecimal result2 = calc.calculate("14.5");
        BigDecimal resultSin = calc.calculate("sin(2)");
        BigDecimal resultSin2 = calc.calculate("sin(1+1)");
        BigDecimal resultCos = calc.calculate("cos(1+1)");
        BigDecimal resultCos2 = calc.calculate("cos(2)");
        System.out.println(result);
        System.out.println(result2);
        System.out.println(resultSin2);
        System.out.println(resultSin);
        System.out.println(resultCos2);
        System.out.println(resultCos);
    }
}