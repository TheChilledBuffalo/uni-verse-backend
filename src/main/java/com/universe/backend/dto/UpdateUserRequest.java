package com.universe.backend.dto;

import com.universe.backend.enums.Department;
import com.universe.backend.enums.Role;
import lombok.Data;

@Data
public class UpdateUserRequest {

    private String name;
    private String email;
    private String password;
    private Role role;
    private Department department;
}
