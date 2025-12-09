package aoc2025.day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    public void maximum_joltage_rating_for_two_batteries() {
        BatteryBank batteryBank = new BatteryBank("45");
        int result = batteryBank.getMaximumJoltageRating();
        assertEquals(45, result);
    }

    /**
     * Test case for a bank with two batteries.
     * Verifies that the method calculates the rating of the only possible pair.
     */
    @Test
    public void maximum_joltage_rating_for_three_batteries() {
        BatteryBank batteryBank = new BatteryBank("345");
        int result = batteryBank.getMaximumJoltageRating();
        assertEquals(45, result, "Maximum joltage rating should be the integer value of the two batteries combined");
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

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
        "987654321111111, 98",
        "811111111111119, 89",
        "234234234234278, 78",
        "818181911112111, 92"
    })
    void test_two_battery_combination(String input, int expected) {
        BatteryBank batteryBank = new BatteryBank(input);
        assertEquals(expected, batteryBank.getMaximumJoltageRating());
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "987654321111111, 987654321111",
            "811111111111119, 811111111119",
            "234234234234278, 434234234278",
            "818181911112111, 888911112111"
    })
    void test_12_batteries_combination(String input, long expected) {
        BatteryBank batteryBank = new BatteryBank(input);
        assertEquals(expected, batteryBank.getMaximumJoltageRating(12));
    }
}