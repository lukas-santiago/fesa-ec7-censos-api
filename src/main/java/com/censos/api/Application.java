package com.censos.api;

import com.censos.api.entity.Field;
import com.censos.api.entity.User;
import com.censos.api.repository.FieldRepository;
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
		User user = new User();
		user.setUsername("Admin");
		user.setEmail("admin@123.com");
		user.setPassword("password@123");
		return args -> {
			try {
				service.create(user);
				// service.create(new User("FormBuilder", "fb@123.com", "password@123"));
				// service.create(new User("Common", "c@123.com", "password@123"));				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		};
	}
	@Bean
	public CommandLineRunner demoFieldData(FieldRepository fieldRepository) {
		Field textField = new Field(null, "Text", null);
		Field longTextField = new Field(null, "Long Text", null);
		Field SatisfactionDegreefield = new Field(null, "Satisfaction Degree", null);
		
		
		return args -> {
			try {
				fieldRepository.save(textField);	
				fieldRepository.save(longTextField);	
				fieldRepository.save(SatisfactionDegreefield);	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		};
	}
}
