package starbuzz;

import starbuzz.beverage.Beverage;

public class CoffeeMachineFacade {

    private CoffeeMachine coffeeMachine;

    public CoffeeMachineFacade() {
        coffeeMachine = new CoffeeMachine();
    }

    public Beverage makeHouseBlendWithMilkAndWhip(CoffeeSize size) {
        System.out.println("Making a House Blend with Milk and Whip...");
        Beverage beverage = coffeeMachine.makeBeverage("houseblend", size);
        beverage = coffeeMachine.addCondiment(beverage, "milk");
        beverage = coffeeMachine.addCondiment(beverage, "whip");
        System.out.println(
                "Here is your " + beverage.getDescription() + " and your total would be $" + beverage.cost() + " :) \n");

        return beverage;
    }

    public Beverage makeDarkRoastWithSoyAndMocha(CoffeeSize size) {
        System.out.println("Making a Dark Roast with Soy and Mocha...");
        Beverage beverage = coffeeMachine.makeBeverage("darkroast", size);
        beverage = coffeeMachine.addCondiment(beverage, "soy");
        beverage = coffeeMachine.addCondiment(beverage, "mocha");
        System.out.println(
                "Here is your " + beverage.getDescription() + " and your total would be $" + beverage.cost() + " :) \n");
        return beverage;
    }

    public Beverage makeEspressoWithMochaSoyAndWhip(CoffeeSize size) {
        System.out.println("Making an Espresso with Mocha, Soy, and Whip...");
        Beverage beverage = coffeeMachine.makeBeverage("espresso", size);
        beverage = coffeeMachine.addCondiment(beverage, "mocha");
        beverage = coffeeMachine.addCondiment(beverage, "soy");
        beverage = coffeeMachine.addCondiment(beverage, "whip");
        System.out.println(
                "Here is your " + beverage.getDescription() + " and your total would be $" + beverage.cost() + " :) \n");
        return beverage;
    }
}