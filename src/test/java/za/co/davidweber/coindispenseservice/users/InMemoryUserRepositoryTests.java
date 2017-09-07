package za.co.davidweber.coindispenseservice.users;

import static org.hamcrest.CoreMatchers.not;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * Tests for {@link InMemoryUserRepository}.
 *
 * @author David
 */
public class InMemoryUserRepositoryTests {

	@Test
	public void loadUserByUsername() {
		InMemoryUserRepository userRepository = new InMemoryUserRepository();

		User johnDoe = userRepository.loadUserByUsername("johndoe");
		assertNotNull(johnDoe);
		assertEquals("johndoe", johnDoe.getUsername());
	}

	@Test
	public void updateUser() {
		InMemoryUserRepository userRepository = new InMemoryUserRepository();

		double newBalance = 100;

		User johnDoe = userRepository.loadUserByUsername("johndoe");
		Assert.assertThat(johnDoe.getAccountBalance(), not(newBalance));

		// Update the user balance
		johnDoe.setAccountBalance(newBalance);
		userRepository.updateUser(johnDoe);

		// Reload and verify update was persisted
		User updatedJohnDoe = userRepository.loadUserByUsername("johndoe");
		assertEquals(newBalance, updatedJohnDoe.getAccountBalance(), 0.1);
	}
}
