package aoc2025.day1;

import aoc2025.util.TurnsFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> turns = TurnsFile.readFrom("input.txt");

        final Dial safeDial = new Dial(50);
        int zeroCount = 0;

        for (String t : turns) {
            safeDial.turn(new Turn(t));
            if (safeDial.getPosition() == 0) {
                zeroCount++;
            }
        }

        System.out.println(zeroCount);
    }
}

