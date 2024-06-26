package ducksimulator.quackbehavior;

import output.OutputManager;

public class MockMuteQuack implements QuackBehavior {

    private OutputManager output;

    public MockMuteQuack(OutputManager output) {
        this.output = output;
    }

    @Override
    public void quack() {
        output.print("<< Silence >>");
    }
}