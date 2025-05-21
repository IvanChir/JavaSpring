package com.example.taskmanagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService extends Subject {
    private static TaskService instance;
    private List<Task> tasks = new ArrayList<>();

    private TaskService() {}

    public static TaskService getInstance() {
        if (instance == null) {
            instance = new TaskService();
        }
        return instance;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
