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
import pizzastore.factorymethod.argentinianpizza.ArgentinianCheesePizza;
import pizzastore.factorymethod.argentinianpizza.ArgentinianFugazzettaPizza;
import pizzastore.factorymethod.argentinianpizza.ArgentinianPizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStylePepperoniPizza;
import pizzastore.factorymethod.nypizza.NYStyleCheesePizza;

public class TestFactoryMethod {
    
    @ParameterizedTest
    @MethodSource("factoryMethodPizzaProvider")
    public void testFactoryMethodPizzaCreation(String type, Class <? extends Pizza> expectedPizzaClass, PizzaStore pizzaStore) {
        
        Pizza pizza = pizzaStore.orderPizza(type);
        assert(pizza.getClass().equals(expectedPizzaClass));
    }

    private static Stream<Object> factoryMethodPizzaProvider() {
        return Stream.of(
            Arguments.of("argentinian", ArgentinianPizza.class, new ArgentinianPizzaStore()),
            Arguments.of("cheese", NYStyleCheesePizza.class, new NYPizzaStore()),
            Arguments.of("pepperoni", ChicagoStylePepperoniPizza.class, new ChicagoPizzaStore()),
            Arguments.of("fugazzetta", ArgentinianFugazzettaPizza.class, new ArgentinianPizzaStore()),
            Arguments.of("cheese", ArgentinianCheesePizza.class, new ArgentinianPizzaStore())
        );
    }
}