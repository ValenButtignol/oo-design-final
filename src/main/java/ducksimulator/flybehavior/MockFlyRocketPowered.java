package ducksimulator.flybehavior;

import output.OutputManager;

public class MockFlyRocketPowered implements FlyBehavior {
    
    private OutputManager output;

    public MockFlyRocketPowered(OutputManager output) {
        this.output = output;
    }

    @Override
    public void fly() {
        output.print("I'm flying with a rocket");
    }
}