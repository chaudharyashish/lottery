package com.sunaniya.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sunaniya.app.model.UserForm;

@Component
public class UserValidator implements Validator {
    
	/*@Autowired
    private UserService userService;*/

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
        
        if(user.getEmailId().isEmpty() && user.getMobileNumber() == null) {
        	errors.rejectValue("emailId", "EmailOrMobile");
        }
        
        /*if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }*/

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
    }
}