package aoc2025.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test class for the BatteryBank class.
 */
public class BatteryBankTest {

    /**
     * Test case for an empty battery bank.
     * Verifies that the method returns 0 when no batteries are present.
     */
    @Test
    public void maximum_joltage_rating_for_empty_bank() {
        BatteryBank batteryBank = new BatteryBank("");
        int result = batteryBank.getMaximumJoltageRating();
        assertEquals(0, result, "Maximum joltage rating for an empty bank should be 0");
    }

    /**
     * Test case for a single battery in the bank.
     * Verifies that the method returns 0 as no pairs can be formed.
     */
    @Test
    public void maximum_joltage_rating_for_single_battery() {
        BatteryBank batteryBank = new BatteryBank("5");
        int result = batteryBank.getMaximumJoltageRating();
        assertEquals(5, result, "Maximum joltage rating of a single battery should be 5");
    }

    /**
     * Test case for a bank with two batteries.
     * Verifies that the method calculates the rating of the only possible pair.
     */
    @Test
    public void maximum_joltage_rating_for_two_batteries() {
        BatteryBank batteryBank = new BatteryBank("34");
        int result = batteryBank.getMaximumJoltageRating();
        assertEquals(34, result, "Maximum joltage rating should be the integer value of the two batteries combined");
    }

    /**
     * Test case for a bank with multiple batteries.
     * Verifies that the method correctly identifies and calculates the maximum joltage rating.
     */
    @Test
    public void maximum_joltage_rating_for_multiple_batteries() {
        BatteryBank batteryBank = new BatteryBank("98007600590011");
        int result = batteryBank.getMaximumJoltageRating();
        assertEquals(99, result, "Maximum joltage rating should be the highest possible value of any valid pair without rearranging batteries");
    }

    /**
     * Test case for a bank with only zero batteries.
     * Verifies that the method returns 0 when all batteries have zero value.
     */
    @Test
    public void maximum_joltage_rating_for_all_zero_batteries() {
        BatteryBank batteryBank = new BatteryBank("0000000");
        int result = batteryBank.getMaximumJoltageRating();
        assertEquals(0, result, "Maximum joltage rating for all zero batteries should be 0");
    }
}