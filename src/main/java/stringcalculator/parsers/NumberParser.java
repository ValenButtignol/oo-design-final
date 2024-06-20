package stringcalculator.parsers;

import java.util.ArrayList;
import java.util.List;

import stringcalculator.StringConstants;
import stringcalculator.exceptions.DelimiterAtBeginningException;
import stringcalculator.exceptions.DelimiterAtEndException;
import stringcalculator.exceptions.InvalidDelimiterException;

public class NumberParser {

    private String unprocessedNumbers;
    private List<Integer> processedNumbers = new ArrayList<>();
    private DelimiterParser delimiterParser;

    public NumberParser(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public List<Integer> getNumbers() {
        return processedNumbers;
    }

    public void setUnprocessedNumbers(String unprocessedNumbers) {
        this.unprocessedNumbers = unprocessedNumbers;
    }

    public void parseNumbers() {
        processedNumbers = new ArrayList<Integer>();

        if (unprocessedNumbers.isEmpty())
            return;

        int i = processNumber(0);
        for (; i < unprocessedNumbers.length();) {
            i = processDelimiter(i);
            i = processNumber(i);
        }
    }

    private int processNumber(int index) {
        StringBuilder numbersString = new StringBuilder();
        Character character = unprocessedNumbers.charAt(index);

        if (!Character.isDigit(character)) {
            if (character != StringConstants.NEGATIVE)
                throw new DelimiterAtBeginningException(character);

            numbersString.append(character);
            index++;
        }

        for (; index < unprocessedNumbers.length(); index++) {
            character = unprocessedNumbers.charAt(index);
            if (Character.isDigit(character) || character == StringConstants.NEGATIVE) {
                numbersString.append(character);
            } else {
                addProcessedNumber(numbersString);
                return index;
            }
        }

        addProcessedNumber(numbersString);
        return index;
    }

    private int processDelimiter(int i) {
        StringBuilder possibleDelimiter = new StringBuilder();
        Character character;

        for (; i < unprocessedNumbers.length(); i++) {
            character = unprocessedNumbers.charAt(i);
            if (Character.isDigit(character) || character == StringConstants.NEGATIVE)
                return checkForValidDelimiter(possibleDelimiter, i);

            possibleDelimiter.append(character);
        }

        throw new DelimiterAtEndException(possibleDelimiter.toString());
    }

    private void addProcessedNumber(StringBuilder numbersString) {
        processedNumbers.add(Integer.parseInt(numbersString.toString()));
    }

    private int checkForValidDelimiter(StringBuilder possibleDelimiter, int i) {
        if (delimiterParser.isValidDelimiter(possibleDelimiter.toString()))
            return i;
        else
            throw new InvalidDelimiterException(possibleDelimiter.toString());
    }
}