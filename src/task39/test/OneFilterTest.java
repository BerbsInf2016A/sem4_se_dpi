package task39.test;


import org.junit.Test;
import task39.Context;
import task39.PrimeFactorization;
import task39.TrialDivisionOperation;
import task39.filter.IPrimeFactorizationFilter;
import task39.filter.OneFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static task39.filter.OneFilter.one;
import static task39.test.TestHelpers.assertFilteredArrays;

/**
 * Tests for the OneFilter.
 */
public class OneFilterTest {
    /**
     * Execute the filter and assert the correct result.
     */
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

    /**
     * Execute the filter and assert the correct result.
     */
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

    /**
     * Ensure the filter won't crash on a empty list.
     */
    @Test
    public void oneFilter_emptyList() {
        List<PrimeFactorization> result = one(new ArrayList<>());

        assertEquals("Result should be empty", 0, result.size());
    }

}
