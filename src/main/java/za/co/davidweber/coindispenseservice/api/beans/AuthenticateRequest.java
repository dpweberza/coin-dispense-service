package za.co.davidweber.coindispenseservice.api.beans;

import za.co.davidweber.coindispenseservice.api.routes.AuthenticateRoute;

/**
 * {@link AuthenticateRoute} request bean.
 *
 * @author David
 */
public class AuthenticateRequest {

	private String username;
	private String password;

	public AuthenticateRequest() {
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
