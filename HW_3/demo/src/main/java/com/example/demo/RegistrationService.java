package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserService userService;
    private final NotificationService notificationService;

    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public void processRegistration(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        userService.addUser(user);

        notificationService.sendNotification("Пользователь " + name + " успешно зарегистрирован!");
    }
}