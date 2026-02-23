package com.universe.backend.controllers;

import com.universe.backend.dto.*;
import com.universe.backend.service.AdminCourseService;
import com.universe.backend.service.AdminUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminUserService adminUserService;
    private final AdminCourseService adminCourseService;

    // User Management Endpoints
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

    // Course Management Endpoints
    @PostMapping("/course")
    public CourseResponse createCourse(@RequestBody CreateCourseRequest request) {
        return adminCourseService.createCourse(request);
    }

    @PostMapping("/courses/upload")
    public List<CourseResponse> uploadCourses(@RequestParam MultipartFile file) {
        return adminCourseService.createCourses(file);
    }

    @GetMapping("/courses")
    public List<CourseResponse> getAllCourses() {
        return adminCourseService.getAllCourses();
    }

    @PutMapping("course/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody UpdateCourseRequest request) {
        return adminCourseService.updateCourse(id, request);
    }

    @DeleteMapping("course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        adminCourseService.deleteCourse(id);
    }
}
