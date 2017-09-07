package za.co.davidweber.coindispenseservice.util.currency.rand;

/**
 * An enum of rand cash denominations.
 *
 * @author David
 */
public enum RandCashDenomination {

	ONE_HUNDRED_RANDS(true, 100, "R100"), FIFTY_RANDS(true, 50, "R50"), TWENTY_RANDS(true, 20, "R20"), TEN_RANDS(true, 10, "R10"), FIVE_RANDS(false, 5, "R5"), TWO_RANDS(false, 2, "R2"), ONE_RAND(false, 1, "R1"), FIFTY_CENTS(false, 0.50, "50c"), TWENTY_FIVE_CENTS(false, 0.25, "25c"), TEN_CENTS(false, 0.10, "10c"), FIVE_CENTS(false, 0.05, "5c");

	private final boolean note;
	private final double amount;
	private final String name;

	private RandCashDenomination(boolean note, double amount, String name) {
		this.note = note;
		this.amount = amount;
		this.name = name;
	}

	public boolean isNote() {
		return note;
	}

	public double getAmount() {
		return amount;
	}

	public String getName() {
		return name;
	}

}
