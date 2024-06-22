package starbuzz;

public class Mocha extends CondimentDecorator {
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public Integer cost() {
		Integer cost = beverage.cost();
		if (beverage.getSize() == CoffeeSize.SMALL) {
			return 10 + cost;
		} else if (beverage.getSize() == CoffeeSize.MEDIUM) {
			return 15 + cost;
		} else {
			return 20 + cost;
		}
	}
}