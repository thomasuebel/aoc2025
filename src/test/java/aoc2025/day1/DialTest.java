package aoc2025.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DialTest {

    @Test
    void initialPositionIsZero() {
        Dial dial = new Dial(0);

        assertEquals(0, dial.getPosition());
        assertEquals(0, dial.getWraparounds());
    }

    @ParameterizedTest(name = "Left from {0} by {1} -> Pos: {2}, Wraps: {3}")
    @CsvSource({
        // wrap-around at 0
        "0, 1, 99, 1",
        "0, 2, 98, 1",
        // simple move without wrap
        "10, 3, 7, 0",
        // multi-wrap (>= 100)
        "5, 107, 98, 2",
        // Exact wrap boundary
        "0, 100, 0, 1"
    })
    void turnLeft_wrapsAndMovesCorrectly(int start, int by, int expectedPos, int expectedWraps) {
        Dial dial = new Dial(start);

        dial.turnLeft(new Turn("L" + by));
        assertEquals(expectedPos, dial.getPosition());
        assertEquals(expectedWraps, dial.getWraparounds());
    }

    @ParameterizedTest(name = "Right from {0} by {1} -> Pos: {2}, Wraps: {3}")
    @CsvSource({
        // wrap-around at 99
        "99, 1, 0, 1",
        "99, 2, 1, 1",
        // simple move without wrap
        "10, 3, 13, 0",
        // multi-wrap (>= 100)
        "95, 110, 5, 2",
        // Exact wrap boundary
        "0, 100, 0, 1"
    })
    void turnRight_wrapsAndMovesCorrectly(int start, int by, int expectedPos, int expectedWraps) {
        Dial dial = new Dial(start);

        dial.turnRight(new Turn("R" + by));
        assertEquals(expectedPos, dial.getPosition());
        assertEquals(expectedWraps, dial.getWraparounds());
    }

    @Test
    void turn_usesDirection() {
        Dial dial = new Dial(0);

        dial.turn(new Turn("L1"));
        assertEquals(99, dial.getPosition());
        assertEquals(1, dial.getWraparounds());

        dial.turn(new Turn("R100")); // full circle -> unchanged position, +1 wrap
        assertEquals(99, dial.getPosition());
        assertEquals(2, dial.getWraparounds());
    }

    @Test
    void multipleTurns_sequence() {
        Dial dial = new Dial(50);

        dial.turnLeft(new Turn("L30"));  // 50 -> 20 (0 wraps)
        assertEquals(20, dial.getPosition());
        assertEquals(0, dial.getWraparounds());

        dial.turnRight(new Turn("R85")); // 20 -> 105 -> 5 (1 wrap)
        assertEquals(5, dial.getPosition());
        assertEquals(1, dial.getWraparounds());

        dial.turn(new Turn("L7"));     // 5 -> -2 -> 98 (1 wrap)
        assertEquals(98, dial.getPosition());
        assertEquals(2, dial.getWraparounds());
    }
}
