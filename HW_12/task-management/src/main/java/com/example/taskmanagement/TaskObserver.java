package com.example.taskmanagement;

public class TaskObserver implements Observer {
    private String name;

    public TaskObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Task task) {
        System.out.println("Observer " + name + ": задача добавлена - " + task.getDescription());
    }
}
