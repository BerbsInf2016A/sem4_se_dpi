package task39.test;

import org.junit.Test;
import task39.Context;
import task39.PrimeFactorization;
import task39.TrialDivisionOperation;
import task39.filter.IPrimeFactorizationFilter;
import task39.filter.TwinFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static task39.filter.TwinFilter.twin;
import static task39.test.TestHelpers.assertFilteredArrays;

/**
 * Tests for the TwinFilter.
 */
public class TwinFilterTest {

    /**
     * Get the expected test data.
     *
     * @return A list containing the expected test data.
     */
    private List<PrimeFactorization> getExpectedTestData() {
        List<PrimeFactorization> expected = new ArrayList<>();
        expected.add(new PrimeFactorization(15, Arrays.asList(3, 5)));
        expected.add(new PrimeFactorization(30, Arrays.asList(2, 3, 5)));
        expected.add(new PrimeFactorization(35, Arrays.asList(5, 7)));
        expected.add(new PrimeFactorization(45, Arrays.asList(3, 3, 5)));
        expected.add(new PrimeFactorization(60, Arrays.asList(2, 2, 3, 5)));
        expected.add(new PrimeFactorization(70, Arrays.asList(2, 5, 7)));
        expected.add(new PrimeFactorization(75, Arrays.asList(3, 5, 5)));
        expected.add(new PrimeFactorization(90, Arrays.asList(2, 3, 3, 5)));
        expected.add(new PrimeFactorization(105, Arrays.asList(3, 5, 7)));
        expected.add(new PrimeFactorization(120, Arrays.asList(2, 2, 2, 3, 5)));
        expected.add(new PrimeFactorization(135, Arrays.asList(3, 3, 3, 5)));
        expected.add(new PrimeFactorization(140, Arrays.asList(2, 2, 5, 7)));
        expected.add(new PrimeFactorization(143, Arrays.asList(11, 13)));
        expected.add(new PrimeFactorization(150, Arrays.asList(2, 3, 5, 5)));
        expected.add(new PrimeFactorization(165, Arrays.asList(3, 5, 11)));
        expected.add(new PrimeFactorization(175, Arrays.asList(5, 5, 7)));
        expected.add(new PrimeFactorization(180, Arrays.asList(2, 2, 3, 3, 5)));
        expected.add(new PrimeFactorization(195, Arrays.asList(3, 5, 13)));
        return expected;
    }

    /**
     * Execute the twin filter and assert a correct result.
     */
    @Test
    public void twinFilter_filterObjects() {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 200);

        IPrimeFactorizationFilter filter = new TwinFilter();
        List<PrimeFactorization> filteredData = filter.filterObjects(data);

        List<PrimeFactorization> expected = this.getExpectedTestData();

        assertFilteredArrays(expected, filteredData);
    }

    /**
     * Execute the twin filter and assert a correct result.
     */
    @Test
    public void shortStaticTwin() {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> filteredData = twin(context.executeStrategy(10, 200));

        List<PrimeFactorization> expected = this.getExpectedTestData();

        assertFilteredArrays(expected, filteredData);
    }

    /**
     * Ensure the filter won't crash on a empty list.
     */
    @Test
    public void twinFilter_emptyList() {
        List<PrimeFactorization> result = twin(new ArrayList<>());

        assertEquals("Result should be empty", 0, result.size());
    }
}