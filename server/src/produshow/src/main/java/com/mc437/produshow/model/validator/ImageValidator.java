package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.Image;

public class ImageValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Image.class) ;
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "url", "empty");
	}

}
