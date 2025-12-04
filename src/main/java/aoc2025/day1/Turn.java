package aoc2025.day1;

public class Turn {

    String directionAndRange;

    /**
     * construct a Turn from a String consisting of the direction code L or R followed by a range without leading zeroes
     * the solution interprets L as Left and any other character as Right
     * */
    public Turn (String directionAndRange) {
        this.directionAndRange = directionAndRange;
    }

    public boolean isLeft() {
        return directionAndRange.charAt(0) == 'L';
    }

    public int range() {
        return Integer.parseInt(directionAndRange.substring(1));
    }
}
