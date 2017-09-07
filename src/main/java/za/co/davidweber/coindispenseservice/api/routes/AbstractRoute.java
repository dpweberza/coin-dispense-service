package za.co.davidweber.coindispenseservice.api.routes;

import spark.Route;
import za.co.davidweber.coindispenseservice.auth.ITokenAuthenticator;
import za.co.davidweber.coindispenseservice.users.IUserRepository;
import za.co.davidweber.coindispenseservice.util.hashing.IPasswordHasher;

/**
 * Abstract route.
 *
 * @author David
 */
public abstract class AbstractRoute implements Route {

	protected final IUserRepository userRepository;
	protected final IPasswordHasher passwordHasher;
	protected final ITokenAuthenticator tokenAuthenticator;

	/**
	 * Constructor.
	 *
	 * @param userRepository
	 * @param passwordHasher
	 * @param tokenAuthenticator
	 */
	public AbstractRoute(IUserRepository userRepository, IPasswordHasher passwordHasher, ITokenAuthenticator tokenAuthenticator) {
		this.userRepository = userRepository;
		this.passwordHasher = passwordHasher;
		this.tokenAuthenticator = tokenAuthenticator;
	}

}
