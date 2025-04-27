package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> filterUsersByAge(int age) {
        return userRepository.findAll().stream() // Предполагается, что у вас есть метод findAll()
                .filter(user -> user.getAge() == age)
                .collect(Collectors.toList());
    }

    @Override
    public double calculateAverageAge() {
        return userRepository.findAll().stream() // Предполагается, что у вас есть метод findAll()
                .mapToInt(User::getAge)
                .average()
                .orElse(0.0);
    }
}