package za.co.davidweber.coindispenseservice.util.http;

/**
 * An enum representing HTTP content types.
 *
 * @author David
 */
public enum ContentType {

	APPLICATION_JSON("application/json");

	private final String name;

	private ContentType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
