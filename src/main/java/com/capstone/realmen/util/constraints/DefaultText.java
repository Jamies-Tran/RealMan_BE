package com.capstone.realmen.util.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DefaultTextValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface DefaultText {
    String message() default "Invalid_Request";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
