package com.universe.backend.dto;

import com.universe.backend.enums.Department;
import com.universe.backend.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotNull
    private Role role;

    private Department department;
}
