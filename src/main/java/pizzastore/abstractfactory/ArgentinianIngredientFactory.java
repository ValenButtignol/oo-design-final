package pizzastore.abstractfactory;

import pizzastore.abstractfactory.cheese.CheddarCheese;
import pizzastore.abstractfactory.cheese.Cheese;
import pizzastore.abstractfactory.clam.Clams;
import pizzastore.abstractfactory.dough.Dough;
import pizzastore.abstractfactory.dough.ThinCrustDough;
import pizzastore.abstractfactory.pepperoni.Bacon;
import pizzastore.abstractfactory.pepperoni.Pepperoni;
import pizzastore.abstractfactory.sauce.PlumTomatoSauce;
import pizzastore.abstractfactory.sauce.Sauce;
import pizzastore.abstractfactory.veggie.FrenchFries;
import pizzastore.abstractfactory.veggie.FriedEggs;
import pizzastore.abstractfactory.veggie.Onion;
import pizzastore.abstractfactory.veggie.Veggies;

public class ArgentinianIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new CheddarCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = { new FriedEggs(), new Onion(), new FrenchFries() };
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new Bacon();
    }

    @Override
    public Clams createClam() {
        return null;
    }

}