package com.example.demo;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUserByEmail(String email);
    List<User> filterUsersByAge(int age); // Новый метод для фильтрации пользователей
    double calculateAverageAge(); // Новый метод для вычисления среднего возраста
}