package primenumbers_i39.filter;

import primenumbers_i39.PrimeFactorization;

import java.util.ArrayList;
import java.util.List;

public class OneFilter implements IPrimeFactorizationFilter {
    static OneFilter instance = new OneFilter();
    @Override
    public  List<PrimeFactorization> filterObjects(List<PrimeFactorization> data) {
        List<PrimeFactorization> filteredData = new ArrayList<>();
        for (PrimeFactorization entry : data ) {
            if (entry.getFactors().size() >= 2 ){
                List<Integer> factors = entry.getFactors();
                if (minMaxDifferenceIsOne(factors.get(0), factors.get(factors.size() - 1))) {
                    filteredData.add(entry);
                }
            }
        }
        return filteredData;
    }

    boolean minMaxDifferenceIsOne(int min, int max){
        return max - min == 1;
    }

    public static List<PrimeFactorization> one(List<PrimeFactorization> data){
        return OneFilter.instance.filterObjects(data);
    }
}
