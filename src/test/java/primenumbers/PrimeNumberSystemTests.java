package primenumbers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import primenumbers.outputs.MockOutput;
import primenumbers.primenumbergenerators.PrimeNumberGenerator;
import primenumbers.primenumbergenerators.PrimeNumberGeneratorRecursive;
import primenumbers.primenumbergenerators.PrimeNumberGeneratorWithDivisors;

public class PrimeNumberSystemTests {
    
    MockOutput outputManager = new MockOutput();

    @ParameterizedTest
    @MethodSource("PrimeNumberGeneratorProvider")
    public void testPrimeNumberGenerators(PrimeNumberGenerator primeNumberGenerator, int number, List<Integer> expectedResult) {
        
        PrimeNumberSystem primeNumberSystem = new PrimeNumberSystem(primeNumberGenerator, outputManager);
        List<Integer> primeNumbers = primeNumberSystem.printFirstNPrimeNumbers(number);
        assertThat(outputManager.getResultMessage()).isEqualTo("Prime numbers: " + primeNumbers);  
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
