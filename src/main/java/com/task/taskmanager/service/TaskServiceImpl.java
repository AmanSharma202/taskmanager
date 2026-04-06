package com.task.taskmanager.service;

import com.task.taskmanager.entity.*;
import com.task.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task existing = getTaskById(id);
        existing.setDescription(task.getDescription());
        existing.setTitle(task.getTitle());
        existing.setCreatedAt(task.getCreatedAt());
        existing.setStartDate(task.getStartDate());
        existing.setEndDate(task.getEndDate());
        return taskRepository.save(existing);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);

    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found"));
    }

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

}
