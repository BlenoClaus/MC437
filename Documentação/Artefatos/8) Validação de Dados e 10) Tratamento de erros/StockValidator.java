package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.Product;
import com.mc437.produshow.model.Stock;

public class StockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Stock.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "amount", "empty");
		ValidationUtils.rejectIfEmpty(e, "zip", "empty");
		
		if (checkZip((Stock)obj)) {
			e.rejectValue("zip", "zip.invalid");
		}
	}
	
	private boolean checkZip(Stock stock) {
		return stock == null || stock.getZip() == null || stock.getZip().length() > 10 ;
	}

}
