package za.co.davidweber.coindispenseservice.api.middleware;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import za.co.davidweber.coindispenseservice.api.beans.GeneralError;
import za.co.davidweber.coindispenseservice.api.exceptions.ApiException;

/**
 * API exception handler.
 *
 * @author David
 */
public class ApiExceptionHandler extends GeneralExceptionHandler {

	@Override
	public void handle(Exception ex, Request request, Response response) {

		if (ex instanceof ApiException) {
			ApiException apiException = (ApiException) ex;
			response.status(apiException.getHttpStatusCode());
			response.body(new Gson().toJson(new GeneralError(apiException.getMessage())));
		} else
			super.handle(ex, request, response);
	}

}