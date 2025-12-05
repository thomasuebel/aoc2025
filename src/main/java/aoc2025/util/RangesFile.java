package aoc2025.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RangesFile {
    /**
     * Read a list of Ranges from an input file. The file is expected to contain only one line, with Ranges separated by commas.
     * For example: 1-3,5-7,9-11
     * @param resourceName the name of the resource file
     * @return a List of Ranges
     */
    public static List<String> readFrom(String resourceName) {
        InputStream in = RangesFile.class.getClassLoader().getResourceAsStream(resourceName);
        if (in == null) {
            throw new IllegalStateException("Resource not found: " + resourceName);
        }
        List<String> ranges = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            // Get every line, split on comma and collect to an ArrayList
            reader.lines().forEach(line -> ranges.addAll(Stream.of(line.split(",")).filter(s -> !s.isBlank()).toList()));
            return ranges;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
