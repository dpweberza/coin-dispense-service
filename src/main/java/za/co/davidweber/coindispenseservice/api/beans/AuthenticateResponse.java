package za.co.davidweber.coindispenseservice.api.beans;

import za.co.davidweber.coindispenseservice.api.routes.AuthenticateRoute;
import za.co.davidweber.coindispenseservice.users.User;

/**
 * {@link AuthenticateRoute} response bean.
 *
 * @author David
 */
public class AuthenticateResponse {

	private final String token;
	private final UserRepresentation user;

	public AuthenticateResponse(String token, User user) {
		this.token = token;
		this.user = new UserRepresentation(user);
	}

	public String getToken() {
		return token;
	}

	public UserRepresentation getUser() {
		return user;
	}

}
