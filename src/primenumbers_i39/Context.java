package primenumbers_i39;

import java.util.List;

public class Context {
    private IPrimeFactorStrategy strategy;
    private IPrimeFactorRepository repository;

    public Context(IPrimeFactorStrategy strategy) {
        this.strategy = strategy;
        this.repository = new PrimeFactorRepository();
    }

    public List<PrimeFactorization> executeStrategy(int lowerBound, int upperBound) {
        return this.strategy.doOperation(lowerBound, upperBound, this.repository);
    }
}
