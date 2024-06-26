package starbuzz.beverage;

import starbuzz.CoffeeSize;

public abstract class Beverage {
	String description = "Unknown Beverage";
	CoffeeSize size;
  
	public String getDescription() {
		return description;
	}

	public CoffeeSize getSize() {
		return size;
	}

	public void setSize(CoffeeSize size) {
		this.size = size;
	}
 
	public abstract Integer cost();
}