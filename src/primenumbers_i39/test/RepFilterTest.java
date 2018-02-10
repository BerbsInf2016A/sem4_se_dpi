package primenumbers_i39.test;

import org.junit.Test;
import primenumbers_i39.Context;
import primenumbers_i39.PrimeFactorization;
import primenumbers_i39.TrialDivisionOperation;
import primenumbers_i39.filter.IPrimeFactorizationFilter;
import primenumbers_i39.filter.RepFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static primenumbers_i39.filter.RepFilter.rep;
import static primenumbers_i39.test.TestHelpers.assertFilteredArrays;

public class RepFilterTest {
    @Test
    public void repFilter_filterObjects()  {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 40);
        IPrimeFactorizationFilter filter = new RepFilter();
        List<PrimeFactorization> filteredData = filter.filterObjects(data);

        List<PrimeFactorization> expected =  new ArrayList<>();
        expected.add(new PrimeFactorization(16, Arrays.asList(2,2,2,2)));
        expected.add(new PrimeFactorization(24, Arrays.asList(2,2,2,3)));
        expected.add(new PrimeFactorization(27, Arrays.asList(3,3,3)));
        expected.add(new PrimeFactorization(32, Arrays.asList(2,2,2,2,2)));
        expected.add(new PrimeFactorization(40, Arrays.asList(2,2,2,5)));

        assertFilteredArrays(expected, filteredData);
    }

    @Test
    public void shortStaticRep()  {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> filteredData = rep(context.executeStrategy(10, 40));
        List<PrimeFactorization> expected =  new ArrayList<>();
        expected.add(new PrimeFactorization(16, Arrays.asList(2,2,2,2)));
        expected.add(new PrimeFactorization(24, Arrays.asList(2,2,2,3)));
        expected.add(new PrimeFactorization(27, Arrays.asList(3,3,3)));
        expected.add(new PrimeFactorization(32, Arrays.asList(2,2,2,2,2)));
        expected.add(new PrimeFactorization(40, Arrays.asList(2,2,2,5)));

        assertFilteredArrays(expected, filteredData);
    }
}