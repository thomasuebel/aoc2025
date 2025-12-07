package aoc2025.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinesBasedInputResourceFileTest {

    @Test
    void readTurnsFromResource_validFile_returnsList() {
        List<String> result = LinesBasedInputResourceFile.readFrom("test_turns.txt");
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals("R2", result.get(0));
        assertEquals("R10", result.get(3));
    }

    @Test
    void readTurnsFromResource_nonExistentFile_throwsException() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            LinesBasedInputResourceFile.readFrom("non_existent_file.txt");
        });
        assertTrue(exception.getMessage().contains("Resource not found"));
    }
}