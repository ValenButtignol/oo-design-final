package pizzastore.simplefactory;

import pizzastore.simplefactory.concretepizza.ArgentinianPizza;
import pizzastore.simplefactory.concretepizza.CheesePizza;
import pizzastore.simplefactory.concretepizza.ClamPizza;
import pizzastore.simplefactory.concretepizza.PepperoniPizza;
import pizzastore.simplefactory.concretepizza.VeggiePizza;

public class SimplePizzaFactory {

	public Pizza createPizza(String type) {
		Pizza pizza = null;

		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new ClamPizza();
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza();
		} else if (type.equals("argentinian")) {
			pizza = new ArgentinianPizza();
		}
		return pizza;
	}
}