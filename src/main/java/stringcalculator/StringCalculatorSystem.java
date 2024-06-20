package stringcalculator;

import stringcalculator.inputmanagers.InputManager;
import stringcalculator.inputmanagers.MockInputManager;
import stringcalculator.outputmanagers.MockOutputManager;
import stringcalculator.outputmanagers.OutputManager;
import stringcalculator.parsers.DelimiterParser;
import stringcalculator.parsers.NumberParser;

public class StringCalculatorSystem {

    private Calculator calculator;
    private NumberParser numberParser;
    private DelimiterParser delimiterParser;
    private InputManager inputManager;
    private OutputManager outputManager;

    public StringCalculatorSystem() {
        this.calculator = new Calculator();
        this.delimiterParser = new DelimiterParser();
        this.numberParser = new NumberParser(delimiterParser);
        this.inputManager = new MockInputManager();
        this.outputManager = new MockOutputManager();
    }

    public StringCalculatorSystem(InputManager inputManager, OutputManager outputManager) {
        this.calculator = new Calculator();
        this.delimiterParser = new DelimiterParser();
        this.numberParser = new NumberParser(delimiterParser);
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    public Integer add() {
        String input = inputManager.read();
        separateDelimitersAndString(input, delimiterParser, numberParser); 
        delimiterParser.parseDelimiters();
        numberParser.parseNumbers();
        Integer result = calculator.add(numberParser.getNumbers());
        outputManager.print(result);
        return result;
    }
  
    public void addLoop() {
        String input = "";
        do {
            input = inputManager.read();
            separateDelimitersAndString(input, delimiterParser, numberParser);
            delimiterParser.parseDelimiters();
            numberParser.parseNumbers();
            Integer result = calculator.add(numberParser.getNumbers());
            outputManager.print(result);
        } while (!input.isEmpty());
    }

    private void separateDelimitersAndString(String input, DelimiterParser delimiterParser, NumberParser numberParser) {
        if (!input.startsWith(StringConstants.DELIMITATION_START)) {
            numberParser.setUnprocessedNumbers(input);
        } else {
            String unprocessedDelimiters = input.substring(StringConstants.DELIMITATION_START.length(),
                    input.indexOf(StringConstants.DELIMITATION_END));
            
            String unprocessedNumbers = input.substring(input.indexOf(StringConstants.DELIMITATION_END) + 1);
            delimiterParser.setUnprocessedDelimiters(unprocessedDelimiters);
            numberParser.setUnprocessedNumbers(unprocessedNumbers);
        }
    }
}