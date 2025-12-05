package aoc2025.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IDTest {
    @Test
    void id_is_valid_string() {
        ID id = new ID("12");
        assertTrue(id.isValid());
    }

    @Test
    void is_invalid_string() {
        ID id = new ID("11");
        assertFalse(id.isValid());
    }

    @Test
    void is_an_invalid_long_id_of_equal_sequence() {
        ID id = new ID("1010");

        assertFalse(id.isValid());
    }

    @Test
    void is_an_invalid_long_id_of_equal_sequence_with_leading_zero() {
        ID id = new ID("01010");

        assertFalse(id.isValid());
    }

    @Test
    void id_as_int_valid() {
        ID id = new ID("123");
        assertTrue(id.asInt() == 123, "asInt should return the integer representation of a valid string ID.");
    }

    @Test
    void id_as_int_invalid_input_throws_number_format_exception() {
        ID id = new ID("abc");
        try {
            id.asInt();
            throw new AssertionError("Expected NumberFormatException to be thrown.");
        } catch (NumberFormatException ignored) {
            // Expected exception
        }
    }
}
