package task39.test;

import org.junit.Assert;
import org.junit.Test;
import task39.Context;
import task39.FermatOperation;
import task39.PrimeFactorization;
import task39.TrialDivisionOperation;

import java.util.List;

/**
 * Tests for the strategies.
 */
public class StrategyTest {

    /**
     * Creating data in the same range with both strategies must result in the same results.
     */
    @Test
    public void doOperation_TrialAndFermat_SameResult() {
        Context fermatContext = new Context(new FermatOperation());
        List<PrimeFactorization> factorizationsFermat = fermatContext.executeStrategy(10, 1000);

        Context trialContext = new Context(new TrialDivisionOperation());
        List<PrimeFactorization> factorizationsTrial = trialContext.executeStrategy(10, 1000);

        // Both strategies must create the same results.
        for (int i = 0; i < factorizationsFermat.size(); i++) {
            PrimeFactorization fermat = factorizationsFermat.get(i);
            PrimeFactorization trial = factorizationsTrial.get(i);

            Assert.assertEquals("Should be for the same number", fermat.getNumber(), trial.getNumber());
            Assert.assertArrayEquals("Should contain the same factors", fermat.getFactors().toArray(), trial.getFactors().toArray());

        }
    }

}