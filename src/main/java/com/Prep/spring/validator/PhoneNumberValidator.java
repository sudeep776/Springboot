package com.Prep.spring.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import javax.lang.model.element.Element;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidatorImpl.class)
public @interface PhoneNumberValidator {

    public String message() default "Phone number must be 10 digits";
    Class<?>[] groups() default{};
    Class<? extends Payload>[]payload() default{};

}
