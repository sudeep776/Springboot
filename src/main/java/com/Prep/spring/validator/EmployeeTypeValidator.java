package com.Prep.spring.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTypeValidator implements ConstraintValidator<VaildateEmployeeType,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> employeeTypeList = Arrays.asList("Permanent","Contract");
        if(employeeTypeList.contains(value)){
            return true;
        }return false;
    }
}
