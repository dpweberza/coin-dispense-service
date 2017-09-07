package za.co.davidweber.coindispenseservice.api.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import za.co.davidweber.coindispenseservice.api.routes.PaymentRoute;
import za.co.davidweber.coindispenseservice.util.currency.rand.RandCashDenomination;

/**
 * {@link PaymentRoute} response bean.
 *
 * @author David
 */
public class PaymentResponse {

	private final List<RandCashDenominationRepresentation> randCashDenominations;
	private double total = 0;

	public PaymentResponse(Map<RandCashDenomination, Integer> cashDenominationBreakdown) {
		this.randCashDenominations = new ArrayList<>();

		if (cashDenominationBreakdown != null) {
			for (Map.Entry<RandCashDenomination, Integer> cashDenominationEntry : cashDenominationBreakdown.entrySet()) {
				RandCashDenomination cashDenomination = cashDenominationEntry.getKey();
				Integer count = cashDenominationEntry.getValue();

				this.randCashDenominations.add(new RandCashDenominationRepresentation(cashDenomination.getName(), cashDenomination.getAmount(), count));
				this.total += cashDenomination.getAmount();
			}
		}
	}

	public List<RandCashDenominationRepresentation> getCashDenominations() {
		return randCashDenominations;
	}

	public double getTotal() {
		return total;
	}

}
