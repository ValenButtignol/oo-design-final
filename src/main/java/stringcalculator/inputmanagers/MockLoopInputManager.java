package stringcalculator.inputmanagers;

import java.util.ArrayList;
import java.util.List;

public class MockLoopInputManager implements InputManager {
    
    private List<String> inputs;

    public MockLoopInputManager() {
        this.inputs = new ArrayList<>();
    }

    public void addInput(String input) {
        inputs.add(input);
    }

    @Override
    public String read() {
        return inputs.remove(0);
    }
}
