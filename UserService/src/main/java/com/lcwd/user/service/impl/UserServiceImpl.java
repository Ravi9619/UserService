package com.lcwd.user.service.impl;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server "+userId));

    }

}
