package pizzastore.abstractfactory;

import pizzastore.abstractfactory.cheese.Cheese;
import pizzastore.abstractfactory.clam.Clams;
import pizzastore.abstractfactory.dough.Dough;
import pizzastore.abstractfactory.pepperoni.Pepperoni;
import pizzastore.abstractfactory.sauce.Sauce;
import pizzastore.abstractfactory.veggie.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
