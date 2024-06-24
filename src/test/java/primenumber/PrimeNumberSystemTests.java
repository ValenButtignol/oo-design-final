package primenumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import output.MockOutputManager;
import primenumber.primenumbergenerators.PrimeNumberGenerator;
import primenumber.primenumbergenerators.PrimeNumberGeneratorRecursive;
import primenumber.primenumbergenerators.PrimeNumberGeneratorWithDivisors;

public class PrimeNumberSystemTests {
    
    MockOutputManager outputManager = new MockOutputManager();

    @ParameterizedTest
    @MethodSource("PrimeNumberGeneratorProvider")
    public void testPrimeNumberGenerators(PrimeNumberGenerator primeNumberGenerator, int number, String expectedResult) {
        
        PrimeNumberSystem primeNumberSystem = new PrimeNumberSystem(primeNumberGenerator, outputManager);
        List<Integer> primeNumbers = primeNumberSystem.printFirstNPrimeNumbers(number);
        assertThat(outputManager.getPrintInput()).isEqualTo(expectedResult);
    }

    public static Collection<Object[]> PrimeNumberGeneratorProvider() {
        return Arrays.asList(new Object[][] {
            { new PrimeNumberGeneratorRecursive(), 10, "[2, 3, 5, 7]" },
            { new PrimeNumberGeneratorRecursive(), 15, "[2, 3, 5, 7, 11, 13]" },
            { new PrimeNumberGeneratorRecursive(), 2, "[2]" },
            { new PrimeNumberGeneratorWithDivisors(), 10, "[2, 3, 5, 7]" },
            { new PrimeNumberGeneratorWithDivisors(), 15, "[2, 3, 5, 7, 11, 13]" },
            { new PrimeNumberGeneratorWithDivisors(), 2, "[2]" }
        });
    }
}