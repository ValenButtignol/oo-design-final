package ducksimulator;

import java.util.ArrayList;
import java.util.List;

public class DucksFlock {
    
    private List<Duck> flockOfDucks = new ArrayList<Duck>();

    public DucksFlock() { }

    public void addDuck(Duck duck) {
        flockOfDucks.add(duck);
    }

    public void removeDuck(Duck duck) {
        flockOfDucks.remove(duck);
    }

    public void fly() {
        for (Duck duck : flockOfDucks) {
            duck.performFly();
        }
    }

    public void quack() {
        for (Duck duck : flockOfDucks) {
            duck.performQuack();
        }
    }

    public Duck getDuck(int index) {
        return flockOfDucks.get(index);
    }

    public List<Duck> getDucksFlock() {
        return flockOfDucks;
    }
}