package aoc2025.day4;

import aoc2025.util.LinesBasedInputResourceFile;

import java.util.List;

/**
 * The rolls of paper (@) are arranged on a large grid;
 * The forklifts can only access a roll of paper if there are fewer than four rolls of paper
 * in the eight adjacent positions. If you can figure out which rolls of paper the
 * forklifts can access, they'll spend less time looking and more time breaking down the wall
 * to the cafeteria.
 * A position is empty (.) or contains a roll of paper (@).
 */
public class PaperGrid {
    private char [][] grid;
    private int width = 0;
    private int height = 0;

    public PaperGrid fromLines(List<String> lines) {
        PaperGrid grid = new PaperGrid();
        if (lines.isEmpty()) {
            return grid;
        }

        grid.width = lines.getFirst().length();
        grid.height = lines.size();
        grid.grid = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            grid.grid[i] = lines.get(i).toCharArray();
        }

        return grid;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
