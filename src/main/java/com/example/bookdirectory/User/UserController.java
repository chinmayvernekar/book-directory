package com.example.bookdirectory.User;

import com.example.bookdirectory.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<?> saveUser(@RequestBody Register register){
        return userService.saveUser(register);
    }
}
