package starbuzz;

public class RedCoffee extends Beverage {

    public RedCoffee(CoffeeSize size) {
        description = "Red Coffee";
        this.size = size;
    }

    public Double cost() {
        return 1.8;
    } 
}