package aoc2025.day3;

/**
 * The Battery Bank
 * is represented as a string of digits between 0 and 9. Each digit
 * represents a battery in that bank with its joltage rating. Eg.
 * 98007600590011
 *
 * The BatteryBank provides a method to calculate a combination of
 * any two batteries that can be used to create a maximum joltage rating
 * without rearranging the batteries.
 * In the above example the batteries at index position 0 and index position 9
 * would create a joltage rating of 99 - the highesst possible rating in this bank.
 */
public class BatteryBank {
    private String bank;

    public BatteryBank(String bank) {
        this.bank = bank;
    }

    public int getMaximumJoltageRating() {
        return 0;
    }
}
