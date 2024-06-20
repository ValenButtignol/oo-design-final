package bowlinggame;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RegularFrameTest {
    private RegularFrame frame;
    private RegularFrame nextFrame;
    private LastFrame nextNextFrame;

    @BeforeEach
    public void setUp() {
        nextNextFrame = new LastFrame();
        nextFrame = new RegularFrame(nextNextFrame);
        frame = new RegularFrame(nextFrame, nextNextFrame);
    }

    @ParameterizedTest
    @MethodSource("regularFrameRollsProvider")
    public void testIsFrameComplete(int[] rolls, boolean expectedResult) {
        for (int roll : rolls) {
            frame.roll(roll, 0);
        }
        assertThat(frame.isComplete()).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> regularFrameRollsProvider() {
        return Stream.of(
                Arguments.of(new int[]{10}, true), 
                Arguments.of(new int[]{4, 5}, true),
                Arguments.of(new int[]{5, 5}, true),
                Arguments.of(new int[]{4}, false),
                Arguments.of(new int[]{9}, false),
                Arguments.of(new int[]{0,0}, true),
                Arguments.of(new int[]{0,1}, true),
                Arguments.of(new int[]{}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("threeFramesRollsProvider")
    public void testCalculateBonus(int[] frameRolls, int[] nextFrameRolls, int[] nextNextFrameRolls, int expectedBonus) {
        rollAll(frame, frameRolls);
        rollAll(nextFrame, nextFrameRolls);
        rollAll(nextNextFrame, nextNextFrameRolls);

        int bonus = frame.getBonus();

        assertThat(bonus).isEqualTo(expectedBonus);
    }

    private static Stream<Arguments> threeFramesRollsProvider() {
        return Stream.of(
            Arguments.of(new int[]{10}, new int[]{4, 3}, new int[]{}, 7), 
            Arguments.of(new int[]{10}, new int[]{10}, new int[]{4}, 14), 
            Arguments.of(new int[]{10}, new int[]{10}, new int[]{10}, 20),
            Arguments.of(new int[]{10}, new int[]{5}, new int[]{}, 5),
            Arguments.of(new int[]{5,5}, new int[]{0}, new int[]{4}, 0),
            Arguments.of(new int[]{5,5}, new int[]{3}, new int[]{4}, 3)
        );
    }

    private void rollAll(Frame frame, int[] rolls) {
        for (int roll : rolls) {
            frame.roll(roll, 0);
        }
    }
}