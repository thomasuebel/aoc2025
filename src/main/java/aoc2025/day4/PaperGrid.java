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
    private char [][] grid; // Grid of row and columns
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
        for (int row = 0; row < lines.size(); row++) {
            grid.grid[row] = lines.get(row).toCharArray();
        }

        return grid;
    }

    public String getAdjacentsOf(int row, int column) {
        StringBuilder adjacents = new StringBuilder();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i == row && j == column) {
                    // Origin is not counted as adjacent
                    continue;
                }
                if ( i < 0 || j < 0 || i >= height || j >= width) {
                    // Out of bounds are assumed to be empty
                    continue;
                }
                if (grid[i][j] == '.') {
                    // Empty position don't count towards used
                    continue;
                }
                adjacents.append(grid[i][j]);
            }
        }
        return adjacents.toString();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
