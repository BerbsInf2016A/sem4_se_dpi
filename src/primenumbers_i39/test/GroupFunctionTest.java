package primenumbers_i39.test;

import org.junit.Test;
import primenumbers_i39.Context;
import primenumbers_i39.PrimeFactorization;
import primenumbers_i39.TrialDivisionOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static primenumbers_i39.functions.GroupFunction.group;

public class GroupFunctionTest {
    @Test
    public void group_Data() {
        Context context = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> data = context.executeStrategy(10, 20);

        List<int[]> actualData = group(data);

        List<int[]> expectedData = Stream
                .of(      new int[]{2,11}
                        , new int[]{3,4}
                        , new int[]{5,3}
                        , new int[]{7,1}
                        , new int[]{11,1}
                        , new int[]{13,1}
                        , new int[]{17,1}
                        , new int[]{19,1}
                        ).collect(Collectors.toList());

        assertEquals("Count of grouped data should be equal", expectedData.size(), actualData.size());
        for (int i = 0; i < expectedData.size(); i++) {
            int[] expected = expectedData.get(i);
            int[] actual = actualData.get(i);

            assertArrayEquals("Counts for grouped data should be equal", expected, actual);

        }
    }

}