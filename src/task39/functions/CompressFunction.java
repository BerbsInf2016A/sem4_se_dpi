package task39.functions;

import task39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A function to get a compressed string representation of a prime factorization.
 * E.g. 12 = 2 * 2 * 3 --> 2^2 * 3
 */
public class CompressFunction {
    /**
     * Compress all factorizations in a given list of entries.
     *
     * @param data The data to work on.
     * @return A list of compressed representation strings of the factorizations.
     */
    public static List<String> compress(List<PrimeFactorization> data) {
        List<String> formattedStrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (PrimeFactorization entry : data) {
            // Prefix of the string or the value of number which was factorized.
            sb.append(String.format("%d: ", entry.getNumber()));
            // Count the factors in the current factorization.
            Map<Integer, Long> countedFactors = entry.getFactors().stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            // Generate the formatted string.
            boolean firstFactorInCurrentFactorization = true;
            for (Map.Entry<Integer, Long> factor : countedFactors.entrySet()) {
                int factorValue = factor.getKey();
                long currentFactorCount = factor.getValue();
                if (currentFactorCount != 1L) { // Factor is multiple times in the factorization.
                    if (firstFactorInCurrentFactorization)
                        sb.append(String.format("%d^%d ", factorValue, currentFactorCount));
                    else sb.append(String.format("* %d^%d ", factorValue, currentFactorCount));
                }
                if (currentFactorCount == 1L) { // Factor is only one time in the factorization.
                    if (firstFactorInCurrentFactorization) sb.append(String.format("%d ", factorValue));
                    else sb.append(String.format("* %d ", factorValue));
                }
                firstFactorInCurrentFactorization = false;
            }
            formattedStrings.add(sb.toString().trim());
            // Reset the string builder.
            sb.setLength(0);
        }

        return formattedStrings;
    }
}
