package ducksimulator.quackbehavior;

import output.OutputManager;

public class MockSqueak  implements QuackBehavior{
    private OutputManager output;

    public MockSqueak(OutputManager output) {
        this.output = output;
    }

    @Override
    public void quack() {
        output.print("Squeak");
    }
}