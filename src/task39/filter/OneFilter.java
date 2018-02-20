package task39.filter;

import task39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

/**
 * The OneFilter filters out all entries, which do not meet the following condition:
 * The difference between the smallest prime factor and the biggest prime factor must be 1.
 */
public class OneFilter implements IPrimeFactorizationFilter {
    /**
     * A static instance of this filter, to enable the use of this filter with the following pattern:
     * one(data) instead of:
     * OneFilter one = new OneFilter();
     * one.filterObjects(data).
     */
    static final OneFilter instance = new OneFilter();

    /**
     * Static method to filter out all entries, which do not meet the following condition:
     * The difference between the smallest prime factor and the biggest prime factor must be 1.
     *
     * @param data The data to filter.
     * @return All entries in the data, which meet the filter criteria.
     */
    public static List<PrimeFactorization> one(List<PrimeFactorization> data) {
        return OneFilter.instance.filterObjects(data);
    }

    /**
     * Execute the filter to filter out all entries, which do not meet the following condition:
     * The difference between the smallest prime factor and the biggest prime factor must be 1.
     *
     * @param data The data to filter.
     * @return All entries in the data, which meet the filter criteria.
     */
    @Override
    public List<PrimeFactorization> filterObjects(List<PrimeFactorization> data) {
        List<PrimeFactorization> filteredData = new ArrayList<>();
        for (PrimeFactorization entry : data) {
            if (entry.getFactors().size() >= 2) {
                List<Integer> factors = entry.getFactors();
                if (minMaxDifferenceIsOne(factors.get(0), factors.get(factors.size() - 1))) {
                    filteredData.add(entry);
                }
            }
        }
        return filteredData;
    }

    /**
     * Checks if the difference between the minimum and the maximum is one.
     *
     * @param min The minimum.
     * @param max The maximum.
     * @return True, if the difference is 1, false if not.
     */
    boolean minMaxDifferenceIsOne(int min, int max) {
        return max - min == 1;
    }
}
