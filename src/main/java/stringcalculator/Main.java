package stringcalculator;

import stringcalculator.inputmanagers.TerminalInputManager;
import stringcalculator.outputmanagers.TerminalOutputManager;

public class Main {
    
    public static void main(String[] args) {
        StringCalculatorSystem calculatorSystem = new StringCalculatorSystem(new TerminalInputManager(), new TerminalOutputManager());
        calculatorSystem.addLoop();
    }    
}
