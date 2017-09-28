package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.Stock;

public class StockValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Stock.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "productId", "empty");
		ValidationUtils.rejectIfEmpty(e, "amount", "empty");
		ValidationUtils.rejectIfEmpty(e, "zip", "empty");
		
		Stock stock = (Stock) obj;
		if (checkAmount(stock)) {
			e.rejectValue("amount", "amount.empty");
		}
	}
	
	private boolean checkAmount(Stock stock) {
		return stock.getAmount() > 0 ;
	}

}
