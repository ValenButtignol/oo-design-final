package adapter.ducks;

public class Main {
    public static void main(String[] args) {
        DucksFlock ducksFlock = new DucksFlock();
        ducksFlock.addDuck(new MallardDuck());
        ducksFlock.addDuck(new TurkeyAdapter(new WildTurkey()));
        ducksFlock.addDuck(new DroneAdapter(new SuperDrone()));

        ducksFlock.fly();
        ducksFlock.quack();
    }
}