package za.co.davidweber.coindispenseservice.api.middleware;

import spark.Filter;
import spark.Request;
import spark.Response;
import za.co.davidweber.coindispenseservice.util.http.ContentType;

/**
 * Sets the content-type to json.
 *
 * @author David
 */
public class JsonContentTypeFilter implements Filter {

	@Override
	public void handle(Request request, Response response) throws Exception {
		response.type(ContentType.APPLICATION_JSON.getName());
	}

}
