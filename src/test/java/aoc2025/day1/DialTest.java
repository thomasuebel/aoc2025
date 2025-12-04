package aoc2025.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DialTest {

    @Test
    void initial_position_of_the_dial_is_zero() {
        Dial dial = new Dial(0);

        assertEquals(0, dial.getPosition());
        assertEquals(0, dial.getWraparounds());
    }

    @Test
    void turning_right_from_0_a_thousand_clicks_yields_10_wraparounds() {
        Dial dial = new Dial(50);

        dial.turn(new Turn("R1000"));
        assertEquals(50, dial.getPosition());
        assertEquals(10, dial.getWraparounds());

    }

    @Test
    void turning_left_from_zero_by_one_does_not_yield_a_wraparound() {
        Dial dial = new Dial(0);

        dial.turn(new Turn("L1"));
        assertEquals(99, dial.getPosition());
        assertEquals(0, dial.getWraparounds());
    }

    @Test
    void turning_right_from_zero_a_hundred_times_does_yield_1_wraparound() {
        Dial dial = new Dial(0);

        dial.turn(new Turn("R100")); // full circle -> unchanged position, +1 wrap
        assertEquals(0, dial.getPosition());
        assertEquals(1, dial.getWraparounds());
    }
}
