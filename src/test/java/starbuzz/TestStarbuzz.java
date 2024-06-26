package starbuzz;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import starbuzz.beverage.Beverage;

public class TestStarbuzz {
    
    @ParameterizedTest
    @MethodSource("coffeeAndCondimentsProvider")
    public void testDescriptionOfBeverages(String bevType, CoffeeSize size, List<String> condiments, Integer expectedCost, String expectedDescription) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Beverage bev = coffeeMachine.makeBeverage(bevType, size);
        for (String condiment : condiments) {
            bev = coffeeMachine.addCondiment(bev, condiment);
        }

        assert(bev.cost().equals(expectedCost));
        assert(bev.getDescription().equals(expectedDescription));
    }
    
    private static Stream<Object> coffeeAndCondimentsProvider() {
        return Stream.of(
            Arguments.of("houseblend", CoffeeSize.SMALL, List.of("milk", "whip"), 114, "House Blend Coffee, Milk, Whip"),
            Arguments.of("darkroast", CoffeeSize.LARGE, List.of("soy", "mocha"), 139, "Dark Roast Coffee, Soy, Mocha"),
            Arguments.of("espresso", CoffeeSize.MEDIUM, List.of("mocha", "soy", "whip"), 254, "Espresso, Mocha, Soy, Whip"),
            Arguments.of("decaf", CoffeeSize.LARGE, List.of("milk", "whip", "mocha"), 160, "Decaf Coffee, Milk, Whip, Mocha"),
            Arguments.of("houseblend", CoffeeSize.MEDIUM, List.of("mocha", "mocha", "soy", "whip"), 164, "House Blend Coffee, Mocha, Mocha, Soy, Whip"),
            Arguments.of("redcoffee", CoffeeSize.SMALL, List.of("cinnamon", "soy"), 53, "Red Coffee, Cinnamon, Soy")
        );
    }   
}