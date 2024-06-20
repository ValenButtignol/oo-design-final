package primenumbers.outputs;

import java.util.List;

public class MockOutput implements OutputManager {
    private String resultMessage;

    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public void print(List<Integer> output) {
        this.resultMessage = "Prime numbers: " + output;
    }
}
