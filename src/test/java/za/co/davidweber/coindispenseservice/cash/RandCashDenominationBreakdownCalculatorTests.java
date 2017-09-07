package za.co.davidweber.coindispenseservice.cash;

import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import za.co.davidweber.coindispenseservice.util.currency.rand.RandCashDenomination;
import za.co.davidweber.coindispenseservice.util.currency.rand.RandCashDenominationBreakdownCalculator;

/**
 * Tests for {@link RandCashDenominationBreakdownCalculatorTests}.
 *
 * @author David
 */
public class RandCashDenominationBreakdownCalculatorTests {

	@Test
	public void calculateCashDenominationBreakdownForAmount() {
		RandCashDenominationBreakdownCalculator calculator = new RandCashDenominationBreakdownCalculator();

		double changeTotal = 24.05;
		Map<RandCashDenomination, Integer> cashDenominationBreakdown = calculator.calculateCashDenominationBreakdownForAmount(changeTotal);

		// Check the items
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.TWENTY_RANDS));
		Assert.assertEquals(new Integer(2), cashDenominationBreakdown.get(RandCashDenomination.TWO_RANDS));
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.FIVE_CENTS));

		changeTotal = 65.30;
		cashDenominationBreakdown = calculator.calculateCashDenominationBreakdownForAmount(changeTotal);

		// Check the items
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.FIFTY_RANDS));
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.TEN_RANDS));
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.FIVE_RANDS));
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.TWENTY_FIVE_CENTS));
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.FIVE_CENTS));
	}

	@Test
	public void calculateCashDenominationBreakdownForAmountWithRemainder() {
		RandCashDenominationBreakdownCalculator calculator = new RandCashDenominationBreakdownCalculator();

		double changeTotal = 24.52;
		Map<RandCashDenomination, Integer> cashDenominationBreakdown = calculator.calculateCashDenominationBreakdownForAmount(changeTotal);

		// Check the items
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.TWENTY_RANDS));
		Assert.assertEquals(new Integer(2), cashDenominationBreakdown.get(RandCashDenomination.TWO_RANDS));
		Assert.assertEquals(new Integer(1), cashDenominationBreakdown.get(RandCashDenomination.FIFTY_CENTS));
	}
}
