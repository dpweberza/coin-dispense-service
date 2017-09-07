package za.co.davidweber.coindispenseservice.api.routes;

import com.google.gson.Gson;
import com.google.inject.Inject;
import spark.Request;
import spark.Response;
import za.co.davidweber.coindispenseservice.api.beans.AuthenticateRequest;
import za.co.davidweber.coindispenseservice.api.beans.AuthenticateResponse;
import za.co.davidweber.coindispenseservice.api.exceptions.BadRequestException;
import za.co.davidweber.coindispenseservice.api.exceptions.UnauthorisedException;
import za.co.davidweber.coindispenseservice.auth.ITokenAuthenticator;
import za.co.davidweber.coindispenseservice.users.IUserRepository;
import za.co.davidweber.coindispenseservice.users.User;
import za.co.davidweber.coindispenseservice.util.hashing.IPasswordHasher;

/**
 * Authenticates a user and returns a token for stateless authentication.
 *
 * @author David
 */
public class AuthenticateRoute extends AbstractRoute {

	@Inject
	public AuthenticateRoute(IUserRepository userRepository, IPasswordHasher passwordHasher, ITokenAuthenticator tokenAuthenticator) {
		super(userRepository, passwordHasher, tokenAuthenticator);
	}

	@Override
	public Object handle(Request request, Response response) throws Exception {
		AuthenticateRequest authenticateRequest = new Gson().fromJson(request.body(), AuthenticateRequest.class);
		if (authenticateRequest == null)
			throw new BadRequestException("Malformed JSON request!");

		// Load the user
		User user = userRepository.loadUserByUsername(authenticateRequest.getUsername());
		if (user != null) {

			// Verify the user's password
			if (passwordHasher.verifyPassword(authenticateRequest.getPassword(), user.getHashedPassword())) {
				String token = tokenAuthenticator.generateToken(user.getUsername());

				return new AuthenticateResponse(token, user);
			}
		}

		throw new UnauthorisedException("Failed to authenticate request!");
	}

}
