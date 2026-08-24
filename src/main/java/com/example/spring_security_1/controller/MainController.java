package com.example.spring_security_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/profile")
    public String profile() {
        return "Here is my account information";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "Admin dashboard";
    }
}