package pizzastore.abstractfactory;

import pizzastore.abstractfactory.pizza.ArgentinianPizza;
import pizzastore.abstractfactory.pizza.CheesePizza;
import pizzastore.abstractfactory.pizza.PepperoniPizza;
import pizzastore.abstractfactory.pizza.Pizza;

public class ArgentinianPizzaStore extends PizzaStore {
    
    protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory =
		new ArgentinianIngredientFactory();

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Argentinian Style Cheese Pizza");

		} else if (item.equals("argentinian")) {

			pizza = new ArgentinianPizza(ingredientFactory);
			pizza.setName("Argentinian Style Pizza");

		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Argentinian Style Pepperoni Pizza");

		}
		return pizza;
	}
}
