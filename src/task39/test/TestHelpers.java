package task39.test;

import task39.PrimeFactorization;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestHelpers {
    static void assertFilteredArrays(List<PrimeFactorization> expected, List<PrimeFactorization> filteredData) {
        assertEquals("Should return the same count of data", expected.size(), filteredData.size());
        for (int i = 0; i < expected.size(); i++) {
            PrimeFactorization expect = expected.get(i);
            PrimeFactorization actual = filteredData.get(i);

            assertEquals("Should be for the same number", expect.getNumber(), actual.getNumber());
            assertEquals("Should contain the same number of factors", expect.getFactors().size(), actual.getFactors().size());
            assertArrayEquals("Factors should be the same", expect.getFactors().toArray(), actual.getFactors().toArray());
        }
    }
}
