package aoc2025.day1;

/**
 * This is a safe's dial.
 * Because the dial is a circle, turning the dial left from 0 one click makes it point at 99.
 * Similarly, turning the dial right from 99 one click makes it point at 0.
 */
public class Dial {
    int position = 0;
    int wraparounds = 0;

    protected Dial(int position) {
        this.position = position;
    }

    void turnLeft(final Turn turn) {
        int by = turn.range();
        // Number of times we pass 0 when moving left by 'by' from current 'position'
        int wrapsThisTurn = (by - position + 99) / 100;
        if (wrapsThisTurn > 0) {
            wraparounds += wrapsThisTurn;
        }
        position = Math.floorMod(position - by, 100);
    }

    void turnRight(final Turn turn) {
        int totalMovement = position + turn.range();
        wraparounds += totalMovement / 100;
        position = totalMovement % 100;
    }

    public void turn(final Turn turn) {
        if (turn.isLeft()) {
            turnLeft(turn);
        } else {
            turnRight(turn);
        }
    }

    public int getPosition() {
        return position;
    }

    public int getWraparounds() {
        return wraparounds;
    }
}

