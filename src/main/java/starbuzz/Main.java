package starbuzz;

import starbuzz.beverage.Beverage;
import starbuzz.beverage.DarkRoast;
import starbuzz.beverage.Espresso;
import starbuzz.beverage.HouseBlend;
import starbuzz.condiment.Mocha;
import starbuzz.condiment.Soy;
import starbuzz.condiment.Whip;

public class Main {
 
	public static void main(String args[]) {
		Beverage beverage = new Espresso(CoffeeSize.SMALL);
		System.out.println(beverage.getDescription() 
				+ " $" + beverage.cost());
 
		Beverage beverage2 = new DarkRoast(CoffeeSize.LARGE);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + beverage2.cost());
 
		Beverage beverage3 = new HouseBlend(CoffeeSize.MEDIUM);
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() 
				+ " $" + beverage3.cost());
	}
}