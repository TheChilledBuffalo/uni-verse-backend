package com.universe.backend.controllers;

import com.universe.backend.dto.CreateUserRequest;
import com.universe.backend.dto.UpdateUserRequest;
import com.universe.backend.dto.UserResponse;
import com.universe.backend.service.AdminUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;

    @PostMapping("/user")
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest request) {
        return adminUserService.createUser(request);
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return adminUserService.getAllUsers();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        adminUserService.deleteUser(id);
    }

    @PostMapping("/users/upload")
    public List<UserResponse> uploadUsers(@RequestParam("file") MultipartFile file) {
        return adminUserService.createUsers(file);
    }

    @PutMapping("/user/{id}")
    public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) {
        return adminUserService.updateUser(id, request);
    }
}
