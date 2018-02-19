package primenumbers_i39;

import java.util.List;

public class Context {
    private IPrimeFactorStrategy strategy;

    public Context(IPrimeFactorStrategy strategy) {
        this.strategy = strategy;
    }

    public List<PrimeFactorization> executeStrategy(int lowerBound, int upperBound) {
        return this.strategy.doOperation(lowerBound, upperBound);
    }
}
