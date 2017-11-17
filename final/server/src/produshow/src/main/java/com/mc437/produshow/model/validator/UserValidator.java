package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.product.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "username", "empty");
		ValidationUtils.rejectIfEmpty(e, "password", "empty");
		
		User user = (User) obj;
		
		if (user.getUsername() != null) {
			if (user.getUsername().length() > 10 || user.getUsername().length() < 4) {
				e.reject("USERNAME_NOT_BETWEEN_4_10_CHARS");
			}
		}
		
		if (user.getPassword() != null) {
			if (user.getPassword().length() > 10 || user.getPassword().length() < 4) {
				e.reject("PASSWORD_NOT_BETWEEN_4_10_CHARS");
			}
		}
	}
}
