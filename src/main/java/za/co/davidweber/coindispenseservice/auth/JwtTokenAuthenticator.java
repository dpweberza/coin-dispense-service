package za.co.davidweber.coindispenseservice.auth;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static java.time.temporal.ChronoUnit.HOURS;
import java.util.Date;

/**
 * JSON Web Token authenticator implementation.
 *
 * @author David
 */
public class JwtTokenAuthenticator implements ITokenAuthenticator {

	private final String jwtSecret;

	@Inject
	public JwtTokenAuthenticator(@Named("JWTSecret") String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	@Override
	public String generateToken(String userIdentifier) throws Exception {
		LocalDateTime date = LocalDateTime.now();
		Instant instant = date.atZone(ZoneId.systemDefault()).toInstant();

		// Generate the JWT
		JWSSigner signer = new MACSigner(jwtSecret);
		JWTClaimsSet claimsSet = new JWTClaimsSet();
		claimsSet.setSubject(userIdentifier);
		claimsSet.setIssueTime(Date.from(instant));
		claimsSet.setExpirationTime(Date.from(instant.plus(1, HOURS)));
		SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
		signedJWT.sign(signer);
		String jwt = signedJWT.serialize();

		return jwt;
	}

	@Override
	public boolean verifyToken(String token) throws Exception {
		SignedJWT signedJWT = SignedJWT.parse(token);
		JWSVerifier verifier = new MACVerifier(jwtSecret);

		boolean verified = signedJWT.verify(verifier);
		if (verified)
			verified = new Date().before(signedJWT.getJWTClaimsSet().getExpirationTime());

		return verified;
	}

	@Override
	public String getUserIdentifier(String token) throws Exception {
		SignedJWT signedJWT = SignedJWT.parse(token);
		JWSVerifier verifier = new MACVerifier(jwtSecret);
		if (!signedJWT.verify(verifier))
			throw new Exception("Token not verified!");

		return signedJWT.getJWTClaimsSet().getSubject();
	}

}
