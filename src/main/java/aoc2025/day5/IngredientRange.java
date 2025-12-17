package aoc2025.day5;

import java.util.Optional;

public class IngredientRange {
    long from;
    long to;

    private IngredientRange() {}

    public static Optional<IngredientRange> from(String range) {
        IngredientRange rangeObject = new IngredientRange();
        String[] ids = range.split("-");
        if (ids.length != 2) {
            return Optional.empty();
        }

        rangeObject.from = Long.parseLong(ids[0]);
        rangeObject.to = Long.parseLong(ids[1]);
        return Optional.of(rangeObject);
    }

    public boolean contains(long value) {
        return value >= from && value <= to;
    }

    public long getFreshIngredientsCount() {
        return to - from + 1 ; // inclusive range
    }
}
