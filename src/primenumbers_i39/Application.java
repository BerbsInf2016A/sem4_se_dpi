package primenumbers_i39;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Context context = new Context(new FermatOperation());
        List<PrimeFactorization> factorizationsFermat = context.executeStrategy(10, 1000);
    }
}
