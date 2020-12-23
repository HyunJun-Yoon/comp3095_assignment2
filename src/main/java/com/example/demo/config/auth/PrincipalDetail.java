package com.example.demo.config.auth;

import com.example.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class PrincipalDetail implements UserDetails {
    private User user;  //composition

    public PrincipalDetail(User user){
        this.user = user;
    }


    @Override
    public String getPassword() {
        return user.getEncodedPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }


    public long getId() { return user.getId(); }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(()->{return "ROLE_" + user.getRole();});
        return collectors;
    }

}