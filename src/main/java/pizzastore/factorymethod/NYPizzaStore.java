package pizzastore.factorymethod;

import pizzastore.factorymethod.nypizza.NYStyleCheesePizza;
import pizzastore.factorymethod.nypizza.NYStyleClamPizza;
import pizzastore.factorymethod.nypizza.NYStylePepperoniPizza;
import pizzastore.factorymethod.nypizza.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}
}