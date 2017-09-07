package za.co.davidweber.coindispenseservice.api.middleware;

import com.google.gson.Gson;
import com.google.inject.Inject;
import spark.Filter;
import spark.Request;
import spark.Response;
import static spark.Spark.halt;
import za.co.davidweber.coindispenseservice.api.beans.GeneralError;
import za.co.davidweber.coindispenseservice.auth.ITokenAuthenticator;
import za.co.davidweber.coindispenseservice.util.http.HttpStatusCode;

/**
 * Rejects unauthenticated / expired requests.
 * Tokens must be passed in each request using an auth header.
 *
 * @author David
 */
public class AuthenticatedFilter implements Filter {

	public static final String TOKEN_HEADER = "X-Auth";

	private final ITokenAuthenticator tokenAuthenticator;

	@Inject
	public AuthenticatedFilter(ITokenAuthenticator tokenAuthenticator) {
		this.tokenAuthenticator = tokenAuthenticator;
	}

	@Override
	public void handle(Request request, Response response) throws Exception {
		String jwt = request.headers(TOKEN_HEADER);

		boolean authenticated = tokenAuthenticator.verifyToken(jwt);
		if (!authenticated) {
			response.type("application/json");
			halt(HttpStatusCode.UNAUTHORISED.getCode(), new Gson().toJson(new GeneralError("Failed to authenticate request!")));
		}
	}

}
