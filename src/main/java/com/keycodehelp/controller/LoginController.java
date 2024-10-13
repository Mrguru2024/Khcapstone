package com.keycodehelp.controller;

import com.keycodehelp.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Example endpoint to handle login
    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean isValidUser = loginService.validateUserCredentials(username, password);
        if (isValidUser) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }
}
