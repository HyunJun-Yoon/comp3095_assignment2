package com.example.demo.impl;

import com.example.demo.data.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User>  getUsers() {
        return userRepository.findAll();
    }


}
