package pizzastore.factorymethod.factoryv2;

import pizzastore.factorymethod.Pizza;
import pizzastore.factorymethod.nypizza.NYStyleCheesePizza;
import pizzastore.factorymethod.nypizza.NYStyleClamPizza;
import pizzastore.factorymethod.nypizza.NYStylePepperoniPizza;
import pizzastore.factorymethod.nypizza.NYStyleVeggiePizza;

public class NYPizzaFactory implements PizzaFactory {

    @Override
    public Pizza create(String string) {
       if (string.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (string.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (string.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (string.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
    }
    
}