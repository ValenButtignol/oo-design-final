package ducksimulator;

import ducksimulator.flybehavior.FlyNoWay;
import ducksimulator.quackbehavior.MuteQuack;

public class PaperDuck extends Duck {  

    public PaperDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    void display() {
        System.out.println("I'm a paper duck");
    }
}