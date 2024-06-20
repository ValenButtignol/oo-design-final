package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import stringcalculator.exceptions.CharacterOutsideDelimiterException;
import stringcalculator.exceptions.InvalidDelimiterException;
import stringcalculator.parsers.DelimiterParser;

public class DelimiterParserTests {


    DelimiterParser delimiterParser;

    @BeforeEach
    public void setUp() {
        delimiterParser = new DelimiterParser();
    }

    @ParameterizedTest
    @MethodSource("delimitersProvider")
    public void positiveTestParseDelimiters(String input, Set<String> expectedResult) {
        delimiterParser.setUnprocessedDelimiters(input);
        delimiterParser.parseDelimiters();
        Set<String> delimiters = delimiterParser.getProcessedDelimiters();

        assertThat(delimiters).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> delimitersProvider() {
        return Stream.of(
            Arguments.of("", Set.of(",", "\n")),
            Arguments.of("[;]", Set.of(",", "\n", ";")),
            Arguments.of("[___]", Set.of(",", "\n", "___")),
            Arguments.of("[__][%]", Set.of(",", "\n", "__", "%")),
            Arguments.of("[*][***]", Set.of(",", "\n", "*", "***")),
            Arguments.of("[abc][%][_][**]", Set.of(",", "\n", "**", "abc", "%", "_")));
    }

    @ParameterizedTest
    @MethodSource("exceptionInputProvider")
    public void negativeTestParseDelimiters(String input, String exceptionMessage,
            Class<RuntimeException> expectedExceptionClass) {
        delimiterParser.setUnprocessedDelimiters(input);
        Exception exceptionThrown = assertThrows(expectedExceptionClass, () -> {
            delimiterParser.parseDelimiters();
        });
        assertEquals(exceptionMessage, exceptionThrown.getMessage());
    }

    private static Stream<Arguments> exceptionInputProvider() {
        return Stream.of(
            Arguments.of("[]", "Expression '' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[a][][b]", "Expression '' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[[]", "Expression '[' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[[a]", "Expression '[' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[a[]", "Expression '[' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[-]", "Expression '-' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[a-b]", "Expression '-' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[1]", "Expression '1' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[a2b]", "Expression '2' is not a valid delimiter.", 
                InvalidDelimiterException.class),
            Arguments.of("[a]]", "Character ']' outside of delimiters.", 
                CharacterOutsideDelimiterException.class),
            Arguments.of("[a]b[c]", "Character 'b' outside of delimiters.",
                CharacterOutsideDelimiterException.class),
            Arguments.of("a[b]", "Character 'a' outside of delimiters.", 
                CharacterOutsideDelimiterException.class),
            Arguments.of("[a][b", "Character 'b' outside of delimiters.",
                CharacterOutsideDelimiterException.class));
    }
}