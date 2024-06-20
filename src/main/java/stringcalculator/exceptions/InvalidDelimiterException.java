package stringcalculator.exceptions;

public class InvalidDelimiterException extends RuntimeException {
    public InvalidDelimiterException(String input) {
        super("Expression '" + input + "' is not a valid delimiter.");
    }
}
