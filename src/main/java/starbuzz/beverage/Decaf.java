package starbuzz.beverage;

import starbuzz.CoffeeSize;

public class Decaf extends Beverage {
	public Decaf(CoffeeSize size) {
		description = "Decaf Coffee";
		this.size = size;
	}
 
	public Integer cost() {
		return 105;
	}
}