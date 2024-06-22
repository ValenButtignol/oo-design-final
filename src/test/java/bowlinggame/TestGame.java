package bowlinggame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestGame {

    @ParameterizedTest
    @MethodSource("rollsAndScoresProvider")
    public void testBowlingGame(int[] rolls, int expectedScore) {
        BowlingGame bowlingGame = new BowlingGame();
        rollAll(bowlingGame, rolls);

        int res = bowlingGame.score();

        assertThat(res).isEqualTo(expectedScore);
    }

    private static Stream<Arguments> rollsAndScoresProvider() {
        return Stream.of(
                Arguments.of(new int[] { 2, 8, 3, 3, 4, 5 }, 28),
                Arguments.of(new int[] { 2 }, 2),
                Arguments.of(new int[] { 2, 8, 3, 3, 5, 5 }, 29),
                Arguments.of(new int[] { 2, 8, 3, 3, 10 }, 29),
                Arguments.of(new int[] { 2, 8, 3, 3, 5, 5, 6 }, 41),
                Arguments.of(new int[] { 2, 8, 3, 3, 10, 6 }, 41),
                Arguments.of(new int[] { 2, 8, 3, 3, 10, 6, 2 }, 45),
                Arguments.of(new int[] { 10, 10 }, 30),
                Arguments.of(new int[] { 10, 3, 7 }, 30),
                Arguments.of(new int[] { 10, 10, 6 }, 48),
                Arguments.of(new int[] { 10, 3, 7, 0, 1 }, 31),
                Arguments.of(new int[] { 10, 0, 0 }, 10),
                Arguments.of(new int[] { 8, 2, 7, 3, 3, 4, 10, 2, 8, 10, 10, 8, 0, 10, 8, 2, 9 }, 170),
                Arguments.of(new int[] { 10, 8, 2, 3, 6, 10, 9, 1, 8, 2, 10, 9, 1, 9, 0, 10, 10, 10 }, 178),
                Arguments.of(new int[] { 8, 0, 7, 0, 5, 3, 9, 1, 9, 1, 10, 8, 0, 5, 1, 3, 7, 9, 0 }, 122),
                Arguments.of(new int[] { 5, 5, 4, 0, 8, 1, 10, 0, 10, 10, 10, 10, 4, 6, 10, 10, 5 }, 186),
                Arguments.of(new int[] { 2, 4, 10, 5, 1, 8, 2, 4, 6, 10, 10, 0, 0, 10, 2, 2 }, 110));
    }

    @ParameterizedTest
    @MethodSource("invalidRollsAndExceptionMessageProvider")
    public void testBowlingGameWithInvalidRolls(int[] rolls, String expectedMessage) {
        try {
            BowlingGame bowlingGame = new BowlingGame();
            rollAll(bowlingGame, rolls);
            int res = bowlingGame.score();
        } catch (IllegalArgumentException e) {
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    private static Stream<Arguments> invalidRollsAndExceptionMessageProvider() {
        return Stream.of(
                Arguments.of(new int[] { 11, 2, 9, 0 }, "Illegal amount of pins knocked."),
                Arguments.of(new int[] { 8, 3, 9, 0 }, "Illegal amount of pins knocked."),
                Arguments.of(new int[] { 8, 2, 9, 0, 4, 4, 7, 2, 9, 0, 10, 10, 8, 0, 3, 5, 10, 11 },
                        "Illegal amount of pins knocked."),
                Arguments.of(new int[] { 8, 2, 9, 0, 4, 4, 7, 2, 9, 0, 10, 10, 8, 0, 3, 5, 4, 2, 10 },
                        "No more rolls are allowed, the frames are all complete."),
                Arguments.of(new int[] { 8, 2, 9, 0, 4, 4, 7, 2, 9, 0, 10, 10, 8, 0, 3, 5, 10, 2, 11 },
                        "Illegal amount of pins knocked."),
                Arguments.of(new int[] { 8, 2, 9, 0, 4, 4, 7, 2, 9, 0, 10, 10, 8, 0, 3, 5, 10, 2, 3, 5 },
                        "No more rolls are allowed, the frames are all complete."),
                Arguments.of(new int[] { 8, 2, 9, 0, 4, 4, 7, 2, 9, 0, 10, 10, 8, 0, 3, 5, 5, 10, 3 },
                        "Illegal amount of pins knocked."));
    }

    private void rollAll(BowlingGame game, int[] rolls) {
        for (int roll : rolls) {
            game.roll(roll);
        }
    }
}