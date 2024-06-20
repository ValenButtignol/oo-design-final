package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import stringcalculator.exceptions.DelimiterAtBeginningException;
import stringcalculator.exceptions.DelimiterAtEndException;
import stringcalculator.exceptions.InvalidDelimiterException;
import stringcalculator.parsers.DelimiterParser;
import stringcalculator.parsers.NumberParser;

public class NumberParserTests {

    DelimiterParser delimiterParser;
    NumberParser numberParser;

    @BeforeEach
    public void setUp() {
        delimiterParser = new DelimiterParser();
        numberParser = new NumberParser(delimiterParser);
    }

    @ParameterizedTest
    @MethodSource("numbersStringsProvider")
    public void positiveTestParseNumbers(String input, List<String> expectedResult, String delimiters) {
        delimiterParser.setUnprocessedDelimiters(delimiters);
        delimiterParser.parseDelimiters();
        numberParser.setUnprocessedNumbers(input);
        
        numberParser.parseNumbers();

        List<Integer> numbersString = numberParser.getNumbers();
        assertThat(numbersString).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> numbersStringsProvider() {
        return Stream.of(
            Arguments.of("", List.of(), ""),
            Arguments.of("1", List.of(1), ""),
            Arguments.of("1;2", List.of(1, 2), "[;]"),
            Arguments.of("-1;2;3", List.of(-1, 2, 3), "[;]"),
            Arguments.of("1;-2;3", List.of(1, -2, 3), "[;]"),
            Arguments.of("1;2;-3", List.of(1, 2, -3), "[;]"),
            Arguments.of("1,%2", List.of(1, 2), "[,%]"),
            Arguments.of("1___2___-3", List.of(1, 2, -3), "[___]"),
            Arguments.of("1__2%3", List.of(1, 2, 3), "[__][%]"),
            Arguments.of("1*2***3", List.of(1, 2, 3), "[*][***]"),
            Arguments.of("1H-2@3", List.of(1, -2, 3), "[@][H]"),
            Arguments.of("-10xyzw1m7///3", List.of(-10, 1, 7, 3), "[xyzw][m][///]"));
    }

    @ParameterizedTest
    @MethodSource("exceptionInputProvider")
    public void negativeTestParseNumbers(String input, String expectedMessage,
            String delimiters, Class<RuntimeException> expectedExceptionClass) {
        delimiterParser.setUnprocessedDelimiters(delimiters);
        delimiterParser.parseDelimiters();
        numberParser.setUnprocessedNumbers(input);

        Exception exceptionThrown = assertThrows(expectedExceptionClass, () -> {
            numberParser.parseNumbers();
        });

        assertEquals(expectedMessage, exceptionThrown.getMessage());
    }

    private static Stream<Arguments> exceptionInputProvider() {
        return Stream.of(
            Arguments.of("\n1,2", "Expression '\n' at the beginning of the input.", "",
                    DelimiterAtBeginningException.class),
            Arguments.of("a1,2", "Expression 'a' at the beginning of the input.", "[a]",
                    DelimiterAtBeginningException.class),
            Arguments.of(",1,2", "Expression ',' at the beginning of the input.", "",
                    DelimiterAtBeginningException.class),
            Arguments.of("1,2,", "Expression ',' at the end of the input.", "", 
                    DelimiterAtEndException.class),
            Arguments.of("1,2a", "Expression 'a' at the end of the input.", "[aa]",
                    DelimiterAtEndException.class),
            Arguments.of("1,2aa", "Expression 'aa' at the end of the input.", "[aa]",
                    DelimiterAtEndException.class),
            Arguments.of("1,2aaa", "Expression 'aaa' at the end of the input.", "[aa]",
                    DelimiterAtEndException.class),
            Arguments.of("1\n,2", "Expression '\n,' is not a valid delimiter.", "",
                    InvalidDelimiterException.class),
            Arguments.of("1_,2", "Expression '_,' is not a valid delimiter.", "[_]",
                    InvalidDelimiterException.class),
            Arguments.of("1***2", "Expression '***' is not a valid delimiter.", "[**][*]",
                    InvalidDelimiterException.class),
            Arguments.of("-1***2", "Expression '***' is not a valid delimiter.", "[**][*]",
                    InvalidDelimiterException.class),
            Arguments.of("1_%2", "Expression '_%' is not a valid delimiter.", "[_][%]",
                    InvalidDelimiterException.class),
            Arguments.of("--1***2", "For input string: \"--1\"", "[**][*]",
                    NumberFormatException.class),
            Arguments.of("1,-,2", "For input string: \"-\"", "",
                    NumberFormatException.class),
            Arguments.of("-1-2,8,2", "For input string: \"-1-2\"", "",
                    NumberFormatException.class));
    }
}