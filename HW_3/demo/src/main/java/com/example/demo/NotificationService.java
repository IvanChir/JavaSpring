package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
    void sendNotification(String message);
}