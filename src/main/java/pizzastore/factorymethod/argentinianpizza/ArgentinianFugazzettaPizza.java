package pizzastore.factorymethod.argentinianpizza;

import pizzastore.factorymethod.Pizza;

public class ArgentinianFugazzettaPizza extends Pizza {
    public ArgentinianFugazzettaPizza() {
        name = "Argentinian Fugazzetta Pizza";
        dough = "Crust";
        sauce = "Tomato sauce";
        toppings.add("Onions");
        toppings.add("Mozzarella");
    }
}