package pizzastore.factorymethod;

public class AbstractFactoryPizzaStore {
    
    public PizzaStore create(String type) {
        PizzaStore pizzaStore = null;
        if (type.equals("NY")) {
            pizzaStore = new NYPizzaStore();
        } else if (type.equals("Chicago")) {
            pizzaStore = new ChicagoPizzaStore();
        }
        return pizzaStore;
    }
}