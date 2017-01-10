package rs.bojanb89;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import rs.bojanb89.datamodel.entity.Role;
import rs.bojanb89.datamodel.entity.User;
import rs.bojanb89.repository.UserRepository;
import rs.bojanb89.security.UserDetailsImpl;

@SpringBootApplication(exclude = { HypermediaAutoConfiguration.class })
@PropertySource("classpath:oauth2.properties")
@ComponentScan("rs.bojanb89")
@EntityScan(basePackages = "rs.bojanb89.datamodel")
@EnableJpaRepositories(basePackages = "rs.bojanb89.repository")
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class OAuth2SpringApplication extends SpringBootServletInitializer {

	// this is needed for war packaging of the applicaiton
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OAuth2SpringApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(OAuth2SpringApplication.class, args);
	}

	@Autowired
	public void init(AuthenticationManagerBuilder auth, UserRepository repository) throws Exception {
		if (repository.count() == 0) {
			User user = new User();
			user.setUsername("user");
			user.setPassword("password");
			user.setEnabled(true);
			Role role = new Role();
			role.setName("CLIENT");
			role.setUser(user);
			user.setRoles(Arrays.asList(role));
			repository.save(user);
		}
		auth.userDetailsService(userDetailsService(repository));
	}

	@Bean
	public UserDetailsService userDetailsService(final UserRepository repository) {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return new UserDetailsImpl(repository.findByUsername(username));
			}
		};
	}

	@Configuration
	@EnableResourceServer
	protected static class ResourceServer extends ResourceServerConfigurerAdapter {

		@Autowired
		private TokenStore tokenStore;

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			resources.tokenStore(tokenStore);
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/storage/**").permitAll().antMatchers("/health*").permitAll().and().authorizeRequests().anyRequest()
					.authenticated();
		}

	}
}
