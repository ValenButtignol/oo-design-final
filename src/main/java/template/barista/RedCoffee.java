package template.barista;

public class RedCoffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding red food colouring");
        System.out.println("Adding whipped cream");
    }    
}