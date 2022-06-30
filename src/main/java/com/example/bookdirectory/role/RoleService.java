package com.example.bookdirectory.role;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface RoleService {

    ResponseEntity<?> saveRole(Role role);


}
