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

        System.out.println("Fermat-Strategy: Twins: Count: " + count(twin(factorizationsFermat)));
        System.out.println("Fermat-Strategy: Rep: Count: " + count(rep(factorizationsFermat)));
        System.out.println("Fermat-Strategy: One: Count: " + count(one(factorizationsFermat)));

        System.out.println("count(rep(one(data))): " + count(rep(one(factorizationsFermat))));

        System.out.println("Fermat-Strategy: Twins --> grouped ");
        List<int[]> fermatGroups = group(twin(factorizationsFermat));
        fermatGroups.forEach(t -> System.out.println("----" + Arrays.toString(t)));

        System.out.println("Fermat-Strategy: Twins --> compress ");
        List<String> fermatCompress = compress(twin(factorizationsFermat));
        fermatCompress.forEach(t -> System.out.println("----" + t));

        // Trial:

        Context trialContext = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> factorizationsTrial = trialContext.executeStrategy(10, 1000);

        System.out.println("Trial-Strategy: Twins: Count: " + count(twin(factorizationsTrial)));
        System.out.println("Trial-Strategy: Rep: Count: " + count(rep(factorizationsTrial)));
        System.out.println("Trial-Strategy: One: Count: " + count(one(factorizationsTrial)));

        System.out.println("count(one(rep(data))): " + count(one(rep(factorizationsTrial))));

        System.out.println("Trial-Strategy: Twins --> grouped ");
        List<int[]> trialGroups = group(twin(factorizationsTrial));
        trialGroups.forEach(t -> System.out.println("----" + Arrays.toString(t)));

        System.out.println("Fermat-Strategy: Twins --> compress ");
        List<String> trialCompress = compress(twin(factorizationsTrial));
        trialCompress.forEach(t -> System.out.println("----" + t));
    }
}
