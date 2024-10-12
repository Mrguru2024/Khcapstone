package com.keycodehelp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";  // Returns the login.html in the static folder
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password) {
        // For simplicity, we are not doing actual authentication here
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/home";  // If login is successful, redirect to home
        }
        return "login";  // If login fails, show login page again
    }
}
