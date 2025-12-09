package aoc2025.day3;

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
    /**
     * The length of combinations of batteries as per the given puzzle.
     */
    public static final int LENGTH_OF_BATTERY_COMBINATION = 12;
    private String bank;

    public BatteryBank(String bank) {
        this.bank = bank;
    }

    /**
     * Find the combination of 2 batteries in the given bank to produce the highest joltage rating.
     * @return the maximum joltage rating
     */
    public int getMaximumJoltageRating() {
        String maximumJoltageRating = getVariableLengthJoltageRating(0, 2);

        try {
            return Integer.parseInt(maximumJoltageRating);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Find the combination of the given number of batteries in the given bank to produce the highest joltage rating.
     * @param numberOfBatteries - The number of batteries to consider
     * @return the maximum joltage rating
     */
    public long getMaximumJoltageRating(int numberOfBatteries) {
        try {
            return Long.parseLong(getVariableLengthJoltageRating(0, numberOfBatteries));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Find the highest joltage rating for a combination of batteries starting at the given index and given the
     * required character length.
     *
     * @param startingIndex - The index of the first character in the bank to consider
     * @param charactersOfBankRequired - The amount of characters still required to build a valid bank
     * @return String containing a combination of batteries in a bank with the highest joltage rating
     */
    private String getVariableLengthJoltageRating(int startingIndex, int charactersOfBankRequired) {
        if (charactersOfBankRequired == 0 || this.bank.length() < charactersOfBankRequired) {
            return "";
        }

        var indexOFHighestJoltageFoundSoFar = 0;
        var highestJoltageFoundSoFar = 0;
        var numericValue = 0;
        for (int i = startingIndex; i <= (this.bank.length() - charactersOfBankRequired); i++) {
            numericValue = Character.getNumericValue(bank.charAt(i));
            if (numericValue > highestJoltageFoundSoFar) {
                indexOFHighestJoltageFoundSoFar = i;
                highestJoltageFoundSoFar = numericValue;
            }
        }

        return highestJoltageFoundSoFar + getVariableLengthJoltageRating(indexOFHighestJoltageFoundSoFar + 1, charactersOfBankRequired - 1);
    }
}
