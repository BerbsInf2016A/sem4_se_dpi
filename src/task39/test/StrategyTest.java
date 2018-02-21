package task39.test;

import org.junit.Assert;
import org.junit.Test;
import task39.Context;
import task39.FermatOperation;
import task39.PrimeFactorization;
import task39.TrialDivisionOperation;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

            assertEquals("Should be for the same number", fermat.getNumber(), trial.getNumber());
            Assert.assertArrayEquals("Should contain the same factors", fermat.getFactors().toArray(), trial.getFactors().toArray());
        }
    }

    /**
     * Ensure, that the trial division strategy will not crash on invalid parameters.
     */
    @Test
    public void trialDivision_InvalidParameters() {
        Context trialContext = new Context(new TrialDivisionOperation());

        List<PrimeFactorization> factorizations = trialContext.executeStrategy(-1, 5);
        assertEquals("Should return a empty list", 0, factorizations.size());

        factorizations = trialContext.executeStrategy(5, 2);
        assertEquals("Should return a empty list", 0, factorizations.size());

        factorizations = trialContext.executeStrategy(5, -2);
        assertEquals("Should return a empty list", 0, factorizations.size());

        factorizations = trialContext.executeStrategy(-5, -2);
        assertEquals("Should return a empty list", 0, factorizations.size());
    }

    /**
     * Ensure, that the fermat strategy will not crash on invalid parameters.
     */
    @Test
    public void fermat_InvalidParameters() {
        Context fermatContext = new Context(new FermatOperation());

        List<PrimeFactorization> factorizations = fermatContext.executeStrategy(-1, 5);
        assertEquals("Should return a empty list", 0, factorizations.size());

        factorizations = fermatContext.executeStrategy(5, 2);
        assertEquals("Should return a empty list", 0, factorizations.size());

        factorizations = fermatContext.executeStrategy(5, -2);
        assertEquals("Should return a empty list", 0, factorizations.size());

        factorizations = fermatContext.executeStrategy(-5, -2);
        assertEquals("Should return a empty list", 0, factorizations.size());
    }
}