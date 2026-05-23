package com.task.taskmanager.repository;

import com.task.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
    User findUserById(Integer Id);
}
