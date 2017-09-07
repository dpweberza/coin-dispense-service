package za.co.davidweber.coindispenseservice.api.middleware;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Transforms a response to JSON.
 *
 * @author David
 */
public class JsonTransformer implements ResponseTransformer {

	private final Gson gson = new Gson();

	@Override
	public String render(Object model) {
		return gson.toJson(model);
	}

}
