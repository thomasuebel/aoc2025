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

    @Test
    void getSumOfAllInvalidIds_returns_correct_sum() {
        Range range = new Range(new ID("11"), new ID("22"));

        assertEquals(33, range.getSumOfAllInvalidIds());
    }

    /**
     * Your job is to find all of the invalid IDs that appear in the given ranges. In the above example:
     * 11-22 has two invalid IDs, 11 and 22.
     * 95-115 has one invalid ID, 99.
     * 998-1012 has one invalid ID, 1010.
     * 1188511880-1188511890 has one invalid ID, 1188511885.
     * 222220-222224 has one invalid ID, 222222.
     * 1698522-1698528 contains no invalid IDs.
     * 446443-446449 has one invalid ID, 446446.
     * 38593856-38593862 has one invalid ID, 38593859.
     * The rest of the ranges contain no invalid IDs.
     * Adding up all the invalid IDs in this example produces 1227775554.
     */
    @Test
    void getSumOfAllInvalidIds_for_puzzle_input() {
        List<Range> ranges = List.of(
                Range.from("11-22"),
                Range.from("95-115"),
                Range.from("998-1012"),
                Range.from("1188511880-1188511890"),
                Range.from("222220-222224"),
                Range.from("1698522-1698528"),
                Range.from("446443-446449"),
                Range.from("38593856-38593862")
        );

        long sumOfAllInvalidIds = ranges.stream().mapToLong(Range::getSumOfAllInvalidIds).sum();

        assertEquals(1227775554, sumOfAllInvalidIds);
    }

    @Test
    void works_with_long_numbers() {
        Range range = Range.from("6461919174-6461988558");

        assertEquals(6461964619l, range.getSumOfAllInvalidIds());
    }
}
