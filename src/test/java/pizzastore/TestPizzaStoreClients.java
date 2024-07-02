package pizzastore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pizzastore.factorymethod.ArgentinianPizzaStore;
import pizzastore.factorymethod.ChicagoPizzaStore;
import pizzastore.factorymethod.NYPizzaStore;
import pizzastore.factorymethod.Pizza;
import pizzastore.factorymethod.PizzaStore;
import pizzastore.factorymethod.PizzaStoreClient;
import pizzastore.factorymethod.factoryv2.ArgentinianPizzaFactory;
import pizzastore.factorymethod.factoryv2.ChicagoPizzaFactory;
import pizzastore.factorymethod.factoryv2.NYPizzaFactory;
import pizzastore.factorymethod.factoryv2.PizzaFactory;
import pizzastore.factorymethod.factoryv2.PizzaStoreClientv2;
import pizzastore.factorymethod.factoryv2.PizzaStorev2;

public class TestPizzaStoreClients {
 
    @ParameterizedTest
    @MethodSource("factoryMethodStoreAndOrderProvider")
    public void testFactoryMethodClient(List<String> order, PizzaStore pizzaStore, List<String> pizzasNames) {
        PizzaStoreClient client = new PizzaStoreClient();
        List<Pizza> pizzas = client.takeOrder(order, pizzaStore);

        assertEquals(pizzasNames.size(), pizzas.size());

        for (int i = 0; i < pizzas.size(); i++) {
            assertEquals(pizzas.get(i).getName(), pizzasNames.get(i));
        }
    }

    private static Stream<Object> factoryMethodStoreAndOrderProvider() {
        return Stream.of(
            Arguments.of(
                List.of("cheese", "pepperoni"), new NYPizzaStore(),
                List.of("NY Style Sauce and Cheese Pizza", "NY Style Pepperoni Pizza")),
            Arguments.of(
                List.of("clam", "veggie", "pepperoni"), new ChicagoPizzaStore(),
                List.of("Chicago Style Clam Pizza", "Chicago Deep Dish Veggie Pizza", "Chicago Style Pepperoni Pizza")),
            Arguments.of(
                List.of("cheese", "fugazzetta", "argentinian"), new ArgentinianPizzaStore(),
                List.of("Argentinian Cheese Pizza",  "Argentinian Fugazzetta Pizza", "Argentinian Pizza"))
        );
    }

    @ParameterizedTest
    @MethodSource("abstarctFactoryStoreAndOrderProvider")
    public void testAbstractFactoryClient(List<String> order, PizzaFactory pizzaFactory, List<String> pizzasNames) {
        PizzaStoreClientv2 client = new PizzaStoreClientv2();
        PizzaStorev2 pizzaStorev2 = new PizzaStorev2(pizzaFactory);
        List<Pizza> pizzas = client.takeOrder(order, pizzaStorev2);

        assertEquals(pizzasNames.size(), pizzas.size());

        for (int i = 0; i < pizzas.size(); i++) {
            assertEquals(pizzas.get(i).getName(), pizzasNames.get(i));
        }
    }

    private static Stream<Object> abstarctFactoryStoreAndOrderProvider() {
        return Stream.of(
            Arguments.of(
                List.of("cheese", "pepperoni"), new NYPizzaFactory(),
                List.of("NY Style Sauce and Cheese Pizza", "NY Style Pepperoni Pizza")),
            Arguments.of(
                List.of("clam", "veggie", "pepperoni"), new ChicagoPizzaFactory(),
                List.of("Chicago Style Clam Pizza", "Chicago Deep Dish Veggie Pizza", "Chicago Style Pepperoni Pizza")),
            Arguments.of(
                List.of("cheese", "fugazzetta", "argentinian"), new ArgentinianPizzaFactory(),
                List.of("Argentinian Cheese Pizza",  "Argentinian Fugazzetta Pizza", "Argentinian Pizza"))
        );
    }
}