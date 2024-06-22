package pizzastore.factorymethod;

import pizzastore.factorymethod.argentinianpizza.ArgentinianCheesePizza;
import pizzastore.factorymethod.argentinianpizza.ArgentinianFugazzettaPizza;
import pizzastore.factorymethod.argentinianpizza.ArgentinianPizza;

public class ArgentinianPizzaStore extends PizzaStore {

    Pizza createPizza(String item) {
        if (item == "cheese") {
            return new ArgentinianCheesePizza();
        } else if (item == "fugazzetta") {
            return new ArgentinianFugazzettaPizza();
        } else if (item == "argentinian") {
            return new ArgentinianPizza();
        } else {
            return null;
        }
    }    
}