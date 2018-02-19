package task39.functions;

import task39.PrimeFactorization;

import java.util.List;

/**
 * A function to count the entries in a list of PrimeFactorizations.
 */
public class CountFunction {
    /**
     * Get the count of entries in the given list.
     *
     * @param data The list of PrimeFactorizations to count.
     * @return The count of entries.
     */
    public static int count(List<PrimeFactorization> data) {
        return data.size();
    }
}
