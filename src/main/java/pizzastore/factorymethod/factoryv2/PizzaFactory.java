package pizzastore.factorymethod.factoryv2;

import pizzastore.factorymethod.Pizza;

public interface PizzaFactory {
    public Pizza create(String string);
}