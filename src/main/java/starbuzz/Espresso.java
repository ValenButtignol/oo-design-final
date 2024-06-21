package starbuzz;

public class Espresso extends Beverage {
  
	public Espresso(CoffeeSize size) {
		description = "Espresso";
		this.size = size;
	}
  
	public Double cost() {
		return 1.99;
	}
}