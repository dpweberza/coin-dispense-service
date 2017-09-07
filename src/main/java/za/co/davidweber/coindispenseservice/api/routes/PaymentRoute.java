package za.co.davidweber.coindispenseservice.api.routes;

import com.google.gson.Gson;
import com.google.inject.Inject;
import java.util.Map;
import spark.Request;
import spark.Response;
import za.co.davidweber.coindispenseservice.api.beans.PaymentRequest;
import za.co.davidweber.coindispenseservice.api.beans.PaymentResponse;
import za.co.davidweber.coindispenseservice.api.exceptions.BadRequestException;
import za.co.davidweber.coindispenseservice.api.middleware.AuthenticatedFilter;
import za.co.davidweber.coindispenseservice.auth.ITokenAuthenticator;
import za.co.davidweber.coindispenseservice.util.currency.rand.RandCashDenomination;
import za.co.davidweber.coindispenseservice.util.currency.rand.RandCashDenominationBreakdownCalculator;
import za.co.davidweber.coindispenseservice.users.IUserRepository;
import za.co.davidweber.coindispenseservice.users.User;
import za.co.davidweber.coindispenseservice.util.hashing.IPasswordHasher;

/**
 * Processes a payment against a user's account and returns a denomination breakdown of any required change.
 *
 * @author David
 */
public class PaymentRoute extends AbstractRoute {

	@Inject
	public PaymentRoute(IUserRepository userRepository, IPasswordHasher passwordHasher, ITokenAuthenticator tokenAuthenticator) {
		super(userRepository, passwordHasher, tokenAuthenticator);
	}

	@Override
	public Object handle(Request request, Response response) throws Exception {
		PaymentRequest paymentRequest = new Gson().fromJson(request.body(), PaymentRequest.class);
		if (paymentRequest == null)
			throw new BadRequestException("Malformed JSON request!");

		// Load the user
		String username = tokenAuthenticator.getUserIdentifier(request.headers(AuthenticatedFilter.TOKEN_HEADER));
		User user = userRepository.loadUserByUsername(username);

		// Validate the amount
		if (paymentRequest.getAmount() < user.getAccountBalance())
			throw new BadRequestException("Payment amount is less than the account balance!");

		// Make the payment and update the account
		double change = paymentRequest.getAmount() - user.getAccountBalance();
		user.setAccountBalance(0); // This system only support full payments
		userRepository.updateUser(user);

		// Calculate any change to be returned
		Map<RandCashDenomination, Integer> cashDenominationBreakdown = null;
		if (change > 0) {
			RandCashDenominationBreakdownCalculator denominationBreakdownCalculator = new RandCashDenominationBreakdownCalculator();
			cashDenominationBreakdown = denominationBreakdownCalculator.calculateCashDenominationBreakdownForAmount(change);
		}

		PaymentResponse paymentResponse = new PaymentResponse(cashDenominationBreakdown);

		return paymentResponse;
	}

}
