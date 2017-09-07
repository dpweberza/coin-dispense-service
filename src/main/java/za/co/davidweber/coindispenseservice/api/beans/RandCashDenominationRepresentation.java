package za.co.davidweber.coindispenseservice.api.beans;

/**
 * API representation of a rand cash denomination.
 *
 * @author David
 */
public class RandCashDenominationRepresentation {

	private final String name;
	private final double amount;
	private final int quantity;

	public RandCashDenominationRepresentation(String name, double amount, int quantity) {
		this.name = name;
		this.amount = amount;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public int getQuantity() {
		return quantity;
	}

}
