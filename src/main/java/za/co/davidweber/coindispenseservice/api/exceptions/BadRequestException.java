package za.co.davidweber.coindispenseservice.api.exceptions;

import za.co.davidweber.coindispenseservice.util.http.HttpStatusCode;

/**
 * Thrown when a bad request was made.
 *
 * @author David
 */
public class BadRequestException extends ApiException {

	public BadRequestException(String message) {
		super(message);
	}

	@Override
	public int getHttpStatusCode() {
		return HttpStatusCode.BAD_REQUEST.getCode();
	}

}
