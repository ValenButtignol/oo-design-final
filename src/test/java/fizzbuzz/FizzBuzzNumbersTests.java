package fizzbuzz;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FizzBuzzNumbersTests {

    @ParameterizedTest
    @ValueSource(ints = { 3, 6, 15, 30, 53})
    public void testsFizz(int number) {
        boolean res = FizzBuzz.isFizz(number);
        assertThat(res).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    public void testsNotFizz(int number) {
        boolean res = FizzBuzz.isFizz(number);
        assertThat(res).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = { 5, 10, 15, 30, 53})
    public void testsBuzz(int number) {
        boolean res = FizzBuzz.isBuzz(number);
        assertThat(res).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8, 3})
    public void testsNotBuzz(int number) {
        boolean res = FizzBuzz.isBuzz(number);
        assertThat(res).isFalse();
    }

    static Stream<Arguments> fizzBuzzSequencesProvider() {
        return Stream.of(
            arguments(List.of(1, 2, 3, 4, 5),
                    List.of("1", "2", "Fizz", "4", "Buzz")),
             arguments(List.of(15, 16, 17, 18, 19, 20),
                    List.of("FizzBuzz", "16", "17", "Fizz", "19", "Buzz")),
                arguments(List.of( 53),
                        List.of("FizzBuzz"))
        );
    }

    @ParameterizedTest
    @MethodSource("fizzBuzzSequencesProvider")
    public void testFizzBuzzSequences(List<Integer> numbers, List<String> expected) {
        List<String> res = FizzBuzzSequence.fizzBuzzSequence(numbers);
        assertThat(res).isEqualTo(expected);
    }

}
