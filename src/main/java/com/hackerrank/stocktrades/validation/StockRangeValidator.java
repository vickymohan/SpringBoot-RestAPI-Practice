package com.hackerrank.stocktrades.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StockRangeValidator implements ConstraintValidator<StockRange, Integer> {

	@Override
	public boolean isValid(Integer range, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return range>=0&&range<=100;
	}

}
