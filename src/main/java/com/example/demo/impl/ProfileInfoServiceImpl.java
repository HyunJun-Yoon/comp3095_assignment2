package com.example.demo.impl;

import com.example.demo.data.ProfileRepository;
import com.example.demo.model.Profile;
import com.example.demo.service.ProfileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileInfoServiceImpl implements ProfileInfoService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile>  getProfile() {
        return profileRepository.findAll();
    }

}
