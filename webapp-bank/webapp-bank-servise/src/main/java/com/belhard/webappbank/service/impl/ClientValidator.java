package com.belhard.webappbank.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.belhard.webappbank.beans.ClientBean;

@Component
public class ClientValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		 return ClientBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "label.validate.emailEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "label.validate.passwordEmpty");
		
	}
	
	

}
