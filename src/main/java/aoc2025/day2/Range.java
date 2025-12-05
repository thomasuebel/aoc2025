package aoc2025.day2;

import java.util.ArrayList;
import java.util.List;

public class Range {
    ID from;
    ID to;

    protected Range(ID from, ID to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Create a Range from a String consisting of two IDs separated by a dash
     * @param range the range string
     * @return a new Range
     */
    public static Range from(String range) {
        String[] ids = range.split("-");
        return new Range(new ID(ids[0]), new ID(ids[1]));
    }

    public List<ID> getIdsInRange() {
        List<ID> idsInRange = new ArrayList<>();
        for (long i = from.asLong(); i <= to.asLong(); i++) {
            idsInRange.add(new ID(String.valueOf(i)));
        }

        return idsInRange;
    }

    public List<ID> getAllInvalidIds() {
        return getIdsInRange().stream(). filter(ID::isInvalid).toList();
    }

    public Long getSumOfAllInvalidIds() {
        return getAllInvalidIds().stream().mapToLong(ID::asLong).sum();
    }

}
