package aoc2025;

import aoc2025.day1.Turn;
import aoc2025.day1.Dial;
import aoc2025.day2.Range;
import aoc2025.util.RangesFile;
import aoc2025.util.TurnsFile;

import java.util.List;

public class Main {
    static void main() {
        List<String> turns = TurnsFile.readFrom("input.txt");
        final Dial safeDial = new Dial(50);

        for (String t : turns) {
            safeDial.turn(new Turn(t));
        }

        System.out.println("Dial positions zero-at-rest: " + safeDial.getZeroPositionsAfterCompletedTurn());
        System.out.println("Dial wraparounds: " + safeDial.getWraparounds());

        List<String> ranges = RangesFile.readFrom("day2_input.txt");
        long sumOfInvalidIdsInRanges = ranges.stream().map(Range::from).mapToLong(Range::getSumOfAllInvalidIds).sum();

        System.out.println("Sum of invalid ranges: " + sumOfInvalidIdsInRanges);

    }

}

