package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println(message); // Выводим сообщение в консоль
    }
}