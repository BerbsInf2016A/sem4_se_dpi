package primenumbers_i39.filter;

import primenumbers_i39.PrimeFactorization;

import java.util.List;

public interface IPrimeFactorizationFilter {
    List<PrimeFactorization> filterObjects(List<PrimeFactorization> objects);
}
