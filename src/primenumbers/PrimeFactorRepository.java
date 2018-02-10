package primenumbers;

import java.util.HashMap;
import java.util.Map;

public class PrimeFactorRepository implements IPrimeFactorRepository {
    private Map<Long, PrimeFactorization> primeFactorizations = new HashMap<>();

    @Override
    public PrimeFactorization getPrimeFactorization(long value) {
        return this.primeFactorizations.get(value);
    }

    @Override
    public void savePrimeFactorization(PrimeFactorization factorization) {
        this.primeFactorizations.put(factorization.getNumber(), factorization);
    }

}
