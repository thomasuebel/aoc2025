package aoc2025.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {

    @ParameterizedTest(name = "Input {0} should be Left: {1} and Range: {2}")
    @CsvSource({
        "L1, true, 1",
        "L100, true, 100",
        "R5, false, 5",
        "R0, false, 0",
        "S10, false, 10" // "any other character as Right"
    })
    void testValidTurns(String input, boolean expectedLeft, int expectedRange) {
        Turn turn = new Turn(input);

        assertEquals(expectedLeft, turn.isLeft(), "Direction check failed for input: " + input);
        assertEquals(expectedRange, turn.range(), "Range check failed for input: " + input);
    }

    @Test
    void testInvalidNumberFormat() {
        Turn turn = new Turn("L5a");
        assertThrows(NumberFormatException.class, turn::range, "Should throw NumberFormatException for non-numeric range");
    }

    @Test
    void testMissingRange() {
        Turn turn = new Turn("L");
        assertTrue(turn.isLeft());
        assertThrows(NumberFormatException.class, turn::range, "Should throw NumberFormatException for empty range string");
    }

    @Test
    void testEmptyString() {
        Turn turn = new Turn("");
        assertThrows(StringIndexOutOfBoundsException.class, turn::isLeft, "Should throw exception when string is empty");
        assertThrows(StringIndexOutOfBoundsException.class, turn::range, "Should throw exception when string is empty");
    }

    @Test
    void testNullInput() {
        Turn turn = new Turn(null);
        assertThrows(NullPointerException.class, turn::isLeft);
        assertThrows(NullPointerException.class, turn::range);
    }
}
