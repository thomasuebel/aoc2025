package aoc2025;

import aoc2025.day1.Turn;
import aoc2025.day1.Dial;
import aoc2025.day2.Range;
import aoc2025.day3.BatteryBank;
import aoc2025.day4.PaperGrid;
import aoc2025.day5.IngredientRange;
import aoc2025.util.RangesFile;
import aoc2025.util.LinesBasedInputResourceFile;

import java.awt.print.Paper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Long.sum;

public class Main {
    static void main() {
        // Day 1
        List<String> turns = LinesBasedInputResourceFile.readFrom("input.txt");
        final Dial safeDial = new Dial(50);
        for (String t : turns) {
            safeDial.turn(new Turn(t));
        }
        System.out.println("Dial positions zero-at-rest: " + safeDial.getZeroPositionsAfterCompletedTurn());
        System.out.println("Dial wraparounds: " + safeDial.getWraparounds());

        // Day 2
        List<String> ranges = RangesFile.readFrom("day2_input.txt");
        long sumOfInvalidIdsInRanges = ranges.stream().map(Range::from).mapToLong(Range::getSumOfAllInvalidIds).sum();
        System.out.println("Sum of invalid ranges: " + sumOfInvalidIdsInRanges);

        // Day 3
        List<String> banks = LinesBasedInputResourceFile.readFrom("day3_input.txt");
        int combinedTwoBatteriesJoltage = banks.stream()
                .map(BatteryBank::new)
                .mapToInt(BatteryBank::getMaximumJoltageRating)
                .sum();
        System.out.println("Combined joltage rating: " + combinedTwoBatteriesJoltage);
        // Day 3 - part 2
        var combinedTwelveBatteriesJoltage = banks.stream()
                .map(BatteryBank::new)
                .mapToLong(b -> b.getMaximumJoltageRating(12))
                .sum();
        System.out.println("Combined joltage rating: " + combinedTwelveBatteriesJoltage);

        // Day4
        PaperGrid paperGrid = PaperGrid.fromLines(
                LinesBasedInputResourceFile.readFrom("day4_input.txt"));
        System.out.println("Number of accessible positions: " + paperGrid.getAccessibleCount());

        // Day 4 - part 2
        System.out.println("Number of cleaned up paper rolls: " + paperGrid.cleanUp());

        // Day 5
        var lines = LinesBasedInputResourceFile.readFrom("day5_input.txt");
        var freshIngredientRanges = lines.stream()
                .map(IngredientRange::from)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        var ingredients = lines.stream()
                .filter(l -> !l.contains("-"))
                .mapToLong(Long::parseLong)
                .boxed()
                .toList();

        int freshIngredientsCount = 0;
        for (var ingredient : ingredients) {
            if (freshIngredientRanges.stream().anyMatch(r -> r.contains(ingredient))) {
                freshIngredientsCount++;
            }
        }

        System.out.println("Number of fresh ingredients: " + freshIngredientsCount);

    }

}

