package primenumbers_i39.test;

import org.junit.Test;
import primenumbers_i39.Context;
import primenumbers_i39.PrimeFactorization;
import primenumbers_i39.TrialDivisionOperation;
import primenumbers_i39.filter.IPrimeFactorizationFilter;
import primenumbers_i39.filter.RepFilter;
import primenumbers_i39.filter.TwinFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static primenumbers_i39.filter.TwinFilter.twin;
import static primenumbers_i39.test.TestHelpers.assertFilteredArrays;

public class TwinFilterTest {
    @Test
    public void twinFilter_filterObjects() {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 50);
        IPrimeFactorizationFilter filter = new TwinFilter();
        List<PrimeFactorization> filteredData = filter.filterObjects(data);

        List<PrimeFactorization> expected =  new ArrayList<>();
        expected.add(new PrimeFactorization(15, Arrays.asList(3,5)));
        expected.add(new PrimeFactorization(30, Arrays.asList(2,3,5)));
        expected.add(new PrimeFactorization(35, Arrays.asList(5,7)));
        expected.add(new PrimeFactorization(45, Arrays.asList(3,3,5)));

        assertFilteredArrays(expected, filteredData);
    }

    @Test
    public void shortStaticTwin()  {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> filteredData = twin(context.executeStrategy(10, 50));

        List<PrimeFactorization> expected = new ArrayList<>();
        expected.add(new PrimeFactorization(15, Arrays.asList(3,5)));
        expected.add(new PrimeFactorization(30, Arrays.asList(2,3,5)));
        expected.add(new PrimeFactorization(35, Arrays.asList(5,7)));
        expected.add(new PrimeFactorization(45, Arrays.asList(3,3,5)));

        assertFilteredArrays(expected, filteredData);
    }

}