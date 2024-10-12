package com.keycodehelp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import com.keycodehelp.entities.User;
import com.keycodehelp.service.UserService;

@RestController
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }
}
