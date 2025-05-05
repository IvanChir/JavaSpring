package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {

    @GetMapping("/private-data")
    public String privateData() {
        return "private-data";
    }

    @GetMapping("/public-data")
    public String publicData() {
        return "public-data";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}