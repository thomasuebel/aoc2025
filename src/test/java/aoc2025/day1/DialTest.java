package aoc2025.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DialTest {

    @Test
    void initialPositionIsZero() {
        Dial dial = new Dial(0);

        assertEquals(0, dial.getPosition());
    }

    @ParameterizedTest(name = "Left from {0} by {1} -> {2}")
    @CsvSource({
        // wrap-around at 0
        "0, 1, 99",
        "0, 2, 98",
        // simple move without wrap
        "10, 3, 7",
        // multi-wrap (>= 100)
        "5, 107, 98"
    })
    void turnLeft_wrapsAndMovesCorrectly(int start, int by, int expected) {
        Dial dial = new Dial(start);

        dial.turnLeft(new Turn("L" + by));
        assertEquals(expected, dial.getPosition());
    }

    @ParameterizedTest(name = "Right from {0} by {1} -> {2}")
    @CsvSource({
        // wrap-around at 99
        "99, 1, 0",
        "99, 2, 1",
        // simple move without wrap
        "10, 3, 13",
        // multi-wrap (>= 100)
        "95, 110, 5"
    })

    void turnRight_wrapsAndMovesCorrectly(int start, int by, int expected) {
        Dial dial = new Dial(start);

        dial.turnRight(new Turn("R" + by));
        assertEquals(expected, dial.getPosition());
    }

    @Test
    void turn_usesDirection() {
        Dial dial = new Dial(0);

        dial.turn(new Turn("L1"));
        assertEquals(99, dial.getPosition());

        dial.turn(new Turn("R100")); // full circle -> unchanged
        assertEquals(99, dial.getPosition());
    }

    @Test
    void multipleTurns_sequence() {
        Dial dial = new Dial(50);

        dial.turnLeft(new Turn("L30"));  // 50 -> 20
        assertEquals(20, dial.getPosition());

        dial.turnRight(new Turn("R85")); // 20 -> 105 -> 5
        assertEquals(5, dial.getPosition());

        dial.turn(new Turn("L7"));     // 5 -> -2 -> 98
        assertEquals(98, dial.getPosition());
    }
}
