package bowlinggame;

public abstract class Frame {

    protected Integer firstRoll;
    protected Integer secondRoll;
    protected static final int MAX_PINS = 10;

    public Frame() {
        firstRoll = null;
        secondRoll = null;
    }

    protected Integer getFirstRoll() {
        return firstRoll;
    }

    protected Integer getSecondRoll() {
        return secondRoll;
    }

    protected void setFirstRoll(Integer firstRoll) {
        if (firstRoll > MAX_PINS)
            throw new IllegalArgumentException("Illegal amount of pins knocked.");

        this.firstRoll = firstRoll;
    }

    protected boolean isSpare() {
        if (firstRoll != null && secondRoll != null)
            return firstRoll + secondRoll == MAX_PINS;

        return false;
    }

    protected boolean isStrike() {
        if (firstRoll != null)
            return firstRoll == MAX_PINS;

        return false;
    }

    protected boolean rolledOnce() {
        return firstRoll != null;
    }

    protected boolean rolledTwice() {
        return firstRoll != null && secondRoll != null;
    }

    protected abstract boolean isComplete();

    protected abstract void setSecondRoll(Integer secondRoll);

    public abstract int roll(int pins, int indexCurrentFrame);

    public abstract int getScore();
}