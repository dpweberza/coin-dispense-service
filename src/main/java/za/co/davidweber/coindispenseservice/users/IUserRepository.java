package za.co.davidweber.coindispenseservice.users;

/**
 * Interface for implementing a {@link User} repository.
 *
 * @author David
 */
public interface IUserRepository {

	/**
	 * Loads a user by username.
	 *
	 * @param username
	 * @return
	 */
	public User loadUserByUsername(String username);

	/**
	 * Updates a user.
	 *
	 * @param user
	 */
	public void updateUser(User user);
}
