package ducksimulator.flybehavior;

import output.Output;

public class MockFlyRocketPowered implements FlyBehavior {
    
    private Output output;

    public MockFlyRocketPowered(Output output) {
        this.output = output;
    }

    @Override
    public void fly() {
        output.print("I'm flying with a rocket");
    }
}
