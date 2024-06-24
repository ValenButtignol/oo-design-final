package template.barista;

public class BlackCoffee extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println("Filtering the black coffee");
    }

    @Override
    public void addCondiments() {
        // do nothing
    }   

    @Override
    public boolean customerWantsCondiments() {
        return false;
    } 
}