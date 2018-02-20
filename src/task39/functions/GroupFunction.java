package task39.functions;

import task39.PrimeFactorization;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A function to group the prime factors by their count of occurrences.
 */
public class GroupFunction {
    /**
     * Group the prime factors by their count and sort them by the number of
     * their occurrences.
     *
     * @param data The data to group.
     * @return A list with the grouped entries. The first entry in the array is the number of occurrences,
     * the second entry is the prime factor.
     */
    public static List<int[]> group(List<PrimeFactorization> data) {
        // Count the prime factors.
        Map<Integer, Integer> counts = new HashMap<>();
        for (PrimeFactorization entry : data) {
            for (int factor : entry.getFactors()) {
                if (!counts.containsKey(factor)) counts.put(factor, 1);
                else counts.put(factor, counts.get(factor) + 1);
            }
        }

        return createOrderedList(counts);
    }

    /**
     * Takes a map and creates a ordered list of integer arrays.
     *
     * @param counts A map with a prime factor as key and the count of the prime factor as value.
     * @return A list of integer arrays. The first entry is the count and the second entry is the
     * prime factor.
     */
    private static List<int[]> createOrderedList(Map<Integer, Integer> counts) {
        List<int[]> values = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            values.add(new int[]{entry.getValue(), entry.getKey()});
        }

        Comparator<int[]> comparator = Comparator.comparing(entry -> entry[0]);
        comparator = comparator.thenComparing(Comparator.comparing(entry -> entry[1]));

        List<int[]> test = values.stream().sorted(comparator).collect(Collectors.toList());
        return test;
    }
}
