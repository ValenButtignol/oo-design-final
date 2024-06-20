package ducksimulator;

import org.junit.jupiter.api.Test;

import ducksimulator.flybehavior.FlyBehavior;
import ducksimulator.flybehavior.FlyRocketPowered;
import ducksimulator.flybehavior.MockFlyNoWay;
import ducksimulator.flybehavior.MockFlyRocketPowered;
import ducksimulator.quackbehavior.Quack;
import ducksimulator.quackbehavior.Squeak;
import output.MockOutputManager;
import output.OutputManager;

import static org.assertj.core.api.Assertions.assertThat;

public class DuckSimulatorTests {

    @Test
    public void testDuckSimulator() {
        Duck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyRocketPowered());
    }

    @Test
    public void testChangeOfFlyBehavior() {
        Duck mallardDuck = new MallardDuck();
        MockOutputManager output = new MockOutputManager();
        FlyBehavior flyBehavior = new MockFlyNoWay(output);
        
        mallardDuck.setFlyBehavior(flyBehavior);
        mallardDuck.performFly();
        assert(output.getPrintInput().equals("I can't fly"));
        
        mallardDuck.setFlyBehavior(new MockFlyRocketPowered(output));
        mallardDuck.performFly();
        assert(output.getPrintInput().equals("I'm flying with a rocket"));
    }

    @Test
    public void testChangeOfQuackBehavior() {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.setQuackBehavior(new Quack());
        
        assert(mallardDuck.getQuackBehavior() instanceof Quack);

        mallardDuck.setQuackBehavior(new Squeak());
        assert(mallardDuck.getQuackBehavior() instanceof Squeak);
    }

    @Test
    public void testDucksFlock() {
        DucksFlock ducksFlock = new DucksFlock();
        Duck mallardDuck = new MallardDuck();
        Duck modelDuck = new ModelDuck();
        Duck paperDuck = new PaperDuck();
       
        ducksFlock.addDuck(mallardDuck);
        ducksFlock.addDuck(modelDuck);
        ducksFlock.addDuck(paperDuck);

        assertThat(ducksFlock.getDuck(0)).isEqualTo(mallardDuck);
        assertThat(ducksFlock.getDuck(1)).isEqualTo(modelDuck);
        assertThat(ducksFlock.getDuck(2)).isEqualTo(paperDuck);

    }
}