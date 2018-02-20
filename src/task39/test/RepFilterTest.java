package task39.test;

import org.junit.Test;
import task39.Context;
import task39.PrimeFactorization;
import task39.TrialDivisionOperation;
import task39.filter.IPrimeFactorizationFilter;
import task39.filter.RepFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static task39.filter.RepFilter.rep;
import static task39.test.TestHelpers.assertFilteredArrays;

/**
 * Tests for the RepFilter.
 */
public class RepFilterTest {
    /**
     * Execute the filter and assert a correct result.
     */
    @Test
    public void repFilter_filterObjects() {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 40);

        IPrimeFactorizationFilter filter = new RepFilter();
        List<PrimeFactorization> filteredData = filter.filterObjects(data);

        List<PrimeFactorization> expected = new ArrayList<>();
        expected.add(new PrimeFactorization(16, Arrays.asList(2, 2, 2, 2)));
        expected.add(new PrimeFactorization(24, Arrays.asList(2, 2, 2, 3)));
        expected.add(new PrimeFactorization(27, Arrays.asList(3, 3, 3)));
        expected.add(new PrimeFactorization(32, Arrays.asList(2, 2, 2, 2, 2)));
        expected.add(new PrimeFactorization(40, Arrays.asList(2, 2, 2, 5)));

        assertFilteredArrays(expected, filteredData);
    }

    /**
     * Execute the filter and assert a correct result.
     */
    @Test
    public void shortStaticRep() {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> filteredData = rep(context.executeStrategy(10, 40));
        List<PrimeFactorization> expected = new ArrayList<>();
        expected.add(new PrimeFactorization(16, Arrays.asList(2, 2, 2, 2)));
        expected.add(new PrimeFactorization(24, Arrays.asList(2, 2, 2, 3)));
        expected.add(new PrimeFactorization(27, Arrays.asList(3, 3, 3)));
        expected.add(new PrimeFactorization(32, Arrays.asList(2, 2, 2, 2, 2)));
        expected.add(new PrimeFactorization(40, Arrays.asList(2, 2, 2, 5)));

        assertFilteredArrays(expected, filteredData);
    }

    /**
     * Ensure the filter won't crash on a empty list.
     */
    @Test
    public void repFilter_emptyList() {
        List<PrimeFactorization> result = rep(new ArrayList<>());

        assertEquals("Result should be empty", 0, result.size());
    }
}