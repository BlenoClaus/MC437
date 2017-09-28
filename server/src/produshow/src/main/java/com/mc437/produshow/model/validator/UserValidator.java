package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "token", "empty");
		ValidationUtils.rejectIfEmpty(e, "username", "empty");
		ValidationUtils.rejectIfEmpty(e, "password", "empty");
	}
}
