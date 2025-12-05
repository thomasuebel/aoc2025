package aoc2025.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangesFileTest {
    @Test
    void readFrom_validFile_returnsListOfRanges() {
        String resourceName = "test_ranges.txt";

        List<String> result = RangesFile.readFrom(resourceName);

        assertNotNull(result);
        assertEquals(11, result.size());
        assertEquals("11-22", result.getFirst());
        assertEquals("2121212118-2121212124", result.getLast());
    }

    @Test
    void readFrom_invalidFile_throwsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> RangesFile.readFrom("missing_file.txt"));
    }

    @Test
    void readFrom_fileWithEmptyLines_ignoresEmptyLines() {
        String resourceName = "test_ranges_with_empty_lines.txt"; // Create a resource with empty lines for this test.

        List<String> result = RangesFile.readFrom(resourceName);

        assertNotNull(result);
        assertEquals(0, result.size()); // Adjust this expected size based on the test file contents.
    }

    @Test
    void readFrom_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> RangesFile.readFrom(null));
    }


}