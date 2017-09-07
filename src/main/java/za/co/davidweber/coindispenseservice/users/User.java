package za.co.davidweber.coindispenseservice.users;

/**
 * User model.
 *
 * @author David
 */
public class User {

	private String username;
	private String hashedPassword;
	private double accountBalance;

	public User() {
	}

	public User(String username, String hashedPassword, double accountBalance) {
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.accountBalance = accountBalance;
	}

	public String getUsername() {
		return username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
