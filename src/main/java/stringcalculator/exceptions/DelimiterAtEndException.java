package stringcalculator.exceptions;

public class DelimiterAtEndException extends RuntimeException {
    public DelimiterAtEndException(String input) {
        super("Expression '" + input + "' at the end of the input.");
    }
}
