package com.elurea.user_service.service;

import com.elurea.user_service.dto.LoginRequest;
import com.elurea.user_service.dto.RegisterRequest;
import com.elurea.user_service.dto.SaveUserRequest;
import com.elurea.user_service.entity.User;
import com.elurea.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public User register(RegisterRequest request) {
        if(userRepository.findByEmail(request.email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setTitle(request.title);
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password);
        user.setPhoneNumber(request.phoneNumber);
        userRepository.save(user);

        return user;
    }

    // Login a user
    public User login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user;
    }

    // Get All Users
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // Get User By ID
    public User getById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }

    // Create New User
    public User create(SaveUserRequest request) {
        if(userRepository.findByEmail(request.email).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setTitle(request.title);
        user.setRole(request.role);
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password);
        user.setPhoneNumber(request.phoneNumber);
        user.setAvatar(request.avatar);
        userRepository.save(user);

        return user;
    }

    // Update User
    public User update(SaveUserRequest request) {
        User user = userRepository.findById(request.id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(request.title != null) user.setTitle(request.title);
        if(request.role != null) user.setRole(request.role);
        if(request.name != null) user.setName(request.name);
        if(request.phoneNumber != null) user.setPhoneNumber(request.phoneNumber);
        if(request.avatar != null) user.setAvatar(request.avatar);
        userRepository.save(user);

        return user;
    }

    // Soft Delete User
    public void delete(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setDeletedAt(LocalDateTime.now());

        userRepository.save(user);
    }
}
