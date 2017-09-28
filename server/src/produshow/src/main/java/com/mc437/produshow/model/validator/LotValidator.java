package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.Lot;

public class LotValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Lot.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "amount", "empty");
		ValidationUtils.rejectIfEmpty(e, "productId", "empty");
		ValidationUtils.rejectIfEmpty(e, "stock", "empty");
		ValidationUtils.rejectIfEmpty(e, "action", "empty");

		Lot lot = (Lot) obj;
		if (checkAmount(lot)) {
			e.rejectValue("amount", "amount.empty");
		}
	}

	private boolean checkAmount(Lot lot) {
		return lot.getAmount() > 0;
	}

}
