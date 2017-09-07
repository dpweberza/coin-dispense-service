package za.co.davidweber.coindispenseservice.api.middleware;

import com.google.gson.Gson;
import spark.ExceptionHandler;
import spark.Request;
import spark.Response;
import za.co.davidweber.coindispenseservice.api.beans.GeneralError;
import za.co.davidweber.coindispenseservice.util.http.ContentType;
import za.co.davidweber.coindispenseservice.util.http.HttpStatusCode;

/**
 * General exception handler.
 *
 * @author David
 */
public class GeneralExceptionHandler implements ExceptionHandler {

	@Override
	public void handle(Exception ex, Request request, Response response) {
		response.status(HttpStatusCode.BAD_REQUEST.getCode());
		response.body(new Gson().toJson(new GeneralError(ex.getMessage())));
		response.type(ContentType.APPLICATION_JSON.getName());
	}

}
