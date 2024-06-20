package stringcalculator.inputmanagers;

import java.util.Scanner;

public class TerminalInputManager implements InputManager {


    @Override
    public String read() {
        
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter an input: ");
        return scanner.nextLine();
    }
    
}
