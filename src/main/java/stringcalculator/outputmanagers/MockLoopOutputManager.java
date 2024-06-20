package stringcalculator.outputmanagers;

import java.util.ArrayList;
import java.util.List;

public class MockLoopOutputManager implements OutputManager {

    private List<String> outputs;

    public MockLoopOutputManager() {
        this.outputs = new ArrayList<>();
    }

    public String getResultMessage() {
        return outputs.remove(0);
    }

    @Override
    public void print(Integer result) {
        outputs.add(result.toString());
    }
}