package aoc2025.day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}