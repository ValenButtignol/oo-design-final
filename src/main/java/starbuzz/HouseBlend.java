package starbuzz;

public class HouseBlend extends Beverage {
	public HouseBlend(CoffeeSize size) {
		description = "House Blend Coffee";
		this.size = size;
	}
 
	public Double cost() {
		return .89;
	}
}