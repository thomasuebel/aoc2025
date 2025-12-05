package aoc2025.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RangeTest {
    @Test
    void from_parses_valid_range_string() {
        Range range = Range.from("1-2");
        assertEquals("1", range.from.toString());
        assertEquals("2", range.to.toString());
    }

    @Test
    void from_throws_exception_for_invalid_format() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> Range.from("invalid"));
    }

    @Test
    void getIdsInRange_generates_correct_sequence_for_valid_range() {
        Range range = new Range(new ID("1"), new ID("3"));
        List<ID> ids = range.getIdsInRange();
        assertEquals(3, ids.size());
        assertEquals("1", ids.get(0).toString());
        assertEquals("2", ids.get(1).toString());
        assertEquals("3", ids.get(2).toString());
    }

    @Test
    void getIdsInRange_handles_single_value_range() {
        Range range = new Range(new ID("5"), new ID("5"));
        List<ID> ids = range.getIdsInRange();
        assertEquals(1, ids.size());
        assertEquals("5", ids.getFirst().toString());
    }

    @Test
    void getIdsInRange_returns_empty_for_invalid_range() {
        Range range = new Range(new ID("5"), new ID("3"));
        List<ID> ids = range.getIdsInRange();
        assertEquals(0, ids.size());
    }

    @Test
    void getAllInvalidIds_returns_all_invalid_ids_in_range() {
        Range range = new Range(new ID("11"), new ID("22"));
        List<ID> ids = range.getAllInvalidIds();

        assertEquals(2, ids.size());
        assertEquals("11", ids.get(0).toString());
        assertEquals("22", ids.get(1).toString());
    }
}
