package ducksimulator;

import org.junit.jupiter.api.Test;

import ducksimulator.flybehavior.FlyRocketPowered;

import static org.assertj.core.api.Assertions.assertThat;

public class DuckSimulatorTests {

    @Test
    public void testDuckSimulator() {
        Duck duck = new MallardDuck();
        duck.setFlyBehavior(new FlyRocketPowered());
    }

    @Test
    public void testDucksFlock() {
        DucksFlock ducksFlock = new DucksFlock();
        Duck mallardDuck = new MallardDuck();
        Duck modelDuck = new ModelDuck();
        //Duck paperDuck = new PaperDuck();
       
        ducksFlock.addDuck(mallardDuck);
        ducksFlock.addDuck(modelDuck);
        //ducksFlock.addDuck(paperDuck);

        assertThat(ducksFlock.getDuck(0)).isEqualTo(mallardDuck);
        assertThat(ducksFlock.getDuck(1)).isEqualTo(modelDuck);
        //assertThat(ducksFlock.getDuck(2)).isEqualTo(paperDuck);

    }
}