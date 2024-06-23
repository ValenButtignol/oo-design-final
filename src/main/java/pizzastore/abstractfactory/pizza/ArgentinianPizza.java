package pizzastore.abstractfactory.pizza;

import pizzastore.abstractfactory.PizzaIngredientFactory;

public class ArgentinianPizza extends Pizza {

    private PizzaIngredientFactory ingredientFactory;

    public ArgentinianPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }
}