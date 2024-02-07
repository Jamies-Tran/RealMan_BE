package com.capstone.realmen.util.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DefaultTextValidator implements ConstraintValidator<DefaultText, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("[^\\d!@#$%^&*()-=\\/?.,<>_]+") && value.length() <= 256;
    }

}
