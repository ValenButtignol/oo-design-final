package stringcalculator.exceptions;

public class CharacterOutsideDelimiterException extends RuntimeException {
    public CharacterOutsideDelimiterException(Character character) {
        super("Character '" + character + "' outside of delimiters.");
    }
}
