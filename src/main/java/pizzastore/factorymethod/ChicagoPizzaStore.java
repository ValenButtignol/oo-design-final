package pizzastore.factorymethod;

import pizzastore.factorymethod.chicagopizza.ChicagoStyleCheesePizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStyleClamPizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStylePepperoniPizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("veggie")) {
        	    	return new ChicagoStyleVeggiePizza();
        	} else if (item.equals("clam")) {
        	    	return new ChicagoStyleClamPizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}