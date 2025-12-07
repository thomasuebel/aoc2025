package aoc2025.day3;

import java.lang.management.ThreadInfo;

/**
 * The Battery Bank
 * is represented as a string of digits between 0 and 9. Each digit
 * represents a battery in that bank with its joltage rating. E.g.,
 * 9800760059001
 * The BatteryBank provides a method to calculate a combination of
 * any two batteries that can be used to create a maximum joltage rating
 * without rearranging the batteries.
 * In the above example the batteries at index position 0 and index position 9
 * would create a joltage rating of 99 - the highest possible rating in this bank.
 */
public class BatteryBank {
    private String bank;

    public BatteryBank(String bank) {
        this.bank = bank;
    }

    /**
     * O(N) complexity to find the maximum joltage rating for a combination
     * of batteries in the given bank.
     * @return the maximum joltage rating
     */
    public int getMaximumJoltageRating() {
        // loop through all batteries and the highest, remember its index position
        int lengthOfBank = bank.length();

        // First Pass - Find first digit
        int indexOfHighestJoltageRating = 0;
        int highestJoltageRating = 0;
        for (int i = 0; i < lengthOfBank - 1; i++) {
            if (Character.getNumericValue(bank.charAt(i)) > highestJoltageRating) {
                highestJoltageRating = Character.getNumericValue(bank.charAt(i));
                indexOfHighestJoltageRating = i;
            }
        }

        // Second Pass - Start after the index of the first highest number
        int secondDigitOfHighestJoltageRating = 0;
        for (int i = indexOfHighestJoltageRating + 1; i < lengthOfBank; i++) {
            if (Character.getNumericValue(bank.charAt(i)) > secondDigitOfHighestJoltageRating) {
                secondDigitOfHighestJoltageRating = Character.getNumericValue(bank.charAt(i));
            }
        }

        return Integer.parseInt("%d%d".formatted(highestJoltageRating, secondDigitOfHighestJoltageRating));
    }
}
