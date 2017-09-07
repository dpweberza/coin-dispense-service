package za.co.davidweber.coindispenseservice.util.hashing;

import org.mindrot.jbcrypt.BCrypt;

/**
 * JBCrpyt implementation of a password hasher.
 *
 * @author David
 */
public class JBCryptPasswordHasher implements IPasswordHasher {

	@Override
	public String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	@Override
	public boolean verifyPassword(String password, String hashedPassword) {
		return BCrypt.checkpw(password, hashedPassword);
	}

}