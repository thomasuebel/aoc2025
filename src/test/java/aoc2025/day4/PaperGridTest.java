package aoc2025.day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the PaperGrid class, specifically the fromResourceFile method.
 * This method reads a grid configuration from a resource file and initializes a PaperGrid instance.
 */
class PaperGridTest {

    @Test
    void generates_grid_from_lines() {
        List<String> lines = List.of(
                "..@@.@@@@.",
                "@@@.@.@.@@",
                "@@@@@.@.@@",
                "@.@@@@..@."
        );

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        assertEquals(4, paperGrid.getHeight());
        assertEquals(10, paperGrid.getWidth());
    }

    @Test
    void creates_empty_grid_from_empty_lines() {
        List<String> lines = List.of();

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        assertEquals(0, paperGrid.getHeight());
        assertEquals(0, paperGrid.getWidth());
    }

    @Test
    void adjacent_values_correctly_read() {
        List<String> lines = List.of(
                "..@@.@@@@.",
                "@@@.@.@.@@",
                "@@@@@.@.@@",
                "@.@@@@..@."
        );

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        // Test adjacent values for a central position
        String adjacents = paperGrid.getAdjacentsOf(1, 3); // '@' position
        assertEquals("@@@@@@@", adjacents);
    }

    @Test
    void adjacents_handle_out_of_bounds_positions() {
        List<String> lines = List.of(
                ".@.",
                "@@@",
                ".@."
        );

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        // Position at the edge
        assertEquals("@@@", paperGrid.getAdjacentsOf(0, 1)); // Top row, middle
        assertEquals("@@@", paperGrid.getAdjacentsOf(2, 1)); // Bottom row, middle

        // Center Position
        assertEquals("@@@@", paperGrid.getAdjacentsOf(1, 1));

        // Corner positions
        assertEquals("@@@", paperGrid.getAdjacentsOf(0, 0)); // Top-left corner
        assertEquals("@@@", paperGrid.getAdjacentsOf(2, 2)); // Bottom-right corner
    }

    @Test
    void adjacents_return_empty_string_for_empty_grid() {
        List<String> lines = List.of();

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        assertEquals("", paperGrid.getAdjacentsOf(0, 0));
        assertEquals("", paperGrid.getAdjacentsOf(2, 2)); // Any position on an empty grid
    }

    @Test
    void counts_accessible_paper_rolls_correctly() {
        List<String> lines = List.of(
                ".@.",
                "@@@",
                ".@."
        );

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        // Position at the edge
        assertTrue(paperGrid.isAccessible(0, 1));

        // Center position
        assertFalse(paperGrid.isAccessible(1, 1));
    }

    @Test
    void isInUse_correctly_identifies_positions() {
        List<String> lines = List.of(
                "..@.",
                "@@@@",
                ".@.."
        );

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        // Valid positions
        assertTrue(paperGrid.isInUse(0, 2)); // '@' at (0, 2)
        assertTrue(paperGrid.isInUse(1, 0)); // '@' at (1, 0)
        assertFalse(paperGrid.isInUse(0, 0)); // '.' at (0, 0)
        assertFalse(paperGrid.isInUse(2, 3)); // '.' at (2, 3)
    }

    @Test
    void isInUse_handles_out_of_bounds_positions() {
        List<String> lines = List.of(
                "...",
                "..."
        );

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        // Out-of-bounds positions
        assertFalse(paperGrid.isInUse(-1, 0)); // Above the grid
        assertFalse(paperGrid.isInUse(0, -1)); // Left of the grid
        assertFalse(paperGrid.isInUse(2, 0)); // Below the grid
        assertFalse(paperGrid.isInUse(0, 3)); // Right of the grid
    }

    @Test
    void calculates_accessible_count_for_non_empty_grid() {
        List<String> lines = List.of(
                "@.@",
                "@@@",
                "@.@"
        );

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        // 6 accessible '@' positions (0,0), (0,2), (1,0), (1,2), (2,0), and (2,2)
        assertEquals(6, paperGrid.getAccessibleCount());
    }

    @Test
    void calculates_accessible_count_for_empty_grid() {
        List<String> lines = List.of();

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        // No '@' positions
        assertEquals(0, paperGrid.getAccessibleCount());
    }

    @Test
    void calculates_accessible_count_with_all_positions_accessible() {
        List<String> lines = List.of(
                "@.@",
                "...",
                "@.@"
        );

        PaperGrid paperGrid = new PaperGrid().fromLines(lines);

        // All four '@' positions are accessible
        assertEquals(4, paperGrid.getAccessibleCount());
    }
}