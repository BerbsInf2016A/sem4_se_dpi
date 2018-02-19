package task39.filter;

import task39.PrimeFactorization;

import java.util.List;

/**
 * Interface for  prime factorization filters.
 */
public interface IPrimeFactorizationFilter {
    /**
     * Execute the filter operation.
     *
     * @param objects The list of objects, which should be filtered.
     * @return A list with the objects, which match the filter criteria.
     */
    List<PrimeFactorization> filterObjects(List<PrimeFactorization> objects);
}
