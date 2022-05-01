package com.censos.api;

import com.censos.api.entity.User;
import com.censos.api.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @Bean(value = "datasource")
	// @ConfigurationProperties("app.datasource")
	// public DataSource dataSource() {
	// return DataSourceBuilder.create().build();
	// }

	@Bean
	public CommandLineRunner demoUserData(UserService service) {
		return args -> {
			try {
				service.create(new User("Admin", "admin@123.com", "password@123"));
				service.create(new User("FormBuilder", "fb@123.com", "password@123"));
				service.create(new User("Common", "c@123.com", "password@123"));				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		};
	}
}
