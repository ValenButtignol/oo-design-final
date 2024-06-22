package pizzastore.factorymethod.argentinianpizza;

import pizzastore.factorymethod.Pizza;

public class ArgentinianPizza extends Pizza {
    public ArgentinianPizza() {
        name = "Argentinian Pizza";
        dough = "Crust";
        sauce = "Tomato sauce";
        toppings.add("French Fries");
        toppings.add("Mozzarella");
        toppings.add("Fried Egg");
        toppings.add("Ham");
    }
}