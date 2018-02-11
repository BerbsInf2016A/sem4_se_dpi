package primenumbers_i39.test;

import org.junit.Test;
import primenumbers_i39.Context;
import primenumbers_i39.FermatOperation;
import primenumbers_i39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static primenumbers_i39.functions.CompressFunction.compress;

public class CompressFunctionTest {
    @Test
    public void compressTest() {
        Context context = new Context(new FermatOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 20);

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

        List<String> actualData = compress(data);

        assertEquals("Should contain the correct number of compressed strings", expectedData.size(), actualData.size());
        for (int i = 0; i < expectedData.size(); i++) {
            String expected = expectedData.get(i);
            String actual = actualData.get(i);

            assertEquals("Compress format should be equal", expected, actual);
        }

    }

}