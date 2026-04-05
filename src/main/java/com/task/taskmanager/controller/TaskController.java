package com.task.taskmanager.controller;

import com.task.taskmanager.entity.Task;
import com.task.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all-tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @PostMapping("/createTask")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping("/deleteTask")
    public void deleteTask(@RequestBody Task task) {
        taskService.deleteTask(task.getId());
    }

    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task.getId(), task);
    }
}
