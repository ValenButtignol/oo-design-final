package bowlinggame;

public class LastFrame extends Frame {

    private Integer thirdRoll = null;

    @Override
    protected void setSecondRoll(Integer secondRoll) {
        if (secondRoll > MAX_PINS || (firstRoll < 10 && firstRoll + secondRoll > 10))
            throw new IllegalArgumentException("Illegal amount of pins knocked.");

        this.secondRoll = secondRoll;
    }

    private void setThirdRoll(Integer thirdRoll) {
        if (!isSpare() && !isStrike())
            throw new IllegalArgumentException("Last frame is complete, another roll isn't allowed");

        if (thirdRoll > MAX_PINS)
            throw new IllegalArgumentException("Illegal amount of pins knocked.");

        this.thirdRoll = thirdRoll;
    }

    @Override
    public int getScore() {
        int score = 0;
        if (rolledOnce()) {
            score += firstRoll;
            if (rolledTwice()) {
                score += secondRoll;
                if (thirdRoll != null) {
                    score += thirdRoll;
                }
            }
        }
        return score;
    }

    @Override
    protected boolean isComplete() {
        if (isSpare() || isStrike())
            return firstRoll != null && secondRoll != null && thirdRoll != null;

        if (!isSpare() && !isStrike()) {
            return firstRoll != null && secondRoll != null && thirdRoll == null;
        }

        return false;
    }

    @Override
    public int roll(int pins, int indexCurrentFrame) {
        if (!rolledOnce()) {
            setFirstRoll(pins);
        } else if (rolledOnce() && !rolledTwice()) {
            setSecondRoll(pins);
            if (isComplete())
                indexCurrentFrame++;
        } else if (rolledTwice() && !isComplete()) {
            setThirdRoll(pins);
            indexCurrentFrame++;
        }
        return indexCurrentFrame;
    }
}