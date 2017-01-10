package rs.bojanb89.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder extends BCryptPasswordEncoder {

	public boolean isEncoded(final String password) {
		return password.startsWith("$2a$10");
	}
}
