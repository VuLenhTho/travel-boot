package com.vulenhtho.travelboot.validation;


import com.vulenhtho.travelboot.util.ErrorCode;
import com.vulenhtho.travelboot.validation.impl.NotBlankImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.FIELD)
@Constraint(validatedBy = NotBlankImpl.class)
@Retention(RUNTIME)
@Documented
public @interface NOTBLANK {
    String message() default ErrorCode.Code.NOT_BLANK;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
