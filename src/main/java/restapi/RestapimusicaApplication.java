package restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages="restapi.model")
@ComponentScan(basePackages= {"restapi.*"})
@EnableJpaRepositories(basePackages= {"restapi.repository"})
@EnableTransactionManagement
@RestController
@EnableAutoConfiguration
public class RestapimusicaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RestapimusicaApplication.class, args);
	}
}
