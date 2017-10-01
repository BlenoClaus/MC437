package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.Attribute;
import com.mc437.produshow.model.Product;

public class AttibuteValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return clazz.equals(Attribute.class);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "empty");
		ValidationUtils.rejectIfEmpty(e, "value", "empty");
		
		Attribute attribute = (Attribute) obj;
		if (checkNameSize(attribute)) {
			e.rejectValue("name", "name.invalid");
		}
		
		if (checkValueSize(attribute)) {
			e.rejectValue("value", "value.invalid");
		}
	}

	private boolean checkNameSize(Attribute attribute) {
		return attribute.getName().length() > 45 ;
	}
	
	private boolean checkValueSize(Attribute attribute) {
		return attribute.getName().length() > 45 ;
	}
	
}
