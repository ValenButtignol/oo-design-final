package pizzastore.factorymethod.factoryv2;

import java.util.ArrayList;
import java.util.List;

import pizzastore.factorymethod.Pizza;

public class PizzaStorev3 {
    
	private PizzaFactory pizzaFactory;

	public PizzaStorev3(PizzaFactory pizzaFactory) {
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

	public void setPizzaFactory(PizzaFactory pizzaFactory) { 
		this.pizzaFactory = pizzaFactory;
	}

	public List<Pizza> takeOrder(List<String> order) {
        List<Pizza> pizzas = new ArrayList<>();

        for (String pizzaName : order) {
            pizzas.add(orderPizza(pizzaName));
        }

        return pizzas;
    }
}