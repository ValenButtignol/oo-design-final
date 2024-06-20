package ducksimulator.flybehavior;

import output.Output;

public class MockFlyNoWay implements FlyBehavior {

    private Output output;

    public MockFlyNoWay(Output output) {
        this.output = output;
    }

    @Override
    public void fly() {
        output.print("I can't fly");
    }
}
