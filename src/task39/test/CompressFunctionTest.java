package task39.test;

import org.junit.Test;
import task39.Context;
import task39.FermatOperation;
import task39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static task39.functions.CompressFunction.compress;

/**
 * Tests for the compress function.
 */
public class CompressFunctionTest {
    /**
     * A test for the compress function.
     */
    @Test
    public void compressTest() {
        // Generate test data.
        Context context = new Context(new FermatOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 20);

        // The expected data in the range of the test data.
        List<String> expectedData = new ArrayList<>();
        expectedData.add("10: 2 * 5");
        expectedData.add("11: 11");
        expectedData.add("12: 2^2 * 3");
        expectedData.add("13: 13");
        expectedData.add("14: 2 * 7");
        expectedData.add("15: 3 * 5");
        expectedData.add("16: 2^4");
        expectedData.add("17: 17");
        expectedData.add("18: 2 * 3^2");
        expectedData.add("19: 19");
        expectedData.add("20: 2^2 * 5");

        // Call the function to test.
        List<String> actualData = compress(data);

        // Assert the correct result.
        assertEquals("Should contain the correct number of compressed strings", expectedData.size(), actualData.size());
        for (int i = 0; i < expectedData.size(); i++) {
            String expected = expectedData.get(i);
            String actual = actualData.get(i);

            assertEquals("Compress format should be equal", expected, actual);
        }
    }

    /**
     * Ensure, that the compress function won't crash on a empty list.
     */
    @Test
    public void compress_emptyData() {
        List<String> result = compress(new ArrayList<>());

        assertEquals("Result should be empty", 0, result.size());
    }

}