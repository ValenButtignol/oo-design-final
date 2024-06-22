package starbuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import starbuzz.beverage.Beverage;

public class TestCoffeeMachine {
    
    @ParameterizedTest
    @MethodSource("coffeeCreationProvider")
    public void testCoffeeCreation(String beverage, CoffeeSize size, List<String> condiments, Integer expectedCost) { 
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Beverage coffee = coffeeMachine.makeBeverage(beverage, size);
        for (String condiment : condiments) {
            coffee = coffeeMachine.addCondiment(coffee, condiment);
        }
        assertEquals(expectedCost, coffee.cost());
    } 

    private static Stream<Object> coffeeCreationProvider() {
        return Stream.of(  
            Arguments.of("houseblend", CoffeeSize.SMALL, List.of("milk", "whip"), 114),
            Arguments.of("darkroast", CoffeeSize.LARGE, List.of("soy", "mocha"), 139),
            Arguments.of("espresso", CoffeeSize.MEDIUM, List.of("mocha", "soy", "whip"), 254),
            Arguments.of("decaf", CoffeeSize.LARGE, List.of("milk", "whip", "mocha"), 160),
            Arguments.of("houseblend", CoffeeSize.MEDIUM, List.of("mocha", "mocha", "soy", "whip"), 164),
            Arguments.of("redcoffee", CoffeeSize.SMALL, List.of("cinnamon", "soy"), 53)
        );
    }


}
