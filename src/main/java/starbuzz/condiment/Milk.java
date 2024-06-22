package starbuzz.condiment;

import starbuzz.CoffeeSize;
import starbuzz.beverage.Beverage;

public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public Integer cost() {
		Integer cost = beverage.cost();
		if (beverage.getSize() == CoffeeSize.SMALL) {
			return 5 + cost;
		} else if (beverage.getSize() == CoffeeSize.MEDIUM) {
			return 10 + cost;
		} else {
			return 15 + cost;
		}
	}
}