package task39;

import java.util.ArrayList;
import java.util.List;

/**
 * Strategy using TrialDivision to generate prime factors.
 */
public class TrialDivisionOperation implements IPrimeFactorStrategy {

    /**
     * Execute the strategy to generate the prime factors for all numbers in the range.
     *
     * @param lowerLimit The lower limit of the range.
     * @param upperLimit The upper limit of the range.
     * @return A list containing the prime factorizations.
     */
    @Override
    public List<PrimeFactorization> doOperation(int lowerLimit, int upperLimit) {
        List<PrimeFactorization> factorizations = new ArrayList<>();
        if (lowerLimit > upperLimit || lowerLimit < 0) return factorizations;
        if (lowerLimit == 0 && upperLimit == 0) return factorizations;

        for (int i = lowerLimit; i <= upperLimit; i++) {
            factorizations.add(new PrimeFactorization(i, this.generatePrimeFactors(i)));
        }
        return factorizations;
    }

    /**
     * Generate the prime factors for a number.
     *
     * @param number The number to generate the prime factors for.
     * @return A list containing the prime factors for the given number.
     */
    private List<Integer> generatePrimeFactors(int number) {

        List<Integer> smallestFactors = new ArrayList<>();
        List<Integer> factors = this.applyTrialDivision(number);
        if (factors.size() == 1) {
            // Smallest factor reached
            smallestFactors.add(factors.get(0));
            return smallestFactors;
        } else {
            for (int factor : factors) {
                List<Integer> dividedFactors = this.generatePrimeFactors(factor);
                smallestFactors.addAll(dividedFactors);
            }
        }

        return smallestFactors;
    }

    /**
     * Apply the TrialDivision operation to a given number.
     *
     * @param number The number to apply Fermat on.
     * @return A list of factors for the given number.
     */
    private List<Integer> applyTrialDivision(int number) {
        List<Integer> results = new ArrayList<>();
        int factor = 2;
        while (number > 1) {
            if (number % factor == 0) {
                results.add(factor);
                number = number / factor;
            } else {
                factor += 1;
            }
        }
        return results;
    }
}
