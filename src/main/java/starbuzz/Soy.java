package starbuzz;

public class Soy extends CondimentDecorator {
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public Double cost() {
		double cost = beverage.cost();
		if (beverage.getSize() == CoffeeSize.SMALL) {
			return .10 + cost;
		} else if (beverage.getSize() == CoffeeSize.MEDIUM) {
			return .15 + cost;
		} else {
			return .20 + cost;
		}
	}
}