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

    public static PaperGrid fromLines(List<String> lines) {
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

    /**
     * Retrieves all adjacent elements in the grid surrounding the specified row and column position.
     * Adjacents include all valid non-empty positions forming an 8-connected neighborhood
     * around the specified point. The central position itself is excluded from the result.
     *
     * @param row the row index of the central position
     * @param column the column index of the central position
     * @return a String containing all adjacent non-empty grid elements around the specified position.
     *         Returns an empty string if there are no valid adjacent elements or the grid is empty.
     */
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

    /**
     * Determines if the position at the specified row and column is accessible by forklifts.
     * A position is considered accessible if it is surrounded by fewer than four rolls of paper (@)
     * in its adjacent positions.
     *
     * @param row the row index of the position to check
     * @param column the column index of the position to check
     * @return true if the specified position is accessible, false otherwise
     */
    public boolean isAccessible(int row, int column) {
        return getAdjacentsOf(row, column).length() < 4;
    }

    public boolean isInUse(int row, int column) {
        if (row < 0 || row >= height || column < 0 || column >= width) {
            // Out of bounds are assumed in accessible
            return false;
        }
        return this.grid[row][column] == '@'; // there's a paper roll at this position
    }

    public long getAccessibleCount() {
        long accessibleCount = 0;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (isInUse(row, column) && isAccessible(row, column)) {
                    accessibleCount++;
                }
            }
        }

        return accessibleCount;
    }

    /**
     * Cleans up all accessible positions in the grid that are currently in use.
     * A position is considered "in use" if it contains a paper roll ('@') and
     * "accessible" if it is surrounded by fewer than four adjacent paper rolls ('@').
     * The cleanup operation recursively processes the grid until no accessible
     * positions remain.
     *
     * @return the total number of positions cleaned up during the operation.
     */
    public long cleanUp() {
        long cleanedUpCount = 0;
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (isInUse(row, column) && isAccessible(row, column)) {
                    grid[row][column] = '.';
                    cleanedUpCount++;
                }
            }
        }

        if (cleanedUpCount == 0) {
            return 0L;
        }

        return cleanedUpCount + cleanUp();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
