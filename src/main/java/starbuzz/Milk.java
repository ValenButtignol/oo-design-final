package starbuzz;

public class Milk extends CondimentDecorator {
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public Double cost() {
		double cost = beverage.cost();
		if (beverage.getSize() == CoffeeSize.SMALL) {
			return .05 + cost;
		} else if (beverage.getSize() == CoffeeSize.MEDIUM) {
			return .10 + cost;
		} else {
			return .15 + cost;
		}
	}
}