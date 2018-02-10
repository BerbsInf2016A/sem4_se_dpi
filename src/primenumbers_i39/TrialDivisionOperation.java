package primenumbers_i39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrialDivisionOperation implements IPrimeFactorStrategy {
    private IPrimeFactorRepository repository;

    @Override
    public List<PrimeFactorization> doOperation(int lowerLimit, int upperLimit, IPrimeFactorRepository repository) {
        this.repository = repository;
        List<PrimeFactorization> factorizations = new LinkedList<>();
        if(lowerLimit == 0 && upperLimit == 0) return factorizations;

        for (int i = lowerLimit; i <= upperLimit; i++) {
            this.generateAndSavePrimeFactors(i);
            factorizations.add(this.repository.getPrimeFactorization(i));
        }
        return factorizations;
    }

    private List<Integer> generateAndSavePrimeFactors(int number) {
        PrimeFactorization cachedValue = this.repository.getPrimeFactorization(number);
        if (cachedValue != null) return cachedValue.getFactors();

        List<Integer> smallestFactors = new ArrayList<>();
        List<Integer> factors = this.applyTrialDivision(number);
        if (factors.size() == 1) {
            // Smallest factor reached
            smallestFactors.add(factors.get(0));
            this.repository.savePrimeFactorization(new PrimeFactorization(number, smallestFactors));
            return smallestFactors;
        } else {
            for (int factor : factors) {
                List<Integer> splittedFactors = this.generateAndSavePrimeFactors(factor);
                smallestFactors.addAll(splittedFactors);
            }
        }

        this.repository.savePrimeFactorization(new PrimeFactorization(number, smallestFactors));
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
