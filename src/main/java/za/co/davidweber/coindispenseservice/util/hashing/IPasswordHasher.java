package za.co.davidweber.coindispenseservice.util.hashing;

/**
 * Interface for implementing a password hasher.
 *
 * @author David
 */
public interface IPasswordHasher {

	/**
	 * Hashes a password.
	 *
	 * @param password
	 * @return
	 */
	public String hashPassword(String password);

	/**
	 * Verifies if an unhashed password matches a hashed password.
	 *
	 * @param password
	 * @param hashedPassword
	 * @return
	 */
	public boolean verifyPassword(String password, String hashedPassword);
}
