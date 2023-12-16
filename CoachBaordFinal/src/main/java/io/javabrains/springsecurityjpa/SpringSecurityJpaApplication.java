package io.javabrains.springsecurityjpa;
import io.javabrains.springsecurityjpa.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class SpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserService userService) {
		return (args) -> {
			// Create and save users during application startup
			User user3 = new User();
			user3.setUserName("Ken_me");
			user3.setPassword("password222");
			user3.setRoles("ROLE_ADMIN");
			user3.setActive(true);
			userService.saveUser(user3);

			// You can add additional logic here

			// Don't exit the application
			synchronized (SpringSecurityJpaApplication.class) {
				SpringSecurityJpaApplication.class.wait();
			}
		};
	}
}
