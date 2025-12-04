package aoc2025.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DialTest {

    @Test
    void initialPositionIsZero() {
        Dial dial = new Dial(0);

        assertEquals(0, dial.getPosition());
        assertEquals(0, dial.getWraparounds());
    }

    @Test
    void turnRight_aThousandClicks() {
        Dial dial = new Dial(50);

        dial.turn(new Turn("R1000"));
        assertEquals(50, dial.getPosition());
        assertEquals(10, dial.getWraparounds());

    }

    @Test
    void turnLeft_FromZero_ByOne_DoesNotCountAWraparound() {
        Dial dial = new Dial(0);

        dial.turn(new Turn("L1"));
        assertEquals(99, dial.getPosition());
        assertEquals(0, dial.getWraparounds());
    }

    @Test
    void turnRight_FromZero_by100_CreatingOneWraparound() {
        Dial dial = new Dial(0);

        dial.turn(new Turn("R100")); // full circle -> unchanged position, +1 wrap
        assertEquals(0, dial.getPosition());
        assertEquals(1, dial.getWraparounds());
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
