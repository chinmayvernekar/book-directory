package com.example.bookdirectory.User;

import com.example.bookdirectory.Register;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<Register,Long> {

    Optional<Register> findByUserName(String userName);
}
