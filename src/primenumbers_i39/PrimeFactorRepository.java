package primenumbers_i39;

import java.util.HashMap;
import java.util.Map;

public class PrimeFactorRepository implements IPrimeFactorRepository {
    private Map<Integer, PrimeFactorization> primeFactorizations = new HashMap<>();

    @Override
    public PrimeFactorization getPrimeFactorization(int value) {
        return this.primeFactorizations.get(value);
    }

    @Override
    public void savePrimeFactorization(PrimeFactorization factorization) {
        this.primeFactorizations.put(factorization.getNumber(), factorization);
    }

}
