package com.example.play.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {

    private String message;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object user, ConstraintValidatorContext context) {
        if (user == null) {
            return true; // Null objects can be handled by @NotNull or other validators
        }

        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(user);
        Object password = beanWrapper.getPropertyValue("password");
        Object confirmPassword = beanWrapper.getPropertyValue("confirmPassword");

        if (password == null && confirmPassword == null) {
            return true; // Both can be null
        }

        if (password == null || confirmPassword == null) {
            return false; // One is null, the other isn't
        }

        boolean matches = password.equals(confirmPassword);

        if (!matches) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("confirmPassword") // Target the confirmPassword field in the error message
                    .addConstraintViolation();
        }

        return matches;
    }
}
