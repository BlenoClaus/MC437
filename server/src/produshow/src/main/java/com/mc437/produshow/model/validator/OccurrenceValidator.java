package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.Occurrence;

public class OccurrenceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Occurrence.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "amount", "empty");
		ValidationUtils.rejectIfEmpty(e, "event", "empty");
		ValidationUtils.rejectIfEmpty(e, "lot", "empty");

		Occurrence occurrence = (Occurrence) obj;
		if (checkAmount(occurrence)) {
			e.rejectValue("amount", "amount.empty");
		}

	}

	private boolean checkAmount(Occurrence occurrence) {
		return occurrence.getAmount() > 0;
	}

}
