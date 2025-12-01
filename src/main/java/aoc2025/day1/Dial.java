package aoc2025.day1;

/**
 * This is a safe's dial.
 * Because the dial is a circle, turning the dial left from 0 one click makes it point at 99.
 * Similarly, turning the dial right from 99 one click makes it point at 0.
 */
public class Dial {
    int position = 0;

    protected Dial(int position) {
        this.position = position;
    }

    void turnLeft(final Turn turn) {
        position = (position - turn.range()) % 100;
        if (position < 0) position += 100;
    }

    void turnRight(final Turn turn) {
        position = (position + turn.range()) % 100;
        if (position < 0) position += 100;
    }

    public void turn(final Turn turn) {
        if (turn.isLeft()) {
            turnLeft(turn);
        } else {
            turnRight(turn);
        }
    }

    int getPosition() {
        return position;
    }
}

