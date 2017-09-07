package za.co.davidweber.coindispenseservice.users;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * In-memory user repository.
 *
 * @author David
 */
public class InMemoryUserRepository implements IUserRepository {

	private static final List<User> USERS = new ArrayList<>();

	static {
		USERS.add(new User("johndoe", "$2a$10$wU5XZXJXrLWihFBso6csrefG/QnDrty/b06NIf3vMoqALWigoKevq", 34.70));
		USERS.add(new User("janedoe", "$2a$10$wU5XZXJXrLWihFBso6csrefG/QnDrty/b06NIf3vMoqALWigoKevq", 100.00));
		USERS.add(new User("mrbucks", "$2a$10$wU5XZXJXrLWihFBso6csrefG/QnDrty/b06NIf3vMoqALWigoKevq", 0.00));
	}

	@Override
	public User loadUserByUsername(String username) {
		User user = null;

		for (User tempUser : USERS) {
			if (tempUser.getUsername().equals(username)) {
				user = tempUser;
				break;
			}
		}

		return user;
	}

	@Override
	public void updateUser(User user) {
		Iterator<User> iterator = USERS.iterator();
		while (iterator.hasNext()) {
			User tempUser = iterator.next();
			if (tempUser.getUsername().equals(user.getUsername())) {
				iterator.remove(); // Remove the old record
				break;
			}
		}
		USERS.add(user); // Add the new record
	}

}
