package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.Attribute;

public class AttibuteValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(Attribute.class);
	}

	@Override
	public void validate(Object arg0, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "empty");
		ValidationUtils.rejectIfEmpty(e, "value", "empty");
	}

}
