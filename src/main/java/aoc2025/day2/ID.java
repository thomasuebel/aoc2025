package aoc2025.day2;

public class ID {
    String id;

    public ID(String id) {
        this.id = id;
    }

    public boolean isValid() {
        return !isInvalid();
    }

    // Since the young Elf was just doing silly patterns, you can find the invalid IDs by looking for any ID
    // which is made only of some sequence of digits repeated twice. So, 55 (5 twice), 6464 (64 twice), and
    // 123123 (123 twice) would all be invalid IDs.
    public boolean isInvalid() {
        return false;
    }

}
