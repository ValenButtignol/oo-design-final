package stringcalculator.inputmanagers;

public class MockInputManager implements InputManager {

    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String read() {
        return input;
    }
    
}
