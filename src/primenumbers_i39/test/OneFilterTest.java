package primenumbers_i39.test;


import org.junit.Test;
import primenumbers_i39.Context;
import primenumbers_i39.PrimeFactorization;
import primenumbers_i39.TrialDivisionOperation;
import primenumbers_i39.filter.IPrimeFactorizationFilter;
import primenumbers_i39.filter.OneFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static primenumbers_i39.filter.OneFilter.one;
import static primenumbers_i39.test.TestHelpers.assertFilteredArrays;

public class OneFilterTest {
    @Test
    public void oneFilter_filterObjects() {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 35);
        IPrimeFactorizationFilter filter = new OneFilter();
        List<PrimeFactorization> filteredData = filter.filterObjects(data);

        List<PrimeFactorization> expected = new ArrayList<>();
        expected.add(new PrimeFactorization(12, Arrays.asList(2, 2, 3)));
        expected.add(new PrimeFactorization(18, Arrays.asList(2, 3, 3)));
        expected.add(new PrimeFactorization(24, Arrays.asList(2, 2, 2, 3)));

        assertFilteredArrays(expected, filteredData);
    }

    @Test
    public void shortStaticOne() {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> filteredData = one(context.executeStrategy(50, 100));

        List<PrimeFactorization> expected = new ArrayList<>();
        expected.add(new PrimeFactorization(54, Arrays.asList(2, 3, 3, 3)));
        expected.add(new PrimeFactorization(72, Arrays.asList(2, 2, 2, 3, 3)));
        expected.add(new PrimeFactorization(96, Arrays.asList(2, 2, 2, 2, 2, 3)));

        assertFilteredArrays(expected, filteredData);
    }
}
