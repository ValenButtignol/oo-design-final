package pizzastore.factorymethod.factoryv2;

import pizzastore.factorymethod.Pizza;
import pizzastore.factorymethod.argentinianpizza.ArgentinianCheesePizza;
import pizzastore.factorymethod.argentinianpizza.ArgentinianFugazzettaPizza;
import pizzastore.factorymethod.argentinianpizza.ArgentinianPizza;

public class ArgentinianPizzaFactory implements PizzaFactory {

    @Override
    public Pizza create(String string) {
        if (string.equals("cheese")) {
            return new ArgentinianCheesePizza();
        } else if (string.equals("fugazzetta")) {
            return new ArgentinianFugazzettaPizza();
        } else if (string.equals("argentinian")) {
            return new ArgentinianPizza();
        } else {
            return null;
        }
    }
}