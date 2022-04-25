package com.censos.api;

import com.censos.api.entity.User;
import com.censos.api.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @Bean(value = "datasource")
	// @ConfigurationProperties("app.datasource")
	// public DataSource dataSource() {
	// 	return DataSourceBuilder.create().build();
	// }

	@Bean
	public CommandLineRunner demoUserData(UserRepository repo) {
		return args -> {
			repo.save(new User((long) 0, "Admin", "admin@123.com", "password@123", true));
			repo.save(new User((long) 0, "FormBuilder", "fb@123.com", "password@123", true));
			repo.save(new User((long) 0, "Common", "c@123.com", "password@123", true));
		};
	}
}
