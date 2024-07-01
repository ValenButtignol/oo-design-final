package pizzastore;

import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pizzastore.factorymethod.ArgentinianPizzaStore;
import pizzastore.factorymethod.ChicagoPizzaStore;
import pizzastore.factorymethod.NYPizzaStore;
import pizzastore.factorymethod.Pizza;
import pizzastore.factorymethod.PizzaStore;
import pizzastore.factorymethod.factoryv2.ArgentinianPizzaFactory;
import pizzastore.factorymethod.factoryv2.ChicagoPizzaFactory;
import pizzastore.factorymethod.factoryv2.NYPizzaFactory;
import pizzastore.factorymethod.factoryv2.PizzaFactory;
import pizzastore.factorymethod.factoryv2.PizzaStorev2;

public class TestFactoryMethod {
    
    @ParameterizedTest
    @MethodSource("factoryMethodPizzaProvider")
    public void testFactoryMethodPizzaCreation(String type, String expectedPizzaName, PizzaStore pizzaStore) {
        
        Pizza pizza = pizzaStore.orderPizza(type);
        assert(pizza.getName().equals(expectedPizzaName));
    }

    private static Stream<Object> factoryMethodPizzaProvider() {
        return Stream.of(
            Arguments.of("argentinian", "Argentinian Pizza", new ArgentinianPizzaStore()),
            Arguments.of("cheese", "NY Style Sauce and Cheese Pizza", new NYPizzaStore()),
            Arguments.of("pepperoni", "Chicago Style Pepperoni Pizza", new ChicagoPizzaStore()),
            Arguments.of("fugazzetta", "Argentinian Fugazzetta Pizza", new ArgentinianPizzaStore()),
            Arguments.of("cheese", "Argentinian Cheese Pizza", new ArgentinianPizzaStore())
        );
    }

    @ParameterizedTest
    @MethodSource("abstractPizzaProvider")
    public void testAbstractPizzaCreation(String type, String expectedPizzaName, PizzaFactory pizzaFactory) {
        
        PizzaStorev2 pizzaStore = new PizzaStorev2(pizzaFactory);
        Pizza pizza = pizzaStore.orderPizza(type);
        assert(pizza.getName().equals(expectedPizzaName));
    }

    private static Stream<Object> abstractPizzaProvider() {
        return Stream.of(
            Arguments.of("argentinian", "Argentinian Pizza", new ArgentinianPizzaFactory()),
            Arguments.of("cheese", "NY Style Sauce and Cheese Pizza", new NYPizzaFactory()),
            Arguments.of("pepperoni", "Chicago Style Pepperoni Pizza", new ChicagoPizzaFactory()),
            Arguments.of("fugazzetta", "Argentinian Fugazzetta Pizza", new ArgentinianPizzaFactory()),
            Arguments.of("cheese", "Argentinian Cheese Pizza", new ArgentinianPizzaFactory())
        );
    }
}