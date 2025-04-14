package com.example.play.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordMatchValidator.class)
@Target({ ElementType.TYPE }) // Apply to the class level
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatch {

    String message() default "Passwords do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
