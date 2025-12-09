package aoc2025;

import aoc2025.day1.Turn;
import aoc2025.day1.Dial;
import aoc2025.day2.Range;
import aoc2025.day3.BatteryBank;
import aoc2025.util.RangesFile;
import aoc2025.util.LinesBasedInputResourceFile;

import java.util.List;

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
        int combinedJoltageRating = banks.stream().map(BatteryBank::new).mapToInt(BatteryBank::getMaximumJoltageRating).sum();
        System.out.println("Combined joltage rating: " + combinedJoltageRating);
    }

}

