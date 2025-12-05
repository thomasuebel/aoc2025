package aoc2025.day2;

public class ID {
    String id;

    // regular expression for invalid ids - i.e. ids that are made only of some sequence of digits repeated twice
    private static final String A_SINGLE_DIGIT_REPEATED_ONCE = "(.+?)\\1";

    public ID(String id) {
        this.id = id;
    }

    public boolean isValid() {
        return !isInvalid();
    }

    // Since the young Elf was just doing silly patterns, you can find the invalid IDs by looking for any ID
    // which is made only of some sequence of digits repeated twice. So, 55 (5 twice), 6464 (64 twice), and
    // 123123 (123 twice) would all be invalid IDs.
    // None of the numbers have leading zeroes; 0101 isn't an ID at all. (101 is a valid ID that you would ignore.)
    public boolean isInvalid() {
        return id.startsWith("0") || id.matches(A_SINGLE_DIGIT_REPEATED_ONCE);
    }
}
