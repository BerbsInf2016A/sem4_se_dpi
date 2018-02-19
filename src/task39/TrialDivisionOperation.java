package task39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrialDivisionOperation implements IPrimeFactorStrategy {

    @Override
    public List<PrimeFactorization> doOperation(int lowerLimit, int upperLimit) {
        List<PrimeFactorization> factorizations = new LinkedList<>();
        if (lowerLimit == 0 && upperLimit == 0) return factorizations;

        for (int i = lowerLimit; i <= upperLimit; i++) {
            factorizations.add(new PrimeFactorization(i, this.generatePrimeFactors(i)));
        }
        return factorizations;
    }

    private List<Integer> generatePrimeFactors(int number) {

        List<Integer> smallestFactors = new ArrayList<>();
        List<Integer> factors = this.applyTrialDivision(number);
        if (factors.size() == 1) {
            // Smallest factor reached
            smallestFactors.add(factors.get(0));
            return smallestFactors;
        } else {
            for (int factor : factors) {
                List<Integer> splittedFactors = this.generatePrimeFactors(factor);
                smallestFactors.addAll(splittedFactors);
            }
        }

        return smallestFactors;
    }

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
