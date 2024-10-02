package com.Prep.spring.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmployeeTypeValidator.class)
public @interface VaildateEmployeeType {
    String message() default "Invalid employee type"; // Default error message
    Class<?>[] groups() default {}; // Grouping constraints
    Class<? extends Payload>[] payload() default {};
}
