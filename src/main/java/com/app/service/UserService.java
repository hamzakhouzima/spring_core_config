package com.app.service;

import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        if (isUserExist(user.getId())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public boolean isUserExist(Long id) {
        return userRepository.existsById(id);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(User user) {
        if (!isUserExist(user.getId())) {
            throw new RuntimeException("User does not exist");
        }
        return userRepository.save(user);
    }
}
