package pizzastore.factorymethod;

import java.util.ArrayList;
import java.util.List;

import pizzastore.factorymethod.factoryv2.ArgentinianPizzaFactory;
import pizzastore.factorymethod.factoryv2.NYPizzaFactory;
import pizzastore.factorymethod.factoryv2.PizzaStorev3;

public class MainFactoryv3 {
    public static void main(String[] args) {

        PizzaStorev3 pizzaStorev3 = new PizzaStorev3(new ArgentinianPizzaFactory());

        List<String> order = new ArrayList<>();
        order.add("cheese");
        order.add("pepperoni");

        System.out.println(pizzaStorev3.takeOrder(order));

        pizzaStorev3.setPizzaFactory(new NYPizzaFactory());
        System.out.println(pizzaStorev3.takeOrder(order));
    }
}