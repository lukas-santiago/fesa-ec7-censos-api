package com.censos.api;

import com.censos.api.entity.Field;
import com.censos.api.entity.Role;
import com.censos.api.repository.FieldRepository;
import com.censos.api.repository.RoleRepository;
import com.censos.api.security.SecurityAuditorAware;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new SecurityAuditorAware();
	}

	@Bean
	public CommandLineRunner demoFieldData(FieldRepository fieldRepository) {
		return args -> {
			try {
				if (fieldRepository.findByType("Texto").isEmpty()) {
					Field textField = new Field(null, "Texto", null);
					fieldRepository.save(textField);
				}
				if (fieldRepository.findByType("Texto Longo").isEmpty()) {
					Field longTextField = new Field(null, "Texto Longo", null);
					fieldRepository.save(longTextField);
				}

				if (fieldRepository.findByType("Grau de Satisfação").isEmpty()) {
					Field SatisfactionDegreefield = new Field(null, "Grau de Satisfação", null);
					fieldRepository.save(SatisfactionDegreefield);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		};
	}

	@Bean
	public CommandLineRunner demoRoleData(RoleRepository roleRepository) {
		return args -> {
			try {
				if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
					Role role = new Role();
					role.setName("ROLE_ADMIN");
					roleRepository.save(role);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		};
	}
}
