package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		if (clazz.equals(Product.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "empty");
		ValidationUtils.rejectIfEmpty(e, "price", "empty");
		ValidationUtils.rejectIfEmpty(e, "category", "empty");
		
		Product product = (Product) obj;
		if (checkDescriptionSize(product)) {
			e.rejectValue("description", "description.empty");
		}
		
	}

	private boolean checkDescriptionSize(Product product) {
		return product.getDescription().length() > 250 ;
	}
	
}
