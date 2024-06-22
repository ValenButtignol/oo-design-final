package starbuzz;

public class Decaf extends Beverage {
	public Decaf(CoffeeSize size) {
		description = "Decaf Coffee";
		this.size = size;
	}
 
	public Double cost() {
		return 1.05;
	}
}