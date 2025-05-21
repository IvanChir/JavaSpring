package com.example.taskmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final RequestLogger requestLogger;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
        this.requestLogger = new RequestLogger();

        TaskObserver observer1 = new TaskObserver("Observer1");
        taskService.addObserver(observer1);
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        requestLogger.logRequest("Создана задача: " + task.getDescription());
        taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        requestLogger.logRequest("Запрос всех задач");
        return taskService.getTasks();
    }
}
