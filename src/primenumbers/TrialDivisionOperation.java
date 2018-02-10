package primenumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrialDivisionOperation implements IPrimeFactorStrategy {
    private IPrimeFactorRepository repository;

    @Override
    public List<PrimeFactorization> doOperation(int lowerLimit, int upperLimit, IPrimeFactorRepository repository) {
        this.repository = repository;
        List<PrimeFactorization> factorizations = new LinkedList<>();
        for (long i = lowerLimit; i<= upperLimit; i++) {
            this.generateAndSavePrimeFactors(i);
            factorizations.add(this.repository.getPrimeFactorization(i));
        }
        return factorizations;
    }

    private List<Long> generateAndSavePrimeFactors(long number) {
        PrimeFactorization cachedValue = this.repository.getPrimeFactorization(number);
        if (cachedValue != null) return cachedValue.getFactors();

        List<Long> smallestFactors = new ArrayList<>();
        List<Long> factors = this.applyTrialDivision(number);
        if (factors.size() == 1) {
            // Smallest factor reached
            smallestFactors.add(factors.get(0));
            this.repository.savePrimeFactorization(new PrimeFactorization(number, smallestFactors));
            return smallestFactors;
        } else {
            for (long factor : factors) {
                List<Long> splittedFactors = this.generateAndSavePrimeFactors(factor);
                smallestFactors.addAll(splittedFactors);
            }
        }

        this.repository.savePrimeFactorization(new PrimeFactorization(number, smallestFactors));
        return smallestFactors;
    }

    private List<Long> applyTrialDivision(long number) {
        List<Long> results = new ArrayList<>();
        long factor = 2;
        while(number > 1){
            if (number % factor == 0){
                results.add(factor);
                number = number / factor;
            } else{
                factor += 1;
            }
        }
        return results;
    }
}
