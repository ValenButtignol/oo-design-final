package template;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import output.MockOutputManager;
import output.OutputManager;
import template.primenumbers.NPrimeWithDivisors;
import template.primenumbers.NPrimesRecursive;
import template.primenumbers.PrimeNumberTemplate;

public class TestPrintFirstPrimeNumbers {
    private static OutputManager mockOutputManager = new MockOutputManager();

    @ParameterizedTest
    @MethodSource("PrimeNumberGeneratorProvider")
    public void testPrimeNumberGenerators(PrimeNumberTemplate primeNumberGenerator, int number, List<Integer> expectedResult) {
        
        List<Integer> primeNumbers = primeNumberGenerator.getFirstNPrimeNumbers(number);
        assertThat(primeNumbers.equals(expectedResult));
    }

    public static Collection<Object[]> PrimeNumberGeneratorProvider() {
        return Arrays.asList(new Object[][] {
            { new NPrimeWithDivisors(mockOutputManager), 10, List.of(10, 2, 3, 5, 7) },
            { new NPrimeWithDivisors(mockOutputManager), 15, List.of(2, 3, 5, 7, 11, 13) },
            { new NPrimeWithDivisors(mockOutputManager), 2, List.of(2) },
            { new NPrimesRecursive(mockOutputManager), 10, List.of(2, 3, 5, 7) },
            { new NPrimesRecursive(mockOutputManager), 15, List.of(2, 3, 5, 7, 11, 13) },
            { new NPrimesRecursive(mockOutputManager), 2, List.of(2) }
        });
    }
}