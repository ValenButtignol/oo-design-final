package pizzastore.factorymethod.factoryv2;

import pizzastore.factorymethod.Pizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStyleCheesePizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStyleClamPizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStylePepperoniPizza;
import pizzastore.factorymethod.chicagopizza.ChicagoStyleVeggiePizza;

public class ChicagoPizzaFactory implements PizzaFactory {

    @Override
    public Pizza create(String string) {
       if (string.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (string.equals("veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else if (string.equals("clam")) {
			return new ChicagoStyleClamPizza();
		} else if (string.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else return null;
    }    
}