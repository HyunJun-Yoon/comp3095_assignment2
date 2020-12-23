package com.example.demo.config.auth;

import com.example.demo.data.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User principal = userRepository.findByEmail(email)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("Cannot find the email" + email);
                });
        return new PrincipalDetail(principal);
    }

//    public long getUserId(String email){
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(()->{
//                    return new UsernameNotFoundException("Cannot find the email" + email);
//                });;
//        return user.getId();
//    }
}
