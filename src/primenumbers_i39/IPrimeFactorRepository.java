package primenumbers_i39;

public interface IPrimeFactorRepository {
    PrimeFactorization getPrimeFactorization(int prime);

    void savePrimeFactorization(PrimeFactorization factorization);
}
