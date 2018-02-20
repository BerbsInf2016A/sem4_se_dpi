package task39;

import java.util.List;

/**
 * Interface for strategies to generate prime factorizations for numbers in a given range.
 */
public interface IPrimeFactorStrategy {

    /**
     * Execute the strategy.
     *
     * @param lowerLimit The lower limit of the range.
     * @param upperLimit The upper limit of the range.
     * @return A list containing the prime factorizations in the given range.
     */
    List<PrimeFactorization> doOperation(int lowerLimit, int upperLimit);
}
