package za.co.davidweber.coindispenseservice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.exception;
import static spark.Spark.post;
import static spark.SparkBase.port;

import za.co.davidweber.coindispenseservice.api.exceptions.ApiException;
import za.co.davidweber.coindispenseservice.api.middleware.ApiExceptionHandler;
import za.co.davidweber.coindispenseservice.api.middleware.AuthenticatedFilter;
import za.co.davidweber.coindispenseservice.api.middleware.GeneralExceptionHandler;
import za.co.davidweber.coindispenseservice.api.middleware.JsonContentTypeFilter;
import za.co.davidweber.coindispenseservice.api.middleware.JsonTransformer;
import za.co.davidweber.coindispenseservice.api.routes.AuthenticateRoute;
import za.co.davidweber.coindispenseservice.api.routes.PaymentRoute;

/**
 * Coin Dispense Service.
 *
 * @author David
 */
public class CoinDispenseService {

	public static void main(String[] args) {
		port(8080);

		// Init the dependency injection container
		Injector injector = Guice.createInjector(new CoinDispenseServiceModule());

		// Register exception handlers
		exception(ApiException.class, new ApiExceptionHandler());
		exception(Exception.class, new GeneralExceptionHandler());

		// Register filters
		before("api/v1/authenticated/*", injector.getInstance(AuthenticatedFilter.class));
		after(new JsonContentTypeFilter());

		// Register routes
		post("api/v1/public/authenticate", injector.getInstance(AuthenticateRoute.class), new JsonTransformer());
		post("api/v1/authenticated/payment", injector.getInstance(PaymentRoute.class), new JsonTransformer());
	}
}
