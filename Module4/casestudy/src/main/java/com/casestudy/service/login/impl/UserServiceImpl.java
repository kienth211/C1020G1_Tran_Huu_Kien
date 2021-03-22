package com.casestudy.service.login.impl;

import com.casestudy.model.employee.AppUser;
import com.casestudy.repository.login.UserRepository;
import com.casestudy.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(AppUser user) {
        userRepository.save(user);
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
