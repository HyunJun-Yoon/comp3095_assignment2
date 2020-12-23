package com.example.demo.service;

import com.example.demo.data.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;


import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public Map<String, String> validateHandling(Errors errors, boolean check){
        Map<String, String> validatorResult = new HashMap<>();
        if(errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                System.out.println(error.getField());
                String validKeyName = String.format("valid_%s", error.getField());
                validatorResult.put(validKeyName, error.getDefaultMessage());
            }
        }else if(!errors.hasErrors() && check){
            System.out.println("password is not matching");
            String validKeyName = String.format("valid_confirmPassword");
            validatorResult.put(validKeyName, "Your password is not matching");

        }else if(!errors.hasErrors() && !check){
            System.out.println("not agreed");
            String validKeyName = String.format("valid_agree");
            validatorResult.put(validKeyName, "You must agree to the terms of the service");
        }
        return validatorResult;
    }

}
