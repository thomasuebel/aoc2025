package aoc2025.day1;

/**
 * This is a safe's dial.
 * Because the dial is a circle, turning the dial left from 0 one click makes it point at 99.
 * Similarly, turning the dial right from 99 one click makes it point at 0.
 */
public class Dial {
    int position = 0;
    int wraparounds = 0;
    int zeroPositionsAfterCompletedTurn = 0;

    protected Dial(int position) {
        this.position = position;
    }

    void turnLeft(final Turn turn) {
        for (int i = 0; i < turn.range(); i++) {
            position--;
            wrapAround();
        }
        checkZeroPosition();
    }

    void turnRight(final Turn turn) {
        for (int i = 0; i < turn.range(); i++) {
            position++;
            wrapAround();
        }
        checkZeroPosition();
    }

    void wrapAround() {
        if (position < 0) {
            position = 99;
        }
        if (position > 99) {
            position = 0;
        }
        if (position == 0) {
            wraparounds++;
        }
    }

    void checkZeroPosition() {
        if (position == 0) {
            zeroPositionsAfterCompletedTurn++;
        }
    }

    public void turn(final Turn turn) {
        if (turn.isLeft()) {
            turnLeft(turn);
            return;
        }

        turnRight(turn);
    }

    public int getPosition() {
        return position;
    }

    public int getWraparounds() {
        return wraparounds;
    }

    public int getZeroPositionsAfterCompletedTurn() {
        return zeroPositionsAfterCompletedTurn;
    }
}

