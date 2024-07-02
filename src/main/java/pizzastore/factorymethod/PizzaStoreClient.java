package pizzastore.factorymethod;

import java.util.ArrayList;
import java.util.List;

public class PizzaStoreClient {

    public List<Pizza> takeOrder(List<String> order, PizzaStore pizzaStore) {
        List<Pizza> pizzas = new ArrayList<>();
        
        for (String pizzaName : order) { 
            pizzas.add(pizzaStore.orderPizza(pizzaName));
        }

        return pizzas;
    }
}