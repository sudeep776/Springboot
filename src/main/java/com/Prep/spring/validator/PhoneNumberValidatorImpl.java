package com.Prep.spring.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidatorImpl implements ConstraintValidator<PhoneNumberValidator,String> {

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        boolean flag=false;
        if(phone.length()==10){
            flag = true;
        }
        return flag;
    }
}
