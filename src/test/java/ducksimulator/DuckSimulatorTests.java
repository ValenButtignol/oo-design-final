package ducksimulator;

import org.junit.jupiter.api.Test;

import ducksimulator.flybehavior.FlyRocketPowered;
import ducksimulator.flybehavior.MockFlyNoWay;
import ducksimulator.flybehavior.MockFlyRocketPowered;
import ducksimulator.quackbehavior.MockMuteQuack;
import ducksimulator.quackbehavior.MockSqueak;
import output.MockOutputManager;

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
    
        mallardDuck.setFlyBehavior(new MockFlyNoWay(output));
        mallardDuck.performFly();
        assert(output.getPrintInput().equals("I can't fly"));
        
        mallardDuck.setFlyBehavior(new MockFlyRocketPowered(output));
        mallardDuck.performFly();
        assert(output.getPrintInput().equals("I'm flying with a rocket"));
    }

    @Test
    public void testChangeOfQuackBehavior() {
        Duck mallardDuck = new PaperDuck();
        MockOutputManager output = new MockOutputManager();
    
        mallardDuck.setQuackBehavior(new MockMuteQuack(output));
        mallardDuck.performQuack();
        assert(output.getPrintInput().equals("<< Silence >>"));
        
        mallardDuck.setQuackBehavior(new MockSqueak(output));
        mallardDuck.performQuack();
        assert(output.getPrintInput().equals("Squeak"));
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