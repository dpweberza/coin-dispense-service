package za.co.davidweber.coindispenseservice.auth;

/**
 * Token authenticator interface.
 *
 * @author David
 */
public interface ITokenAuthenticator {

	/**
	 * Generates a token to represent an authenticated user.
	 *
	 * @param userIdentifier
	 * @return
	 * @throws Exception
	 */
	public String generateToken(String userIdentifier) throws Exception;

	/**
	 * Verifies a token.
	 *
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public boolean verifyToken(String token) throws Exception;

	/**
	 * Returns the user identifier for the authenticated user.
	 *
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public String getUserIdentifier(String token) throws Exception;
}
