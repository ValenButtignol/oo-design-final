package pizzastore;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.BattleArena;
import adventuregame.character.Gladiator;
import adventuregame.character.Wizard;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.Staff;

import java.util.stream.Stream;

import pizzastore.simplefactory.Pizza;
import pizzastore.simplefactory.PizzaStore;
import pizzastore.simplefactory.SimplePizzaFactory;
import pizzastore.simplefactory.concretepizza.ArgentinianPizza;
import pizzastore.simplefactory.concretepizza.CheesePizza;
import pizzastore.simplefactory.concretepizza.ClamPizza;
import pizzastore.simplefactory.concretepizza.PepperoniPizza;
import pizzastore.simplefactory.concretepizza.VeggiePizza;

public class TestSimpleFactory {
    
    @ParameterizedTest
    @MethodSource("pizzaProvider")
    public void testSimpleFactoryPizzaCreation(String type, Class <? extends Pizza> expectedPizzaClass) {
        
        PizzaStore pizzastore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzastore.orderPizza(type);
        assert(pizza.getClass().equals(expectedPizzaClass));
    }

    private static Stream<Object> pizzaProvider() {
        return Stream.of(
            Arguments.of("argentinian", ArgentinianPizza.class),
            Arguments.of("cheese", CheesePizza.class),
            Arguments.of("pepperoni", PepperoniPizza.class),
            Arguments.of("clam", ClamPizza.class),
            Arguments.of("veggie", VeggiePizza.class)
        );
    }
}