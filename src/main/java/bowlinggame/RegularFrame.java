package bowlinggame;

public class RegularFrame extends Frame {

    private Integer bonus = 0;
    private boolean bonusCalculated = false;
    private Frame nextFrame;
    private Frame nextNextFrame;

    public RegularFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public RegularFrame(Frame nextFrame, Frame nextNextFrame) {
        this.nextFrame = nextFrame;
        this.nextNextFrame = nextNextFrame;
    }

    @Override
    protected void setSecondRoll(Integer secondRoll) {
        if (secondRoll + firstRoll > MAX_PINS)
            throw new IllegalArgumentException("Illegal amount of pins knocked.");

        this.secondRoll = secondRoll;
    }

    public int getBonus() {
        if (bonusCalculated == false)
            return calculateBonus();

        return bonus;
    }

    private int calculateBonus() {
        int currentBonus = 0;
        if (isSpare())
            currentBonus += calculateBonusForSpare();
        if (isStrike())
            currentBonus += calculateBonusForStrike();

        return currentBonus;
    }

    private int calculateBonusForSpare() {
        if (nextFrame.rolledOnce()) {
            bonus += nextFrame.getFirstRoll();
            bonusCalculated = true;
        }

        return bonus;
    }

    private int calculateBonusForStrike() {
        int currentBonus = 0;

        if (nextFrame.rolledOnce())
            currentBonus += nextFrame.getFirstRoll();

        if (nextFrame.rolledTwice()) {
            currentBonus += nextFrame.getSecondRoll();
            bonus = currentBonus;
            bonusCalculated = true;
        } else {
            if (nextNextFrame != null) {
                if (nextNextFrame.rolledOnce()) {
                    currentBonus += nextNextFrame.getFirstRoll();
                    bonus = currentBonus;
                    bonusCalculated = true;
                }
            }
        }

        return currentBonus;
    }

    @Override
    protected boolean isComplete() {
        return isStrike() || (firstRoll != null && secondRoll != null);
    }

    @Override
    public int getScore() {
        int score = 0;
        if (firstRoll != null) {
            score += firstRoll;
            if (secondRoll != null)
                score += secondRoll;
        }
        return score;
    }

    @Override
    public int roll(int pins, int indexCurrentFrame) {
        if (rolledOnce()) {
            setSecondRoll(pins);
            indexCurrentFrame++;
        } else {
            setFirstRoll(pins);
            if (pins == 10)
                indexCurrentFrame++;
        }
        return indexCurrentFrame;
    }
}