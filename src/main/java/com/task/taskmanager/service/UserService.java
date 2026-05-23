package com.task.taskmanager.service;

import com.task.taskmanager.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    User findUserById(Integer id);
}
