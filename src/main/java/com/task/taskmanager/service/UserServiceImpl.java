package com.task.taskmanager.service;

import com.task.taskmanager.entity.User;
import com.task.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
public UserServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;

}


    @Override
    public User findUserByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(Integer Id) {
        return userRepository.findById(Id).orElseThrow(() -> new RuntimeException("User not found"));
    }


}
