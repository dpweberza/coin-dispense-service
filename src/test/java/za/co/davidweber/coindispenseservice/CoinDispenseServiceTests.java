package za.co.davidweber.coindispenseservice;

import za.co.davidweber.coindispenseservice.cash.RandCashDenominationBreakdownCalculatorTests;
import za.co.davidweber.coindispenseservice.users.InMemoryUserRepositoryTests;

/**
 * Suite of tests for the {@link CoinDispenseService}.
 *
 * @author David
 */
@org.junit.runner.RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({InMemoryUserRepositoryTests.class, RandCashDenominationBreakdownCalculatorTests.class})
public class CoinDispenseServiceTests {

}
