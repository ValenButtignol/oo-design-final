package adapter.ducks;
import java.util.ArrayList;
import java.util.List;

public class DucksFlock {
    private List<Duck> flockOfDucks = new ArrayList<Duck>();

    public DucksFlock() { }

    public void addDuck(Duck duck) {
        flockOfDucks.add(duck);
    }

    public void fly() {
        for (Duck duck : flockOfDucks) {
            duck.fly();
        }
    }

    public void quack() {
        for (Duck duck : flockOfDucks) {
            duck.quack();
        }
    }

    public Duck getDuck(int index) {
        return flockOfDucks.get(index);
    }
}