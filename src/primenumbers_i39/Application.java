package primenumbers_i39;

import java.util.List;

import static primenumbers_i39.filter.TwinFilter.twin;
import static primenumbers_i39.functions.CompressFunction.compress;
import static primenumbers_i39.functions.CountFunction.count;

public class Application {
    public static void main(String[] args) {
        Context context = new Context(new FermatOperation());
        List<PrimeFactorization> factorizationsFermat = context.executeStrategy(10, 1000);
        int g = count(twin(factorizationsFermat));
        List<String> compressed = compress(twin(factorizationsFermat));
        compressed.forEach(t -> System.out.println(t));
    }
}
