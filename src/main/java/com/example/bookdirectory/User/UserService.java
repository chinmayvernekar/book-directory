package com.example.bookdirectory.User;

import com.example.bookdirectory.Register;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> saveUser(Register register);
}
