package com.elurea.user_service.service;

import com.elurea.user_service.dto.LoginRequest;
import com.elurea.user_service.dto.RegisterRequest;
import com.elurea.user_service.entity.User;
import com.elurea.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    public User login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (Objects.equals(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return user;
    }
}
