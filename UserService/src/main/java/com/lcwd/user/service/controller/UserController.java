package com.lcwd.user.service.controller;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    //create

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {

        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //get all user
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUsers = userService.getAUsers();
        return ResponseEntity.ok(allUsers);

    }
}
