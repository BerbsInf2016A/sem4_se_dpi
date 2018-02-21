package task39.filter;

import task39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

/**
 * The TwinFilter filters out all entries, which do not meet the following condition:
 * The difference between two prime factors must be 2.
 */
public class TwinFilter implements IPrimeFactorizationFilter {
    /**
     * A static instance of this filter, to enable the use of this filter with the following pattern:
     * twin(data) instead of:
     * TwinFilter twin = new TwinFilter();
     * twin.filterObjects(data).
     */
    private static final TwinFilter instance = new TwinFilter();

    /**
     * Static method to filter out all entries, which do not meet the following condition:
     * The difference between two prime factors must be 2.
     *
     * @param data The data to filter.
     * @return All entries in the data, which meet the filter criteria.
     */
    public static List<PrimeFactorization> twin(List<PrimeFactorization> data) {
        return TwinFilter.instance.filterObjects(data);
    }

    /**
     * Execute the filter to filter out all entries, which do not meet the following condition:
     * The difference between two prime factors must be 2.
     *
     * @param data The data to filter.
     * @return All entries in the data, which meet the filter criteria.
     */
    @Override
    public List<PrimeFactorization> filterObjects(List<PrimeFactorization> data) {
        List<PrimeFactorization> filteredData = new ArrayList<>();

        for (PrimeFactorization entry : data) {
            int previousValue = -1;
            for (int factor : entry.getFactors()) {
                if (previousValue != -1) {
                    if (factor - previousValue == 2) {
                        filteredData.add(entry);
                        break;
                    }
                }
                previousValue = factor;
            }
        }

        return filteredData;
    }
}
