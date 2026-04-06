package com.task.taskmanager.controller;

import com.task.taskmanager.entity.Task;
import com.task.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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

    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task.getId(), task);
    }
}
