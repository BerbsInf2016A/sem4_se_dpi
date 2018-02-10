package primenumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FermatOperation implements IPrimeFactorStrategy{
    private IPrimeFactorRepository repository;
    @Override
    public List<PrimeFactorization> doOperation(int lowerLimit, int upperLimit, IPrimeFactorRepository repository) {
        this.repository = repository;
        ArrayList<PrimeFactorization> factorizations = new ArrayList<>();
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
        List<Long> factors = this.applyFermat(number);
        if ( factors.contains(1L)) {
            // Smallest factor reached
            List<Long> collect = factors.stream().filter(t -> t != 1L).collect(Collectors.toList());
            smallestFactors.addAll(collect);
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

    private List<Long> applyFermat(long  n) {
        ArrayList<Long> factors = new ArrayList<>();
        if (n % 2 == 0){
            factors.add(2L);
            factors.addAll(applyFermat(n / 2));
            return factors;
        }
        long  a = (long)Math.ceil(Math.sqrt(n));
        long  b = a*a - n;
        long  b_root = (long)(Math.sqrt(b)+0.5);
        while(b_root*b_root != b)
        {
            a++;
            b = a*a - n;
            b_root = (int)(Math.sqrt(b)+0.5);
        }
        factors.add(a-b_root);
        factors.add(a+b_root);
        return factors;
    }

}
