package com.example.bookdirectory.role;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface RoleRepo extends MongoRepository<Role,Long> {

        Optional<Role> findByName(String name);
}
