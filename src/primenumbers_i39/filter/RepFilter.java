package primenumbers_i39.filter;

import primenumbers_i39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepFilter implements IPrimeFactorizationFilter {
    static RepFilter instance = new RepFilter();
    @Override
    public List<PrimeFactorization> filterObjects(List<PrimeFactorization> data) {
        List<PrimeFactorization> filteredData = new ArrayList<>();

        for (PrimeFactorization entry : data ) {
            Map<Integer, Long> counted = entry.getFactors().stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            for (Map.Entry count : counted.entrySet()) {
                if ((long)count.getValue() >= 3L) {
                    filteredData.add(entry);
                    break;
                }
            }
        }

        return filteredData;
    }

    public static List<PrimeFactorization> rep(List<PrimeFactorization> data) {
       return RepFilter.instance.filterObjects(data);
    }
}
