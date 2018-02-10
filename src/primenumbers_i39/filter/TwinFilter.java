package primenumbers_i39.filter;

import primenumbers_i39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

public class TwinFilter implements IPrimeFactorizationFilter{
    static TwinFilter instance = new TwinFilter();
    @Override
    public List<PrimeFactorization> filterObjects(List<PrimeFactorization> data) {
        List<PrimeFactorization> filteredData = new ArrayList<>();

        for (PrimeFactorization entry : data ) {
            int previousValue = -1;
            for (int factor : entry.getFactors()) {
                if (previousValue != -1) {
                    if (factor - previousValue == 2) {
                        filteredData.add(entry);
                        continue;
                    }
                }
                previousValue = factor;
            }
        }

        return filteredData;
    }

    public static List<PrimeFactorization> twin(List<PrimeFactorization> data) {
        return TwinFilter.instance.filterObjects(data);
    }
}
