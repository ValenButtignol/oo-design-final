package pizzastore.abstractfactory;

import pizzastore.abstractfactory.cheese.Cheese;
import pizzastore.abstractfactory.cheese.ReggianoCheese;
import pizzastore.abstractfactory.clam.Clams;
import pizzastore.abstractfactory.clam.FreshClams;
import pizzastore.abstractfactory.dough.Dough;
import pizzastore.abstractfactory.dough.ThinCrustDough;
import pizzastore.abstractfactory.pepperoni.Pepperoni;
import pizzastore.abstractfactory.pepperoni.SlicedPepperoni;
import pizzastore.abstractfactory.sauce.MarinaraSauce;
import pizzastore.abstractfactory.sauce.Sauce;
import pizzastore.abstractfactory.veggie.Garlic;
import pizzastore.abstractfactory.veggie.Mushroom;
import pizzastore.abstractfactory.veggie.Onion;
import pizzastore.abstractfactory.veggie.RedPepper;
import pizzastore.abstractfactory.veggie.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}