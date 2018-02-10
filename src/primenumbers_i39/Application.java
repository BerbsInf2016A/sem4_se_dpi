package primenumbers_i39;

import java.util.Arrays;
import java.util.List;

import static primenumbers_i39.filter.OneFilter.one;
import static primenumbers_i39.filter.RepFilter.rep;
import static primenumbers_i39.filter.TwinFilter.twin;
import static primenumbers_i39.functions.CompressFunction.compress;
import static primenumbers_i39.functions.CountFunction.count;
import static primenumbers_i39.functions.GroupFunction.group;

public class Application {
    public static void main(String[] args) {
        Context fermatContext = new Context(new FermatOperation());
        List<PrimeFactorization> factorizationsFermat = fermatContext.executeStrategy(10, 1000);
        List<PrimeFactorization> fermatTwins = twin(factorizationsFermat);
        List<PrimeFactorization> fermatRep = rep(factorizationsFermat);
        List<PrimeFactorization> fermatOne = one(factorizationsFermat);

        System.out.println("Fermat-Strategy: Twins: Count: " + count(fermatTwins));
        System.out.println("Fermat-Strategy: Rep: Count: " + count(fermatRep));
        System.out.println("Fermat-Strategy: One: Count: " + count(fermatOne));

        System.out.println("Fermat-Strategy: Twins --> grouped ");
        List<int[]> fermatGroups = group(fermatTwins);
        fermatGroups.forEach(t -> System.out.println("----" + Arrays.toString(t)));

        System.out.println("Fermat-Strategy: Twins --> compress ");
        List<String> fermatCompress = compress(fermatTwins);
        fermatCompress.forEach(t -> System.out.println("----" + t));

        Context trialContext = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> factorizationsTrial = trialContext.executeStrategy(10, 1000);
        List<PrimeFactorization> trialTwins = twin(factorizationsTrial);
        List<PrimeFactorization> trialRep = rep(factorizationsTrial);
        List<PrimeFactorization> trialOne = one(factorizationsTrial);

        System.out.println("Trial-Strategy: Twins: Count: " + count(trialTwins));
        System.out.println("Trial-Strategy: Rep: Count: " + count(trialRep));
        System.out.println("Trial-Strategy: One: Count: " + count(trialOne));

        System.out.println("Trial-Strategy: Twins --> grouped ");
        List<int[]> trialGroups = group(trialTwins);
        trialGroups.forEach(t -> System.out.println("----" + Arrays.toString(t)));

        System.out.println("Fermat-Strategy: Twins --> compress ");
        List<String> trialCompress = compress(trialTwins);
        trialCompress.forEach(t -> System.out.println("----" + t));
    }
}
