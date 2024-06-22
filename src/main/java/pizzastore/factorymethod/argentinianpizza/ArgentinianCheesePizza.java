package pizzastore.factorymethod.argentinianpizza;

import pizzastore.factorymethod.Pizza;

public class ArgentinianCheesePizza extends Pizza {
    public ArgentinianCheesePizza() {
        name = "Argentinian Cheese Pizza";
        dough = "Crust";
        sauce = "Tomato sauce";
        toppings.add("Green Olives");
        toppings.add("Mozzarella");
    }
}