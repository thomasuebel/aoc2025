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
}
