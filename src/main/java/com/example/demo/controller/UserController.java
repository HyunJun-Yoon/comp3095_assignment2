package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "auth/addNewUser", method = RequestMethod.POST)
    public String newUser(@ModelAttribute @Valid User user, BindingResult result, @RequestParam(value="agree", defaultValue = "false") Boolean agree){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();

            return "auth/newUser";
        }
        boolean check = user.isPwEqualToCheckPw();
        if(!check){
            result.rejectValue("confirmPassword", "notMatch", "Password are not matching");
            return "auth/newUser";
        }
        if(!agree){
            result.rejectValue("agree", "notagreed", "You must agree to the terms of the service");
            System.out.println("notagreed");
            return "auth/newUser";
        }

        userRepository.save(user);
        return("redirect:/home.html");
    }

    @RequestMapping(value = "auth/addNewUser", method = RequestMethod.GET)
    public ModelAndView registerNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("auth/newUser", "form", user);
    }



    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public ModelAndView users(){
        List<User> allUser = userRepository.findAll();
        return new ModelAndView("allUsers", "users", allUser);
    }

 /*   @ResponseBody
    public String doLogin(String loginId, String loginPw){
        if(loginId.equals("user1") && loginPw.equals("1234")){
            return "Login success";
        }else{
            return "Login failed";
        }

    }*/
}
