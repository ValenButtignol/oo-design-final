package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import stringcalculator.inputmanagers.MockInputManager;
import stringcalculator.inputmanagers.MockLoopInputManager;
import stringcalculator.outputmanagers.MockLoopOutputManager;
import stringcalculator.outputmanagers.MockOutputManager;

public class StringCalculatorSystemTests {

    StringCalculatorSystem calculatorSystem;
    MockInputManager inputManager;
    MockOutputManager outputManager;

    @BeforeEach
    public void setUp() {
        inputManager = new MockInputManager();
        outputManager = new MockOutputManager();
        calculatorSystem = new StringCalculatorSystem(inputManager, outputManager);
    }

    @ParameterizedTest
    @MethodSource("sumTestProvider")
    public void testSuccessfullAdd(String input, Integer expectedResult) {
        inputManager.setInput(input);
        int res = calculatorSystem.add();
        assertThat(res).isEqualTo(expectedResult);
        assertThat(outputManager.getResultMessage()).isEqualTo("The result is: " + res);
    }

    private static Stream<Arguments> sumTestProvider() {
        return Stream.of(
            Arguments.of("", 0),
            Arguments.of("1", 1),
            Arguments.of("1,2", 3),
            Arguments.of("1\n2,3", 6),
            Arguments.of("//[;]\n1;2", 3),
            Arguments.of("//[;]\n1;-2", -1),
            Arguments.of("//[;]\n2;1000", 1002),
            Arguments.of("//[***]\n1***2***3", 6),
            Arguments.of("//[*][%]\n1*2%3", 6),
            Arguments.of("//[xyzw][///][m]\n-10xyzw1m7///3", 1),
            Arguments.of("//[A]\n", 0));
    }

    @ParameterizedTest
    @MethodSource("addLoopTestProvider")
    public void testAddLoop(List<String> inputs, List<String> expectedOutputs) {
        MockLoopInputManager inputManager2 = new MockLoopInputManager();
        MockLoopOutputManager outputManager2 = new MockLoopOutputManager();
        calculatorSystem = new StringCalculatorSystem(inputManager2, outputManager2);

        for (String input : inputs) {
            inputManager2.addInput(input);
        }

        calculatorSystem.addLoop();

        for (String expectedOutput : expectedOutputs) {
            assertThat(outputManager2.getResultMessage()).isEqualTo(expectedOutput);
        }
    }

    static Stream<Arguments> addLoopTestProvider() {
        return Stream.of(
            Arguments.of(
                List.of("1\n2,4", "//[@]\n-10@8", "//[//][%][\\]\n1//2%3\\1", ""),
                List.of("7", "-2", "7", "0")),
            Arguments.of(
                List.of("1,2", "1,2,3", ""),
                List.of("3", "6", "0")),
            Arguments.of(
                List.of("//[___]\n1___2___-3", "//[.][..]\n1..-2.8", ""),
                List.of("0", "7", "0")),
            Arguments.of(
                List.of("//[$]\n", ""),
                List.of("0", "0")));
    }
}