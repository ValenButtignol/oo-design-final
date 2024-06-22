package pizzastore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pizzastore.abstractfactory.ArgentinianPizzaStore;
import pizzastore.abstractfactory.ChicagoPizzaStore;
import pizzastore.abstractfactory.NYPizzaStore;
import pizzastore.abstractfactory.PizzaStore;
import pizzastore.abstractfactory.pizza.Pizza;

public class TestAbstractFactoryMethod {
    
    @ParameterizedTest
    @MethodSource("abstractFactoryMethodPizzaProvider")
    public void testAbstractFactoryMethodCreation(PizzaStore store, String type, String pizzaName) {
        Pizza pizza = store.orderPizza(type);
        assertEquals(pizzaName, pizza.getName());
    }

    private static Stream<Arguments> abstractFactoryMethodPizzaProvider() {
        return Stream.of(
            Arguments.of(new NYPizzaStore(), "cheese", "New York Style Cheese Pizza"),
            Arguments.of(new ArgentinianPizzaStore(), "argentinian", "Argentinian Style Pizza"),
            Arguments.of(new ArgentinianPizzaStore(), "cheese", "Argentinian Style Cheese Pizza"),
            Arguments.of(new ChicagoPizzaStore(), "clam", "Chicago Style Clam Pizza"),
            Arguments.of(new ArgentinianPizzaStore(), "pepperoni", "Argentinian Style Pepperoni Pizza")
        );
    }
}
