package starbuzz;

public class DarkRoast extends Beverage {
	public DarkRoast(CoffeeSize size) {
		description = "Dark Roast Coffee";
		this.size = size;
	}
 
	public Integer cost() {
		return 99;
	}
}
