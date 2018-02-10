package primenumbers_i39;

import java.util.List;
import java.util.stream.Collectors;

public class PrimeFactorization {

    private int number;
    private List<Integer> factors;

    public PrimeFactorization(int number, List<Integer> factorization) {
        this.number = number;
        this.factors = factorization.stream().sorted().collect(Collectors.toList());
    }

    public int getNumber() {
        return number;
    }

    public List<Integer> getFactors() {
        return factors;
    }
}
