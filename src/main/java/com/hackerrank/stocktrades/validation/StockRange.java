package com.hackerrank.stocktrades.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = StockRangeValidator.class)
@Documented
public @interface StockRange {
	String message() default "Invalid stock price range";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
