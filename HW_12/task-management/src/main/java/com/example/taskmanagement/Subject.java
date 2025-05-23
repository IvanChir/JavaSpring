package com.example.taskmanagement;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(Task task) {
        for (Observer observer : observers) {
            observer.update(task);
        }
    }
}
