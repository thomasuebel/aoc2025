package aoc2025.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegrationTest {

    @Test
    void countsZeroHitsForCurrentMainTurns() {
        // Turns as currently listed in Main
        List<String> turns = List.of(
                "L68",
                "L30",
                "R48",
                "L5",
                "R60",
                "L55",
                "L1",
                "L99",
                "R14",
                "L82"
        );

        Dial dial = new Dial(50);
        int zeroCount = 0;

        for (String t : turns) {
            dial.turn(new Turn(t));
            if (dial.getPosition() == 0) {
                zeroCount++;
            }
        }

        assertEquals(3, zeroCount); // three 3 exactly at 0
        assertEquals(6, dial.getWraparounds()); // 6 wraparounds at 0 including zero-at-rest
    }
}
