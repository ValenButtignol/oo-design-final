package pizzastore.factorymethod;

import pizzastore.factorymethod.chicagopizza.ChicagoStyleCheesePizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStyleClamPizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStylePepperoniPizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStyleVeggiePizza;
import pizzastore.factorymethod.nypizza.NYStyleCheesePizza;
import pizzastore.factorymethod.nypizza.NYStyleClamPizza;
import pizzastore.factorymethod.nypizza.NYStylePepperoniPizza;
import pizzastore.factorymethod.nypizza.NYStyleVeggiePizza;

public class DependentPizzaStore {
 
	public Pizza createPizza(String style, String type) {
		Pizza pizza = null;
		if (style.equals("NY")) {
			if (type.equals("cheese")) {
				pizza = new NYStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new NYStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new NYStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new NYStylePepperoniPizza();
			}
		} else if (style.equals("Chicago")) {
			if (type.equals("cheese")) {
				pizza = new ChicagoStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new ChicagoStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new ChicagoStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new ChicagoStylePepperoniPizza();
			}
		} else {
			System.out.println("Error: invalid type of pizza");
			return null;
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}