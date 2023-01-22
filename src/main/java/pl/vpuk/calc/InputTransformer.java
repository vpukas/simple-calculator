package pl.vpuk.calc;


import pl.vpuk.calc.exceptions.WrongArgumentException;
import pl.vpuk.calc.rpn.RPNChecking;

import java.util.function.UnaryOperator;

public class InputTransformer implements UnaryOperator<String> {

    public static final String EMPTY_SPACE = " ";
    protected final RPNChecking checker;

    public InputTransformer(final RPNChecking checker) {
        this.checker = checker;
    }

    public String apply(String input) throws WrongArgumentException {
        final StringBuilder result = new StringBuilder();
        final String inputValue = input.trim();
        int length = inputValue.length();
        char character;
        boolean lastWasDigit = false;
        boolean lastWasOperator = false;
        boolean lastWasWhiteSpace = false;
        boolean lastWasLetter = false;
        for (int i = 0; i < length; i++) {
            character = inputValue.charAt(i);
            if (isDigitOrSeparator(character) && (lastWasDigit || !lastWasOperator)) {
                lastWasDigit = true;
                lastWasWhiteSpace = false;
                lastWasLetter = false;
                result.append(character);
            } else if (Character.isDigit(character)) {
                lastWasDigit = true;
                lastWasLetter = false;
                lastWasOperator = false;
                if (!lastWasWhiteSpace) {
                    result.append(EMPTY_SPACE);
                }
                result.append(character);
                lastWasWhiteSpace = false;
            } else if (checker.isOperatorOrBracket(String.valueOf(character))) {
                lastWasDigit = false;
                lastWasLetter = false;
                lastWasOperator = true;
                if (!lastWasWhiteSpace) {
                    result.append(EMPTY_SPACE);
                }
                result.append(character);
                lastWasWhiteSpace = false;
            } else if (Character.isWhitespace(character)) {
                if (!lastWasWhiteSpace && !lastWasDigit) {
                    result.append(EMPTY_SPACE);
                    lastWasWhiteSpace = true;
                }
                lastWasDigit = false;
                lastWasOperator = false;
            } else if (Character.isLetter(character)) {
                lastWasDigit = false;
                lastWasOperator = false;
                if (!lastWasLetter && !lastWasWhiteSpace) {
                    result.append(EMPTY_SPACE).append(character);
                } else {
                    result.append(character);
                }
                lastWasWhiteSpace = false;
                lastWasLetter = true;
            } else {
                throw new WrongArgumentException("Element \"" + character + "\" is not recognized by the Checker");
            }
        }

        return result.toString().trim();
    }

    private boolean isDigitOrSeparator(char c) {
        return Character.isDigit(c) || c == '.' || c == ',';
    }

}
