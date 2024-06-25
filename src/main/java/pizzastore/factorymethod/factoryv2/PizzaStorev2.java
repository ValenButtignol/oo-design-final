package pizzastore.factorymethod.factoryv2;

import pizzastore.factorymethod.Pizza;

public class PizzaStorev2 {
    
	private PizzaFactory pizzaFactory;

	public PizzaStorev2(PizzaFactory pizzaFactory) {
		this.pizzaFactory = pizzaFactory;	
	}

    public Pizza orderPizza(String type) {
		Pizza pizza = pizzaFactory.create(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}