package starbuzz;

import starbuzz.beverage.Beverage;

public class MainCoffeeMachine {
    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Beverage beverage = coffeeMachine.makeBeverage("espresso", CoffeeSize.LARGE);
        beverage = coffeeMachine.addCondiment(beverage, "cinnamon");
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = coffeeMachine.makeBeverage("houseblend", CoffeeSize.LARGE);
        beverage2 = coffeeMachine.addCondiment(beverage, "mocha");
        beverage2 = coffeeMachine.addCondiment(beverage, "mocha");
        beverage2 = coffeeMachine.addCondiment(beverage, "whip");
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

    }
}
