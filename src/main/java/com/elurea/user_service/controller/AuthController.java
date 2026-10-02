package com.elurea.user_service.controller;

import com.elurea.user_service.dto.LoginRequest;
import com.elurea.user_service.dto.RegisterRequest;
import com.elurea.user_service.entity.User;
import com.elurea.user_service.repository.UserRepository;
import com.elurea.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest req) {
        User createdUser = userService.register(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest req) {
        User user = userService.login(req);
        return ResponseEntity.ok(user);
    }
}
