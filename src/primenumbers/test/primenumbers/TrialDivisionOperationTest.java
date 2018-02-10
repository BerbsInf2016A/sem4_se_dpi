package primenumbers;

import org.junit.Assert;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;


public class TrialDivisionOperationTest {
    @Test
    public void doOperation_TrialAndFermat_SameResult() throws Exception {
        Context context = new Context(new FermatOperation());
        List<PrimeFactorization> factorizationsFermat = context.executeStrategy(10, 1000);


        Context context2 = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> factorizationsTrial = context2.executeStrategy(10, 1000);

        for (int i = 0; i < factorizationsFermat.size(); i++) {
            PrimeFactorization fermat = factorizationsFermat.get(i);
            PrimeFactorization trial = factorizationsTrial.get(i);

            Assert.assertEquals("Should be for the same number", fermat.getNumber(), trial.getNumber());
            Assert.assertArrayEquals("Should contain the same factors", fermat.getFactors().toArray(), trial.getFactors().toArray());

        }
    }

}