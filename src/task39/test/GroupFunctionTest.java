package task39.test;

import org.junit.Test;
import task39.Context;
import task39.PrimeFactorization;
import task39.TrialDivisionOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static task39.functions.GroupFunction.group;

/**
 * Tests for the group function.
 */
public class GroupFunctionTest {
    /**
     * The group function should return the correct grouped data.
     */
    @Test
    public void group_Data() {
        // Create the test data.
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 20);

        // Call the function to test.
        List<int[]> actualData = group(data);

        // Create the expected result.
        List<int[]> expectedData = Stream
                .of(new int[]{1, 7}
                        , new int[]{1, 11}
                        , new int[]{1, 13}
                        , new int[]{1, 17}
                        , new int[]{1, 19}
                        , new int[]{3, 5}
                        , new int[]{4, 3}
                        , new int[]{11, 2}
                ).collect(Collectors.toList());

        // Assert that the result is correct.
        assertEquals("Count of grouped data should be equal", expectedData.size(), actualData.size());
        for (int i = 0; i < expectedData.size(); i++) {
            int[] expected = expectedData.get(i);
            int[] actual = actualData.get(i);

            assertArrayEquals("Counts for grouped data should be equal", expected, actual);

        }
    }

    /**
     * Ensure, that the group function won't crash with an empty list.
     */
    @Test
    public void group_emptyData() {

        List<int[]> result = group(new ArrayList<>());

        assertEquals("Result should be empty", 0, result.size());
    }
}