package com.lcwd.user.service.services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {

    //user operation
    //create
    User saveUser(User user);

    //get all user
    List<User> getAUsers();

    //get single user of given userId;
    User getUser(String userId);

}
