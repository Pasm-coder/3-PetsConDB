package co.edu.uniminuto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"co.edu.uniminuto.entity"})
@EnableJpaRepositories(basePackages = {"co.edu.uniminuto.dao"})
@ComponentScan(basePackages = {"co.edu.uniminuto", "co.edu.uniminuto.service", "co.edu.uniminuto.contoller", "co.edu.uniminuto.security"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
