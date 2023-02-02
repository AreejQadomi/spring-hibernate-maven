package com.springdemo.mvc.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    // define annotation's attributes
    public String value() default "CR";

    public String message() default "Must start with CR";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};




}
