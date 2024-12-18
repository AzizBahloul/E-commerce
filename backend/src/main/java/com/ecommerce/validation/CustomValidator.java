package com.ecommerce.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomAnnotation, String> {

    @Override
    public void initialize(CustomAnnotation customAnnotation) {
        // Initialization logic if needed
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Custom validation logic
        if (value == null || value.isEmpty()) {
            return false;
        }
        // Add more validation logic as needed
        return true;
    }
}