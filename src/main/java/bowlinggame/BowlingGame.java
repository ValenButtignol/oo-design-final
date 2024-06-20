package bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private static final int MAX_FRAME_IDX = 10;
    private List<Frame> frames = new ArrayList<>();
    private int score;
    private int indexCurrentFrame;

    public BowlingGame() {
        score = 0;
        indexCurrentFrame = 0;

        frames.add(0, new LastFrame());
        frames.add(0, new RegularFrame(frames.get(0)));
        for (int i = 0; i < MAX_FRAME_IDX - 2; i++) {
            frames.add(0, new RegularFrame(frames.get(0), frames.get(1)));
        }
    }

    public void roll(int pins) {
        if (indexCurrentFrame == 10)
            throw new IllegalArgumentException("No more rolls are allowed, the frames are all complete.");

        Frame currentFrame = frames.get(indexCurrentFrame);
        indexCurrentFrame = currentFrame.roll(pins, indexCurrentFrame);
    }

    public int score() {
        Frame currentFrame;
        for (int i = 0; i <= indexCurrentFrame && i < 10; i++) {
            currentFrame = frames.get(i);
            score += currentFrame.getScore();
            if (currentFrame instanceof RegularFrame)
                score += ((RegularFrame) currentFrame).getBonus();
        }
        return score;
    }
}