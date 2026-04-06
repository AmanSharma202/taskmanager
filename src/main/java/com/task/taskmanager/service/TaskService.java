package com.task.taskmanager.service;
import com.task.taskmanager.entity.Task;
import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
    Task getTaskById(Long id);

}
