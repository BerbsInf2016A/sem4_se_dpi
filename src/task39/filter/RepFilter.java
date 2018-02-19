package task39.filter;

import task39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The RepFilter filters out all entries, which do not meet the following condition:
 * A prime factor must be at least 3 times in the factorization.
 */
public class RepFilter implements IPrimeFactorizationFilter {
    /**
     * A static instance of this filter, to enable the use of this filter with the following pattern:
     * rep(data) instead of:
     * RepFilter rep = new RepFilter();
     * rep.filterObjects(data).
     */
    static RepFilter instance = new RepFilter();

    /**
     * Static method to filter out all entries, which do not meet the following condition:
     * A prime factor must be at least 3 times in the factorization.
     *
     * @param data The data to filter.
     * @return All entries in the data, which meet the filter criteria.
     */
    public static List<PrimeFactorization> rep(List<PrimeFactorization> data) {
        return RepFilter.instance.filterObjects(data);
    }

    /**
     * Execute the filter to filter out all entries, which do not meet the following condition:
     * A prime factor must be at least 3 times in the factorization.
     *
     * @param data The data to filter.
     * @return All entries in the data, which meet the filter criteria.
     */
    @Override
    public List<PrimeFactorization> filterObjects(List<PrimeFactorization> data) {
        List<PrimeFactorization> filteredData = new ArrayList<>();

        for (PrimeFactorization entry : data) {
            Map<Integer, Long> counted = entry.getFactors().stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            for (Map.Entry count : counted.entrySet()) {
                if ((long) count.getValue() >= 3L) {
                    filteredData.add(entry);
                    break;
                }
            }
        }

        return filteredData;
    }
}
