package com.elurea.user_service.controller;

import com.elurea.user_service.dto.SaveUserRequest;
import com.elurea.user_service.entity.User;
import com.elurea.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody SaveUserRequest req) {
        return ResponseEntity.ok(userService.create(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody SaveUserRequest req) {
        return ResponseEntity.ok(userService.update(req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDelete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted");
    }
}
