package aoc2025;

import aoc2025.day1.Turn;
import aoc2025.day1.Dial;
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
    }
}

