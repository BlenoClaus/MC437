package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.product.Attribute;

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
		if (checkName(attribute)) {
			e.rejectValue("name", "name.invalid");
		}
		
		if (checkValue(attribute)) {
			e.rejectValue("value", "value.invalid");
		}
	}

	private boolean checkName(Attribute attribute) {
		return attribute == null || attribute.getName() == null || attribute.getName().length() > 45 ;
	}
	
	private boolean checkValue(Attribute attribute) {
		return attribute == null || attribute.getValue() == null || attribute.getValue().length() > 45 ;
	}
	
}
