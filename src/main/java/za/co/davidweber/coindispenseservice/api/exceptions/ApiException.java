package za.co.davidweber.coindispenseservice.api.exceptions;

/**
 * Abstract API exception class.
 *
 * @author David
 */
public abstract class ApiException extends Exception {

	public ApiException(String message) {
		super(message);
	}

	public abstract int getHttpStatusCode();

}