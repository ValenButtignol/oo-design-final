package starbuzz;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import starbuzz.beverage.Beverage;
import starbuzz.beverage.DarkRoast;
import starbuzz.beverage.Decaf;
import starbuzz.beverage.Espresso;
import starbuzz.beverage.HouseBlend;
import starbuzz.beverage.RedCoffee;
import starbuzz.condiment.Cinnamon;
import starbuzz.condiment.CondimentDecorator;
import starbuzz.condiment.Milk;
import starbuzz.condiment.Mocha;
import starbuzz.condiment.Soy;
import starbuzz.condiment.Whip;

public class TestStarbuzz {
    
    @ParameterizedTest
    @MethodSource("coffeeAndCondimentsProvider")
    public void testDescriptionOfBeverages(Beverage bev, List<Class <? extends CondimentDecorator>> condiments, Integer expectedCost, String expectedDescription) {
        for (Class <? extends CondimentDecorator> condiment : condiments) {
            bev = createBeverage(condiment, bev);
        }

        assert(bev.cost().equals(expectedCost));
        assert(bev.getDescription().equals(expectedDescription));
    }
    
    private static Stream<Object> coffeeAndCondimentsProvider() {
        return Stream.of(
                Arguments.of(new HouseBlend(CoffeeSize.SMALL), List.of(Milk.class, Whip.class), 114, "House Blend Coffee, Milk, Whip"),
                Arguments.of(new DarkRoast(CoffeeSize.LARGE), List.of(Soy.class, Mocha.class), 139, "Dark Roast Coffee, Soy, Mocha"),
                Arguments.of(new Espresso(CoffeeSize.MEDIUM), List.of(Mocha.class, Soy.class, Whip.class), 254, "Espresso, Mocha, Soy, Whip"),
                Arguments.of(new Decaf(CoffeeSize.LARGE), List.of(Milk.class, Whip.class, Mocha.class), 160, "Decaf Coffee, Milk, Whip, Mocha"),
                Arguments.of(new HouseBlend(CoffeeSize.MEDIUM), List.of(Mocha.class, Mocha.class, Soy.class, Whip.class), 164, "House Blend Coffee, Mocha, Mocha, Soy, Whip"),
                Arguments.of(new RedCoffee(CoffeeSize.SMALL), List.of(Cinnamon.class, Soy.class), 53, "Red Coffee, Cinnamon, Soy")
            );
        }

    private static Beverage createBeverage(Class <? extends CondimentDecorator> condiment, Beverage beverage) {
        if (condiment == Milk.class) {
            return new Milk(beverage);
        } else if (condiment == Mocha.class) {
            return new Mocha(beverage);
        } else if (condiment == Soy.class) {
            return new Soy(beverage);
        } else if (condiment == Whip.class) {
            return new Whip(beverage);
        } else {
            return new Cinnamon(beverage);
        }
    }
}