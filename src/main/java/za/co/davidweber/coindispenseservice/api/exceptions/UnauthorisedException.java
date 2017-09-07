package za.co.davidweber.coindispenseservice.api.exceptions;

import za.co.davidweber.coindispenseservice.util.http.HttpStatusCode;

/**
 * Thrown when an authentication attempt fails or when no authentication was provided.
 *
 * @author David
 */
public class UnauthorisedException extends ApiException {

	public UnauthorisedException(String message) {
		super(message);
	}

	@Override
	public int getHttpStatusCode() {
		return HttpStatusCode.UNAUTHORISED.getCode();
	}

}
