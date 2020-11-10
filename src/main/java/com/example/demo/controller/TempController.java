package com.example.demo.controller;

import com.example.demo.data.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TempController {
        @Autowired
        private UserService userService;

        @Autowired
        private UserRepository userRepository;

        @GetMapping("/home")
        public String home(){
            return "loginPage";
        }

        @GetMapping("/")
        public String index(){
            return "loginPage";
        }

        @GetMapping("/login")
        public String login(){
            return "loginPage";
        }

        @RequestMapping(value = "/newUser", method = RequestMethod.GET)
        public String newUser(Model model, User user){ return "newUser"; }


        @PostMapping(value = "/newUser")
        public String checkUser(@Valid User user,  Errors errors, Model model, @RequestParam(value="agree", defaultValue = "false") boolean agree){
            boolean check = user.isPwEqualToCheckPw();
            if(errors.hasErrors() || !agree || !check){
                model.addAttribute("user", user);
                Map<String, String> validatorResult = new HashMap<>();
                if(errors.hasErrors()) {
                    validatorResult = userService.validateHandling(errors, true);
                }else if(!check){
                    validatorResult = userService.validateHandling(errors, true);
                }else if(!agree){
                    validatorResult = userService.validateHandling(errors, false);
                }
                for(String key : validatorResult.keySet()){
                    model.addAttribute(key, validatorResult.get(key));
                }
                return "newUser";
            }

//            boolean check = user.isPwEqualToCheckPw();
//            if(!check){
//                bindingResult.rejectValue("confirmPassword", "Not Matching", "Password are not matching");
//                return "newUser";
//           }
            System.out.println();
            userRepository.save(user);
            return "/dashboard";
        }

        @GetMapping("loginPage")
            public String loginPage(){

                return "loginPage";
        }

        @GetMapping("registerPage")
        public String registerPage(){
            return "registerPage";
        }

        @GetMapping("dashboard")
        public String dashboard(User user, Model model){
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setAddress("abc");
            user.setAgree(true);
            user.setConfirmPassword("P@ssword1");
            user.setPassword("P@ssword1");
            user.setEmail("asd@asd.com");
            System.out.println(user.getFirstName());
            model.addAttribute("user", user);
            userRepository.save( user);
            return "dashboard";
        }

        @GetMapping("/uconstruction1")
        public String uconstruction1(User user, Model model){
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setAddress("abc");
            user.setAgree(true);
            user.setConfirmPassword("P@ssword1");
            user.setPassword("P@ssword1");
            user.setEmail("asd@asd.com");
            System.out.println(user.getFirstName());
            model.addAttribute("user", user);
            userRepository.save( user);
            return "uconstruction1";
        }

        @GetMapping("/uconstruction2")
        public String uconstruction2(User user, Model model){
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setAddress("abc");
            user.setAgree(true);
            user.setConfirmPassword("P@ssword1");
            user.setPassword("P@ssword1");
            user.setEmail("asd@asd.com");
            System.out.println(user.getFirstName());
            model.addAttribute("user", user);
            userRepository.save( user);
            return "uconstruction2";
        }

        @GetMapping("/uconstruction3")
        public String uconstruction3(User user, Model model){
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setAddress("abc");
            user.setAgree(true);
            user.setConfirmPassword("P@ssword1");
            user.setPassword("P@ssword1");
            user.setEmail("asd@asd.com");
            System.out.println(user.getFirstName());
            model.addAttribute("user", user);
            userRepository.save( user);
            return "uconstruction3";
        }

        @GetMapping("/uconstruction4")
        public String uconstruction4(User user, Model model){
            user.setFirstName("admin");
            user.setLastName("admin");
            user.setAddress("abc");
            user.setAgree(true);
            user.setConfirmPassword("P@ssword1");
            user.setPassword("P@ssword1");
            user.setEmail("asd@asd.com");
            System.out.println(user.getFirstName());
            model.addAttribute("user", user);
            userRepository.save( user);
            return "uconstruction4";
        }
}
