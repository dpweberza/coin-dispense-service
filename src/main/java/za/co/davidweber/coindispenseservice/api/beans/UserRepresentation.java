package za.co.davidweber.coindispenseservice.api.beans;

import za.co.davidweber.coindispenseservice.users.User;

/**
 * API representation of a user.
 *
 * @author David
 */
public class UserRepresentation {

	private final String username;
	private final double accountBalance;

	public UserRepresentation(User user) {
		this.username = user.getUsername();
		this.accountBalance = user.getAccountBalance();
	}

	public String getUsername() {
		return username;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

}
