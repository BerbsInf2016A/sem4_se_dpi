package primenumbers;

import java.util.List;
import java.util.stream.Collectors;

public class PrimeFactorization {

    private long number;
    private List<Long> factors;

    public PrimeFactorization(long number, List<Long> factorization) {
        this.number = number;
        this.factors = factorization.stream().sorted().collect(Collectors.toList());
    }

    public long getNumber() {
        return number;
    }

    public List<Long> getFactors() {
        return factors;
    }
}
