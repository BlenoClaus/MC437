package com.mc437.produshow.model.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc437.produshow.model.product.Attribute;
import com.mc437.produshow.model.product.Image;

public class ImageValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Image.class) ;
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "url", "empty");
		
		if (checkUrl((Image)obj)) {
			e.rejectValue("url", "url.invalid");
		}
	}
	
	private boolean checkUrl(Image image) {
		return image == null || image.getUrl() == null || image.getUrl().length() > 145 ;
	}

}
