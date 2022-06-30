package com.example.bookdirectory.User;

import com.example.bookdirectory.Register;
import com.example.bookdirectory.role.Role;
import com.example.bookdirectory.role.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseEntity<?> saveUser(Register register) {
        Map<String,String> map = new HashMap<>();

        try {
            register.setId(UUID.randomUUID());
            Role role = roleRepo.findByName("USER").orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            register.addRole(role);
            register.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));
            userRepo.save(register);
            map.put("message","Registration Successfull.");
        }catch (Exception e){
            System.out.println("Error: " + e);
        }

        return ResponseEntity.ok(map);
    }
}
