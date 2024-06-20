package stringcalculator.outputmanagers;

public class TerminalOutputManager implements OutputManager {

    @Override
    public void print(Integer value) {
        System.out.println("The result is: " + value + "\n");
    }

}
