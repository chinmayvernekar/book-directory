package com.example.bookdirectory.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/save-role")
    public ResponseEntity<?> saveRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }
}
