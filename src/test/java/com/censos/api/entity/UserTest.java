package com.censos.api.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void simpleUserValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        // I'd name the test to something like
        // invalidEmailShouldFailValidation()

        User user = new User();
        user.setName("test"); 
        user.setEmail("test@test.com");
        user.setPassword("authorities");
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        
        for (ConstraintViolation<User> violation : violations) {
            System.err.println(violation.getMessage());
        }

        assertTrue(violations.isEmpty());
    }
}
