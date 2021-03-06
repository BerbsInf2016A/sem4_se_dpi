package task39.test;

import org.junit.Test;
import task39.Context;
import task39.PrimeFactorization;
import task39.TrialDivisionOperation;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static task39.functions.CountFunction.count;

/**
 * Tests for the count function.
 */
public class CountFunctionTest {
    /**
     * The count function should return the correct count for the entries, given there are entries.
     */
    @Test
    public void count_ShouldBe26() {

        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 35);

        assertEquals("Count should be 26", 26, count(data));
    }

    /**
     * The count function should return 0, if there are no entries in the data.
     */
    @Test
    public void count_ShouldBe0() {

        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(0, 0);

        assertEquals("Count should be 0", 0, count(data));
    }

}