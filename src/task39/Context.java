package task39;

import java.util.List;

/**
 * Context for a search strategy.
 */
public class Context {
    /**
     * The search strategy which should be executed.
     */
    private IPrimeFactorStrategy strategy;

    /**
     * Constructor for the Context.
     *
     * @param strategy The strategy which should be used.
     */
    public Context(IPrimeFactorStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Execute the strategy.
     *
     * @param lowerBound The lower bound for the strategy.
     * @param upperBound The upper bound for the strategy.
     * @return A list, containing the results of the executed strategy.
     */
    public List<PrimeFactorization> executeStrategy(int lowerBound, int upperBound) {
        return this.strategy.doOperation(lowerBound, upperBound);
    }
}
