package starbuzz;

public class Cinnamon extends CondimentDecorator {

    public Cinnamon(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Cinnamon";
    }

    public Double cost() {
        return .15 + beverage.cost() ;
    }    
}