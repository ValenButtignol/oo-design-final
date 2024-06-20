package stringcalculator.parsers;

import java.util.HashSet;
import java.util.Set;

import stringcalculator.StringConstants;
import stringcalculator.exceptions.CharacterOutsideDelimiterException;
import stringcalculator.exceptions.InvalidDelimiterException;

public class DelimiterParser {

    private String unprocessedDelimiters;
    private Set<String> processedDelimiters;

    public DelimiterParser() {
        this.unprocessedDelimiters = "";
        this.processedDelimiters = new HashSet<>();
        processedDelimiters.add(StringConstants.COMMA);
        processedDelimiters.add(StringConstants.NEW_LINE);
    }

    public Set<String> getProcessedDelimiters() {
        return processedDelimiters;
    }

    public void setUnprocessedDelimiters(String unprocessedDelimiters) {
        this.unprocessedDelimiters = unprocessedDelimiters;
    }

    public boolean isValidDelimiter(String delimiter) {
        return processedDelimiters.contains(delimiter);
    }

    public void parseDelimiters() {
        resetProcessedDelimiters(); // reset to default delimiters in case of multiple calls.
        if (unprocessedDelimiters.isEmpty())
            return;

        for (int i = 0; i < unprocessedDelimiters.length(); i++) {
            i = processOpenDelimiter(i);
            i = processDelimiterCharacters(i);
            i = processCloseDelimiter(i);
        }
    }

    private void resetProcessedDelimiters() {
        processedDelimiters.clear();
        processedDelimiters.add(StringConstants.NEW_LINE);
        processedDelimiters.add(StringConstants.COMMA);
    }

    private int processOpenDelimiter(int i) {
        Character character = unprocessedDelimiters.charAt(i);
        if (character != StringConstants.OPEN_DELIMITER)
            throw new CharacterOutsideDelimiterException(character);
        
        return i + 1;
    }

    private int processDelimiterCharacters(int i) {
        StringBuilder delimiter = new StringBuilder();
        Character character;

        for (; i < unprocessedDelimiters.length(); i++) {
            character = unprocessedDelimiters.charAt(i);
            if (isCloseDelimiter(character)) {
                if (delimiter.isEmpty())
                    throw new InvalidDelimiterException(delimiter.toString());
                
                processedDelimiters.add(delimiter.toString());
                return i;
            }
            
            checkForDelimiterRestrictions(i);
            delimiter.append(character);
        }
        
        if (i == unprocessedDelimiters.length())
            throw new CharacterOutsideDelimiterException(unprocessedDelimiters.charAt(i - 1));

        return i;
    }
    
    private int processCloseDelimiter(int i) {
        Character character = unprocessedDelimiters.charAt(i);
        if (character != StringConstants.CLOSE_DELIMITER) {
            throw new CharacterOutsideDelimiterException(character);
        }
        return i;
    }

    private boolean isCloseDelimiter(Character character) {
        return character == StringConstants.CLOSE_DELIMITER;
    }
    
    private void checkForDelimiterRestrictions(int i) {
        Character character = unprocessedDelimiters.charAt(i);
        if (character == StringConstants.OPEN_DELIMITER
                || character == StringConstants.NEGATIVE
                || Character.isDigit(character)) {
            throw new InvalidDelimiterException(character + "");
        }
    }
}