package com.vulenhtho.travelboot.validation.impl;

import com.vulenhtho.travelboot.validation.NOTBLANK;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class NotBlankImpl implements ConstraintValidator<NOTBLANK,String > {
    @Override
    public void initialize(NOTBLANK constraintAnnotation) {

    }

    @Override
    public boolean isValid(String userRequest, ConstraintValidatorContext constraintValidatorContext) {
        return !(userRequest == null || userRequest.length() <= 0);
    }
}
