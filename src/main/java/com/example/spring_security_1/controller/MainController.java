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
        return "J'ai accès à cette page en modifiant mon application.properties, avec : spring.security.user.roles=ADMIN, USER";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "J'ai aussi accès à cette page avec cette config : spring.security.user.roles=ADMIN, USER ";
    }
}