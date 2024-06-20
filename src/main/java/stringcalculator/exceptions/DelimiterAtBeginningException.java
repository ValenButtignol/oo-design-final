package stringcalculator.exceptions;

public class DelimiterAtBeginningException extends RuntimeException {
    
    public DelimiterAtBeginningException(Character input) {
        super("Expression '" + input + "' at the beginning of the input.");
    }
}
