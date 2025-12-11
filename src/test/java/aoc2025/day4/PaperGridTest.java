package aoc2025.day4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}