package starbuzz.beverage;

import starbuzz.CoffeeSize;

public class Espresso extends Beverage {
  
	public Espresso(CoffeeSize size) {
		description = "Espresso";
		this.size = size;
	}
  
	public Integer cost() {
		return 199;
	}
}