package com.nutritracker.common.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author desai
 */

@NotNull
@Min(value = 0)
@Digits(integer = 8, fraction = 3)
@Constraint(validatedBy = {})
@Documented
@Retention(RUNTIME)
@ReportAsSingleViolation
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
public @interface StandardDecimal {
	String message() default "{invalid.decimal}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
