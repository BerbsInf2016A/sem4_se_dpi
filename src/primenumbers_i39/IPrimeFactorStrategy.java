package primenumbers_i39;

import java.util.List;

public interface IPrimeFactorStrategy {
    List<PrimeFactorization> doOperation(int lowerLimit, int upperLimit, IPrimeFactorRepository repository);
}
