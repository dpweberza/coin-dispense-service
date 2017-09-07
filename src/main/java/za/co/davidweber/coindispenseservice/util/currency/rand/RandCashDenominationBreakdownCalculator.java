package za.co.davidweber.coindispenseservice.util.currency.rand;

import java.util.Map;
import java.util.TreeMap;

/**
 * Calculates the cash denominations required to make up a given amount.
 *
 * @author David
 */
public class RandCashDenominationBreakdownCalculator {

	public static final double DOUBLE_MARGIN_OF_ERROR = 0.001;

	public Map<RandCashDenomination, Integer> calculateCashDenominationBreakdownForAmount(double amount) {
		Map<RandCashDenomination, Integer> cashDomininations = new TreeMap<>();
		double tempAmount = amount;

		// While there is cash to allocate, allocate the highest denominations possible.
		// Skip any remainder lower than the lowest denonimation.
		while (tempAmount > DOUBLE_MARGIN_OF_ERROR && tempAmount >= RandCashDenomination.FIVE_CENTS.getAmount()) {
			for (RandCashDenomination cashDenomination : RandCashDenomination.values()) {
				if (tempAmount >= cashDenomination.getAmount()) {
					Integer count = cashDomininations.get(cashDenomination);
					if (count == null)
						cashDomininations.put(cashDenomination, 1);
					else
						cashDomininations.put(cashDenomination, count + 1);

					tempAmount = roundDoubleToTwoDecimalPlaces(tempAmount - cashDenomination.getAmount());
					break;
				}
			}
		}

		return cashDomininations;
	}

	private double roundDoubleToTwoDecimalPlaces(double value) {
		return Math.round(value * 100.0) / 100.0;
	}

}
