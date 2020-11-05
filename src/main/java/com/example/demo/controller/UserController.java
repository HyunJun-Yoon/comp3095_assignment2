package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/user/doLogin")
    @ResponseBody
    public String doLogin(String loginId, String loginPw){
        if(loginId.equals("user1") && loginPw.equals("1234")){
            return "Login success";
        }else{
            return "Login failed";
        }

    }
}
