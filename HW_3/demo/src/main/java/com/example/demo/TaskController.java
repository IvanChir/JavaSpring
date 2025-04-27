package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final UserService userService;

    @Autowired
    public TaskController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return userService.filterUsersByAge(age); // Метод filterUsersByAge в UserService
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
        return userService.calculateAverageAge(); // Метод calculateAverageAge в UserService
    }
}