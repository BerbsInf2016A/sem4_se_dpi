package primenumbers_i39.functions;

import primenumbers_i39.PrimeFactorization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupFunction {
    public static List<int[]> group(List<PrimeFactorization> data) {
        List<int[]> groupedData = new ArrayList<>();
        // Vorne 4 mal  18 (Faktor)
        // Sotierend Aufsteigend

        Map<Integer, Integer> counts = new HashMap<>();
        for (PrimeFactorization entry : data ) {
            for (int factor : entry.getFactors()) {
                if (!counts.containsKey(factor)) counts.put(factor, 1);
                else counts.put(factor, counts.get(factor) + 1);
            }
        }

        return order(counts);
    }

    private static List<int[]> order(Map<Integer, Integer> counts) {
        List<int[]> values = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet() ) {
            values.add(new int[]{entry.getValue(), entry.getKey()});
        }

        Comparator<int[]> comparator = Comparator.comparing(entry -> entry[0]);
        comparator = comparator.thenComparing(Comparator.comparing(entry -> entry[1]));

        List<int[]> test = values.stream().sorted(comparator).collect(Collectors.toList());
        return test;
    }
}
