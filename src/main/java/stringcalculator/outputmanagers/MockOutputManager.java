package stringcalculator.outputmanagers;

public class MockOutputManager implements OutputManager {

    private String resultMessage;

    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public void print(Integer value) {
        this.resultMessage = "The result is: " + value;
    }
}