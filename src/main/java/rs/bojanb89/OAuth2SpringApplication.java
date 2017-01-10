package rs.bojanb89;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
}
