package primenumbers;

public interface IPrimeFactorRepository {
    PrimeFactorization getPrimeFactorization(long prime);
    void savePrimeFactorization(PrimeFactorization factorization);
}
