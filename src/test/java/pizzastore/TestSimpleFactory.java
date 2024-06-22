package pizzastore;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    @MethodSource("simpleFactoryPizzaProvider")
    public void testSimpleFactoryPizzaCreation(String type, Class <? extends Pizza> expectedPizzaClass) {
        
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza(type);
        assert(pizza.getClass().equals(expectedPizzaClass));
    }

    private static Stream<Object> simpleFactoryPizzaProvider() {
        return Stream.of(
            Arguments.of("argentinian", ArgentinianPizza.class),
            Arguments.of("cheese", CheesePizza.class),
            Arguments.of("pepperoni", PepperoniPizza.class),
            Arguments.of("clam", ClamPizza.class),
            Arguments.of("veggie", VeggiePizza.class)
        );
    }
}