package com.example.demo.controller;

import com.example.demo.data.ProfileRepository;
import com.example.demo.data.UserRepository;
import com.example.demo.model.Profile;
import com.example.demo.model.User;
import com.example.demo.service.ProfileInfoService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TempController {
        @Autowired
        private UserService userService;

        @Autowired
        private UserInfoService userInfoService;

        @Autowired
        private ProfileInfoService profileInfoService;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private ProfileRepository profileRepository;

        @Autowired
        private BCryptPasswordEncoder encoder;

        @GetMapping("/")
        public String index(){
            return "loginPage";
        }

        @GetMapping("/login")
        public String login(){
            return "loginPage";
        }

        @RequestMapping(value = "auth/newUser", method = RequestMethod.GET)
        public String newUser(Model model, User user){ return "newUser"; }


        @PostMapping(value = "auth/newUser")
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
            user.setRole("USER");
            String rawPassword = user.getPassword();
            String encPassword = encoder.encode(rawPassword); //hash
            user.setEncodedPassword(encPassword);
            userRepository.save(user);
            return "loginPage";
        }

//        @GetMapping("loginPage")
//            public String loginPage(){
//                return "loginPage";
//        }

        @GetMapping("registerPage")
        public String registerPage(){
            return "registerPage";
        }

        @GetMapping("dashboard")
        public String dashboard(Model model, Profile profile){
            List<User> info = userInfoService.getUsers();
            model.addAttribute("users", info);
            List<Profile> profiles = profileInfoService.getProfile();
            model.addAttribute("profiles", profiles);
            return "dashboard";
        }

        @GetMapping("profile")
        public String profile(Model model, Profile profile){
            List<Profile> profiles = profileInfoService.getProfile();
            model.addAttribute("profiles", profiles);
            return "profile";
        }

        @PostMapping("profile")
        public String checkProfile(@Valid Profile profile, Errors errors, Model model) {
            model.addAttribute("profile", profile);
            if(errors.hasErrors()){
                Map<String, String> validatorResult = new HashMap<>();
                model.addAttribute("profile", profile);
                for (FieldError error : errors.getFieldErrors()) {
                    System.out.println(error.getField());
                    String validKeyName = String.format("valid_%s", error.getField());
                    validatorResult.put(validKeyName, error.getDefaultMessage());
                }
                for(String key : validatorResult.keySet()){
                    model.addAttribute(key, validatorResult.get(key));
                }
                return "profile";
            }
            profileRepository.save(profile);
            return "profile";
        }


        @GetMapping("uconstruction2")
        public String uconstruction2(){
            return "uconstruction2";
        }

        @GetMapping("uconstruction3")
        public String uconstruction3(){ return "uconstruction3"; }

        @GetMapping("uconstruction4")
        public String uconstruction4(){
            return "uconstruction4";
        }
}
