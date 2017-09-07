package za.co.davidweber.coindispenseservice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import za.co.davidweber.coindispenseservice.auth.ITokenAuthenticator;
import za.co.davidweber.coindispenseservice.auth.JwtTokenAuthenticator;
import za.co.davidweber.coindispenseservice.users.IUserRepository;
import za.co.davidweber.coindispenseservice.users.InMemoryUserRepository;
import za.co.davidweber.coindispenseservice.util.hashing.IPasswordHasher;
import za.co.davidweber.coindispenseservice.util.hashing.JBCryptPasswordHasher;

/**
 * Google Guice dependencies registration.
 *
 * @author David
 */
public class CoinDispenseServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IUserRepository.class).to(InMemoryUserRepository.class);
		bind(IPasswordHasher.class).to(JBCryptPasswordHasher.class);
		bind(ITokenAuthenticator.class).to(JwtTokenAuthenticator.class);
		bind(String.class).annotatedWith(Names.named("JWTSecret")).toInstance("KCJvpiRqQO4QYuG64wmSQ8MUUqLOLxNz1ungR3l5pYwVAuNI3oY2XvGBTEvwekE2rPK9PtR2AMTp"); // 256 bit key
	}

}
