package aoc2025.day2;

public class ID {
    String id;

    /**
     * Since the young Elf was just doing silly patterns, you can find the invalid IDs by looking for any ID
     * which is made only of some sequence of digits repeated twice. So, 55 (5 twice), 6464 (64 twice), and
     * 123123 (123 twice) would all be invalid IDs.
     */
    private static final String A_SINGLE_DIGIT_REPEATED_ONCE = "(d+?)\\1";

    /**
     *  Now, an ID is invalid if it is made only of some sequence of digits repeated at least twice.
     *  So, 12341234 (1234 two times), 123123123 (123 three times), 1212121212 (12 five times), and
     *  1111111 (1 seven times) are all invalid IDs.
     */
    private static final String REPEATED_DIGIT_SEQUENCE = "^(\\d+?)\\1+$";

    public ID(String id) {
        this.id = id;
    }

    public boolean isValid() {
        return !isInvalid();
    }

    public boolean isInvalid() {
        return id.startsWith("0") || id.matches(REPEATED_DIGIT_SEQUENCE);
    }

    public Long asLong() {
        return Long.parseLong(id);
    }

    public String toString() {
        return this.id;
    }
}
