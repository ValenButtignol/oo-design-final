package starbuzz;

import starbuzz.beverage.Beverage;
import starbuzz.beverage.DarkRoast;
import starbuzz.beverage.Decaf;
import starbuzz.beverage.Espresso;
import starbuzz.beverage.HouseBlend;
import starbuzz.beverage.RedCoffee;
import starbuzz.condiment.Cinnamon;
import starbuzz.condiment.Milk;
import starbuzz.condiment.Mocha;
import starbuzz.condiment.Soy;
import starbuzz.condiment.Whip;

public class CoffeeMachine {
    
    public Beverage makeBeverage(String beverageType, CoffeeSize size) {
        if (beverageType.equals("espresso")) {
            return new Espresso(size);
        } else if (beverageType.equals("houseblend")) {
            return new HouseBlend(size);
        } else if (beverageType.equals("darkroast")) {
            return new DarkRoast(size);
        } else if (beverageType.equals("decaf")) {
            return new Decaf(size);
        } else if (beverageType.equals("redcoffee")) {
            return new RedCoffee(size);
        } else 
            throw new IllegalArgumentException("Invalid beverage type");
    }

    public Beverage addCondiment(Beverage beverage, String condiment) {
        if (condiment.equals("milk")) {
            beverage = new Milk(beverage);
        } else if (condiment.equals("mocha")) {
            beverage = new Mocha(beverage);
        } else if (condiment.equals("soy")) {
            beverage = new Soy(beverage);
        } else if (condiment.equals("whip")) {
            beverage = new Whip(beverage);
        } else if (condiment.equals("cinnamon")) {
            beverage = new Cinnamon(beverage);
        } else 
            throw new IllegalArgumentException("Invalid condiment");
        
        return beverage;
    }
}