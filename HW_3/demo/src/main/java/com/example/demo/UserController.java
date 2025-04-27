package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/user")
public class UserController {

    private List<User> users = new ArrayList<>();

    @PostMapping("/body")
    public String addUser(@RequestBody User user) {
        users.add(user);
        return "Пользователь " + user.getName() + " добавлен!";
    }

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/sort")
    public List<User> sortUsers() {
        users.sort(Comparator.comparing(User::getName));
        return users;
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return users.stream()
                .filter(user -> user.getAge() == age)
                .collect(Collectors.toList());
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
        OptionalDouble average = users.stream()
                .mapToInt(User::getAge)
                .average();
        return average.orElse(0.0);
    }
}