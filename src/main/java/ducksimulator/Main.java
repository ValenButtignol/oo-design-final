package ducksimulator;

import ducksimulator.flybehavior.FlyNoWay;

public class Main {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		Duck model = new ModelDuck();

		DucksFlock ducksFlock = new DucksFlock();
		ducksFlock.addDuck(mallard);
		ducksFlock.addDuck(model);
		System.out.println("Ducks Flock flying and quacking");
		ducksFlock.fly();
		ducksFlock.quack();

		Duck paperDuck = new PaperDuck();
		ducksFlock.addDuck(paperDuck);

		System.out.println("\n" +"The Ducks Flock has a new member!");
		ducksFlock.fly();
		ducksFlock.quack();

		mallard.setFlyBehavior(new FlyNoWay());
		System.out.println("\n" + "Our mallard duck was injured and can't fly no more!");
		ducksFlock.fly();
	}
}