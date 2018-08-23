package com.sunaniya.app.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sunaniya.app.model.UserForm;
import com.sunaniya.app.service.UserService;

@Component
public class UserValidator implements Validator {
    
	@Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserForm user = (UserForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (user.getFirstName().length() < 0 ) {
            errors.rejectValue("firstName", "NotEmpty");
        }
        
        if(user.getMobileNumber() == null) {
        	errors.rejectValue("mobileNumber", "MobileNotEmpty");
        }
        
        if (userService.findByMobileNumber(user.getMobileNumber()) != null) {
            errors.rejectValue("mobileNumber", "Duplicate.userForm.mobile");
        }

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
    }
}