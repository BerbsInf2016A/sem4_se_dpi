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
                .of(    new int[]{1,7}
                        , new int[]{1,11}
                        , new int[]{1,13}
                        , new int[]{1,17}
                        , new int[]{1,19}
                        , new int[]{3,5}
                        , new int[]{4,3}
                        , new int[]{11,2}
                        ).collect(Collectors.toList());

        assertEquals("Count of grouped data should be equal", expectedData.size(), actualData.size());
        for (int i = 0; i < expectedData.size(); i++) {
            int[] expected = expectedData.get(i);
            int[] actual = actualData.get(i);

            assertArrayEquals("Counts for grouped data should be equal", expected, actual);

        }
    }

}