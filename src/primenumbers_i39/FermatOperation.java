package primenumbers_i39;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FermatOperation implements IPrimeFactorStrategy {

    @Override
    public List<PrimeFactorization> doOperation(int lowerLimit, int upperLimit) {
        ArrayList<PrimeFactorization> factorizations = new ArrayList<>();
        if (lowerLimit == 0 && upperLimit == 0) return factorizations;

        for (int i = lowerLimit; i <= upperLimit; i++) {
            factorizations.add(new PrimeFactorization(i,generatePrimeFactors(i)));
        }
        return factorizations;
    }

    private List<Integer> generatePrimeFactors(int number) {
        List<Integer> smallestFactors = new ArrayList<>();
        List<Integer> factors = this.applyFermat(number);
        if (factors.contains(1)) {
            // Smallest factor reached
            List<Integer> collect = factors.stream().filter(t -> t != 1).collect(Collectors.toList());
            smallestFactors.addAll(collect);
            return smallestFactors;
        } else {
            for (int factor : factors) {
                List<Integer> splittedFactors = this.generatePrimeFactors(factor);
                smallestFactors.addAll(splittedFactors);
            }
        }

        return smallestFactors;
    }

    private List<Integer> applyFermat(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        if (n % 2 == 0) {
            factors.add(2);
            factors.addAll(applyFermat(n / 2));
            return factors;
        }
        int a = (int) Math.ceil(Math.sqrt(n));
        int b = a * a - n;
        int b_root = (int) (Math.sqrt(b) + 0.5);
        while (b_root * b_root != b) {
            a++;
            b = a * a - n;
            b_root = (int) (Math.sqrt(b) + 0.5);
        }
        factors.add(a - b_root);
        factors.add(a + b_root);
        return factors;
    }

}
