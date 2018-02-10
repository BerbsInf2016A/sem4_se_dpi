package primenumbers_i39.functions;

import primenumbers_i39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompressFunction {
    public static List<String> compress(List<PrimeFactorization> data) {
        List<String> formattedStrings = new ArrayList<>();
        // Value: Zerlegung mit Hochzahlen
        // 48: 2^4*3
        StringBuilder sb = new StringBuilder();
        for (PrimeFactorization entry : data ) {
            sb.append(String.format("%d: ", entry.getNumber()));
            Map<Integer, Long> countedFactors = entry.getFactors().stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            int counter = 0;
            for (Map.Entry<Integer, Long> factor : countedFactors.entrySet() ) {
                int factorValue = factor.getKey();
                long count = factor.getValue();
                if (count != 1L )  {
                    if (counter == 0) sb.append(String.format("%d^%d ", factorValue, count));
                    else sb.append(String.format("* %d^%d ", factorValue, count));
                }
                if (count == 1L)  {
                    if (counter == 0) sb.append(String.format("%d ", factorValue));
                    else sb.append(String.format("* %d ", factorValue, count));
                }
                counter++;
            }
            formattedStrings.add(sb.toString().trim());
            // Reset the string builder.
            sb.setLength(0);
        }

        return formattedStrings;
    }
}
