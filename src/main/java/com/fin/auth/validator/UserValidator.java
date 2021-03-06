package com.fin.auth.validator;


import com.fin.auth.model.User;
import com.fin.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    public boolean supports(Class<?> aClass){
        return User.class.equals(aClass);
    }

    public void validate(Object o, Errors errors){

        User  user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","Not Empty");
        if(user.getUsername().length()<6 || user.getUsername().length()>32){
            errors.rejectValue("username","Size.userForm.username");
        }
        if(userService.findByUsername(user.getUsername())!= null){
            errors.rejectValue("username","Duplicate.userForm.username");

        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty");
        if (user.getPassword().length()<8 || user.getPassword().length() > 32){
            errors.rejectValue("password","Size.userForm.password");
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())){
            errors.rejectValue("passwordConfirm","Diff.userForm.passwordConfirm");
        }



    }


}
