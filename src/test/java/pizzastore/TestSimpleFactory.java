package pizzastore;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pizzastore.simplefactory.Pizza;
import pizzastore.simplefactory.PizzaStore;
import pizzastore.simplefactory.SimplePizzaFactory;

public class TestSimpleFactory {
    
    @ParameterizedTest
    @MethodSource("simpleFactoryPizzaProvider")
    public void testSimpleFactoryPizzaCreation(String type, String expectedPizzaName) {
        
        PizzaStore pizzaStore = new PizzaStore(new SimplePizzaFactory());
        Pizza pizza = pizzaStore.orderPizza(type);
        assert(pizza.getName().equals(expectedPizzaName));
    }

    private static Stream<Object> simpleFactoryPizzaProvider() {
        return Stream.of(
            Arguments.of("argentinian", "Argentinian Pizza"),
            Arguments.of("cheese", "Cheese Pizza"),
            Arguments.of("pepperoni", "Pepperoni Pizza"),
            Arguments.of("clam", "Clam Pizza"),
            Arguments.of("veggie", "Veggie Pizza")
        );
    }
}