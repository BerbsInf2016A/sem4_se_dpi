package task39;

import java.util.List;
import java.util.stream.Collectors;
// TODO: Negative values in the strategy range!
/**
 * A class to store a number and it prime factorization.
 */
public class PrimeFactorization {

    /**
     * The number to factorize.
     */
    private int number;

    /**
     * The prime factors of the number.
     */
    private List<Integer> factors;

    /**
     * Constructor for the PrimeFactorization class.
     *
     * @param number The number which is factorized.
     * @param factorization The prime factors of the number.
     */
    public PrimeFactorization(int number, List<Integer> factorization) {
        this.number = number;
        this.factors = factorization.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Get the number.
     *
     * @return The number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Get the factors of the number.
     *
     * @return The factors of the number.
     */
    public List<Integer> getFactors() {
        return factors;
    }
}
