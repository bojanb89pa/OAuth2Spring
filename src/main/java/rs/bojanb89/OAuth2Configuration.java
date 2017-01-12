/**
 * 
 */
package rs.bojanb89;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import rs.bojanb89.security.PasswordEncoder;

/**
 * @author Bojan Bogojevic
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager auth;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public JdbcTokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	protected AuthorizationCodeServices authorizationCodeServices() {
		return new JdbcAuthorizationCodeServices(dataSource);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.passwordEncoder(passwordEncoder);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(auth).tokenStore(tokenStore());
		endpoints.userDetailsService(userDetailsService); // Inject custom
		endpoints.authorizationCodeServices(authorizationCodeServices());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// @formatter:off
		clients.jdbc(dataSource);
		//add this to init client:
//		.passwordEncoder(passwordEncoder);
//			.withClient("test_client")
//				.authorizedGrantTypes("password", "refresh_token")
//				.scopes("read", "write", "trust");
			
//		.passwordEncoder(passwordEncoder)
//	.withClient("my-trusted-client")
//		.authorizedGrantTypes("password", "authorization_code",
//				"refresh_token", "implicit")
//		.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//		.scopes("read", "write", "trust")
//		.resourceIds("oauth2-resource")
//		.accessTokenValiditySeconds(60).and()
//	.withClient("my-client-with-registered-redirect")
//		.authorizedGrantTypes("authorization_code")
//		.authorities("ROLE_CLIENT").scopes("read", "trust")
//		.resourceIds("oauth2-resource")
//		.redirectUris("http://anywhere?key=value").and()
//	.withClient("my-client-with-secret")
//		.authorizedGrantTypes("client_credentials", "password")
//		.authorities("ROLE_CLIENT").scopes("read")
//		.resourceIds("oauth2-resource").secret("secret");
		// @formatter:on
	}

}
