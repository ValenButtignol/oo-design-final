package starbuzz.condiment;

import starbuzz.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	public abstract String getDescription();
}