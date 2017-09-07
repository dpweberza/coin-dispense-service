package za.co.davidweber.coindispenseservice.util.http;

/**
 * An enum representing HTTP status codes.
 *
 * @author David
 */
public enum HttpStatusCode {

	BAD_REQUEST(400), UNAUTHORISED(401), INTERNAL_SERVER_ERROR(500);

	private final int code;

	private HttpStatusCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
