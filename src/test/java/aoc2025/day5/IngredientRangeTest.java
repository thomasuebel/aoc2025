package aoc2025.day5;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IngredientRangeTest {

    /**
     * Test to verify that a value within the range is correctly identified as being contained.
     */
    @Test
    void value_within_range() {
        IngredientRange range = IngredientRange.from("10-20").orElseThrow();
        assertTrue(range.contains(15), "Value 15 should be within the range [10, 20].");
    }

    /**
     * Test to verify that the lower boundary of the range is correctly included.
     */
    @Test
    void value_at_lower_boundary() {
        IngredientRange range = IngredientRange.from("10-20").orElseThrow();
        assertTrue(range.contains(10), "Value 10 should be within the range [10, 20].");
    }

    /**
     * Test to verify that the upper boundary of the range is correctly included.
     */
    @Test
    void value_at_upper_boundary() {
        IngredientRange range = IngredientRange.from("10-20").orElseThrow();
        assertTrue(range.contains(20), "Value 20 should be within the range [10, 20].");
    }

    /**
     * Test to verify that a value below the range is correctly identified as not being contained.
     */
    @Test
    void value_below_range() {
        IngredientRange range = IngredientRange.from("10-20").orElseThrow();
        assertFalse(range.contains(5), "Value 5 should not be within the range [10, 20].");
    }

    /**
     * Test to verify that a value above the range is correctly identified as not being contained.
     */
    @Test
    void value_above_range() {
        IngredientRange range = IngredientRange.from("10-20").orElseThrow();
        assertFalse(range.contains(25), "Value 25 should not be within the range [10, 20].");
    }

    /**
     * Test to verify that a single-point range only includes that point.
     */
    @Test
    void single_point_range() {
        IngredientRange range = IngredientRange.from("10-10").orElseThrow();
        assertTrue(range.contains(10), "Value 10 should be within the range [10, 10].");
        assertFalse(range.contains(9), "Value 9 should not be within the range [10, 10].");
        assertFalse(range.contains(11), "Value 11 should not be within the range [10, 10].");
    }

    @Test
    void invalid_ingredient_range() {
        assertThrows(NoSuchElementException.class, () -> IngredientRange.from("10").orElseThrow());
    }

    /**
     * Test to verify the correct calculation of fresh ingredients for a valid range.
     */
    @Test
    void calculate_fresh_ingredients_for_valid_range() {
        IngredientRange range = IngredientRange.from("10-20").orElseThrow();
        assertEquals(11, range.getFreshIngredientsCount(), "Fresh ingredients count should be 10 for range [10, 20].");
    }

    /**
     * Test to verify the correct calculation of fresh ingredients for a single-point range.
     */
    @Test
    void calculate_fresh_ingredients_for_single_point_range() {
        IngredientRange range = IngredientRange.from("10-10").orElseThrow();
        assertEquals(1, range.getFreshIngredientsCount(), "Fresh ingredients count should be 0 for a single-point range [10, 10].");
    }
}