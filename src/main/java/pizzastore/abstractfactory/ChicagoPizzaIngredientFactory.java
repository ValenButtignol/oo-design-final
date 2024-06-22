package pizzastore.abstractfactory;

import pizzastore.abstractfactory.cheese.Cheese;
import pizzastore.abstractfactory.cheese.MozzarellaCheese;
import pizzastore.abstractfactory.clam.Clams;
import pizzastore.abstractfactory.clam.FrozenClams;
import pizzastore.abstractfactory.dough.Dough;
import pizzastore.abstractfactory.dough.ThickCrustDough;
import pizzastore.abstractfactory.pepperoni.Pepperoni;
import pizzastore.abstractfactory.pepperoni.SlicedPepperoni;
import pizzastore.abstractfactory.sauce.PlumTomatoSauce;
import pizzastore.abstractfactory.sauce.Sauce;
import pizzastore.abstractfactory.veggie.BlackOlives;
import pizzastore.abstractfactory.veggie.Eggplant;
import pizzastore.abstractfactory.veggie.Spinach;
import pizzastore.abstractfactory.veggie.Veggies;

public class ChicagoPizzaIngredientFactory 
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
