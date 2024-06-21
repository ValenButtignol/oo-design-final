package ducksimulator.flybehavior;

import output.OutputManager;

public class MockFlyNoWay implements FlyBehavior {

    private OutputManager output;

    public MockFlyNoWay(OutputManager output) {
        this.output = output;
    }

    @Override
    public void fly() {
        output.print("I can't fly");
    }
}