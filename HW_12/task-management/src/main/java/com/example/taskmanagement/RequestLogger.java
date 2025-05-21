package com.example.taskmanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class RequestLogger {
    private static final String LOG_FILE = "user_requests.log";

    public void logRequest(String request) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(LocalDateTime.now() + " - " + request);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
