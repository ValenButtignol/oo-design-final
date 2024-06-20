package primenumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import primenumber.primenumbergenerators.PrimeNumberGenerator;
import primenumber.primenumbergenerators.PrimeNumberGeneratorRecursive;
import primenumber.primenumbergenerators.PrimeNumberGeneratorWithDivisors;


public class PrimeNumberGeneratorTests {
    
    @ParameterizedTest
    @MethodSource("PrimeNumberGeneratorProvider")
    public void testPrimeNumberGenerators(PrimeNumberGenerator primeNumberGenerator, int number, List<Integer> expectedResult) {
        assertEquals(primeNumberGenerator.getPrimeNumbers(number), expectedResult);        
    }

    public static Collection<Object[]> PrimeNumberGeneratorProvider() {
        return Arrays.asList(new Object[][] {
            { new PrimeNumberGeneratorRecursive(), 10, List.of(2, 3, 5, 7) },
            { new PrimeNumberGeneratorRecursive(), 15, List.of(2, 3, 5, 7, 11, 13) },
            { new PrimeNumberGeneratorRecursive(), 2, List.of(2) },
            { new PrimeNumberGeneratorWithDivisors(), 10, List.of(2, 3, 5, 7) },
            { new PrimeNumberGeneratorWithDivisors(), 15, List.of(2, 3, 5, 7, 11, 13) },
            { new PrimeNumberGeneratorWithDivisors(), 2, List.of(2) }
        });
    }
}
