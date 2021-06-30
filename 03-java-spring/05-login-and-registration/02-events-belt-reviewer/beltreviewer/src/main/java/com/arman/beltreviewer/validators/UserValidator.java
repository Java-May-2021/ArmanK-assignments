package com.arman.beltreviewer.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.arman.beltreviewer.models.User;
import com.arman.beltreviewer.repositories.UserRepository;


@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserRepository uRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		
		if(!user.getPassword().equals(user.getConfirm_pw())) {
			errors.rejectValue("password", "match","Password doesnot match");
		}
		
		if(uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "unique","Email already exists");
		}
		
	}

}
