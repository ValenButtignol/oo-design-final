package pizzastore.factorymethod.factoryv2;

import java.util.ArrayList;
import java.util.List;

import pizzastore.factorymethod.Pizza;

public class PizzaStoreClientv2 {

    public List<Pizza> takeOrder(List<String> order, PizzaStorev2 pizzaStore) {
        List<Pizza> pizzas = new ArrayList<>();
        
        for (String pizzaName : order) { 
            pizzas.add(pizzaStore.orderPizza(pizzaName));
        }

        return pizzas;
    }   
}